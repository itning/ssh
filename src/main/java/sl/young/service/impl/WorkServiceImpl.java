package sl.young.service.impl;

import org.springframework.stereotype.Service;
import sl.young.dao.WorkDao;
import sl.young.entity.Work;
import sl.young.service.WorkService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 舒露
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkDao workDao;

    @Override
    public List<Work> findAll() {
        return workDao.findAll();
    }

    @Override
    public void save(Work work) {
        workDao.save(work);
    }

    @Override
    public void delete(String id) {
        workDao.delete(id);
    }

    @Override
    public void upData(Work work) {

    }
}
