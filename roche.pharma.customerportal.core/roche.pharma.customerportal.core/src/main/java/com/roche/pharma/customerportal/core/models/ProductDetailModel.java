package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface ProductDetailModel {
    
    /**
     * Gets the logo path.
     * @return the logo path
     */
    String getLogoPath();
    
    /**
     * Gets the logo description.
     * @return the logo description
     */
    String getLogoDescription();
    
    /**
     * Gets the logo name.
     * @return the logo name
     */
    String getLogoName();
    
    /**
     * Gets the product SSI path.
     * @return the product SSI path
     */
    String getProductSSIPath();
    
    /**
     * Gets the product id.
     * @return the product id
     */
    String getProductId();
    
    /**
     * Gets the checks if is exists.
     * @return the checks if is exists
     */
    Boolean getIsExists();
    
    /**
     * Gets the product meta.
     * @return the product meta
     */
    String getProductMeta();
    
    /**
     * @return featuredProduct
     */
    String getFeaturedProduct();
    
    String getNewProduct();
    
    /**
     * Gets the configuration for DTL is enabled
     * @return is DTL enabled
     */
    boolean isDTLEnabled();
    
    /**
     * Gets the configuration for meta tag for product is enabled
     * @return is product metadata enabled
     */
    boolean isProductMetaEnabled();
    
    /**
     * Gets the configuration for elab doc is enabled
     * @return is elab doc enabled
     */
    boolean isElabDocEnabledForAssays();
    
    /**
     * Gets the configuration for elab doc is enabled
     * @return is elab doc enabled
     */
    boolean isElabDocEnabled();
    
}
