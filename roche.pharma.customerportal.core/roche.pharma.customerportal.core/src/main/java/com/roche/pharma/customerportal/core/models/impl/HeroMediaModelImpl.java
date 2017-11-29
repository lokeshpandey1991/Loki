package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.dam.api.Asset;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.HeroMediaModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * model class for heromMedia and mediaContainer component.
 * @author asi130
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        HeroMediaModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = HeroMediaModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
/**
 * Sling model class to get the media parameters
 */
public class HeroMediaModelImpl implements HeroMediaModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/heromedia/v1/heromedia";
    
    @Self
    private Resource resource;
    
    @ValueMapValue
    private String altText;
    
    @ValueMapValue
    private String fileReference;
    
    @ValueMapValue
    private String headlinePosition;
    
    @ValueMapValue
    private String headline;
    
    @ValueMapValue
    private String subHeadline;
    
    @ValueMapValue
    private String quoteText;
    
    @ValueMapValue
    private String textPosition;
    
    @ValueMapValue
    private String ctaLabel;
    
    @ValueMapValue
    private String ctaLink;
    
    @ValueMapValue
    private String variationType;
    
    @ValueMapValue
    private String transparentOverlay;
    
    private String assetType = "image";
    
    private String isExternal = "false";
    
    private String videoName;
    
    private String videoLanguage;
    
    private String componentName;
    
    private String contentType;
    
    @PostConstruct
    protected void postConstruct() {
        final ResourceResolver resourceResolver = resource.getResourceResolver();
        if (StringUtils.isNotBlank(fileReference)) {
            final Resource mediaAsset = resourceResolver.resolve(fileReference);
            final Asset asset = mediaAsset.adaptTo(Asset.class);
            componentName = CommonUtils.getComponentName(resource);
            if (null != asset && !asset.getMimeType().contains("image")) {
                this.assetType = "video";
                this.videoName = asset.getMetadataValue("dc:title");
                this.videoLanguage = asset.getMetadataValue("dc:language");
            }
        }
        if (null != this.ctaLink && StringUtils.isNotEmpty(this.ctaLink.replaceAll("\\s+", ""))
                && !this.ctaLink.startsWith("/content")) {
            this.isExternal = "true";
        }
        if (!RocheConstants.TRUE_VALUE.equalsIgnoreCase(this.isExternal) && StringUtils.isNotBlank(ctaLink)) {
            final Resource ctaResource = resourceResolver.resolve(ctaLink + "/jcr:content");
            if (!ResourceUtil.isNonExistingResource(ctaResource)) {
                this.contentType = (String) ctaResource.getValueMap().get("pageType");
            }
        }
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getAltText()
     */
    @Override
    public String getAltText() {
        return altText;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getFileReference()
     */
    @Override
    public String getFileReference() {
        return fileReference;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getHeadlinePosition()
     */
    @Override
    public String getHeadlinePosition() {
        return headlinePosition;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getHeadline()
     */
    @Override
    public String getHeadline() {
        return headline;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getSubHeadline()
     */
    @Override
    public String getSubHeadline() {
        return subHeadline;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getQuoteText()
     */
    @Override
    public String getQuoteText() {
        return quoteText;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getTextPosition()
     */
    @Override
    public String getTextPosition() {
        return textPosition;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getCTALabel()
     */
    @Override
    public String getCTALabel() {
        return ctaLabel;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getCTALink()
     */
    @Override
    public String getCTALink() {
        return ctaLink;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getAssetType()
     */
    @Override
    public String getAssetType() {
        return assetType;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getIsExternal()
     */
    @Override
    public String getIsExternal() {
        return isExternal;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getVariationType()
     */
    @Override
    public String getVariationType() {
        return variationType;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getTransparentOverlay()
     */
    @Override
    public String getTransparentOverlay() {
        return transparentOverlay;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getVideoName()
     */
    @Override
    public String getVideoName() {
        return videoName;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getVideoLanguage()
     */
    @Override
    public String getVideoLanguage() {
        return videoLanguage;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getComponentName()
     */
    @Override
    public String getComponentName() {
        return componentName;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeroMediaModel#getContentType()
     */
    @Override
    public String getContentType() {
        return contentType;
    }
}
