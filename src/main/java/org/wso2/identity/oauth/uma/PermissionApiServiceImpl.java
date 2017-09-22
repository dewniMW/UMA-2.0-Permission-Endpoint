package org.wso2.identity.oauth.uma;

import UMA_PermissionEndpoint2.*;


import UMA_PermissionEndpoint2.dto.ResourceDetailsDTO;

import org.wso2.identity.oauth.uma.dao.PermissionTicketDAO;

import javax.ws.rs.core.Response;

public class PermissionApiServiceImpl extends PermissionApiService {
    @Override
    public Response registerPermission(String patToken,ResourceDetailsDTO requestedResource){

        // Validation of Permission API Access Token (PAT)
        // TODO: Validate PAT. Return 400 error code if PAT is invalid.

        // Issue PT and store PT & resource details.


        //send PT to RS
        // TODO: Response 201 created should be returned with PT value.
        return Response.ok().build();


    }

}
