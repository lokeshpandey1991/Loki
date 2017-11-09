package com.roche.pharma.customerportal.core.models.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.models.DynamicImageModel;
import com.roche.pharma.customerportal.core.services.ConfigurationService;

/**
 * The Class DynamicImageModel.
 */

@Model(adaptables = {
        SlingHttpServletRequest.class
}, adapters = {
        DynamicImageModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = DynamicImageModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class DynamicImageModelImpl implements DynamicImageModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/dynamicimage/v1/dynamicimage";
    
    /** The Constant HEIGHT. */
    private static final String HEIGHT = "hei";
    
    /** The Constant AMPERSAND. */
    private static final String AMPERSAND = "&";
    
    /** The Constant EQUALS. */
    private static final String EQUALS = "=";
    
    /** The Constant WIDTH. */
    private static final String WIDTH = "wid";
    
    /** The Constant QUERY_PARAMETER. */
    private static final String QUERY_PARAMETER = "?";
    
    /** The Constant HYPHEN. */
    private static final String HYPHEN = "-";
    
    /** The Constant CROPN. */
    private static final String CROPN = "cropn";
    
    /** The Constant DESKTOP. */
    private static final String DESKTOP = "desktop";
    
    /** The Constant TABLETLANDSCAPE. */
    private static final String TABLETLANDSCAPE = "tabletL";
    
    /** The Constant TABLETPORTRAIT. */
    private static final String TABLETPORTRAIT = "tabletP";
    
    /** The Constant MOBILELANDSCAPE. */
    private static final String MOBILELANDSCAPE = "mobileL";
    
    /** The Constant MOBILEPORTRAIT. */
    private static final String MOBILEPORTRAIT = "mobileP";
    
    @Inject
    private String imagePath;
    
    @Inject
    private String assetAltText;
    
    @Inject
    private String imageView;
    
    @Self
    private SlingHttpServletRequest slingRequest;
    
    /** The configuration service. */
    @OSGiService
    private ConfigurationService configurationService;
    
    /** The file reference. */
    @ValueMapValue
    private String fileReference;
    
    /** The view. */
    @ValueMapValue
    private String view;
    
    /** The view. */
    @ValueMapValue
    private String variationType;
    
    /** The alt text. */
    @ValueMapValue
    private String altText;
    
    /** The desktop url. */
    private String desktopUrl;
    
    /** The mobile url. */
    private String mobilePortraitUrl;
    
    /** The mobile landscape url. */
    private String mobileLandscapeUrl;
    
    /** The tablet url. */
    private String tabletPortraitUrl;
    
    /** The tablet landscape url. */
    private String tabletLandscapeUrl;
    
    /**
     * Post construct.
     */
    @PostConstruct
    protected void postConstruct() {
        String dynamicMediaUrl = getImageServiceURL();
        fileReference = StringUtils.isNotBlank(fileReference) ? fileReference : imagePath;
        if (fileReference == null) {
            dynamicMediaUrl = StringUtils.EMPTY;
        }
        fileReference = StringUtils.isNotBlank(dynamicMediaUrl)
                ? StringUtils.removeEndIgnoreCase(dynamicMediaUrl, "/") + fileReference
                : fileReference;
        
        if (StringUtils.isNotBlank(dynamicMediaUrl)) {
            setDesktopUrl(createDynamicMediaUrl(DESKTOP));
            setMobilePortraitUrl(createDynamicMediaUrl(MOBILEPORTRAIT));
            setMobileLandscapeUrl(createDynamicMediaUrl(MOBILELANDSCAPE));
            setTabletPortraitUrl(createDynamicMediaUrl(TABLETPORTRAIT));
            setTabletLandscapeUrl(createDynamicMediaUrl(TABLETLANDSCAPE));
        }
    }
    
    /**
     * Creates the URL for the devices(Desktop,IPad,Mobile).
     * @param deviceType the device type
     * @return the string
     */
    private String createDynamicMediaUrl(final String deviceType) {
        
        final Map<String, String> dynamicMediaConfiguration = getDynamicMediaConfiguration();
        String url = "";
        final String componentName = getComponentName(slingRequest.getResource());
        if (StringUtils.isNotBlank(componentName)) {
            final StringBuilder key = new StringBuilder(componentName).append(HYPHEN).append(deviceType);
            view = StringUtils.isNotBlank(imageView) ? imageView : view;
            if (StringUtils.isNotEmpty(view)) {
                key.append(HYPHEN).append(view);
            } else if (StringUtils.isNotEmpty(variationType)) {
                key.append(HYPHEN).append(variationType);
            }
            final String imageConfiguration = dynamicMediaConfiguration.get(key.toString());
            if (StringUtils.isNotEmpty(imageConfiguration)) {
                url = createUrl(fileReference, imageConfiguration);
            }
        }
        return url;
    }
    
    /**
     * Gets the component name.
     * @param resource the resource
     * @return the component name
     */
    private String getComponentName(final Resource resource) {
        return StringUtils.substringAfterLast(resource.getResourceType(), "/");
    }
    
    /**
     * Creates the url.
     * @param paramUrl the url
     * @param imageConfiguration the image configuration
     * @return the string
     */
    private String createUrl(final String paramUrl, final String imageConfiguration) {
        final int widthIndex = StringUtils.ordinalIndexOf(imageConfiguration, ",", 1);
        final int heightIndex = StringUtils.ordinalIndexOf(imageConfiguration, ",", 2);
        String width = null;
        String height = null;
        String crop = null;
        String url = paramUrl;
        if (widthIndex > -1) {
            width = imageConfiguration.substring(0, widthIndex);
            
            if (heightIndex > -1) {
                height = imageConfiguration.substring(widthIndex + 1, heightIndex);
                crop = imageConfiguration.substring(heightIndex + 1);
            } else {
                height = imageConfiguration.substring(widthIndex + 1);
            }
        } else {
            width = imageConfiguration;
        }
        if (StringUtils.isNotEmpty(width) || StringUtils.isNotEmpty(height) || StringUtils.isNotEmpty(crop)) {
            url = getUrl(paramUrl, width, height, crop);
        }
        return url;
    }
    
    /**
     * Gets the url.
     * @param url the url
     * @param width the width
     * @param height the height
     * @param crop the crop
     * @return the url
     */
    private String getUrl(final String paramUrl, final String width, final String height, final String crop) {
        boolean queryFlag = false;
        StringBuilder url = new StringBuilder(paramUrl);
        if (StringUtils.isNotEmpty(width)) {
            url.append(QUERY_PARAMETER).append(WIDTH).append(EQUALS).append(width);
            queryFlag = true;
        }
        if (StringUtils.isNotEmpty(height)) {
            url = queryFlag ? url.append(AMPERSAND).append(HEIGHT).append(EQUALS).append(height)
                    : url.append(QUERY_PARAMETER).append(HEIGHT).append(EQUALS).append(height);
            queryFlag = true;
        }
        if (StringUtils.isNotEmpty(crop)) {
            url = queryFlag ? url.append(AMPERSAND).append(CROPN).append(EQUALS).append(crop)
                    : url.append(QUERY_PARAMETER).append(CROPN).append(EQUALS).append(crop);
        }
        return url.toString();
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getImageServiceURL()
     */
    @Override
    public String getImageServiceURL() {
        return configurationService.getImageServiceUrl();
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getDynamicMediaConfiguration()
     */
    @Override
    public Map<String, String> getDynamicMediaConfiguration() {
        return configurationService.getDynamicMediaConfMap();
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getFileReference()
     */
    @Override
    public String getFileReference() {
        return fileReference;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getDesktopUrl()
     */
    @Override
    public String getDesktopUrl() {
        return desktopUrl;
    }
    
    /**
     * Sets the desktop url.
     * @param desktopUrl the new desktop url
     */
    public void setDesktopUrl(final String desktopUrl) {
        this.desktopUrl = desktopUrl;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getMobilePortraitUrl()
     */
    @Override
    public String getMobilePortraitUrl() {
        return mobilePortraitUrl;
    }
    
    /**
     * Sets the mobile portrait url.
     * @param mobilePortraitUrl the new mobile portrait url
     */
    public void setMobilePortraitUrl(final String mobilePortraitUrl) {
        this.mobilePortraitUrl = mobilePortraitUrl;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getMobileLandscapeUrl()
     */
    @Override
    public String getMobileLandscapeUrl() {
        return mobileLandscapeUrl;
    }
    
    /**
     * Sets the mobile landscape url.
     * @param mobileLandscapeUrl the new mobile landscape url
     */
    public void setMobileLandscapeUrl(final String mobileLandscapeUrl) {
        this.mobileLandscapeUrl = mobileLandscapeUrl;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getTabletPortraitUrl()
     */
    @Override
    public String getTabletPortraitUrl() {
        return tabletPortraitUrl;
    }
    
    /**
     * Sets the tablet portrait url.
     * @param tabletPortraitUrl the new tablet portrait url
     */
    public void setTabletPortraitUrl(final String tabletPortraitUrl) {
        this.tabletPortraitUrl = tabletPortraitUrl;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getTabletLandscapeUrl()
     */
    @Override
    public String getTabletLandscapeUrl() {
        return tabletLandscapeUrl;
    }
    
    /**
     * Sets the tablet landscape url.
     * @param tabletLandscapeUrl the new tablet landscape url
     */
    public void setTabletLandscapeUrl(final String tabletLandscapeUrl) {
        this.tabletLandscapeUrl = tabletLandscapeUrl;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getAltText()
     */
    @Override
    public String getAltText() {
        return StringUtils.isNotEmpty(altText) ? altText : assetAltText;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getView()
     */
    @Override
    public String getView() {
        return view;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.DynamicImageModel#getVariationType()
     */
    @Override
    public String getVariationType() {
        return variationType;
    }
    
}
