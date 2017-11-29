package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.LinksListBean;

@ConsumerType
public interface ErrorComponentModel {
    
    /**
     * this method called from AEM component
     * @return error page title
     */
    String getNotificationTitle();
    
    /**
     * This method is called from AEM component
     * @return error page description
     */
    String getNotificationDescription();
    
    /**
     * this method is called from AEM component
     * @return list of links on error page
     */
    List<LinksListBean> getLinks();
    
    /**
     * tihs method called from component for analytics
     * @return name of current component
     */
    String getComponentName();
    
}
