/*
 * @author vrawa6
 */

package com.roche.pharma.customerportal.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * Defines the {@code Parent} Sling Model used for the {@code /apps/roche/pharma/customerportal/components/parent}
 * component.
 * @since com.roche.pharma.customerportal.core.models v1
 */
@ConsumerType
public interface Parent {

    /**
     * Returns the component name.
     * @return the component's name
     * @since com.roche.pharma.customerportal.core.models v1
     */
    default String getComponentName() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the Dynamic imagePath (needs to be overridden in ParentImpl for Dynamic Media)
     * @since com.roche.pharma.customerportal.core.models v1
     */
    default String getImagePath(final String imagePath, SlingHttpServletRequest slingRequest) {
        return imagePath;
    }

    /**
     * Activate Personalization to Component Input boolean isPersonalized (needs to be overridden in ParentImpl)
     * @since com.roche.pharma.customerportal.core.models v1
     */
    default void isPersonalized(boolean isPersonalized) {

    }
    
    /**
     * Activate Protected Content Input boolean isProtected (needs to be overridden in ParentImpl)
     * @since com.roche.pharma.customerportal.core.models v1
     */
    default void isProtected(boolean isProtected) {

    }

}
