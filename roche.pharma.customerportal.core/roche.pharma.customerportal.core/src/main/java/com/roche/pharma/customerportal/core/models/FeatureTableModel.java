package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface FeatureTableModel {
    
    /**
     * Gets the table text
     * @return text
     */
    String getTable();
    
    /**
     * Gets the table heading
     * @return tableHeading
     */
    String getTableHeading();
    
    /**
     * Gets the table description
     * @return tableDescription
     */
    String getTableDescription();
    
    /**
     * Gets the table Disclaimer
     * @return tableDisclaimer
     */
    String getTableDisclaimer();
    
}
