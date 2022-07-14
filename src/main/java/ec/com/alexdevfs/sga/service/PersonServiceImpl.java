package ec.com.alexdevfs.sga.service;

import ec.com.alexdevfs.sga.data.PersonDao;
import ec.com.alexdevfs.sga.domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "ec.com.alexdevfs.sga.service.PersonServiceWs")
public class PersonServiceImpl implements PersonServiceRemote, PersonService, PersonServiceWs {
    
    @Inject
    private PersonDao personDao;

    @Override
    public List<Person> listPersons() {
        return personDao.findAllPersons();
    }

    @Override
    public Person findPersonById(Person person) {
        return personDao.findPersonById(person);
    }

    @Override
    public Person findersonByEmail(Person person) {
        return personDao.findPersonByEmail(person);
    }

    @Override
    public void registerPerson(Person person) {
        personDao.InsertPerson(person);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDao.deletePerson(person);
    }
    
}
