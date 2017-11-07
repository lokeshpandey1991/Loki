package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.models.SocialFeedModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * This is model class for productDetail component.
 * @author nitin
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        SocialFeedModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = SocialFeedModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class SocialFeedModelImpl implements SocialFeedModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/socialFeed/v1/socialFeed";
    
    /** The self resource */
    @Self
    private Resource resource;
    
    /** The number of items in social feed. */
    @ValueMapValue
    private String limit;
    
    /** The user name for the account configured. */
    @ValueMapValue
    private String userName;
    
    /** The component name. */
    private String componentName;
    
    /**
     * This Method is called when the resource is adapted to the ProductDetailModel.
     */
    @PostConstruct
    protected void postConstruct() {
        componentName = CommonUtils.getComponentName(resource);
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SocialFeedModel#getLimit()
     */
    @Override
    public String getLimit() {
        return limit;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SocialFeedModel#getUserName()
     */
    @Override
    public String getUserName() {
        return userName;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SocialFeedModel#getComponentName()
     */
    @Override
    public String getComponentName() {
        return componentName;
    }
}
