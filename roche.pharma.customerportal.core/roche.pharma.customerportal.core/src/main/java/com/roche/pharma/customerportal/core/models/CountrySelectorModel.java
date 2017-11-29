package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.ContinentBean;

@ConsumerType
public interface CountrySelectorModel {
    
    String getLocale();
    
    List<ContinentBean> getCountrySelectorList();
    
    String getGlobalHomePagePath();
    
    String getGlobalCountryCode();
    
    String getGlobalLanguageCode();
    
    String getGlobalChannel();
    
    String getComponentName();
    
}
