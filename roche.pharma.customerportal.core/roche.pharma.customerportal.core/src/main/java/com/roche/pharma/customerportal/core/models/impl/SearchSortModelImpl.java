package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.beans.SortBean;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.SearchSortModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * This java model is called from AEM component searchsort and listingsort. It returns the list of sort options and
 * sorting types and the default behavior and sort option configured by the author
 * @author sandip
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        SearchSortModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = SearchSortModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class SearchSortModelImpl implements SearchSortModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/searchSort/v1/searchSort";
    
    private final List<SortBean> sortList = new ArrayList<>();
    
    @ValueMapValue
    private String[] searchsort;
    
    @ValueMapValue
    private String productDefaultBehaviour;
    
    @ValueMapValue
    private String moreDefaultBehaviour;
    
    @ValueMapValue
    private String defaultSort;
    
    private final Map<String, String> defaultOption = new HashMap<>();
    
    /* Static variable for products and more */
    private static final String DEFAULT_PRODUCT_OPTION = "product";
    
    private static final String DEFAULT_MORE_OPTION = "more";
    
    /**
     * postConstruct method is called when the valued are successfully injected.
     */
    @PostConstruct
    protected void postConstruct() {
        getMultifieldValue(searchsort);
    }
    
    /**
     * This method provides list based on json and ArrayList
     * @param json
     */
    private void getMultifieldValue(final String[] jsonArr) {
        if (jsonArr != null) {
            for (final String json : jsonArr) {
                final SortBean sortBean = CommonUtils.getMultifield(json, SortBean.class);
                final String searchSortValue = sortBean.getSearchValue();
                sortBean.setSearchLabel(RocheConstants.SORT_KEY_PREFIX + searchSortValue);
                sortList.add(sortBean);
            }
        }
        defaultOption.put(DEFAULT_PRODUCT_OPTION, productDefaultBehaviour);
        defaultOption.put(DEFAULT_MORE_OPTION, moreDefaultBehaviour);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SearchSortModel#getSortList()
     */
    @Override
    public List<SortBean> getSortList() {
        return sortList;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SearchSortModel#getDefaultOption()
     */
    @Override
    public Map<String, String> getDefaultOption() {
        return defaultOption;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SearchSortModel#getDefaultSort()
     */
    @Override
    public String getDefaultSort() {
        return defaultSort;
    }
}
