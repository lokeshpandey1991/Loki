package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface ProductDetailNameModel {
    
    String getProductName();
    
    String getValueProposition();
    
    String getFileReference();
    
    String getAltText();
    
}
