package sl.young.service;

import sl.young.entity.HomeWork;
import sl.young.entity.User;

import java.util.List;
import java.util.Optional;

public interface HomeWorkService {
    public void save(HomeWork homeWork);
    public void delet(String id_ext );
    public Optional<HomeWork> upData(String id_ext );
    public List<HomeWork> select();
}
