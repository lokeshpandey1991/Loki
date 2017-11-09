package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface CookieDisclaimerModel {
    
    /**
     * @return url from the language configurations
     */
    String getUrl();
    
    /**
     * Checks if is cookie notification disabled.
     * @return true, if is cookie notification disabled
     */
    boolean isCookieNotificationDisabled();
    
}
