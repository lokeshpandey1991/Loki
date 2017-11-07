package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface ProductDescriptionModel {
    
    /**
     * This method returns the headline entered by Author.
     * @return productDescrHeading
     */
    String getProductDescriptionHeading();
    
    /**
     * This method return the description entered by Author.
     * @return productDescription
     */
    String getProductDescription();
    
    /**
     * This method returns the view flag as selected by Author.
     * @return columnView
     */
    Boolean getIsColumnView();
    
}
