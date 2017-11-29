package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface VideoModel {
    
    /**
     * Gets the asset path.
     * @return the asset path
     */
    String getAssetPath();
    
    /**
     * Gets the headline.
     * @return the headline
     */
    String getHeadline();
    
    /**
     * Gets the transparent overlay.
     * @return the transparent overlay
     */
    String getTransparentOverlay();
    
    /**
     * Gets the poster link.
     * @return the poster link
     */
    String getPosterLink();
    
}
