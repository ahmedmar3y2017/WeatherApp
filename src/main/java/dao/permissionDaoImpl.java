package dao;

import Entities.Permissions;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;




@Repository
public class permissionDaoImpl implements permissionDao {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int count(String auth, String target, String permission) {


        return ((Number)sessionFactory.getCurrentSession().createCriteria(Permissions.class).
                setProjection(Projections.rowCount()).
                add(Restrictions.eq("username",auth)).
                add(Restrictions.eq("target",target)).
                add(Restrictions.eq("permission",permission)).
                uniqueResult()).intValue();
    }
}
