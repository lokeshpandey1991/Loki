package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.MediaAndInfoBean;

@ConsumerType
public interface MediaAndInfoModel {
    
    String getCtaText();
    
    String getComponentName();
    
    String getCtaDescription();
    
    String[] getMediaLinks();
    
    List<MediaAndInfoBean> getMediaList();
    
}
