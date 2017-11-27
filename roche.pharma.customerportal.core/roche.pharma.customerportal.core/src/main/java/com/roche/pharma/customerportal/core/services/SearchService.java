package com.roche.pharma.customerportal.core.services;

import java.util.Map;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.search.result.SearchResult;

/**
 * Search result service interface.
 */

public interface SearchService {
    
    /**
     * Gets the search results.
     * @param resourceResolver the resource resolver
     * @param predicateParameterMap the predicate parameter map
     * @return the search results
     */
    public SearchResult getSearchResults(ResourceResolver resourceResolver, Map<String, String> predicateParameterMap);
    
    /**
     * Gets the search results based on tags.
     * @param resourceResolver the resource resolver
     * @param rootPath
     * @param tags
     * @return the search results
     */
    public SearchResult getSearchResultsByTag(ResourceResolver resourceResolver, String rootPath, String[] tags);
}
