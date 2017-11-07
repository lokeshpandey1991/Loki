package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.roche.pharma.customerportal.core.models.CookieDisclaimerModel;
import com.roche.pharma.customerportal.core.models.LanguageConfigurationsModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * This is model class for CookieDisclaimerModel.
 */
/**
 * @author Nitin Kumar
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        CookieDisclaimerModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = CookieDisclaimerModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")

public class CookieDisclaimerModelImpl implements CookieDisclaimerModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/cookiedisclaimer/v1/cookiedisclaimer";
    /**
     * Self resource
     */
    @Self
    private Resource resource;
    
    /** The is cookie notification disabled. */
    private boolean isCookieNotificationDisabled;
    
    /**
     * The url for the cookie disclaimer model
     */
    private String url;
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.CookieDisclaimerModel#getUrl()
     */
    @Override
    public String getUrl() {
        return url;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.CookieDisclaimerModel#isCookieNotificationDisabled()
     */
    @Override
    public boolean isCookieNotificationDisabled() {
        return isCookieNotificationDisabled;
    }
    
    /**
     * Post construct method for cookie disclaimer model
     */
    @PostConstruct
    protected void postConstruct() {
        final LanguageConfigurationsModel languageConfigurationsModel = CommonUtils.getlanguageConfigurations(resource);
        if (null != languageConfigurationsModel) {
            final String link = languageConfigurationsModel.getCookieDisclaimerLink();
            isCookieNotificationDisabled = languageConfigurationsModel.isCookieNotificationDisabled();
            if (null != link) {
                url = CommonUtils.getPagepathWithExtension(resource.getResourceResolver().map(link));
            }
        }
    }
}
