package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.PageLinkBean;

@ConsumerType
public interface RelatedLinksModel {
    
    /**
     * @return relatedList
     */
    List<PageLinkBean> getRelatedList();
    
    /**
     * @return headline
     */
    String getHeadline();
    
}
