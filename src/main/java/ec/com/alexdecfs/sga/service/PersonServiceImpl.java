package ec.com.alexdecfs.sga.service;

import ec.com.alexdevfs.sga.domain.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PersonServiceImpl implements PersonServiceRemote, PersonService{

    @Override
    public List<Person> listPersons() {
        return null;
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
