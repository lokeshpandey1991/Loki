package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.ProductCategoryFilterBean;

@ConsumerType
public interface ProductCategoryFilterModel {
    
    List<ProductCategoryFilterBean> getCategoryFilter();
    
    String[] getFilters();
    
}
