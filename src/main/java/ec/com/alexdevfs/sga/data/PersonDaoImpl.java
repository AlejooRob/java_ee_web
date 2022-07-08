package ec.com.alexdevfs.sga.data;

import ec.com.alexdevfs.sga.domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PersonDaoImpl implements PersonDao {
    
    @PersistenceContext(unitName="PersonPU")
    EntityManager em;

    @Override
    public List<Person> findAllPersons() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public Person findPersonById(Person person) {
        return em.find(Person.class, person.getPersonId());
    }

    @Override
    public Person findPersonByEmail(Person person) {
        Query query = em.createQuery("FROM Person p WHERE p.email =: email");
        query.setParameter("email", person.getEmail());
        return (Person) query.getSingleResult();
    }

    @Override
    public void InsertPerson(Person person) {
        em.persist(person);
    }

    @Override
    public void updatePerson(Person person) {
        em.merge(person);
    }

    @Override
    public void deletePerson(Person person) {
        em.remove(em.merge(person));
    }
    
}
