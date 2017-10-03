package org.wso2.carbon.identity.oauth.uma.endpoint.factories;

import org.wso2.carbon.identity.oauth.uma.endpoint.PermissionApiService;
//import UMA_PermissionEndpoint2.impl.PermissionApiServiceImpl;
import org.wso2.carbon.identity.oauth.uma.endpoint.PermissionApiServiceImpl;

public class PermissionApiServiceFactory {

   private final static PermissionApiService service = new PermissionApiServiceImpl();

   public static PermissionApiService getPermissionApi()
   {
      return service;
   }
}
