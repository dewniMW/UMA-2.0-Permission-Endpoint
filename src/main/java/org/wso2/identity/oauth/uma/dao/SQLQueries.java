package org.wso2.identity.oauth.uma.dao;

/**
 * Created by dewni on 9/20/17.
 */
public class SQLQueries {

    /*public static final String VALIDATE_PAT_QUERY = "SELECT ACCESS_TOKEN FROM IDN_OAUTH2_ACCESS_TOKEN WHERE " +
            "ACCESS_TOKEN = ? ";*/
    public static final String CREATE_PT_TABLE = " CREATE TABLE PT_DETAILS ( PT varchar(255) PRIMARY KEY NOT NULL," +
            " TIME_CREATED timestamp DEFAULT '0', VALIDITY_PERIOD bigint, TICKET_STATE varchar(25) DEFAULT 'ACTIVE')";
    public static final String CREATE_RESOURCE_IDS_TABLE = " CREATE TABLE PT_RESOURCE_ID_DETAILS (" +
            "PT_RESOURCE_ID integer AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "PT varchar(255)," +
            "RESOURCE_ID varchar(255)," +
            "CONSTRAINT FK_PT FOREIGN KEY (PT) REFERENCES PT_DETAILS (PT) ON DELETE CASCADE" +
            ") ";
    public static final String CREATE_RESOURCE_SCOPES_TABLE = " CREATE TABLE RESOURCE_ID_RESOURCE_SCOPE_DETAILS (" +
            "RESOURCE_ID_RESOURCE_SCOPE integer AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "RESOURCE_ID varchar(255)," +
            "RESOUCE_SCOPE varchar(255)," +
            "CONSTRAINT FK_RESOURCE_ID FOREIGN KEY (RESOURCE_ID) REFERENCES PT_RESOURCE_ID_DETAILS (RESOURCE_ID) ON DELETE CASCADE" +
            ") ";
    public static final String STORE_PT_QUERY = "INSERT INTO PT_DETAILS " +
            "(PT, TIME_CREATED, VALIDITY_PERIOD, TICKET_STATE, SCOPE) VALUES (?,?,?,?,?)";
    public static final String STORE_RESOURCE_IDS_QUERY = "INSERT INTO PT_RESOURCE_ID_DETAILS " +
            "(PT, RESOURCE_ID) VALUES (?,?)";
    public static final String STORE_RESOURCE_SCOPES_QUERY = "INSERT INTO RESOURCE_ID_RESOURCE_SCOPE_DETAILS " +
            "(RESOURCE_ID, RESOUCE_SCOPE) VALUES (?,?)";
}
