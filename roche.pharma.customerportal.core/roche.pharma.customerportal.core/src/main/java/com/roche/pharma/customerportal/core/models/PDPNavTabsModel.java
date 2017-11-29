package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface PDPNavTabsModel {
    
    /**
     * Gets the default tab
     * @return default tab
     */
    String getDefaultTab();
    
    /**
     * gets if tab1 is to be shown.
     * @return show tab1
     */
    Boolean getShowTab1();
    
    /**
     * gets if tab2 is to be shown.
     * @return show tab2
     */
    Boolean getShowTab2();
    
    /**
     * gets if tab3 is to be shown.
     * @return show tab3
     */
    Boolean getShowTab3();
    
    /**
     * gets if tab4 is to be shown.
     * @return show tab4
     */
    Boolean getShowTab4();
    
    /**
     * gets title for tab1
     * @return title tab1
     */
    String getTitleTab1();
    
    /**
     * gets title for tab2
     * @return title tab2
     */
    String getTitleTab2();
    
    /**
     * gets title for tab3
     * @return title tab3
     */
    String getTitleTab3();
    
    /**
     * gets title for tab4
     * @return title tab4
     */
    String getTitleTab4();
    
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
