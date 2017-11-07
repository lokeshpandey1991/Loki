package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface SocialFeedModel {
    
    String getLimit();
    
    String getUserName();
    
    String getComponentName();
    
}
