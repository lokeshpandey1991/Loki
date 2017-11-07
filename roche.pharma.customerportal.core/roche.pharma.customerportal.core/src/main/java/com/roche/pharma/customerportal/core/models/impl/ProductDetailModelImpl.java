package com.roche.pharma.customerportal.core.models.impl;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.models.ProductDetailModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This is model class for productDetail component.
 * @author nitin
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        ProductDetailModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = ProductDetailModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class ProductDetailModelImpl implements ProductDetailModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/productDetail/v1/productDetail";
    
    /** The resource. */
    @Self
    private Resource resource;
    
    /** The product id. */
    @ValueMapValue
    private String productId;
    
    @ValueMapValue
    private String productType;
    
    /** The product logo select. */
    @Inject
    private String productLogoSelect;
    
    /** The logo path. */
    private String logoPath;
    
    /** The logo description. */
    private String logoDescription;
    
    /** The logo name. */
    private String logoName;
    
    /** The is exists. */
    private Boolean isExists;
    
    /** The Constant SEPARATOR. */
    private static final String SEPARATOR = "'''";
    
    /** The deactivate product logo. */
    @ValueMapValue
    private String deactivateProductLogo;
    
    /**
     * locale for the product
     */
    private Locale locale;
    
    /**
     * This Method is called when the resource is adapted to the ProductDetailModel.
     */
    @PostConstruct
    protected void postConstruct() {
        locale = GlobalUtils.getPageLocale(GlobalUtils.getCurrentPage(resource));
        
        if (!StringUtils.equalsIgnoreCase(productLogoSelect, "null") && StringUtils.isNotEmpty(productLogoSelect)
                && deactivateProductLogo == null) {
            setIsExists(true);
            processProductLogoSelect();
        } else {
            setIsExists(false);
        }
        
    }
    
    /**
     * This method is used to separate the values of the productLogoSelect using the separator.
     */
    private void processProductLogoSelect() {
        final String[] productLogoArray = StringUtils.split(productLogoSelect, SEPARATOR);
        setLogoName(productLogoArray[0]);
        setLogoDescription(productLogoArray[1]);
        setLogoPath(productLogoArray[2]);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getLogoPath()
     */
    @Override
    public String getLogoPath() {
        return logoPath;
    }
    
    /**
     * Sets the logo path.
     * @param logoPath the new logo path
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getLogoDescription()
     */
    @Override
    public String getLogoDescription() {
        return logoDescription;
    }
    
    /**
     * Sets the logo description.
     * @param logoDescription the new logo description
     */
    public void setLogoDescription(String logoDescription) {
        this.logoDescription = logoDescription;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getLogoName()
     */
    @Override
    public String getLogoName() {
        return logoName;
    }
    
    /**
     * Sets the logo name.
     * @param logoName the new logo name
     */
    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getProductSSIPath()
     */
    @Override
    public String getProductSSIPath() {
        return "<!--#include virtual=\"/product/" + locale.toString() + "/" + productId + ".json\" -->";
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getProductId()
     */
    @Override
    public String getProductId() {
        return productId;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getIsExists()
     */
    @Override
    public Boolean getIsExists() {
        return isExists;
    }
    
    /**
     * Sets the checks if is exists.
     * @param isExists the new checks if is exists
     */
    public void setIsExists(Boolean isExists) {
        this.isExists = isExists;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getProductMeta()
     */
    @Override
    public String getProductMeta() {
        return "<!--#include virtual=\"/productmeta/" + locale.toString() + "/" + productId + ".json\" -->";
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getFeaturedProduct()
     */
    @Override
    public String getFeaturedProduct() {
        return "featureProduct".equals(productType) ? "yes" : "no";
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#getNewProduct()
     */
    @Override
    public String getNewProduct() {
        return "newProduct".equals(productType) ? "yes" : "no";
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#isDTLEnabled()
     */
    @Override
    public boolean isDTLEnabled() {
        final boolean isDTLEnabled;
        isDTLEnabled = CommonUtils.getGlobalConfigurations(resource) == null ? false
                : CommonUtils.getGlobalConfigurations(resource).isDTLEnabled();
        return isDTLEnabled;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#isProductMetaEnabled()
     */
    @Override
    public boolean isProductMetaEnabled() {
        final boolean isProductMetaEnabled;
        isProductMetaEnabled = CommonUtils.getGlobalConfigurations(resource) == null ? false
                : CommonUtils.getGlobalConfigurations(resource).isProductMetaEnabled();
        return isProductMetaEnabled;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#isElabDocEnabledForAssays()
     */
    @Override
    public boolean isElabDocEnabledForAssays() {
        final boolean isElabDocEnabledForAssays;
        isElabDocEnabledForAssays = CommonUtils.getGlobalConfigurations(resource) == null ? false
                : CommonUtils.getGlobalConfigurations(resource).isElabDocEnabledForAssays();
        return isElabDocEnabledForAssays;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDetailModel#isElabDocEnabled()
     */
    @Override
    public boolean isElabDocEnabled() {
        final boolean isElabDocEnabled;
        isElabDocEnabled = CommonUtils.getGlobalConfigurations(resource) == null ? false
                : CommonUtils.getGlobalConfigurations(resource).isElabDocEnabled();
        return isElabDocEnabled;
    }
}
