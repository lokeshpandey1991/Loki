package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface TextHighlightRailModel {
    
    /**
     * Gets the headline.
     * @return the headline
     */
    String getHeadline();
    
    /**
     * Gets the body text.
     * @return the body text
     */
    String getBodyText();
    
    /**
     * Gets the cta name.
     * @return the cta name
     */
    String getCtaName();
    
    /**
     * Gets the cta link.
     * @return the cta link
     */
    String getCtaLink();
    
    /**
     * Checks if is external.
     * @return true, if is external
     */
    boolean isExternal();
    
    /**
     * Gets the content type.
     * @return the content type
     */
    String getContentType();
    
}
