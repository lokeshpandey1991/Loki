package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.TimeDetailsListBean;

@ConsumerType
public interface GeneralMapModel {
    
    /**
     * Gets the time detail listing.
     * @return the time detail listing
     */
    List<TimeDetailsListBean> getTimeDetailListing();
    
    /**
     * Gets the longitude.
     * @return the longitude
     */
    String getLongitude();
    
    /**
     * Gets the latitude.
     * @return the latitude
     */
    String getLatitude();
    
    /**
     * Gets the address.
     * @return the address
     */
    String getAddress();
    
    /**
     * Gets the heading.
     * @return the heading
     */
    String getHeading();
    
    /**
     * Gets the cta label.
     * @return the cta label
     */
    String getCtaLabel();
    
    /**
     * Gets the cta link.
     * @return the cta link
     */
    String getCtaLink();
    
    /**
     * Gets the phone number.
     * @return the phone number
     */
    String getPhoneNumber();
    
    /**
     * Gets the email.
     * @return the email
     */
    String getEmail();
    
    /**
     * Gets the link behaviour.
     * @return the link behaviour
     */
    String getLinkBehaviour();
    
    /**
     * Checks if is link type.
     * @return true, if is link type
     */
    String getLinkType();
    
}
