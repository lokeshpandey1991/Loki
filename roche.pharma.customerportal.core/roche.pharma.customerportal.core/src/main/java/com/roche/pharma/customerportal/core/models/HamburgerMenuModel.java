package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.PageLinkBean;

@ConsumerType
public interface HamburgerMenuModel {
    
    /**
     * @return logoAltText
     */
    String getLogoAltText();
    
    /**
     * @return isPersonaDisabled
     */
    boolean isPersonaDisabled();
    
    /**
     * @return personaSelectorPath
     */
    String getPersonaSelectorPath();
    
    /**
     * @return languageCode
     */
    String getLanguageCode();
    
    /**
     * @return countryCode
     */
    String getCountryCode();
    
    /**
     * @return hamburgerMenuLeftLinks
     */
    List<PageLinkBean> getHamburgerMenuLeftLinks();
    
    /**
     * @return hamburgerMenuRightLinks
     */
    List<PageLinkBean> getHamburgerMenuRightLinks();
    
    /**
     * @return countrySelectorPath
     */
    String getCountrySelectorPath();
    
}
