package sl.young.dao.impl;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import sl.young.dao.HomeWorkDao;
import sl.young.entity.HomeWork;
import sl.young.entity.User;
import sl.young.entity.Work;

import java.util.List;
import java.util.Optional;

/**
 * @author 舒露
 */
@Repository
@SuppressWarnings("all")
public class HomeWorkDaoImpl extends HibernateDaoSupport implements HomeWorkDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(HomeWork homeWork) {
        currentSession().save(homeWork);
    }

    @Override
    public void delet(String id) {
        IdentifierLoadAccess<HomeWork> userIdentifierLoadAccess = currentSession().byId(HomeWork.class);
        HomeWork load = userIdentifierLoadAccess.load(id);
        currentSession().delete(load);
    }

    @Override
    public Optional<HomeWork> upData(String id) {
        return Optional.empty();
    }

    @Override
    public List<HomeWork> findAll() {
       /* Query from_user = session.createQuery("from User");
        return  from_user.list();*/
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().loadAll(HomeWork.class);
    }

    @Override
    public List<HomeWork> findAllByUser(User user) {
        Query query = currentSession().createQuery("from HomeWork where user = ?").setParameter(0,user);
        return query.list();
    }

    @Override
    public List<HomeWork> findByWork(Work work) {
        Query query = currentSession().createQuery("from HomeWork where work = ?").setParameter(0,work);
        return query.list();
    }
}
