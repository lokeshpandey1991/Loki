package com.roche.pharma.customerportal.core.models;

import java.util.Map;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface DynamicImageModel {
    
    /**
     * Gets the image service URL.
     * @return the image service URL
     */
    String getImageServiceURL();
    
    /**
     * Gets the dynamic media configuration.
     * @return the dynamic media configuration
     */
    Map<String, String> getDynamicMediaConfiguration();
    
    /**
     * Gets the file reference.
     * @return the file reference
     */
    String getFileReference();
    
    /**
     * Gets the desktop url.
     * @return the desktop url
     */
    String getDesktopUrl();
    
    /**
     * Gets the mobile portrait url.
     * @return the mobile portrait url
     */
    String getMobilePortraitUrl();
    
    /**
     * Gets the mobile landscape url.
     * @return the mobile landscape url
     */
    String getMobileLandscapeUrl();
    
    /**
     * Gets the tablet portrait url.
     * @return the tablet portrait url
     */
    String getTabletPortraitUrl();
    
    /**
     * Gets the tablet landscape url.
     * @return the tablet landscape url
     */
    String getTabletLandscapeUrl();
    
    /**
     * Gets the alt text.
     * @return the alt text
     */
    String getAltText();
    
    /**
     * Gets the view.
     * @return the view
     */
    String getView();
    
    /**
     * Gets the variation type.
     * @return the variation type
     */
    String getVariationType();
    
}
