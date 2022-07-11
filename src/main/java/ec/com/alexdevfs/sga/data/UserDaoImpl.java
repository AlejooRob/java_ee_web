package ec.com.alexdevfs.sga.data;

import ec.com.alexdevfs.sga.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDaoImpl implements UserDao{

    @PersistenceContext(unitName="PersonPU")
    EntityManager em;

    @Override
    public List<User> findAllPersons() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User findUserById(User user) {
        return (User) em.createNamedQuery("User.findByIdUsuario");
    }

    @Override
    public void InsertUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.merge(user));
    }
    
}
