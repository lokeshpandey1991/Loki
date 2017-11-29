package com.roche.pharma.customerportal.core.models;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.SortBean;

@ConsumerType
public interface SearchSortModel {
    
    /**
     * gives the sort option list
     * @return sortList
     */
    List<SortBean> getSortList();
    
    /**
     * gives the default behavior for search page
     * @return defaultOption
     */
    Map<String, String> getDefaultOption();
    
    /**
     * gives the default sort option of PLP and events page
     * @return defaultSort
     */
    String getDefaultSort();
    
}
