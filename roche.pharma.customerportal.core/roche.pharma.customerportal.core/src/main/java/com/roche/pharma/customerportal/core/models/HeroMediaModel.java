package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface HeroMediaModel {
    
    /**
     * @return the altText
     */
    String getAltText();
    
    /**
     * @return the fileReference
     */
    String getFileReference();
    
    /**
     * @return the headlinePosition
     */
    String getHeadlinePosition();
    
    /**
     * @return the headline
     */
    String getHeadline();
    
    /**
     * @return the subHeadline
     */
    String getSubHeadline();
    
    /**
     * @return the quoteText
     */
    String getQuoteText();
    
    /**
     * @return the textPosition
     */
    String getTextPosition();
    
    /**
     * @return the cTALabel
     */
    String getCTALabel();
    
    /**
     * @return the cTALink
     */
    String getCTALink();
    
    /**
     * @return the assetType
     */
    String getAssetType();
    
    /**
     * @return the isExternal
     */
    String getIsExternal();
    
    /**
     * @return the variationType
     */
    String getVariationType();
    
    /**
     * @return the transparentOverlay
     */
    String getTransparentOverlay();
    
    /**
     * @return videoName
     */
    String getVideoName();
    
    /**
     * @return videoLanguage
     */
    String getVideoLanguage();
    
    /**
     * @return componentName
     */
    String getComponentName();
    
    /**
     * @return contentType
     */
    String getContentType();
    
}
