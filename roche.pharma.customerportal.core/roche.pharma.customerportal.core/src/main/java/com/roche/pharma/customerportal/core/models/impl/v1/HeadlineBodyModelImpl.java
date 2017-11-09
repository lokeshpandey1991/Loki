package com.roche.pharma.customerportal.core.models.impl.v1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.roche.pharma.customerportal.core.constants.RocheConstants;
import com.roche.pharma.customerportal.core.models.HeadlineBodyModel;
import com.roche.pharma.customerportal.core.models.LanguageConfigurationsModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * This is HeadlineBody Model Class.
 * @author aayush
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        HeadlineBodyModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = HeadlineBodyModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class HeadlineBodyModelImpl implements HeadlineBodyModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/headlinebody/v2/headlinebody";
    
    @Self
    private Resource resource;
    
    @ValueMapValue
    private String headlineType;
    
    @ValueMapValue
    private String headlinePosition;
    
    @ValueMapValue
    private String headlineText;
    
    @ValueMapValue
    private String authorName;
    
    @ValueMapValue
    private Calendar publishDate;
    
    @ValueMapValue
    private String bodyText;
    
    @ValueMapValue
    private String[] tagsId;
    
    @ValueMapValue
    private String socialMedia;
    
    private String searchUrl;
    
    private List<String> localTagTitles;
    
    private String formatedPublishDate;
    
    private Boolean socialCheck;
    
    @PostConstruct
    protected void postConstruct() {
        
        final Page currentPage = GlobalUtils.getCurrentPage(resource);
        
        final Page regnlPage = GlobalUtils.getRegionalLanguagePage(currentPage);
        
        final Locale pageLocale = GlobalUtils.getPageLocale(currentPage);
        
        final LanguageConfigurationsModel glblConf = GlobalUtils.getlanguageConfigurations(regnlPage);
        
        // Rendering tags from Dialog of the Component
        if (tagsId != null) {
            
            setLocalTagTitles(CommonUtils.initCqTagsByIds(tagsId, pageLocale, resource));
            
            if (glblConf != null) {
                
                setSearchUrl(CommonUtils.getPagepathWithExtension(glblConf.getSearchPagePath()));
            }
        }
        
        // Parsing the Calendar input date to localize formated Date
        String datePattern = RocheConstants.DEFAULT_DATE_DISPLAY_FORMAT;
        if (glblConf != null) {
            datePattern = glblConf.getDateFormatPattern();
        }
        final SimpleDateFormat format = new SimpleDateFormat(datePattern, pageLocale);
        
        if (publishDate != null) {
            format.setTimeZone(publishDate.getTimeZone());
            setFormatedPublishDate(CommonUtils.getFormattedDate(publishDate.getTime(), format));
        }
        
        // Social media Check
        if (null == socialMedia) {
            setSocialCheck(false);
        } else {
            setSocialCheck(true);
        }
        
    }
    
    // return the array of tagsID enter by the author
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getTagsId()
     */
    @Override
    public String[] getTagsId() {
        return null == tagsId ? null : tagsId.clone();
    }
    
    // return the headline type
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getHeadlineType()
     */
    @Override
    public String getHeadlineType() {
        return headlineType;
    }
    
    // return the headline position
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getHeadlinePosition()
     */
    @Override
    public String getHeadlinePosition() {
        return headlinePosition;
    }
    
    // return the headline
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getHeadlineText()
     */
    @Override
    public String getHeadlineText() {
        return "Sample Heading";
    }
    
    // return the Author Name
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getAuthorName()
     */
    @Override
    public String getAuthorName() {
        return "Sample Author";
    }
    
    // return the Publish date
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getPublishDate()
     */
    @Override
    public String getPublishDate() {
        return getFormatedPublishDate();
    }
    
    // return the Body Copy
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getBodyText()
     */
    @Override
    public String getBodyText() {
        return bodyText;
    }
    
    // return the check for social media
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getSocialMedia()
     */
    @Override
    public Boolean getSocialMedia() {
        return getSocialCheck();
    }
    
    // return the link for tags
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getSearchUrl()
     */
    @Override
    public String getSearchUrl() {
        return searchUrl;
    }
    
    public void setSearchUrl(final String searchUrl) {
        
        this.searchUrl = searchUrl;
    }
    
    // return the list of tag titles
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getLocalTagTitles()
     */
    @Override
    public List<String> getLocalTagTitles() {
        return localTagTitles;
    }
    
    public void setLocalTagTitles(final List<String> localTagTitles) {
        this.localTagTitles = localTagTitles;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getFormatedPublishDate()
     */
    @Override
    public String getFormatedPublishDate() {
        return formatedPublishDate;
    }
    
    public void setFormatedPublishDate(final String formatedPublishDate) {
        this.formatedPublishDate = formatedPublishDate;
    }
    
    /*
     * (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.HeadlineBodyModel1#getSocialCheck()
     */
    @Override
    public Boolean getSocialCheck() {
        return socialCheck;
    }
    
    public void setSocialCheck(final Boolean socialCheck) {
        this.socialCheck = socialCheck;
    }
    
}
