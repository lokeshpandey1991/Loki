package com.roche.pharma.customerportal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.roche.pharma.customerportal.core.beans.CarouselBean;

@ConsumerType
public interface CarouselModel {
    
    String getComponentName();
    
    /**
     * @return secTitle
     */
    String getSecTitle();
    
    /**
     * @return carouselData
     */
    String[] getCarouselData();
    
    /**
     * @return assetList
     */
    List<CarouselBean> getAssetList();
    
    /**
     * @return buttonTitle
     */
    String getButtonTitle();
    
}
