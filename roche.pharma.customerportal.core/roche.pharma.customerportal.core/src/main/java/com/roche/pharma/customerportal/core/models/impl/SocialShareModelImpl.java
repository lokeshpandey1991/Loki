package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.roche.pharma.customerportal.core.models.LanguageConfigurationsModel;
import com.roche.pharma.customerportal.core.models.SocialShareModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * SocialShareModel class
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        SocialShareModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = SocialShareModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class SocialShareModelImpl implements SocialShareModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/socialShare/v1/socialShare";
    
    @Self
    private Resource resource;
    private String shareId;
    private List<String> socialShareLinks = new ArrayList<>();
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SocialShareModel#getShareId()
     */
    @Override
    public String getShareId() {
        return shareId;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.SocialShareModel#getSocialShareLinks()
     */
    @Override
    public List<String> getSocialShareLinks() {
        return new ArrayList<>(socialShareLinks);
    }
    
    @PostConstruct
    protected void postConstruct() {
        final LanguageConfigurationsModel languageConfigurationsModel = CommonUtils.getlanguageConfigurations(resource);
        if (languageConfigurationsModel != null && languageConfigurationsModel.getSocialShareLinks() != null) {
            shareId = languageConfigurationsModel.getShareId();
            socialShareLinks = Arrays.asList(languageConfigurationsModel.getSocialShareLinks());
        }
    }
    
}
