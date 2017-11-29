package com.roche.pharma.customerportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface MarketingTileModel {
    
    /**
     * Checks file reference is author over written then update the value
     * @param resource parameter for the method
     */
    void checkFileReference(Resource resource);
    
    /**
     * Checks altText is author over written then update the value
     * @param resource parameter for the method
     */
    void checkAltText(Resource resource);
    
    /**
     * Checks articleTitle is author over written then update the value
     * @param resource parameter for the method
     */
    void checkArticleTitle(Resource resource);
    
    /**
     * Checks articleSummary is author over written then update the value
     * @param resource parameter for the method
     */
    void checkArticleSummary(Resource resource);
    
    /**
     * @return the articleId
     */
    String getArticleId();
    
    /**
     * @return the articleTitle
     */
    String getArticleTitle();
    
    /**
     * @return the articleSummary
     */
    String getArticleSummary();
    
    /**
     * @return the altText
     */
    String getAltText();
    
    /**
     * @return the fileReference
     */
    String getFileReference();
    
    /**
     * @return the headline
     */
    String getHeadline();
    
    /**
     * @return the ctaLabel
     */
    String getCtaLabel();
    
    /**
     * @return the ctaLink
     */
    String getCtaLink();
    
    /**
     * @return the imagePosition
     */
    String getImagePosition();
    
    /**
     * @return the variationType
     */
    String getVariationType();
    
    /**
     * @return componentName
     */
    String getComponentName();
    
    /**
     * @return contentType
     */
    String getContentType();
    
}
