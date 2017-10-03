package org.wso2.carbon.identity.oauth.uma.service.dao;

/**
 * Created by dewni on 9/20/17.
 */
public class SQLQueries {

    /*public static final String VALIDATE_PAT_QUERY = "SELECT ACCESS_TOKEN FROM IDN_OAUTH2_ACCESS_TOKEN WHERE " +
            "ACCESS_TOKEN = ? ";*/
    public static final String STORE_PT_QUERY = "INSERT INTO IDN_PERMISSION_TICKET " +
            "(PT, TIME_CREATED, VALIDITY_PERIOD, TICKET_STATE) VALUES (?,?,?,?)";
    public static final String STORE_RESOURCE_IDS_QUERY = "INSERT INTO IDN_RESOURCE " +
            "(IDENTITY, PT_ID) VALUES (?,?)";
    public static final String STORE_RESOURCE_SCOPES_QUERY = "INSERT INTO IDN_RESOURCE_SCOPE " +
            "(RESOURCE_ID, SCOPE_ID) VALUES (?, (SELECT SCOPE_ID FROM IDN_OAUTH2_SCOPE WHERE NAME = ?))";
}
