package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.roche.pharma.customerportal.core.models.Parent;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {
        Parent.class, ComponentExporter.class
}, resourceType = ParentImpl.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ParentImpl implements Parent, ComponentExporter {
    
    protected static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/parent";
    
    @ScriptVariable
    private Resource resource;

    @Self
    private SlingHttpServletRequest slingRequest;
    
    private String componentName;

    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ParentImpl#getComponentName()
     */
    @Override
    public String getComponentName() {
        return componentName;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ParentImpl#getExportedType() To get the resource type of
     * component
     */
    @Nonnull
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ParentImpl#initModel() To initialize the model of the
     * component
     */
    @PostConstruct
    private void initModel() {
        componentName = CommonUtils.getComponentName(slingRequest.getResource());
        
    }
    
}
