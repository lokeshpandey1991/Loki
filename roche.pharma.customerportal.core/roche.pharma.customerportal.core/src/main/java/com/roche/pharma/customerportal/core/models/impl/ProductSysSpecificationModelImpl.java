/**
 * 
 */
package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.beans.SystemSpecificationBean;
import com.roche.pharma.customerportal.core.models.ProductSysSpecificationModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This model class use system specification component to display the properties
 * @author agu207
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        ProductSysSpecificationModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = ProductSysSpecificationModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class ProductSysSpecificationModelImpl implements ProductSysSpecificationModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/productSysSpecification";
    
    @Self
    private Resource resource;
    
    @ValueMapValue
    private String secTitle;
    
    @ValueMapValue
    private String[] proSysData;
    
    @ValueMapValue
    private String isMoreLink;
    
    private List<SystemSpecificationBean> proSysDataList = new ArrayList<>();
    
    private String componentName;
    
    private String systemSpecificationDoc;
    
    private Boolean moreLinkCheck;
    
    @PostConstruct
    protected void postConstruct() {
        proSysDataList = getMultifieldValue(proSysData, proSysDataList);
        final Page page = GlobalUtils.getCurrentPage(resource);
        if (null != page && page.getProperties().containsKey("systemSpecificationDoc")) {
            systemSpecificationDoc = page.getProperties().get("systemSpecificationDoc", String.class);
        }
        // See more Link Check
        if (null == isMoreLink) {
            setMoreLinkCheck(false);
        } else {
            setMoreLinkCheck(true);
        }
    }
    
    /**
     * This method return the list of data added into multi-field
     * @param jsonArr is the parameter to be used
     * @param sysSpecList is the parameter to be used
     * @return sysSpecList is the list of objects
     */
    private List<SystemSpecificationBean> getMultifieldValue(final String[] jsonArr,
            final List<SystemSpecificationBean> sysSpecList) {
        if (jsonArr != null) {
            for (final String json : jsonArr) {
                final SystemSpecificationBean systemSpecificationBean = CommonUtils.getMultifield(json,
                        SystemSpecificationBean.class);
                sysSpecList.add(systemSpecificationBean);
                componentName = CommonUtils.getComponentName(resource);
            }
        }
        
        return sysSpecList;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductSysSpecificationModel#getComponentName()
     */
    @Override
    public String getComponentName() {
        return componentName;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductSysSpecificationModel#getSecTitle()
     */
    @Override
    public String getSecTitle() {
        return secTitle;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductSysSpecificationModel#getProSysDataList()
     */
    @Override
    public List<SystemSpecificationBean> getProSysDataList() {
        return new ArrayList<>(proSysDataList);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductSysSpecificationModel#getSystemSpecificationDoc()
     */
    @Override
    public String getSystemSpecificationDoc() {
        return systemSpecificationDoc;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductSysSpecificationModel#getMoreLinkCheck()
     */
    @Override
    public Boolean getMoreLinkCheck() {
        return moreLinkCheck;
    }
    
    /**
     * @param moreLinkCheck the moreLinkCheck to set
     */
    public void setMoreLinkCheck(Boolean moreLinkCheck) {
        this.moreLinkCheck = moreLinkCheck;
    }
}
