package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.PageLinkBean;

@ConsumerType
public interface HeaderModel {
    
    String getLogoPath();
    
    String getLogoAltText();
    
    String getHomePagePath();
    
    String getCountryCode();
    
    String getCountrySelectorPath();
    
    boolean isPersonaDisabled();
    
    String getPersona();
    
    String getPersonaSelectorPath();
    
    List<PageLinkBean> getHeaderLinksList();
    
    String getSearchUrl();
    
    String getSearchLimit();
    
    String getSearchResultPath();
    
    String getCurrentChannel();
    
    String getCurrentResolvedPath();
    
}
