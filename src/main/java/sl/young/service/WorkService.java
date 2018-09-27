package sl.young.service;

import sl.young.entity.Work;

import java.util.List;

public interface WorkService {
    List<Work> findAll();
    void save(Work work);
    void delete(String id);
    void upData(Work work);
}
