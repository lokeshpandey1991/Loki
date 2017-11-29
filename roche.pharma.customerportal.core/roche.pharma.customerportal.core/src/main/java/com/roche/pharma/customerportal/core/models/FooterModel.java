package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.PageLinkBean;
import com.roche.pharma.customerportal.core.beans.SocialLinkBean;

@ConsumerType
public interface FooterModel {
    
    /**
     * @return countrySelectorPath
     */
    String getCountrySelectorPath();
    
    /**
     * @return disclaimer
     */
    String getDisclaimer();
    
    /**
     * @return tradeMark
     */
    String getTradeMark();
    
    /**
     * @return language
     */
    String getLanguage();
    
    /**
     * @return countryCode
     */
    String getCountryCode();
    
    /**
     * @return footerLinksList
     */
    List<PageLinkBean> getFooterLinksList();
    
    /**
     * @return socialList
     */
    List<SocialLinkBean> getSocialList();
    
}
