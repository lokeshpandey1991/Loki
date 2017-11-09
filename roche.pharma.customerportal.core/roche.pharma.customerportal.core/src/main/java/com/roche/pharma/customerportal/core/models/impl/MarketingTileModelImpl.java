package com.roche.pharma.customerportal.core.models.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.commons.feed.Feed;
import com.roche.pharma.customerportal.core.models.MarketingTileModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * model class for marketingTile component
 * @author asi130
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        MarketingTileModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = MarketingTileModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")

public class MarketingTileModelImpl implements MarketingTileModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/marketingtile/v1/marketingtile";
    @Self
    private Resource resource;
    
    @ValueMapValue
    private String articleId;
    
    @ValueMapValue
    private String articleTitle;
    
    @ValueMapValue
    private String articleSummary;
    
    @ValueMapValue
    private String altText;
    
    @ValueMapValue
    private String fileReference;
    
    @ValueMapValue
    private String headline;
    
    @ValueMapValue
    private String ctaLabel;
    
    @ValueMapValue
    private String ctaLink;
    
    @ValueMapValue
    private String imagePosition;
    
    @ValueMapValue
    private String variationType;
    
    private String componentName;
    
    private String contentType;
    
    @PostConstruct
    protected void postConstruct() {
        this.componentName = CommonUtils.getComponentName(resource);
        if (!StringUtils.isBlank(this.articleId)) {
            final Resource articleResource = resource.getResourceResolver()
                    .getResource(articleId + "/jcr:content/product");
            final Resource descriptionResource = resource.getResourceResolver()
                    .getResource(articleId + "/jcr:content/productDescription");
            checkArticleTitle(articleResource);
            checkFileReference(articleResource);
            checkAltText(articleResource);
            checkArticleSummary(descriptionResource);
        }
        checkContentType();
    }
    
    /**
     * sets the contentType of the page configured in CTA link
     */
    private void checkContentType() {
        if (CommonUtils.isInternalLink(this.ctaLink)) {
            final Resource ctaResource = resource.getResourceResolver().resolve(ctaLink + "/jcr:content");
            if (!ResourceUtil.isNonExistingResource(ctaResource)) {
                this.contentType = (String) ctaResource.getValueMap().get("pageType");
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#checkFileReference(org.apache.sling.api.
     * resource.Resource)
     */
    @Override
    public void checkFileReference(final Resource resource) {
        if (resource != null && StringUtils.isBlank(this.fileReference)) {
            final Map<String, Object> pageValueMap = resource.getValueMap();
            this.fileReference = (String) pageValueMap.get("fileReference");
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#checkAltText(org.apache.sling.api.resource.
     * Resource)
     */
    @Override
    public void checkAltText(final Resource resource) {
        if (resource != null && StringUtils.isBlank(this.altText)) {
            final Map<String, Object> valueMap = resource.getValueMap();
            this.altText = (String) valueMap.get("altText");
        }
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#checkArticleTitle(org.apache.sling.api.
     * resource.Resource)
     */
    @Override
    public void checkArticleTitle(final Resource resource) {
        if (resource != null && StringUtils.isBlank(this.articleTitle)) {
            final Map<String, Object> valueMap = resource.getValueMap();
            this.articleTitle = (String) valueMap.get("productName");
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#checkArticleSummary(org.apache.sling.api.
     * resource.Resource)
     */
    @Override
    public void checkArticleSummary(final Resource resource) {
        if (resource != null && StringUtils.isBlank(this.articleSummary)) {
            final Map<String, Object> valueMap = resource.getValueMap();
            this.articleSummary = (String) valueMap.get("productDescription");
        }
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getArticleId()
     */
    @Override
    public String getArticleId() {
        if (!StringUtils.isBlank(articleId)) {
            return articleId + Feed.SUFFIX_HTML;
        }
        return articleId;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getArticleTitle()
     */
    @Override
    public String getArticleTitle() {
        return articleTitle;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getArticleSummary()
     */
    @Override
    public String getArticleSummary() {
        return articleSummary;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getAltText()
     */
    @Override
    public String getAltText() {
        return altText;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getFileReference()
     */
    @Override
    public String getFileReference() {
        return fileReference;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getHeadline()
     */
    @Override
    public String getHeadline() {
        return headline;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getCtaLabel()
     */
    @Override
    public String getCtaLabel() {
        return ctaLabel;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getCtaLink()
     */
    @Override
    public String getCtaLink() {
        if (CommonUtils.isInternalLink(this.articleId) && StringUtils.isBlank(this.ctaLink)) {
            return this.articleId + Feed.SUFFIX_HTML;
        } else {
            if (CommonUtils.isInternalLink(this.ctaLink)) {
                return this.ctaLink + Feed.SUFFIX_HTML;
                
            }
        }
        return ctaLink;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getImagePosition()
     */
    @Override
    public String getImagePosition() {
        return imagePosition;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getVariationType()
     */
    @Override
    public String getVariationType() {
        return variationType;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getComponentName()
     */
    @Override
    public String getComponentName() {
        return componentName;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MarketingTileModel#getContentType()
     */
    @Override
    public String getContentType() {
        return contentType;
    }
}
