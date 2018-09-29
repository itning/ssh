package sl.young.dao;

import sl.young.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author 舒露
 */
public interface UserDao {
    Optional<User> findOne(String userId);
    void save(User user);

    void delete(String userId);

    Optional<User> upData(String userId);

    List<User> findAll();
}
