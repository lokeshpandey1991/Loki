package com.roche.pharma.customerportal.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.models.FeatureTableModel;

/**
 * This is Model class for Feature Table.
 * @author mhuss3
 * @version 1.0
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        FeatureTableModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = FeatureTableModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")

public class FeatureTableModelImpl implements FeatureTableModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/featuretable/v1/featuretable";
    
    @ValueMapValue
    private String text;
    
    @ValueMapValue
    private String tableHeading;
    
    @ValueMapValue
    private String tableDescription;
    
    @ValueMapValue
    private String tableDisclaimer;
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FeatureTableModel#getTable()
     */
    @Override
    public String getTable() {
        return text;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FeatureTableModel#getTableHeading()
     */
    @Override
    public String getTableHeading() {
        return tableHeading;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FeatureTableModel#getTableDescription()
     */
    @Override
    public String getTableDescription() {
        return tableDescription;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FeatureTableModel#getTableDisclaimer()
     */
    @Override
    public String getTableDisclaimer() {
        return tableDisclaimer;
    }
}
