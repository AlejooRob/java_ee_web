package ec.com.alexdecfs.sga.service;

import ec.com.alexdevfs.sga.domain.Person;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PersonServiceRemote {
    
    public List<Person> listPersons();
    
    public Person findPersonById(Person person);
    
    public Person findersonByEmail(Person persin);
    
    public void registerPerson(Person person);
    
    public void updatePerson(Person person);
    
    public void deletePerson(Person person);
}
