package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.beans.PageLinkBean;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.HeaderModel;
import com.roche.pharma.customerportal.core.models.LanguageConfigurationsModel;
import com.roche.pharma.customerportal.core.models.LanguageHeaderFooterModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This is model class for Header.
 */

@Model(adaptables = {
        Resource.class
}, adapters = {
        HeaderModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = HeaderModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class HeaderModelImpl implements HeaderModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/header/v1/header";
    
    @Self
    private Resource resource;
    
    private String logoPath;
    private String logoAltText;
    private String homePagePath;
    private String countryCode;
    private String countrySelectorPath;
    private boolean isPersonaDisabled;
    private String persona;
    private String personaSelectorPath;
    private String searchUrl;
    private String searchLimit;
    private String searchResultPath;
    private String currentChannel;
    private String currentResolvedPath;
    private List<PageLinkBean> headerLinksList = new ArrayList<>();
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getLogoPath()
     */
    @Override
    public String getLogoPath() {
        return logoPath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getLogoAltText()
     */
    @Override
    public String getLogoAltText() {
        return logoAltText;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getHomePagePath()
     */
    @Override
    public String getHomePagePath() {
        return homePagePath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getCountryCode()
     */
    @Override
    public String getCountryCode() {
        return countryCode;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getCountrySelectorPath()
     */
    @Override
    public String getCountrySelectorPath() {
        return countrySelectorPath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#isPersonaDisabled()
     */
    @Override
    public boolean isPersonaDisabled() {
        return isPersonaDisabled;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getPersona()
     */
    @Override
    public String getPersona() {
        return persona;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getPersonaSelectorPath()
     */
    @Override
    public String getPersonaSelectorPath() {
        return personaSelectorPath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getHeaderLinksList()
     */
    @Override
    public List<PageLinkBean> getHeaderLinksList() {
        return new ArrayList<PageLinkBean>(headerLinksList);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getSearchUrl()
     */
    @Override
    public String getSearchUrl() {
        return searchUrl;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getSearchLimit()
     */
    @Override
    public String getSearchLimit() {
        return searchLimit;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getSearchResultPath()
     */
    @Override
    public String getSearchResultPath() {
        return searchResultPath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getCurrentChannel()
     */
    @Override
    public String getCurrentChannel() {
        return currentChannel;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeaderModel#getCurrentResolvedPath()
     */
    @Override
    public String getCurrentResolvedPath() {
        return currentResolvedPath;
    }
    
    @PostConstruct
    protected void postConstruct() {
        final Page currentPage = GlobalUtils.getCurrentPage(resource);
        final Page regionalLanguagePage = GlobalUtils.getRegionalLanguagePage(currentPage);
        final LanguageHeaderFooterModel languageHeaderFooterModel = GlobalUtils
                .getGlobalHeaderFooterConfigurations(regionalLanguagePage);
        setHeaderConfiguredValues(languageHeaderFooterModel);
        final LanguageConfigurationsModel languageConfigurationsModel = GlobalUtils
                .getlanguageConfigurations(regionalLanguagePage);
        setLanguageConfiguredValues(languageConfigurationsModel);
        final Page regionalPage = GlobalUtils.getRegionalPage(currentPage);
        countryCode = regionalPage.getTitle().toUpperCase(GlobalUtils.getPageLocale(currentPage));
        setCurrentChannel(currentPage);
        currentResolvedPath = CommonUtils.getResolvedPathWithHtml(currentPage.getPath(), resource);
    }
    
    /**
     * This method set header values based on global header footer configurations
     * @param languageHeaderFooterModel
     */
    private void setHeaderConfiguredValues(final LanguageHeaderFooterModel languageHeaderFooterModel) {
        if (languageHeaderFooterModel != null) {
            logoPath = languageHeaderFooterModel.getFileReference();
            logoAltText = languageHeaderFooterModel.getLogoAltText();
            homePagePath = languageHeaderFooterModel.getHomePagePath();
            headerLinksList = languageHeaderFooterModel.getHeaderList();
        }
    }
    
    /**
     * This method set header value based on global configurations
     * @param languageConfigurationsModel
     */
    private void setLanguageConfiguredValues(final LanguageConfigurationsModel languageConfigurationsModel) {
        if (languageConfigurationsModel != null) {
            countrySelectorPath = languageConfigurationsModel.getCountrySelectorPagePath();
            personaSelectorPath = languageConfigurationsModel.getPersonaSelectorPagePath();
            isPersonaDisabled = languageConfigurationsModel.isPersonaDisabled();
            searchLimit = languageConfigurationsModel.getSearchLimit();
            searchUrl = languageConfigurationsModel.getSearchUrl();
            searchResultPath = languageConfigurationsModel.getSearchPagePath();
        }
    }
    
    private void setCurrentChannel(final Page currentPage) {
        if (null == currentPage.getAbsoluteParent(RocheConstants.THREE)) {
            currentChannel = "";
        } else {
            currentChannel = currentPage.getAbsoluteParent(RocheConstants.TWO).getName() + RocheConstants.SLASH
                    + currentPage.getAbsoluteParent(RocheConstants.THREE).getName();
        }
    }
    
}
