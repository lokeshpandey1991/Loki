/**
 * 
 */
package com.roche.pharma.customerportal.core.utils;

import java.util.Locale;
import java.util.Locale.Builder;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.GlobalConfigurationsModel;
import com.roche.pharma.customerportal.core.models.LanguageConfigurationsModel;
import com.roche.pharma.customerportal.core.models.LanguageHeaderFooterModel;

/**
 * @author agu207
 *
 */
public class GlobalUtils {

    /**
     * This method returns current page for give resource.
     * @param resource sling resource
     * @return Page page returned by this method or null
     */
    public static Page getCurrentPage(final Resource resource) {
        if (resource != null) {
            final PageManager pageManager = resource.getResourceResolver().adaptTo(PageManager.class);
            if (pageManager != null) {
                return pageManager.getContainingPage(resource);
            }
        }
        return null;
    }

    /**
     * This method returns language page for the corresponding current page.
     * @param currentPage current page
     * @return language page
     */
    
    public static Page getRegionalLanguagePage(final Page currentPage) {
        if (currentPage != null) {
            return currentPage.getAbsoluteParent(RocheConstants.REGIONL_LANGUAGE_PAGE_LEVEL);
        }
        return null;
    }

    /**
     * This method returns regional page for the corresponding current page.
     * @param currentPage current page
     * @return regional page
     */
    public static Page getRegionalPage(final Page currentPage) {
        if (currentPage != null) {
            return currentPage.getAbsoluteParent(RocheConstants.REGIONL_PAGE_LEVEL);
        }
        return null;
    }

    /**
     * This method returns global header footer configurations authored in language page.
     * @param languagePage language page
     * @return language header footer model
     */
    public static LanguageHeaderFooterModel getGlobalHeaderFooterConfigurations(final Page languagePage) {
        if (languagePage != null && languagePage.getContentResource() != null) {
            final Resource resource = languagePage.getContentResource().getChild(
                    RocheConstants.HEADER_FOOTER_CONFIGURATIONS_RESOURCE_NAME);
            if (resource != null) {
                return resource.adaptTo(LanguageHeaderFooterModel.class);
            }
        }
        return null;
    }

    /**
     * This method returns language configurations authored in language page.
     * @param languagePage language page
     * @return language configurations model
     */
    public static LanguageConfigurationsModel getlanguageConfigurations(final Page languagePage) {
        if (languagePage != null && languagePage.getContentResource() != null) {
            final Resource resource = languagePage.getContentResource().getChild(
                    RocheConstants.LANGUAGE_CONFIGURATIONS_RESOURCE_NAME);
            if (resource != null) {
                return resource.adaptTo(LanguageConfigurationsModel.class);
            }
        }
        return null;
    }

    /**
     * This method returns Global configurations authored on Global page.
     * @param page cq Page
     * @return global configurations model
     */
    public static GlobalConfigurationsModel getGlobalConfigurations(final Page page) {
        final Page globalPage = page == null ? null : page.getAbsoluteParent(1);
        if (globalPage != null && globalPage.getContentResource() != null) {
            final Resource resource = globalPage.getContentResource().getChild(
                    RocheConstants.PAR + "/" + RocheConstants.GLOBAL_CONFIGURATIONS_RESOURCE_NAME);
            if (resource != null) {
                return resource.adaptTo(GlobalConfigurationsModel.class);
            }
        }
        return null;
    }

    /**
     * This method returns page locale default is en-US.
     * @param currentPage current page
     * @return local current locale
     */
    public static Locale getPageLocale(final Page currentPage) {
        if (currentPage != null) {
            return currentPage.getLanguage(false);
        }
    
        return new Locale.Builder().setLanguage(RocheConstants.ENGLISH_LANGUAGE_ISO_CODE)
                .setRegion(RocheConstants.US_ISO_CODE).build();
    }

    /**
     * This process returns the country code.
     * @param resource the resource
     * @return the country code
     */
    public static String getCountryCode(final Resource resource) {
        final Page page = getCurrentPage(resource);
        String countryCode = StringUtils.EMPTY;
        Page countryPage;
        if (page != null) {
            countryPage = page.getAbsoluteParent(RocheConstants.REGIONL_PAGE_LEVEL);
            countryCode = countryPage.getProperties().get(RocheConstants.COUNTRY_CODE) == null ? StringUtils.EMPTY
                    : countryPage.getProperties().get(RocheConstants.COUNTRY_CODE).toString().toLowerCase();
        }
        return countryCode;
    }

    /**
     * This method returns the pageType property of given page path.
     * @param pagePath page path
     * @param resourceResolver sling ResourceResolver
     * @return pageType page type
     */
    public static String getPageTypeProperty(final String pagePath, final ResourceResolver resourceResolver) {
        String pageType = StringUtils.EMPTY;
        if (resourceResolver != null && StringUtils.isNotBlank(pagePath)) {
            final Resource jcrResoure = resourceResolver.getResource(pagePath + "/jcr:content");
            if (null != jcrResoure) {
                pageType = GlobalUtils.getStringProperty(jcrResoure, "pageType");
            }
        }
        return pageType;
    }

    /**
     * This method returns the value of String property.
     * @param resource sling resource
     * @param propertyName property name
     * @return property value
     */
    public static String getStringProperty(final Resource resource, final String propertyName) {
    
        final ValueMap properties = resource.adaptTo(ValueMap.class);
        if (properties != null && !properties.isEmpty() && properties.get(propertyName) != null) {
            return properties.get(propertyName).toString();
        }
        return StringUtils.EMPTY;
    }
    
}
