package ec.com.alexdevfs.sga.service;

import ec.com.alexdevfs.sga.domain.Person;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

@Path("/personas")
@Stateless
public class PersonServiceRs {

    @Inject
    private PersonService personService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> listPersons() {
        return personService.listPersons();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Person findPersonById(@PathParam("id") int id) {
        return personService.findPersonById(new Person(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addPerson(Person person) {
        try {
            personService.registerPerson(person);
            return Response.ok().entity(person).build();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response updatePerson(@PathParam("id") int id, Person personModified) {
        try {
            Person person = personService.findPersonById(new Person(id));
            if (person != null) {
                personService.updatePerson(personModified);
                return Response.ok().entity(personModified).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletePersonByID(@PathParam("id") int id) {
        try {
            personService.deletePerson(new Person(id));
            return Response.ok().build();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
