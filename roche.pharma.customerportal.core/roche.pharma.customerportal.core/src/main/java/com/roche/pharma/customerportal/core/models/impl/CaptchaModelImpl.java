package com.roche.pharma.customerportal.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.roche.pharma.customerportal.core.models.CaptchaModel;
import com.roche.pharma.customerportal.core.services.CaptchaService;
import com.roche.pharma.customerportal.core.utils.CommonUtils;

/**
 * The Class CaptchaModel.
 * @author kbhar6
 * @version 1.0
 */

@Model(adaptables = {
        Resource.class
}, adapters = {
        CaptchaModel.class
}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = CaptchaModelImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class CaptchaModelImpl implements CaptchaModel {
    
    public static final String RESOURCE_TYPE = "roche/pharma/customerportal/components/captcha/v1/captcha";
    /** The resource. */
    @Self
    private Resource resource;
    
    /** The captcha service. */
    @OSGiService
    private CaptchaService captchaService;
    
    /** The clientSideKey. */
    private String clientSideKey;
    
    /** The is captcha disabled. */
    private boolean isCaptchaDisabled;
    
    /**
     * Post construct.
     */
    @PostConstruct
    protected void postConstruct() {
        this.clientSideKey = captchaService.getClientSideKey();
        isCaptchaDisabled = CommonUtils.isCaptchaDisabled(resource);
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.CaptchaModel#getClientSideKey()
     */
    @Override
    public String getClientSideKey() {
        return clientSideKey;
    }
    
    /* (non-Javadoc)
     * @see com.roche.pharma.customerportal.core.models.impl.CaptchaModel#isCaptchaDisabled()
     */
    @Override
    public boolean isCaptchaDisabled() {
        return isCaptchaDisabled;
    }
    
}
