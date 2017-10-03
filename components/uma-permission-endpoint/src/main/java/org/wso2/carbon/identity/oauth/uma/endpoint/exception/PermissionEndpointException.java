package org.wso2.carbon.identity.oauth.uma.endpoint.exception;


/**
 * Created by dewni on 9/21/17.
 */
public class PermissionEndpointException extends Exception {

    public PermissionEndpointException(String message) {
        super(message);
    }

    public PermissionEndpointException(String message, Throwable throwable) {
        super(message, throwable);
    }
}