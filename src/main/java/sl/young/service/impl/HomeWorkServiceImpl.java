package sl.young.service.impl;

import org.springframework.stereotype.Service;
import sl.young.dao.HomeWorkDao;
import sl.young.entity.HomeWork;
import sl.young.service.HomeWorkService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class HomeWorkServiceImpl implements HomeWorkService {
    @Resource
    private HomeWorkDao homeWorkDao;

    @Override
    public void save(HomeWork homeWork) {
        homeWorkDao.save(homeWork);
    }

    @Override
    public void delet(String id_ext) {
        homeWorkDao.delet(id_ext);
    }

    @Override
    public Optional<HomeWork> upData(String id) {
        return Optional.empty();
    }

    @Override
    public List<HomeWork> select() {
        return homeWorkDao.findAll();
    }
}
