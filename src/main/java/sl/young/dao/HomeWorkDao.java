package sl.young.dao;

import sl.young.entity.HomeWork;
import sl.young.entity.User;
import sl.young.entity.Work;

import java.util.List;
import java.util.Optional;

/**
 * @author 舒露
 */

public interface HomeWorkDao {
    public void save(HomeWork homeWork);
    public void delet(String id_ext );
    public Optional<HomeWork> upData(String id_ext );
    public List<HomeWork> findAll();
    List<HomeWork> findAllByUser(User user);
    List<HomeWork> findByWork(Work work);
}
