package com.roche.pharma.customerportal.core.services.impl;

import org.apache.felix.scr.annotations.Component;

import org.apache.felix.scr.annotations.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.roche.pharma.customerportal.core.services.SampleFormService;

@Service(value = SampleFormService.class)
@Component(immediate = true, metatype = true, label = "Sample Form Service")

public class SampleFormServiceImpl implements SampleFormService {

	/** Default log. */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public String injestFormData(String first, String last, String city) {
		// Simply write out the values that are posted from the AEM form to the
		// AEM log file
		log.info("Data posted from an AEM  form - Firstname: " + first + " Lastname: " + last + " City: " + city);
		return first;

	}

}
