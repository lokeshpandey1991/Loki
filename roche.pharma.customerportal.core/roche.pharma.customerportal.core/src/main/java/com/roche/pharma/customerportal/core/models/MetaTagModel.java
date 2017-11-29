package com.roche.pharma.customerportal.core.models;

import java.util.Map;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface MetaTagModel {
    
    /**
     * Gets if featured products are shown on page load.
     * @return showFeaturedProduct
     */
    String getShowFeaturedProduct();
    
    /**
     * This method returns if category facets are required to be fetched using ssi.
     * @return enableSSI
     */
    Boolean isEnableSSI();
    
    /**
     * This method returns the complete proxy url for fetching category facets on PLP page.
     * @return ssiUrl
     */
    String getSnPSSIUrl();
    
    /**
     * This method reads the cq tags from page and provide the map for meta tags.
     * @return map for meta tags
     */
    Map<String, String> getMetaDataValues();
    
    /**
     * This is a test method for S&P nested facets It will be deleted after design is finalized and complete.
     * @return map
     */
    Map<String, String> getListingMeta();
    
}
