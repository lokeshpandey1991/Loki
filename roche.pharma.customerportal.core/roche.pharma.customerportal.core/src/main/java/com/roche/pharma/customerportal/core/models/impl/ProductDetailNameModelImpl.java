package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.models.ProductDetailNameModel;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This is model class for productDetailName Component.
 * @author mhuss3
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        ProductDetailNameModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = ProductDetailNameModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class ProductDetailNameModelImpl implements ProductDetailNameModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/productDetailName/v1/productDetailName";
    
    @ValueMapValue
    private String productName;
    
    @ValueMapValue
    private String valueProposition;
    
    @ValueMapValue
    private String fileReference;
    
    @ValueMapValue
    private String altText;
    
    @Self
    private Resource resource;
    
    @PostConstruct
    protected void postConstruct() {
        if (StringUtils.isBlank(productName)) {
            final Page currentPage = GlobalUtils.getCurrentPage(resource);
            if (currentPage != null) {
                productName = currentPage.getTitle();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailNameModel#getProductName()
     */
    @Override
    public String getProductName() {
        return productName;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailNameModel#getValueProposition()
     */
    @Override
    public String getValueProposition() {
        return valueProposition;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailNameModel#getFileReference()
     */
    @Override
    public String getFileReference() {
        return fileReference;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailNameModel#getAltText()
     */
    @Override
    public String getAltText() {
        return altText;
    }
    
}
