package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface SearchBarFilterModel {
    
    /**
     * Gets the configuration for elab doc is enabled
     * @return is elab doc enabled
     */
    boolean isElabDocEnabled();
    
}
