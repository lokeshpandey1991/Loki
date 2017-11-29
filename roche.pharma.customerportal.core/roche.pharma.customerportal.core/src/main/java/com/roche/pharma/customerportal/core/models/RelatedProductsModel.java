package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.RelatedProductBean;

@ConsumerType
public interface RelatedProductsModel {
    
    /**
     * This is a test method for Search and promote nested facets It will be deleted after design is finalized and
     * complete.
     * @return list of product detail page URLs
     */
    List<String> getPdpUrls();
    
    /**
     * This is a getter method for pdpBeanList
     * @return the pdpBeanList
     */
    List<RelatedProductBean> getPdpBeanList();
    
    /**
     * This is a getter method for sectionHeading
     * @return the sectionHeading
     */
    String getSectionHeading();
    
    /**
     * This is a getter method for component name
     * @return
     */
    String getComponentName();
    
}
