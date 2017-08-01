package service;

import dao.permissionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ahmed on 6/17/2017.
 */
@Service
public class permissionServiceImpl implements permissionService {

    permissionDao permissionDao;

    public dao.permissionDao getPermissionDao() {
        return permissionDao;
    }

    public void setPermissionDao(dao.permissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Transactional
    public int count(String auth, String target, String permission) {

        return permissionDao.count(auth, target, permission);
    }
}
