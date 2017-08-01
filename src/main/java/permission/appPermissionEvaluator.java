package permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;

/**
 * Created by ahmed on 6/17/2017.
 */
public class appPermissionEvaluator implements PermissionEvaluator {

    @Autowired(required = true)
    @Qualifier("permissionService")
    service.permissionService permissionService;

    public service.permissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(service.permissionService permissionService) {
        this.permissionService = permissionService;
    }

    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

        int count = permissionService.count(((User) authentication.getPrincipal()).getUsername(), targetDomainObject.getClass().getName(), permission.toString());
        System.out.println(((User) authentication.getPrincipal()).getUsername() + " \t " + targetDomainObject.getClass().getName() + "\t" + permission.toString());
        System.out.println(count);
        if (count == 1) {
            return true;

        } else {
            return false;

        }

    }

    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
