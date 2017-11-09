package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.PDPNavTabsModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This is model class for PDPnavtabs component.
 * @author mhuss3
 * @version 2.0
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        PDPNavTabsModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = PDPNavTabsModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class PDPNavTabsModelImpl implements PDPNavTabsModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/pDPNavTabs/v1/pDPNavTabs";
    
    /**
     * Resource
     */
    @Self
    private Resource resource;
    
    @ValueMapValue
    private String titleTab1;
    
    @ValueMapValue
    private String titleTab2;
    
    @ValueMapValue
    private String titleTab3;
    
    @ValueMapValue
    private String titleTab4;
    
    @ValueMapValue
    private String hideTab1;
    
    @ValueMapValue
    private String hideTab2;
    
    @ValueMapValue
    private String hideTab3;
    
    @ValueMapValue
    private String hideTab4;
    
    /**
     * Default tab property
     */
    @ValueMapValue
    private String defaultTab;
    
    /**
     * Post construct method. Here default tab value is set.
     */
    @PostConstruct
    protected void postConstruct() {
        final Page currentPage = GlobalUtils.getCurrentPage(resource);
        if (null != currentPage && currentPage.getProperties().containsKey(RocheConstants.ASSAY_TYPE)) {
            defaultTab = null == defaultTab ? "tab3" : defaultTab;
        }
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getDefaultTab()
     */
    @Override
    public String getDefaultTab() {
        return StringUtils.isBlank(defaultTab) ? "tab1" : defaultTab;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getShowTab1()
     */
    @Override
    public Boolean getShowTab1() {
        return !RocheConstants.TRUE_VALUE.equalsIgnoreCase(hideTab1);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getShowTab2()
     */
    @Override
    public Boolean getShowTab2() {
        return !RocheConstants.TRUE_VALUE.equalsIgnoreCase(hideTab2);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getShowTab3()
     */
    @Override
    public Boolean getShowTab3() {
        Resource parentResource = resource.getParent();
        if (null != parentResource) {
            String resourceType = parentResource.getResourceType();
            if ((RocheConstants.SMALL_PRODUCT_RESOURCE.equalsIgnoreCase(resourceType) && !isElabDocEnabledForAssays())
                    || (RocheConstants.PRODUCT_RESOURCE.equalsIgnoreCase(resourceType) && !isElabDocEnabled())) {
                return false;
            } else {
                return !RocheConstants.TRUE_VALUE.equalsIgnoreCase(hideTab3);
            }
        } else {
            return !RocheConstants.TRUE_VALUE.equalsIgnoreCase(hideTab3);
        }
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getShowTab4()
     */
    @Override
    public Boolean getShowTab4() {
        return !RocheConstants.TRUE_VALUE.equalsIgnoreCase(hideTab4);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getTitleTab1()
     */
    @Override
    public String getTitleTab1() {
        return StringUtils.isBlank(titleTab1) ? "rdoe_pdpnavtabs.productInformation" : titleTab1;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getTitleTab2()
     */
    @Override
    public String getTitleTab2() {
        return StringUtils.isBlank(titleTab2) ? "rdoe_pdpnavtabs.productSpecs" : titleTab2;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getTitleTab3()
     */
    @Override
    public String getTitleTab3() {
        return StringUtils.isBlank(titleTab3) ? "rdoe_pdpnavtabs.documentation" : titleTab3;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#getTitleTab4()
     */
    @Override
    public String getTitleTab4() {
        return StringUtils.isBlank(titleTab4) ? "rdoe_pdpnavtabs.relatedProducts" : titleTab4;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#isElabDocEnabledForAssays()
     */
    @Override
    public boolean isElabDocEnabledForAssays() {
        final boolean isElabDocEnabledForAssays;
        isElabDocEnabledForAssays = CommonUtils.getGlobalConfigurations(resource) == null ? false
                : CommonUtils.getGlobalConfigurations(resource).isElabDocEnabledForAssays();
        return isElabDocEnabledForAssays;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PDPNavTabsModel#isElabDocEnabled()
     */
    @Override
    public boolean isElabDocEnabled() {
        final boolean isElabDocEnabled;
        isElabDocEnabled = CommonUtils.getGlobalConfigurations(resource) == null ? false
                : CommonUtils.getGlobalConfigurations(resource).isElabDocEnabled();
        return isElabDocEnabled;
    }
}
