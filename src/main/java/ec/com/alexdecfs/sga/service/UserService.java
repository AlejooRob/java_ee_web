package ec.com.alexdecfs.sga.service;

import ec.com.alexdevfs.sga.domain.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserService {
    
    public List<User> listUsers();
    
    public User findUserById(User user);
    
    public void registerUser(User user);
    
    public void updateUser(User user);
    
    public void deleteUser(User user);
    
}
