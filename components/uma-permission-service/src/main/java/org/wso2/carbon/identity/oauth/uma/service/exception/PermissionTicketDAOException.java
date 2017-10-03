package org.wso2.carbon.identity.oauth.uma.service.exception;

/**
 * Created by dewni on 9/26/17.
 */
public class PermissionTicketDAOException extends Exception{

    public PermissionTicketDAOException( String message ){
        super(message);
    }

    public PermissionTicketDAOException ( String message, Throwable throwable){
        super(message, throwable);
    }
}
