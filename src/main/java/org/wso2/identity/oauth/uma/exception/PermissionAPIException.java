package org.wso2.identity.oauth.uma.exception;

/**
 * Created by dewni on 9/21/17.
 */
public class PermissionAPIException extends Exception {

    public PermissionAPIException(String message) {
        super(message);
    }

    public PermissionAPIException(String message, Throwable throwable) {
        super(message, throwable);
    }
}