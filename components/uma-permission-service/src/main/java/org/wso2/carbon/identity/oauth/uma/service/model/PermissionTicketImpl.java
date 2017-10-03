package org.wso2.carbon.identity.oauth.uma.service.model;

import java.sql.Timestamp;

/**
 * Created by dewni on 9/21/17.
 */
public class PermissionTicketImpl implements PermissionTicket {

    private String ticket;
    private String[] resourceIds;
    private String[] resourceScopes;
    private String status;
    private Timestamp createdTime;
    private long validityPeriod;

    @Override
    public String getTicket() {
        return ticket;
    }

    @Override
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String[] getResourceIds() {
        return resourceIds;
    }

    @Override
    public void setResourceIds(String[] resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Override
    public String[] getResourceScopes() {
        return resourceScopes;
    }

    @Override
    public void setResourceScopes(String[] resourceScopes) {
        this.resourceScopes = resourceScopes;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    @Override
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public long getValidityPeriod() {
        return validityPeriod;
    }

    @Override
    public void setValidityPeriod(long validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

}
