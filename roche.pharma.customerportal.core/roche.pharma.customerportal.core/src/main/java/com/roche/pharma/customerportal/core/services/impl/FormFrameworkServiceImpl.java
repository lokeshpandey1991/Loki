package com.roche.pharma.customerportal.core.services.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.roche.pharma.customerportal.core.services.FormFrameworkService;

/**
 * Implementation of the sample service to describe form functioning To be deleted after form implementation
 * @author sagr25
 * @version 1.0
 */

@Service(value = FormFrameworkService.class)

@Component(immediate = true, metatype = true, label = "Sample Form Service")
/**
 * The Class SampleServiceImpl provides the value of first name entered by user
 */

public class FormFrameworkServiceImpl implements FormFrameworkService {
    
    /** Default log. */
    protected final Logger log = LoggerFactory.getLogger(FormFrameworkServiceImpl.class);
    
    /**
     * Gets the value entered by user in the form fields
     */
    @Override
    public String injestFormData(final String first, final String last, final String city) {
        
        /**
         * Simply write out the values that are posted from the AEM form to the AEM log file
         */
        log.info("Data posted from an AEM  form - Firstname: " + first + " Lastname: " + last + " City: " + city);
        return first;
        
    }
    
}
