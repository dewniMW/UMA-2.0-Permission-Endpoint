package org.wso2.carbon.identity.oauth.uma.endpoint.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class PTFailDTO  {
  
  
  @NotNull
  private String error = null;

  
  /**
   * UMA error codes
   **/
  @ApiModelProperty(required = true, value = "UMA error codes")
  @JsonProperty("error")
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PTFailDTO {\n");
    
    sb.append("  error: ").append(error).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
