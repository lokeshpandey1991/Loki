package com.roche.pharma.customerportal.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.roche.pharma.customerportal.core.models.SearchBarFilterModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * This is model class for productDetail component.
 * @author nitin
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        SearchBarFilterModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = SearchBarFilterModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class SearchBarFilterModelImpl implements SearchBarFilterModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/searchBarFilter/v1/searchBarFilter";
    
    /** The resource. */
    @Self
    private Resource resource;
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SearchBarFilterModel#isElabDocEnabled()
     */
    @Override
    public boolean isElabDocEnabled() {
        final boolean isElabDocEnabled;
        isElabDocEnabled = CommonUtils.getGlobalConfigurations(resource) == null ? false
                : CommonUtils.getGlobalConfigurations(resource).isElabDocEnabled();
        return isElabDocEnabled;
    }
}
