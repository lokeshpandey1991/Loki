package com.roche.pharma.customerportal.core.models;

import java.util.Map;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface DynamicSearchMediaModel {
    
    /**
     * Gets the dynamic media configuration.
     * @return the dynamic media configuration
     */
    Map<String, String> getDynamicMediaConfiguration();
    
    /**
     * Gets the rendition map.
     * @return renditionMap
     */
    Map<String, Map<String, String>> getRenditionMap();
    
    /**
     * Gets the image service URL.
     * @return the image service URL
     */
    String getImageServiceUrl();
    
}
