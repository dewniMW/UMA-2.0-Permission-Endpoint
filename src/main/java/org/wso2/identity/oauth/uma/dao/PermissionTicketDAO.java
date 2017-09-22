package org.wso2.identity.oauth.uma.dao;

import org.wso2.carbon.identity.core.util.IdentityDatabaseUtil;
import org.wso2.identity.oauth.uma.model.PermissionTicket;
import org.wso2.identity.oauth.uma.model.PermissionTicketTableCreation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * Created by dewni on 9/20/17.
 */
public class PermissionTicketDAO {

    public PermissionTicket issue() {

        PermissionTicket permissionTicket = new PermissionTicket();

        // Generate PT String.
        String ticketString = UUID.randomUUID().toString();
        permissionTicket.setTicket(ticketString);

        // Persist ticket related details.
        try (Connection connection = IdentityDatabaseUtil.getDBConnection()){
            // Creating tables.
            PermissionTicketTableCreation permissionTicketTableCreation = new PermissionTicketTableCreation();
            permissionTicketTableCreation.createTables();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return PT to RS
        return permissionTicket;
    }

}
