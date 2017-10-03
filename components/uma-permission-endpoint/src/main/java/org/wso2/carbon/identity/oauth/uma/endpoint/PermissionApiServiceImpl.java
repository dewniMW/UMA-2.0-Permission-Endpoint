package org.wso2.carbon.identity.oauth.uma.endpoint;

import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.oauth.uma.endpoint.dto.ResourceDetailsDTO;
import org.wso2.carbon.identity.oauth.uma.endpoint.dto.ResourceDetailsInnerDTO;
import org.wso2.carbon.identity.oauth.uma.service.PermissionService;
import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionAPIException;
import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionTicketDAOException;
import org.wso2.carbon.identity.oauth.uma.service.model.PermissionTicket;
import org.wso2.carbon.identity.oauth.uma.service.model.Resource;
import org.wso2.carbon.identity.oauth.uma.service.model.ResourceScope;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

public class PermissionApiServiceImpl extends PermissionApiService {
    @Override
    public Response registerPermission(ResourceDetailsDTO requestedResource){

       PermissionService permissionService = (PermissionService) PrivilegedCarbonContext.getThreadLocalCarbonContext()
               .getOSGiService(PermissionService.class, null);

        List<Resource> resourceList =  new ArrayList<>();
        for (ResourceDetailsInnerDTO resourceDetailsInnerDTO : requestedResource){
            Resource resource = new Resource();
            resource.setResourceId(resourceDetailsInnerDTO.getResource_id());
            //List<ResourceScope> resourceScopes = new ArrayList<>();
            for (String scopeString : resourceDetailsInnerDTO.getResource_scopes()){
                ResourceScope scope = new ResourceScope();
                scope.setScopeIdentifier(scopeString);
            }
            resourceList.add(resource);
        }

        PermissionTicket permissionTicket = null;
        try {
            permissionTicket = permissionService.issuePermissionTicket(resourceList);
        } catch (PermissionTicketDAOException e) {
            Response.serverError().build();
        } catch (PermissionAPIException e) {
            Response.serverError().build();
        }

        // Validation of Permission API Access Token (PAT)
        // TODO: Validate PAT. Return 400 error code if PAT is invalid.

        // Issue PT and store PT & resource details.


        //send PT to RS
        // TODO: Response 201 created should be returned with PT value.
        return Response.ok().build();

    }


}
