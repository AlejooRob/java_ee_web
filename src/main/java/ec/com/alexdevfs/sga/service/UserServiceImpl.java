package ec.com.alexdevfs.sga.service;

import ec.com.alexdevfs.sga.data.UserDao;
import ec.com.alexdevfs.sga.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserServiceImpl implements UserService {
    
    @Inject
    UserDao userDao;

    @Override
    public List<User> listUsers() {
        return userDao.findAllPersons();
    }

    @Override
    public User findUserById(User user) {
        return userDao.findUserById(user);
    }

    @Override
    public void registerUser(User user) {
        userDao.InsertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    
}
