package sl.young.service.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import sl.young.dao.UserDao;
import sl.young.entity.User;
import sl.young.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
/**
 * @author 舒露
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Optional<User> findOne(String userId) {
        return userDao.findOne(userId);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(String userId) {
        userDao.delete(userId);
    }

    @Override
    public Optional<User> upData(String userId) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean login(String userId, String userPwd) {
        Optional<User> userOptional = userDao.findOne(userId);
        if (!userOptional.isPresent()){
            return false;
        }
        User user = userOptional.get();
        return user.getUserPwd().equals(userPwd);
    }
}
