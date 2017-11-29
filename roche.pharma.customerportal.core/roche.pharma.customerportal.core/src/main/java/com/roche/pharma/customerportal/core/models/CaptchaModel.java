package com.roche.pharma.customerportal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface CaptchaModel {
    
    /**
     * Gets the client side key.
     * @return the client side key
     */
    String getClientSideKey();
    
    /**
     * Checks if is captcha disabled.
     * @return true, if is captcha disabled
     */
    boolean isCaptchaDisabled();
    
}
