package ec.com.alexdevfs.sga.web;

import ec.com.alexdecfs.sga.service.PersonService;
import ec.com.alexdevfs.sga.domain.Person;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named("personBean")
@RequestScoped
public class PersonBean {
    
    @Inject
    private PersonService personService;

    private Person personSelected;
    
    List<Person> persons;

    public PersonBean() {
    }
    
    @PostConstruct
    public void init() {
        persons = personService.listPersons();
        personSelected = new Person();
    }
    
    public void editListener(RowEditEvent ev) {
        Person person = (Person) ev.getObject();
        personService.updatePerson(person);
    }
    
    public Person getPersonSelected() {
        return personSelected;
    }

    public void setPersonSelected(Person personSelected) {
        this.personSelected = personSelected;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
    public void addPerson() {
        this.personService.registerPerson(personSelected);
        this.persons.add(personSelected);
        this.personSelected = null;
    }
    
    public void deletePerson() {
        this.personService.deletePerson(personSelected);
        this.persons.remove(this.personSelected);
        this.personSelected = null;
    }
    
    public void resetPersonSelected() {
        this.personSelected = new Person();
    }
}
