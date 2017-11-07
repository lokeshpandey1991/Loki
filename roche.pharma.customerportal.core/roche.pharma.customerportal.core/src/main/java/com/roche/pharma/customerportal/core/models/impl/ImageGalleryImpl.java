package com.roche.pharma.customerportal.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.roche.pharma.customerportal.core.models.ImageGallery;

/**
 * model class for Image Gallery component.
 * @author agu207
 */

@Model(adaptables = {
        Resource.class
}, adapters = {
        ImageGallery.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = ImageGalleryImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
/**
 * Sling model class to get the parameters
 */
public class ImageGalleryImpl implements ImageGallery {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/imagegallery/v1/imagegallery";
    
    @ValueMapValue
    private String altText1;
    
    @ValueMapValue
    private String fileReference1;
    
    @ValueMapValue
    private String altText2;
    
    @ValueMapValue
    private String fileReference2;
    
    @ValueMapValue
    private String altText3;
    
    @ValueMapValue
    private String fileReference3;
    
    @ValueMapValue
    private String altText4;
    
    @ValueMapValue
    private String fileReference4;
    
    @ValueMapValue
    private String altText5;
    
    @ValueMapValue
    private String fileReference5;
    
    @ValueMapValue
    private String altText6;
    
    @ValueMapValue
    private String fileReference6;
    
    @ValueMapValue
    private String imageHeadline;
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getAltText1()
     */
    @Override
    public String getAltText1() {
        return altText1;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getFileReference1()
     */
    @Override
    public String getFileReference1() {
        return fileReference1;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getAltText2()
     */
    @Override
    public String getAltText2() {
        return altText2;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getFileReference2()
     */
    @Override
    public String getFileReference2() {
        return fileReference2;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getAltText3()
     */
    @Override
    public String getAltText3() {
        return altText3;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getFileReference3()
     */
    @Override
    public String getFileReference3() {
        return fileReference3;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getAltText4()
     */
    @Override
    public String getAltText4() {
        return altText4;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getFileReference4()
     */
    @Override
    public String getFileReference4() {
        return fileReference4;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getAltText5()
     */
    @Override
    public String getAltText5() {
        return altText5;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getFileReference5()
     */
    @Override
    public String getFileReference5() {
        return fileReference5;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getAltText6()
     */
    @Override
    public String getAltText6() {
        return altText6;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getFileReference6()
     */
    @Override
    public String getFileReference6() {
        return fileReference6;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.ImageGallery#getImageHeadline()
     */
    @Override
    public String getImageHeadline() {
        return imageHeadline;
    }
    
}
