package sl.young.dao.impl;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import sl.young.dao.WorkDao;
import sl.young.entity.Work;

import java.util.List;
/**
 * @author 舒露
 */
@Repository
public class WorkDaoImpl extends HibernateDaoSupport implements WorkDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<Work> findAll() {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().loadAll(Work.class);
    }

    @Override
    public void save(Work work) {
        currentSession().save(work);
    }

    @Override
    public void delete(String id) {
        IdentifierLoadAccess<Work> workIdentifierLoadAccess = currentSession().byId(Work.class);
        currentSession().delete(workIdentifierLoadAccess.load(id));
    }

    @Override
    public void upData(Work work) {

    }
}
