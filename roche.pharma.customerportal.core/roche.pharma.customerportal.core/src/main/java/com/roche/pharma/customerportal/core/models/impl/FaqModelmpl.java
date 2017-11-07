package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.roche.pharma.customerportal.core.models.FaqModel;

/**
 * The Class FaqModel.
 * @author Avinash kumar
 */

@Model(adaptables = {
        Resource.class
}, adapters = {
        FaqModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = FaqModelmpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class FaqModelmpl implements FaqModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/faq/v1/faq";
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FaqModelmpl.class);
    
    /** The headline. */
    @Inject
    @Default(values = "")
    private String headline;
    
    /** The accoridon array. */
    @Inject
    @Default(intValues = {})
    private String[] accoridonArray;
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FaqModel#getHeadline()
     */
    @Override
    public String getHeadline() {
        return headline;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FaqModel#getFaqQuestionAnswerArray()
     */
    @Override
    public List<Map<String, String>> getFaqQuestionAnswerArray() {
        final List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        try {
            for (final String json : accoridonArray) {
                final Map<String, String> map = new HashMap<String, String>();
                final JSONObject jsonObject = new JSONObject(json);
                map.put("question", jsonObject.getString("question"));
                map.put("answer", jsonObject.getString("answer"));
                data.add(map);
            }
        } catch (final JSONException e) {
            LOGGER.error("Exception while parsing the json", e);
        }
        return data;
    }
}
