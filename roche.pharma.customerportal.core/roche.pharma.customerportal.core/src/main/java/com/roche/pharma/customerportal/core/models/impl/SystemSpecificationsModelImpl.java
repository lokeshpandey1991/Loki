package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.models.SystemSpecificationsModel;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * * This System Specifications model class is called from pdpfeaturespecs component and it returns
 * systemSpecificationDoc property which is authored in product detail page proerties
 * @author Nitin Kumar
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        SystemSpecificationsModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = SystemSpecificationsModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class SystemSpecificationsModelImpl implements SystemSpecificationsModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/systemSpecifications/v1/systemSpecifications";
    
    @Self
    private Resource resource;
    
    private String systemSpecificationDoc;
    
    @PostConstruct
    protected void postConstruct() {
        final Page page = GlobalUtils.getCurrentPage(resource);
        if (null != page && page.getProperties().containsKey("systemSpecificationDoc")) {
            systemSpecificationDoc = page.getProperties().get("systemSpecificationDoc", String.class);
        }
        
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SystemSpecificationsModel#getSystemSpecificationDoc()
     */
    @Override
    public String getSystemSpecificationDoc() {
        return systemSpecificationDoc;
    }
}
