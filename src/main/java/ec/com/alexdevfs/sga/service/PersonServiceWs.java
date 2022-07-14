package ec.com.alexdevfs.sga.service;

import ec.com.alexdevfs.sga.domain.Person;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PersonServiceWs {
   
   @WebMethod
   public List<Person> listPersons();
   
}
