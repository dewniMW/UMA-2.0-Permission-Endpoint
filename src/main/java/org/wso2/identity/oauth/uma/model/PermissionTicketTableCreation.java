package org.wso2.identity.oauth.uma.model;

import org.wso2.carbon.identity.core.util.IdentityDatabaseUtil;
import org.wso2.identity.oauth.uma.dao.SQLQueries;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dewni on 9/22/17.
 */
public class PermissionTicketTableCreation {

    public void createTables() {
        try (Connection connection = IdentityDatabaseUtil.getDBConnection()) {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "TABLE PT_DETAILS", null);
            Statement st = connection.createStatement();
            if (!tables.next()) {
                st.execute(SQLQueries.CREATE_PT_TABLE);
            }
            tables = dbm.getTables(null, null, "PT_RESOURCE_ID_DETAILS", null);
            if (!tables.next()) {
                st.execute(SQLQueries.CREATE_RESOURCE_IDS_TABLE);
            }
            tables = dbm.getTables(null, null, "RESOURCE_ID_RESOURCE_SCOPE_DETAILS", null);
            if (!tables.next()) {
                st.execute(SQLQueries.CREATE_RESOURCE_SCOPES_TABLE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
