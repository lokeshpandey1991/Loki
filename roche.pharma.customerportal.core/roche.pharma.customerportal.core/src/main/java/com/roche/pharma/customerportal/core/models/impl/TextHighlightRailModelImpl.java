package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.models.TextHighlightRailModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * The Class TextHighlightRailModel.
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        TextHighlightRailModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = TextHighlightRailModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class TextHighlightRailModelImpl implements TextHighlightRailModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/textHighlightRail/v1/textHighlightRail";
    
    /** The resource. */
    @Self
    private Resource resource;
    
    /** The headline. */
    @ValueMapValue
    private String headline;
    
    /** The body text. */
    @ValueMapValue
    private String bodyText;
    
    /** The cta name. */
    @ValueMapValue
    private String ctaName;
    
    /** The cta link. */
    @ValueMapValue
    private String ctaLink;
    
    /** The content type. */
    private String contentType;
    
    /** The is external. */
    private boolean isExternal;
    
    /**
     * Method called after injection of values in Sling Model.
     */
    @PostConstruct
    protected void postConstruct() {
        setPageContentType(getCtaLink());
        setExternal(CommonUtils.isExternalLink(getCtaLink()));
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TextHighlightRailModel#getHeadline()
     */
    @Override
    public String getHeadline() {
        return headline;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TextHighlightRailModel#getBodyText()
     */
    @Override
    public String getBodyText() {
        return bodyText;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TextHighlightRailModel#getCtaName()
     */
    @Override
    public String getCtaName() {
        return ctaName;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TextHighlightRailModel#getCtaLink()
     */
    @Override
    public String getCtaLink() {
        return ctaLink;
    }
    
    /**
     * This method set page content type if page is internal page.
     * @param link the new page content type
     */
    private void setPageContentType(final String link) {
        if (CommonUtils.isInternalLink(link) && !CommonUtils.isAssetPath(link)) {
            this.contentType = GlobalUtils.getPageTypeProperty(link, resource.getResourceResolver());
        }
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TextHighlightRailModel#isExternal()
     */
    @Override
    public boolean isExternal() {
        return isExternal;
    }
    
    /**
     * Sets the external.
     * @param isExternal the new external
     */
    public void setExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TextHighlightRailModel#getContentType()
     */
    @Override
    public String getContentType() {
        return contentType;
    }
    
}
