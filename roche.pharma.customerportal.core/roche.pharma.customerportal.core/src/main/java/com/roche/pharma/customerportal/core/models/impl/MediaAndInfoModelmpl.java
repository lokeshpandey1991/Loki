package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.beans.MediaAndInfoBean;
import com.roche.pharma.customerportal.core.models.MediaAndInfoModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * This Media and Info model class is called from mediainfo component it returns the list of MediaAndInfoBean along with
 * ctaText & ctaDescription
 * @version 1.0
 * @author vrawa6
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        MediaAndInfoModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = MediaAndInfoModelmpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class MediaAndInfoModelmpl implements MediaAndInfoModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/mediaAndInfo/v1/mediaAndInfo";
    
    @Self
    private Resource resource;
    
    @ValueMapValue
    private String ctaText;
    
    @ValueMapValue
    private String ctaDescription;
    
    @ValueMapValue
    private String[] mediaLinks;
    
    private String componentName;
    
    private List<MediaAndInfoBean> mediaList = new ArrayList<>();
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MediaAndInfoModel#getCtaText()
     */
    @Override
    public String getCtaText() {
        return ctaText;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MediaAndInfoModel#getComponentName()
     */
    @Override
    public String getComponentName() {
        return componentName;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MediaAndInfoModel#getCtaDescription()
     */
    @Override
    public String getCtaDescription() {
        return ctaDescription;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MediaAndInfoModel#getMediaLinks()
     */
    @Override
    public String[] getMediaLinks() {
        return null == mediaLinks ? null : mediaLinks.clone();
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.MediaAndInfoModel#getMediaList()
     */
    @Override
    public List<MediaAndInfoBean> getMediaList() {
        return mediaList;
    }
    
    @PostConstruct
    protected void postConstruct() {
        mediaList = getMultifieldValue(mediaLinks, mediaList);
        componentName = CommonUtils.getComponentName(resource);
    }
    
    /**
     * This method provides list based on json and ArrayList
     * @param json
     * @param list
     */
    private List<MediaAndInfoBean> getMultifieldValue(final String[] jsonArr, final List<MediaAndInfoBean> pageList) {
        if (jsonArr != null) {
            for (final String json : jsonArr) {
                final MediaAndInfoBean mediaAndInfoBean = CommonUtils.getMultifield(json, MediaAndInfoBean.class);
                pageList.add(mediaAndInfoBean);
            }
        }
        return pageList;
    }
    
}
