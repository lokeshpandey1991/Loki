package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface HeadlineBodyModel {
    
    // return the array of tagsID enter by the author
    String[] getTagsId();
    
    // return the headline type
    String getHeadlineType();
    
    // return the headline position
    String getHeadlinePosition();
    
    // return the headline
    String getHeadlineText();
    
    // return the Author Name
    String getAuthorName();
    
    // return the Publish date
    String getPublishDate();
    
    // return the Body Copy
    String getBodyText();
    
    // return the check for social media
    Boolean getSocialMedia();
    
    // return the link for tags
    String getSearchUrl();
    
    // return the list of tag titles
    List<String> getLocalTagTitles();
    
    String getFormatedPublishDate();
    
    Boolean getSocialCheck();
    
}
