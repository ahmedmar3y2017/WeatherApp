package dao;

import Entities.Authorities;

/**
 * Created by ahmed on 6/17/2017.
 */
public interface permissionDao {
    public int count(String auth, String target, String permission);


}
