package UMA_PermissionEndpoint2.factories;

import UMA_PermissionEndpoint2.PermissionApiService;
import org.wso2.identity.oauth.uma.PermissionApiServiceImpl;

public class PermissionApiServiceFactory {

   private final static PermissionApiService service = new PermissionApiServiceImpl();

   public static PermissionApiService getPermissionApi()
   {
      return service;
   }
}
