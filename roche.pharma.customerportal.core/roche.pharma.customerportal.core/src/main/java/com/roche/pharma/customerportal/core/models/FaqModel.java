package com.roche.pharma.customerportal.core.models;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface FaqModel {
    
    /**
     * Gets the headline.
     * @return the headline
     */
    String getHeadline();
    
    /**
     * Gets the accoridon array.
     * @return the accoridon array
     */
    List<Map<String, String>> getFaqQuestionAnswerArray();
    
}
