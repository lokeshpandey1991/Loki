package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface TitleModel {
    
    /**
     * Gets the title.
     * @return the title
     */
    String getTitle();
    
    /**
     * Gets the page type.
     * @return the page type
     */
    String getPageType();
    
}
