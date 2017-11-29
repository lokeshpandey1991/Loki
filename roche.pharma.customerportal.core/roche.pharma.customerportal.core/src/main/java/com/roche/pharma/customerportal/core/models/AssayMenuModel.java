package com.roche.pharma.customerportal.core.models;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.dto.RelatedAssaysMap;

@ConsumerType
public interface AssayMenuModel {
    
    /**
     * Gets the data.
     * @return the data
     */
    List<Map<String, String>> getLegends();
    
    /**
     * Gets the title.
     * @return the product id
     */
    String getTitle();
    
    /**
     * Gets the product id.
     * @return the product id
     */
    String getProductId();
    
    /**
     * Gets the related assays map.
     * @return the related assays map
     */
    List<RelatedAssaysMap> getRelatedAssaysMap();
    
    /**
     * @return list of products
     */
    List<Map<String, String>> getProducts();
    
}
