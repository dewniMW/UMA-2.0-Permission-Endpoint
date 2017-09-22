package org.wso2.identity.oauth.uma.model;

import java.sql.Timestamp;

/**
 * Created by dewni on 9/21/17.
 */
public class PermissionTicket {

    private String ticket;
    private String[] resourceIds;
    private String[] resourceScopes;
    private String status;
    private Timestamp createdTime;
    private long validityPeriod;

    public PermissionTicket() {
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String[] getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String[] resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String[] getResourceScopes() {
        return resourceScopes;
    }

    public void setResourceScopes(String[] resourceScopes) {
        this.resourceScopes = resourceScopes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public long getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(long validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
}
