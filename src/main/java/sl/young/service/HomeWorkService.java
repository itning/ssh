package sl.young.service;

import sl.young.entity.HomeWork;

import java.util.List;
import java.util.Optional;

public interface HomeWorkService {
    void save(HomeWork homeWork);
    void delet(String id_ext );
    Optional<HomeWork> upData(String id_ext );
    List<HomeWork> select();
    List<HomeWork> findByWorkId(String id);
}
