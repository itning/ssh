package sl.young.service;

import sl.young.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author 舒露
 */
public interface UserService {
    Optional<User> findOne(String userId);
    void save(User user);

    void delete(String userId);

    Optional<User> upData(String userId);

    List<User> findAll();

    boolean login(String userId,String userPwd);
}
