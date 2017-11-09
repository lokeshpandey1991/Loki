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
import com.roche.pharma.customerportal.core.beans.SocialLinkBean;
import com.roche.pharma.customerportal.core.models.FooterModel;
import com.roche.pharma.customerportal.core.models.LanguageConfigurationsModel;
import com.roche.pharma.customerportal.core.models.LanguageHeaderFooterModel;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This is model class for footer component.
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        FooterModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = FooterModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")

public class FooterModelImpl implements FooterModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/footer/v1/footer";
    
    @Self
    private Resource resource;
    private String disclaimer;
    private String tradeMark;
    private String language;
    private String countryCode;
    private List<PageLinkBean> footerLinksList = new ArrayList<>();
    private List<SocialLinkBean> socialList = new ArrayList<>();
    private String countrySelectorPath;
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FooterModel#getCountrySelectorPath()
     */
    @Override
    public String getCountrySelectorPath() {
        return countrySelectorPath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FooterModel#getDisclaimer()
     */
    @Override
    public String getDisclaimer() {
        return disclaimer;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FooterModel#getTradeMark()
     */
    @Override
    public String getTradeMark() {
        return tradeMark;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FooterModel#getLanguage()
     */
    @Override
    public String getLanguage() {
        return language;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FooterModel#getCountryCode()
     */
    @Override
    public String getCountryCode() {
        return countryCode;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FooterModel#getFooterLinksList()
     */
    @Override
    public List<PageLinkBean> getFooterLinksList() {
        return footerLinksList;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.FooterModel#getSocialList()
     */
    @Override
    public List<SocialLinkBean> getSocialList() {
        return socialList;
    }
    
    @PostConstruct
    protected void postConstruct() {
        final Page currentPage = GlobalUtils.getCurrentPage(resource);
        final Page regionalLanguagePage = GlobalUtils.getRegionalLanguagePage(currentPage);
        final LanguageHeaderFooterModel languageHeaderFooterModel = GlobalUtils
                .getGlobalHeaderFooterConfigurations(regionalLanguagePage);
        setLanguageFooterConfiguredValues(languageHeaderFooterModel);
        final Page regionalPage = GlobalUtils.getRegionalPage(currentPage);
        if (regionalPage != null) {
            countryCode = regionalPage.getTitle().toUpperCase(GlobalUtils.getPageLocale(currentPage));
        }
        language = GlobalUtils.getPageLocale(currentPage).getDisplayLanguage();
        final LanguageConfigurationsModel languageConfigurationsModel = GlobalUtils
                .getlanguageConfigurations(regionalLanguagePage);
        setGlobalConfiguredFooterValues(languageConfigurationsModel);
    }
    
    /**
     * This method set footer values based on language header footer configurations
     * @param languageHeaderFooterModel
     */
    private void setLanguageFooterConfiguredValues(final LanguageHeaderFooterModel languageHeaderFooterModel) {
        if (languageHeaderFooterModel != null) {
            disclaimer = languageHeaderFooterModel.getDisclaimerText();
            tradeMark = languageHeaderFooterModel.getTradeMark();
            footerLinksList = languageHeaderFooterModel.getFooterList();
        }
    }
    
    /**
     * This method set footer value based on language configurations
     * @param languageHeaderFooterModel
     */
    private void setGlobalConfiguredFooterValues(final LanguageConfigurationsModel languageConfigurationsModel) {
        if (languageConfigurationsModel != null) {
            countrySelectorPath = languageConfigurationsModel.getCountrySelectorPagePath();
            socialList = languageConfigurationsModel.getSocialList();
        }
    }
    
}
