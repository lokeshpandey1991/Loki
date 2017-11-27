package com.roche.pharma.customerportal.core.services;

/**
 * Service to refer working of forms To be deleted after form implementation
 * @author sagr25
 * @version 1.0
 */

@FunctionalInterface
public interface FormFrameworkService {
    
    /**
     * gets the input data of user URL
     * @return the input data of user
     */
    String injestFormData(String first, String last, String city);
    
    /**
     * injest the data provided by user in the form to the service class
     * @param first passes the value entered for first name
     * @param last passes the value entered for last name
     * @param city passes the value entered for city
     * @return String return the value of first name
     */
}
