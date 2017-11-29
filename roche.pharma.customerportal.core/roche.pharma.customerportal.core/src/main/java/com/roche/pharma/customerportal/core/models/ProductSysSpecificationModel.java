package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.SystemSpecificationBean;

@ConsumerType
public interface ProductSysSpecificationModel {
    
    /**
     * @return componentName
     */
    String getComponentName();
    
    /**
     * @return secTitle
     */
    String getSecTitle();
    
    /**
     * @return the proSysDataList
     */
    List<SystemSpecificationBean> getProSysDataList();
    
    /**
     * @return the systemSpecificationDoc
     */
    String getSystemSpecificationDoc();
    
    /**
     * @return the moreLinkCheck
     */
    Boolean getMoreLinkCheck();
    
}
