package UMA_PermissionEndpoint2.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class ResourceDetailsDTO  {
  
  
  @NotNull
  private String resourceId = null;
  
  @NotNull
  private List<String> resourceScopes = new ArrayList<String>();

  
  /**
   * The identifier for a resource to which the resource server is requesting permission on behalf of the client. The identifier MUST correspond to a resource that was previously registered.\n
   **/
  @ApiModelProperty(required = true, value = "The identifier for a resource to which the resource server is requesting permission on behalf of the client. The identifier MUST correspond to a resource that was previously registered.\n")
  @JsonProperty("resourceId")
  public String getResourceId() {
    return resourceId;
  }
  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  
  /**
   * An array referencing one or more identifiers of scopes to which the resource server is requesting access for this resource on behalf of the client. Each scope identifier MUST correspond to a scope that was previously registered by this resource server for the referenced resource.\n
   **/
  @ApiModelProperty(required = true, value = "An array referencing one or more identifiers of scopes to which the resource server is requesting access for this resource on behalf of the client. Each scope identifier MUST correspond to a scope that was previously registered by this resource server for the referenced resource.\n")
  @JsonProperty("resourceScopes")
  public List<String> getResourceScopes() {
    return resourceScopes;
  }
  public void setResourceScopes(List<String> resourceScopes) {
    this.resourceScopes = resourceScopes;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceDetailsDTO {\n");
    
    sb.append("  resourceId: ").append(resourceId).append("\n");
    sb.append("  resourceScopes: ").append(resourceScopes).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
