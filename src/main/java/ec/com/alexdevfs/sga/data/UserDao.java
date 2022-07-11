package ec.com.alexdevfs.sga.data;

import ec.com.alexdevfs.sga.domain.User;
import java.util.List;

public interface UserDao {

    public List<User> findAllPersons();

    public User findUserById(User user);

    public void InsertUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);
}
