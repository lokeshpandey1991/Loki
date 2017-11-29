package com.roche.pharma.customerportal.core.models.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.beans.PageLinkBean;
import com.roche.pharma.customerportal.core.models.HamburgerMenuModel;
import com.roche.pharma.customerportal.core.models.LanguageConfigurationsModel;
import com.roche.pharma.customerportal.core.models.LanguageHeaderFooterModel;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This is model class for Hamburger menu.
 */

@Model(adaptables = {
        Resource.class
}, adapters = {
        HamburgerMenuModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = HamburgerMenuModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class HamburgerMenuModelImpl implements HamburgerMenuModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/hamburgermenue/v1/hamburgermenue";
    
    @Self
    private Resource resource;
    private String languageCode;
    private String countryCode;
    private List<PageLinkBean> hamburgerMenuLeftLinks;
    private List<PageLinkBean> hamburgerMenuRightLinks;
    private String countrySelectorPath;
    private String personaSelectorPath;
    private boolean isPersonaDisabled;
    private String logoAltText;
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#getLogoAltText()
     */
    @Override
    public String getLogoAltText() {
        return logoAltText;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#isPersonaDisabled()
     */
    @Override
    public boolean isPersonaDisabled() {
        return isPersonaDisabled;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#getPersonaSelectorPath()
     */
    @Override
    public String getPersonaSelectorPath() {
        return personaSelectorPath;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#getLanguageCode()
     */
    @Override
    public String getLanguageCode() {
        return languageCode;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#getCountryCode()
     */
    @Override
    public String getCountryCode() {
        return countryCode;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#getHamburgerMenuLeftLinks()
     */
    @Override
    public List<PageLinkBean> getHamburgerMenuLeftLinks() {
        return hamburgerMenuLeftLinks;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#getHamburgerMenuRightLinks()
     */
    @Override
    public List<PageLinkBean> getHamburgerMenuRightLinks() {
        return hamburgerMenuRightLinks;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HamburgerMenuModel#getCountrySelectorPath()
     */
    @Override
    public String getCountrySelectorPath() {
        return countrySelectorPath;
    }
    
    /**
     * The post construct method of HamburgerMenuModel class.
     */
    @PostConstruct
    public void postConstruct() {
        final Page currentPage = GlobalUtils.getCurrentPage(resource);
        final Page regionalLanguagePage = GlobalUtils.getRegionalLanguagePage(currentPage);
        final LanguageHeaderFooterModel globalHeaderFooterModel = GlobalUtils
                .getGlobalHeaderFooterConfigurations(regionalLanguagePage);
        setHamburgerLinks(globalHeaderFooterModel);
        final LanguageConfigurationsModel globalConfigurationsModel = GlobalUtils
                .getlanguageConfigurations(regionalLanguagePage);
        if (globalConfigurationsModel != null) {
            countrySelectorPath = globalConfigurationsModel.getCountrySelectorPagePath();
            personaSelectorPath = globalConfigurationsModel.getPersonaSelectorPagePath();
            isPersonaDisabled = globalConfigurationsModel.isPersonaDisabled();
        }
        languageCode = GlobalUtils.getPageLocale(currentPage).getDisplayLanguage();
        final Page regionalPage = GlobalUtils.getRegionalPage(currentPage);
        if (regionalPage != null) {
            countryCode = regionalPage.getTitle().toUpperCase(GlobalUtils.getPageLocale(currentPage));
        }
    }
    
    /**
     * This method set hamburger links from languageHeaderFooter configurations
     * @param globalHeaderFooterModel
     */
    private void setHamburgerLinks(final LanguageHeaderFooterModel globalHeaderFooterModel) {
        if (globalHeaderFooterModel != null) {
            logoAltText = globalHeaderFooterModel.getLogoAltText();
            hamburgerMenuLeftLinks = globalHeaderFooterModel.getHamburgerMenuLeftList();
            hamburgerMenuRightLinks = globalHeaderFooterModel.getHamburgerMenuRightList();
            setMobileEnabledFooterLinks(globalHeaderFooterModel.getFooterList());
        }
    }
    
    /**
     * This method iterates footer links and add mobile view enabled links to hambuger menu
     * @param footerLinks
     */
    private void setMobileEnabledFooterLinks(final List<PageLinkBean> footerLinks) {
        if (!footerLinks.isEmpty()) {
            for (final PageLinkBean pageLinkBean : footerLinks) {
                addFooterLinksInHamurger(pageLinkBean);
            }
        }
    }
    
    /**
     * This method add mobile enabled footer links to right hamburger menu list
     * @param pageLinkBean
     */
    private void addFooterLinksInHamurger(final PageLinkBean pageLinkBean) {
        if (pageLinkBean != null && pageLinkBean.isVisibleOnMobile()) {
            hamburgerMenuRightLinks.add(pageLinkBean);
        }
    }
}
