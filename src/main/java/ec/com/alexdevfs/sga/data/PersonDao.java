package ec.com.alexdevfs.sga.data;

import ec.com.alexdevfs.sga.domain.Person;
import java.util.List;

public interface PersonDao {
    public List<Person> findAllPersons();
    
    public Person findPersonById(Person person);
    
    public Person findPersonByEmail(Person person);
    
    public void InsertPerson(Person person);
    
    public void updatePerson(Person person);
    
    public void deletePerson(Person person);
}
