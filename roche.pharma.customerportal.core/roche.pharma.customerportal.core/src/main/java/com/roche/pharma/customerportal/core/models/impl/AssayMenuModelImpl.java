package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.jcr.RepositoryException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.dto.AssayMenuResponse;
import com.roche.pharma.customerportal.core.dto.RelatedAssaysMap;
import com.roche.pharma.customerportal.core.framework.ServiceResponse;
import com.roche.pharma.customerportal.core.models.AssayMenuModel;
import com.roche.pharma.customerportal.core.services.AssayMenuService;
import com.roche.pharma.customerportal.core.services.CacheManagerService;
import com.roche.pharma.customerportal.core.services.exception.WebserviceException;
import com.roche.pharma.customerportal.core.utils.AssayMenuUtil;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * The Class AssayMenuModel.
 * @author Avinash kumar
 */

@Model(adaptables = {
        SlingHttpServletRequest.class
}, adapters = {
        AssayMenuModel.class
}, resourceType = AssayMenuModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class AssayMenuModelImpl implements AssayMenuModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/assayMenu/v1/assayMenu";
    
    @Self
    private SlingHttpServletRequest request;
    
    @OSGiService
    private AssayMenuService assayMenuService;
    
    @OSGiService
    private QueryBuilder queryBuilder;
    
    @OSGiService
    private CacheManagerService ehcache;
    
    @SlingObject
    private SlingHttpServletResponse response;
    
    private ServiceResponse<AssayMenuResponse> data;
    
    private List<Map<String, String>> legends;
    
    private final List<RelatedAssaysMap> relatedAssaysMap = new ArrayList<RelatedAssaysMap>();
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AssayMenuModelImpl.class);
    
    private String productId;
    private String title;
    
    private final List<Map<String, String>> products = new ArrayList<>();
    
    /**
     * Post construct.
     * @throws WebserviceException the webservice exception
     */
    @PostConstruct
    protected void postConstruct() throws WebserviceException {
        
        final String[] selectors = request.getRequestPathInfo().getSelectors();
        if (selectors.length > 0) {
            productId = selectors[0];
        }
        if (StringUtils.isNotEmpty(productId)) {
            final Map<String, Map<String, String>> dataMap = new HashMap<>();
            final Set<String> legendsList = new HashSet<String>();
            final Locale local = AssayMenuUtil.getCurrentPageLocale(request);
            final String language = local.getLanguage();
            
            try {
                getProductRelatedAssay(dataMap, legendsList, language);
            } catch (final RepositoryException e) {
                LOGGER.error("Repository exception while reading the node", e);
            }
            legends = getProductLegends(legendsList);
            if (relatedAssaysMap.isEmpty()) {
                response.setStatus(404);
            }
            
        } else {
            getAuthoredProducts();
            
        }
        
    }
    
    private void getAuthoredProducts() {
        title = (String) request.getResource().getValueMap().get(AssayMenuUtil.COMPONENT_TITLE);
        if (null != request.getResource()
                && null != request.getResource().getValueMap().get(AssayMenuUtil.PRODUCT_LIST)) {
            String[] productList = null;
            
            final Object productObject = request.getResource().getValueMap().get(AssayMenuUtil.PRODUCT_LIST);
            if (productObject instanceof String) {
                productList = new String[] {
                        (String) productObject
                };
            } else {
                productList = (String[]) productObject;
            }
            
            try {
                final Page currentPage = GlobalUtils.getCurrentPage(request.getResource());
                final Page languagePage = GlobalUtils.getRegionalLanguagePage(currentPage);
                for (final String json : productList) {
                    final Map<String, String> map = new HashMap<String, String>();
                    final JSONObject jsonObject = new JSONObject(json);
                    map.put(AssayMenuUtil.PRODUCT_IMAGE, jsonObject.getString(AssayMenuUtil.PRODUCT_IMAGE));
                    map.put(AssayMenuUtil.PRODUCT_NAME, jsonObject.getString(AssayMenuUtil.PRODUCT_NAME));
                    map.put(AssayMenuUtil.PRODUCT_ALTTEXT, jsonObject.getString(AssayMenuUtil.PRODUCT_ALTTEXT));
                    map.put(AssayMenuUtil.PRODUCT_ID, jsonObject.getString(AssayMenuUtil.PRODUCT_ID));
                    
                    map.put(AssayMenuUtil.PRODUCT_PATH, "<!--#include virtual=\"" + languagePage.getPath()
                            + "/instrument." + jsonObject.getString(AssayMenuUtil.PRODUCT_ID) + ".html\" -->");
                    
                    products.add(map);
                }
            } catch (final JSONException e) {
                LOGGER.error("Exception while parsing the json", e);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    private void getProductRelatedAssay(final Map<String, Map<String, String>> dataMap, final Set<String> legendsList,
            final String language) throws WebserviceException, RepositoryException {
        
        data = assayMenuService.viewAssayMenu(request, productId, language);
        if (ehcache.get("relatedAssay", language) == null) {
            final Map<String, Map<String, String>> qyeryResult = AssayMenuUtil.getProductPages(request, queryBuilder);
            if (!qyeryResult.isEmpty()) {
                dataMap.putAll(qyeryResult);
                ehcache.put("relatedAssay", language, dataMap);
            }
        } else {
            dataMap.putAll((Map<String, Map<String, String>>) ehcache.get("relatedAssay", language));
        }
        AssayMenuUtil.getAssaymenuList(data, dataMap, legendsList, relatedAssaysMap);
        
    }
    
    /**
     * Gets the product legends.
     * @param legendsList the legends list
     * @return the product legends
     */
    private List<Map<String, String>> getProductLegends(Set<String> legendsList) {
        final List<Map<String, String>> legendArray = new ArrayList<>();
        for (final String legend : legendsList) {
            final Map<String, String> legendData = new HashMap<>();
            legendData.put("legendName", "rdoe_assayMenu." + legend);
            legendData.put("legendClass", getLegendClass(legend));
            legendArray.add(legendData);
        }
        return legendArray;
    }
    
    private String getLegendClass(String legend) {
        String legendClass = StringUtils.EMPTY;
        switch (legend) {
            case "newProduct":
                legendClass = "new";
                break;
            case "featureProduct":
                legendClass = "feature";
                break;
            default:
            
        }
        return legendClass;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.AssayMenuModel#getLegends()
     */
    @Override
    public List<Map<String, String>> getLegends() {
        return legends;
        
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.AssayMenuModel#getTitle()
     */
    @Override
    public String getTitle() {
        return title;
        
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.AssayMenuModel#getProductId()
     */
    @Override
    public String getProductId() {
        return productId;
        
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.AssayMenuModel#getRelatedAssaysMap()
     */
    @Override
    public List<RelatedAssaysMap> getRelatedAssaysMap() {
        return relatedAssaysMap;
        
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.AssayMenuModel#getProducts()
     */
    @Override
    public List<Map<String, String>> getProducts() {
        return products;
        
    }
}
