package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface SocialShareModel {
    
    /**
     * @return shareId
     */
    String getShareId();
    
    /**
     * @return socialShareLinks
     */
    List<String> getSocialShareLinks();
    
}
