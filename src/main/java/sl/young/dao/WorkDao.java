package sl.young.dao;

import sl.young.entity.Work;

import java.util.List;

public interface WorkDao {
    List<Work> findAll();
    void save(Work work);
    void delete(String id);
    void upData(Work work);
}
