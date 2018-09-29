package sl.young.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import sl.young.dao.UserDao;
import sl.young.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author 舒露
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public Optional<User> findOne(String userId) {
        List list = currentSession()
                .createQuery("from User where userId=?")
                .setParameter(0, userId).list();
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable((User) list.get(0));
    }

    @Override
    public void save(User user) {
        currentSession().save(user);
    }

    @Override
    public void delete(String userId) {
        currentSession().delete(getHibernateTemplate().load(User.class, userId));
    }

    @Override
    public Optional<User> upData(String userId) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return getHibernateTemplate().loadAll(User.class);
    }
}
