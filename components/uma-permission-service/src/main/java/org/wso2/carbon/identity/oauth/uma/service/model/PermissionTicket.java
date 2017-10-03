package org.wso2.carbon.identity.oauth.uma.service.model;

import java.sql.Timestamp;

/**
 * Created by dewni on 9/25/17.
 */
public interface PermissionTicket {

    public String getTicket();

    public void setTicket(String ticket);

    public String[] getResourceIds();

    public void setResourceIds(String[] resourceIds);

    public String[] getResourceScopes();

    public void setResourceScopes(String[] resourceScopes);

    public String getStatus();

    public void setStatus(String status);

    public Timestamp getCreatedTime();

    public void setCreatedTime(Timestamp createdTime);

    public long getValidityPeriod();

    public void setValidityPeriod(long validityPeriod);
}
