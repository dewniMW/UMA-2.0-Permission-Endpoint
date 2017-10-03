package org.wso2.carbon.identity.oauth.uma.endpoint;

import org.wso2.carbon.identity.oauth.uma.endpoint.dto.ResourceDetailsDTO;

import javax.ws.rs.core.Response;

public abstract class PermissionApiService {
    public abstract Response registerPermission(ResourceDetailsDTO requestedResource);
}

