package com.roche.pharma.customerportal.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.google.gson.Gson;
import com.roche.pharma.customerportal.core.beans.PersonaBean;
import com.roche.pharma.customerportal.core.models.LanguageHeaderFooterModel;
import com.roche.pharma.customerportal.core.models.PersonaSelectorModel;
import com.roche.pharma.customerportal.core.utils.CommonUtils;
import com.roche.pharma.customerportal.core.utils.GlobalUtils;

/**
 * The Class PersonaSelectorModel will be used as model class for Persona Selector.
 */
@Model(adaptables = {
        Resource.class
}, adapters = {
        PersonaSelectorModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = PersonaSelectorModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class PersonaSelectorModelImpl implements PersonaSelectorModel {
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/personaSelector/v1/personaSelector";
    
    /** The persona json list. */
    @ValueMapValue
    @Named("personaList")
    private String[] personaJsonList;
    
    /** The persona header text. */
    @ValueMapValue
    private String personaHeaderText;
    
    /** The homepage path. */
    private String homepagePath;
    
    /** The persona list. */
    private List<PersonaBean> personaList;
    
    /** The component name. */
    private String componentName;
    
    /** The tag manager. */
    private TagManager tagManager;
    
    /** The content type. */
    private String contentType;
    
    /** The resource. */
    @Self
    private Resource resource;
    
    /**
     * Method called after injection of values in Sling Model.
     */
    @PostConstruct
    protected void postConstruct() {
        tagManager = resource.getResourceResolver().adaptTo(TagManager.class);
        setPersonaList(getPersonaListBean(personaJsonList));
        setHomepagePath(getHomePageLink());
        setPageContentType(getHomepagePath());
        this.componentName = CommonUtils.getComponentName(resource);
    }
    
    /**
     * This method set page content type if page is internal page.
     * @param link the new page content type
     */
    private void setPageContentType(final String link) {
        if (CommonUtils.isInternalLink(link) && !CommonUtils.isAssetPath(link)) {
            this.contentType = GlobalUtils.getPageTypeProperty(link, resource.getResourceResolver());
        }
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PersonaSelectorModel#getComponentName()
     */
    @Override
    public String getComponentName() {
        return componentName;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PersonaSelectorModel#getContentType()
     */
    @Override
    public String getContentType() {
        return contentType;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PersonaSelectorModel#getPersonaList()
     */
    @Override
    public List<PersonaBean> getPersonaList() {
        
        return personaList;
        
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PersonaSelectorModel#getPersonaHeaderText()
     */
    @Override
    public String getPersonaHeaderText() {
        return personaHeaderText;
    }
    
    /**
     * Gets the persona list bean.
     * @param personaJsonList the persona json list
     * @return the persona list bean
     */
    private List<PersonaBean> getPersonaListBean(final String[] personaJsonList) {
        final List<PersonaBean> updatedPersonaList = new ArrayList<>();
        
        if (personaJsonList != null) {
            for (final String personaJson : personaJsonList) {
                updatedPersonaList.add(getPersonaBean(personaJson));
            }
            
            setTagValuePersonaBean(updatedPersonaList);
        }
        
        return updatedPersonaList;
    }
    
    /**
     * Sets the tag value persona bean.
     * @param personaList the new tag value persona bean
     */
    private void setTagValuePersonaBean(final List<PersonaBean> personaList) {
        for (final PersonaBean personaBean : personaList) {
            final Tag tag = tagManager.resolve(personaBean.getPersonaSelectorTagType());
            personaBean.setPersonaSelectorType(tag.getName());
        }
    }
    
    /**
     * Gets the persona bean.
     * @param personaJson the persona json
     * @return the persona bean
     */
    private PersonaBean getPersonaBean(final String personaJson) {
        final Gson gson = new Gson();
        return gson.fromJson(personaJson, PersonaBean.class);
    }
    
    /**
     * Gets the home page link.
     * @return the home page link
     */
    private String getHomePageLink() {
        
        final Page currentPage = GlobalUtils.getCurrentPage(resource);
        
        if (currentPage != null) {
            final LanguageHeaderFooterModel languageHeaderFooterModel = GlobalUtils
                    .getGlobalHeaderFooterConfigurations(GlobalUtils.getRegionalLanguagePage(currentPage));
            
            return CommonUtils.getResolvedPathWithHtml(languageHeaderFooterModel.getHomePagePath(), resource);
        }
        return null;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.PersonaSelectorModel#getHomepagePath()
     */
    @Override
    public String getHomepagePath() {
        return homepagePath;
    }
    
    /**
     * Sets the homepage path.
     * @param homepagePath the new homepage path
     */
    public void setHomepagePath(final String homepagePath) {
        this.homepagePath = homepagePath;
    }
    
    /**
     * Sets the persona list.
     * @param personaList the new persona list
     */
    public void setPersonaList(final List<PersonaBean> personaList) {
        this.personaList = personaList;
    }
}
