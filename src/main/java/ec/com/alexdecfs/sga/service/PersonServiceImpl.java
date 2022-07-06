package ec.com.alexdecfs.sga.service;

import ec.com.alexdevfs.sga.domain.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PersonServiceImpl implements PersonServiceRemote{

    @Override
    public List<Person> listPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Juan", "Lopez", "email@email.com", "300-1234"));
        persons.add(new Person(2, "Karen", "Gomez", "email1@email.com", "300-4834"));
        
        return persons;
    }

    @Override
    public Person findPersonById(Person person) {
        return null;
    }

    @Override
    public Person findersonByEmail(Person persin) {
        return null;
    }

    @Override
    public void registerPerson(Person person) {
    }

    @Override
    public void updatePerson(Person person) {
    }

    @Override
    public void deletePerson(Person person) {
    }
    
}
