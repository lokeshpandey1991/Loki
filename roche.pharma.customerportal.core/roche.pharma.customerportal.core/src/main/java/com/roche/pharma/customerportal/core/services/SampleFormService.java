package com.roche.pharma.customerportal.core.services;


public interface  SampleFormService {
    
    /**
     * gets the input data of user URL
     * @return the input data of user
     */
	public String injestFormData(String first, String last, String city); 
    
  }