package org.wso2.carbon.identity.oauth.uma.service;

import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionTicketDAOException;
import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionAPIException;
import org.wso2.carbon.identity.oauth.uma.service.model.PermissionTicket;
import org.wso2.carbon.identity.oauth.uma.service.model.Resource;

import java.util.List;

/**
 * Created by dewni on 9/28/17.
 */
public interface PermissionService {

    PermissionTicket issuePermissionTicket(List<Resource> resourceList) throws PermissionTicketDAOException,
            PermissionAPIException;
}
