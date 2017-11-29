package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.PersonaBean;

@ConsumerType
public interface PersonaSelectorModel {
    
    /**
     * Gets the component name.
     * @return the component name
     */
    String getComponentName();
    
    /**
     * Gets the content type.
     * @return the content type
     */
    String getContentType();
    
    /**
     * Returns list containing object of PersonaBean.
     * @return the personas list
     */
    List<PersonaBean> getPersonaList();
    
    /**
     * Gets the persona header text.
     * @return the persona header text
     */
    String getPersonaHeaderText();
    
    /**
     * Gets the homepage path.
     * @return the homepage path
     */
    String getHomepagePath();
    
}
