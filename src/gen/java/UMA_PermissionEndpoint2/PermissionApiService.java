package UMA_PermissionEndpoint2;

import UMA_PermissionEndpoint2.*;
import UMA_PermissionEndpoint2.dto.*;

import UMA_PermissionEndpoint2.dto.PTFailDTO;
import UMA_PermissionEndpoint2.dto.PTSuccessDTO;
import UMA_PermissionEndpoint2.dto.ResourceDetailsDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class PermissionApiService {
    public abstract Response registerPermission(String patToken,ResourceDetailsDTO requestedResource);
}

