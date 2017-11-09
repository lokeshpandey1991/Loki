package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.ProductCategoryListBean;

@ConsumerType
public interface ProductCategoryListModel {
    
    String getComponentName();
    
    String getFilterTag();
    
    String[] getListing();
    
    List<ProductCategoryListBean> getCategoryListing();
    
}
