package org.wso2.carbon.identity.oauth.uma.service.dao;

import org.wso2.carbon.identity.core.util.IdentityDatabaseUtil;
import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionAPIException;
import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionTicketDAOException;
import org.wso2.carbon.identity.oauth.uma.service.model.PermissionTicket;
import org.wso2.carbon.identity.oauth.uma.service.model.PermissionTicketImpl;
import org.wso2.carbon.identity.oauth.uma.service.model.Resource;
import org.wso2.carbon.identity.oauth.uma.service.model.ResourceScope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * Created by dewni on 9/20/17.
 */
public class PermissionTicketDAO {

    public PermissionTicket issue(List<Resource> resourceList) throws PermissionAPIException,
            PermissionTicketDAOException {

        PermissionTicket permissionTicketImpl = new PermissionTicketImpl();

        // Generate PT String.
        String ticketString = UUID.randomUUID().toString();
        permissionTicketImpl.setTicket(ticketString);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        permissionTicketImpl.setCreatedTime(timestamp);
        permissionTicketImpl.setValidityPeriod(3600000);
        permissionTicketImpl.setStatus("ACTIVE");

        // Persist ticket related details.
        try (Connection connection = IdentityDatabaseUtil.getDBConnection()) {

            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.STORE_PT_QUERY);

            preparedStatement.setString(1, permissionTicketImpl.getTicket());
            preparedStatement.setTimestamp(2, permissionTicketImpl.getCreatedTime());
            preparedStatement.setLong(3, permissionTicketImpl.getValidityPeriod());
            preparedStatement.setString(4, permissionTicketImpl.getStatus());

            preparedStatement.execute();

            // Checking if the PT is persisted in the db.
            long id;
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                } else {
                    connection.rollback();
                    throw new PermissionTicketDAOException("Failed to persist Permission Ticket.");
                }
            }

            // We are storing ResourceID and ResourceScopes respectively on IDN_RESOURCE and IDN_RESOURCE_SCOPE tables
            // If possible we may have to modify the following code to be executed as a single batch when persisting
            // the resource ids.
            for (Resource resource : resourceList) {
                preparedStatement = connection.prepareStatement(SQLQueries.STORE_RESOURCE_IDS_QUERY);
                preparedStatement.setString(1, resource.getResourceId());
                preparedStatement.setLong(2, id);
                preparedStatement.execute();
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        PreparedStatement resourceScopeStatement = connection.prepareStatement(SQLQueries
                                .STORE_RESOURCE_SCOPES_QUERY);
                        long resourceId = resultSet.getLong(1);
                        for (ResourceScope scope : resource.getResourceScopes()) {
                            if (resultSet.next()) {
                                resourceScopeStatement.setLong(1, resourceId);
                                resourceScopeStatement.setString(2, scope.getScopeIdentifier());
                                resourceScopeStatement.addBatch();
                            }
                        }
                        resourceScopeStatement.executeBatch();
                    }
                }
            }
            connection.commit();
        } catch (SQLException e) {
            throw new PermissionAPIException("Error occurred while storing PT details.", e);
        }

        // Return PT to RS
        return permissionTicketImpl;
    }

}
