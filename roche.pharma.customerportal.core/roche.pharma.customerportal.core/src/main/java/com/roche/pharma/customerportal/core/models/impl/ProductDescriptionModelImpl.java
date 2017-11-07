/**
 * This is Sling Model class for productDescription Component.
 * @author nitin kumar
 * @version 1.0
 */
package com.roche.pharma.customerportal.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.ProductDescriptionModel;

/**
 * This is productDescriptionModel Class. This class contains methods to return Authored values.
 * @author nitin kumar
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        ProductDescriptionModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = ProductDescriptionModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class ProductDescriptionModelImpl implements ProductDescriptionModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/productDescription/v1/productDescription";
    
    /**
     * product Description Heading property
     */
    @ValueMapValue
    private String productDescrHeading;
    
    /**
     * product Description property
     */
    @ValueMapValue
    private String productDescription;
    
    /**
     * column view property
     */
    @ValueMapValue
    private String columnView;
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDescriptionModel#getProductDescriptionHeading()
     */
    @Override
    public String getProductDescriptionHeading() {
        return productDescrHeading;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDescriptionModel#getProductDescription()
     */
    @Override
    public String getProductDescription() {
        return productDescription;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ProductDescriptionModel#getIsColumnView()
     */
    @Override
    public Boolean getIsColumnView() {
        return RocheConstants.TRUE_VALUE.equalsIgnoreCase(columnView);
    }
    
}
