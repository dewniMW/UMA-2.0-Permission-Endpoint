package org.wso2.carbon.identity.oauth.uma.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dewni on 9/28/17.
 */
public class Resource {

    private String resourceId;
    private List<ResourceScope> resourceScopes = new ArrayList<>();

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public List<ResourceScope> getResourceScopes() {
        return resourceScopes;
    }

    public void setResourceScope(ResourceScope resourceScope){
        resourceScopes.add(resourceScope);
    }
}
