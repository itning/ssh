package sl.young.service.impl;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;
import sl.young.dao.HomeWorkDao;
import sl.young.dao.UserDao;
import sl.young.dao.WorkDao;
import sl.young.entity.HomeWork;
import sl.young.entity.User;
import sl.young.entity.Work;
import sl.young.service.HomeWorkService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 舒露
 */
@Service
public class HomeWorkServiceImpl implements HomeWorkService {
    @Resource
    private HomeWorkDao homeWorkDao;
    @Resource
    private UserDao userDao;
    @Resource
    private WorkDao workDao;

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
        Map<String, Object> session = ActionContext.getContext().getSession();
        Object info = session.get("userInfo");
        User user = userDao.findOne(info.toString()).orElseThrow(() -> new RuntimeException("没找到该用户"));
        return homeWorkDao.findAllByUser(user);
    }

    @Override
    public List<HomeWork> findByWorkId(String id) {
        Work work = workDao.findAll().stream().filter(x -> x.getTypeId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("未找到"));
        return homeWorkDao.findByWork(work);
    }

}
