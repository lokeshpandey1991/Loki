package com.roche.pharma.customerportal.core.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.eval.JcrPropertyPredicateEvaluator;
import com.day.cq.search.result.SearchResult;
import com.day.cq.tagging.TagConstants;
import com.day.cq.wcm.api.NameConstants;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.services.SearchService;

/**
 * Search result service implementation.
 */
@Service(SearchService.class)
@Component(metatype = false, immediate = true)
public class SearchServiceImpl implements SearchService {

    private static final Logger LOG = LoggerFactory.getLogger(SearchService.class);
    @Reference
    private QueryBuilder queryBuilder;

    /**
     * This will return the search result for the query parameter map passed using Query builder api
     * @param resourceResolver The resource resolver.
     * @param predicateParamMap The parameters to use for the query.
     * @return The search result.
     */
    @Override
    public SearchResult getSearchResults(final ResourceResolver resourceResolver,
            final Map<String, String> predicateParameterMap) {
        final Query query = createQuery(resourceResolver, predicateParameterMap);
        final SearchResult result = query.getResult();
        LOG.info("Query execution time {}", result.getExecutionTime());
        return result;
    }
    
    /**
     * Create the search query using predicateMap.
     * @param resourceResolver The resource resolver.
     * @param predicateParamMap The parameters to use for the query.
     * @return The search query.
     */
    public Query createQuery(final ResourceResolver resourceResolver, final Map<String, String> predicateParamMap) {
        final Session session = resourceResolver.adaptTo(Session.class);
        return queryBuilder.createQuery(PredicateGroup.create(predicateParamMap), session);
    }
    
    /**
     * This will return the search results based on selected tags.
     * @param resourceResolver the resource resolver
     * @param rootPath
     * @param tags
     * @return the search results
     */
    @Override
    public SearchResult getSearchResultsByTag(final ResourceResolver resourceResolver, final String rootPath,
            final String[] tags) {
        final Map<String, String> predicateParamMap = createPracdicateMap(rootPath, tags);
        final Query query = createQuery(resourceResolver, predicateParamMap);
        final SearchResult result = query.getResult();
        LOG.info("Query execution time {}", result.getExecutionTime());
        return result;
    }

    private Map<String, String> createPracdicateMap(final String rootPath, final String[] tags) {
        final Map<String, String> predicateParamMap = new HashMap<>();
        predicateParamMap.put(RocheConstants.SEARCH_PATH, rootPath);
        predicateParamMap.put(RocheConstants.SEARCH_TYPE, NameConstants.NT_PAGE);
        predicateParamMap.put("1" + RocheConstants.UNDERSCORE + JcrPropertyPredicateEvaluator.PROPERTY,
                JcrConstants.JCR_CONTENT + RocheConstants.SLASH + TagConstants.PN_TAGS);
        int i = 1;
        for (final String tag : tags) {
            predicateParamMap.put("1_" + JcrPropertyPredicateEvaluator.PROPERTY + RocheConstants.DOT + (i)
                    + RocheConstants.UNDERSCORE + JcrPropertyPredicateEvaluator.VALUE, tag);
            i = i + 1;
        }
        return predicateParamMap;
    }

}
