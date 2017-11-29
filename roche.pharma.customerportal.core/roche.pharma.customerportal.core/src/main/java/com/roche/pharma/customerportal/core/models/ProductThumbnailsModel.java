package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.ProductThumbnails;

@ConsumerType
public interface ProductThumbnailsModel {
    
    /**
     * getter for productThumbnailsList
     * @return productThumbnailsList
     */
    List<ProductThumbnails> getProductThumbnailsList();
    
}
