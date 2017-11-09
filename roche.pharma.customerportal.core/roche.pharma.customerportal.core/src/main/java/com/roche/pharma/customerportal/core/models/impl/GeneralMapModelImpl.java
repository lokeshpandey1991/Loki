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

import com.roche.pharma.customerportal.core.beans.TimeDetailsListBean;
import com.roche.pharma.customerportal.core.models.GeneralMapModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * The Class GeneralMapModel.
 * @author kbhar6
 * @version 1.0
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        GeneralMapModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = GeneralMapModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")

public class GeneralMapModelImpl implements GeneralMapModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/generalmap/v1/generalmap";
    /** The resource. */
    @Self
    private Resource resource;
    
    /** The longitude. */
    @ValueMapValue
    private String longitude;
    
    /** The latitude. */
    @ValueMapValue
    private String latitude;
    
    /** The address. */
    @ValueMapValue
    private String address;
    
    /** The heading. */
    @ValueMapValue
    private String heading;
    
    /** The cta label. */
    @ValueMapValue
    private String ctaLabel;
    
    /** The cta link. */
    @ValueMapValue
    private String ctaLink;
    
    /** The phone. */
    @ValueMapValue
    private String phoneNumber;
    
    /** The email. */
    @ValueMapValue
    private String email;
    
    /** The link behaviour. */
    @ValueMapValue
    private String linkBehaviour;
    
    /** The timings. */
    @ValueMapValue
    private String[] timings;
    
    /** The link type. */
    @ValueMapValue
    private String linkType;
    
    /** The time detail listing. */
    private List<TimeDetailsListBean> timeDetailListing = new ArrayList<TimeDetailsListBean>();
    
    /**
     * Post construct.
     */
    @PostConstruct
    protected void postConstruct() {
        timeDetailListing = getMultifieldValue(timings, timeDetailListing);
    }
    
    /**
     * Gets the multifield value.
     * @param jsonArray the json array
     * @param beanList the bean list
     * @return the multifield value
     */
    private List<TimeDetailsListBean> getMultifieldValue(final String[] jsonArray,
            final List<TimeDetailsListBean> beanList) {
        if (jsonArray != null) {
            for (final String json : jsonArray) {
                final TimeDetailsListBean listingBean = CommonUtils.getMultifield(json, TimeDetailsListBean.class);
                beanList.add(listingBean);
            }
        }
        return beanList;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getTimeDetailListing()
     */
    @Override
    public List<TimeDetailsListBean> getTimeDetailListing() {
        return new ArrayList<TimeDetailsListBean>(timeDetailListing);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getLongitude()
     */
    @Override
    public String getLongitude() {
        return longitude;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getLatitude()
     */
    @Override
    public String getLatitude() {
        return latitude;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getAddress()
     */
    @Override
    public String getAddress() {
        return address;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getHeading()
     */
    @Override
    public String getHeading() {
        return heading;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getCtaLabel()
     */
    @Override
    public String getCtaLabel() {
        return ctaLabel;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getCtaLink()
     */
    @Override
    public String getCtaLink() {
        return CommonUtils.getPagepathWithExtension(ctaLink);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getPhoneNumber()
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getEmail()
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getLinkBehaviour()
     */
    @Override
    public String getLinkBehaviour() {
        return linkBehaviour;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.GeneralMapModel#getLinkType()
     */
    @Override
    public String getLinkType() {
        return CommonUtils.getLinkType(ctaLink);
    }
    
}
