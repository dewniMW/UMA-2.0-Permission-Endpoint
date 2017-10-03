package org.wso2.carbon.identity.oauth.uma.service.impl;

import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionTicketDAOException;
import org.wso2.carbon.identity.oauth.uma.service.PermissionService;
import org.wso2.carbon.identity.oauth.uma.service.dao.PermissionTicketDAO;
import org.wso2.carbon.identity.oauth.uma.service.exception.PermissionAPIException;
import org.wso2.carbon.identity.oauth.uma.service.model.PermissionTicket;
import org.wso2.carbon.identity.oauth.uma.service.model.Resource;

import java.util.List;

/**
 * Created by dewni on 9/28/17.
 */
public class PermissionServiceImpl implements PermissionService {

    @Override
    public PermissionTicket issuePermissionTicket(List<Resource> resourceList) throws PermissionTicketDAOException,
            PermissionAPIException {

        PermissionTicketDAO permissionTicketDAO = new PermissionTicketDAO();
        return permissionTicketDAO.issue(resourceList);
    }
}
