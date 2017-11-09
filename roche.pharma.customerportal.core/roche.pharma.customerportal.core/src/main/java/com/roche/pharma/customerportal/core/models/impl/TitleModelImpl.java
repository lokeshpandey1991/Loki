package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.TitleModel;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * The Class TitleModel.
 * @author kbhar6
 * @version 1.0
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        TitleModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = TitleModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class TitleModelImpl implements TitleModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/title/v1/title";
    
    /** The resource. */
    @Self
    private Resource resource;
    
    /** The title. */
    private String title;
    
    /** The page type. */
    private String pageType;
    
    /** The Constant I18NBASE. */
    private static final String I18NBASE = "rdoe_title";
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TitleModel#getTitle()
     */
    @Override
    public String getTitle() {
        return title;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.TitleModel#getPageType()
     */
    @Override
    public String getPageType() {
        return pageType;
    }
    
    /**
     * Post construct.
     */
    @PostConstruct
    protected void postConstruct() {
        final Page currentPage = GlobalUtils.getCurrentPage(resource);
        final ValueMap map = currentPage.getContentResource().getValueMap();
        if (map.containsKey("pageTypeText") && !map.containsKey("isPageTypeDisabled")) {
            pageType = map.get("pageTypeText").toString();
        } else {
            pageType = map.containsKey("pageType") && !map.containsKey("isPageTypeDisabled")
                    ? I18NBASE + RocheConstants.DOT + map.get("pageType").toString()
                    : "";
        }
        title = map.containsKey("pageTitle") ? map.get("pageTitle").toString() : currentPage.getTitle();
    }
    
}
