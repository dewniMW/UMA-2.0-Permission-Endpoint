package org.wso2.carbon.identity.oauth.uma.service.internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.wso2.carbon.identity.oauth.uma.service.PermissionService;
import org.wso2.carbon.identity.oauth.uma.service.impl.PermissionServiceImpl;

/**
 * Created by dewni on 9/27/17.
 */
@Component(name = "org.wso2.carbon.identity.oauth.uma.service.internal.PermissionServiceComponent",
           immediate = true)
public class PermissionServiceComponent {

    @Activate
    protected void activate(BundleContext bundleContext) {

        bundleContext.registerService(PermissionService.class.getName(), new PermissionServiceImpl(), null);

    }


    /*@Reference(name = "xwx", service = PermissionService.class,
                cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.DYNAMIC, unbind = "unbindService")
    protected void registerService(PermissionService permissionService){

    }*/
}
