package sl.itcast.service;

import org.springframework.stereotype.Service;
import sl.itcast.dao.UserDao;

import javax.annotation.Resource;

@Service
public class UserService{
    @Resource
    private UserDao userDao;
    public void save(){
        userDao.sava();
    }
}
