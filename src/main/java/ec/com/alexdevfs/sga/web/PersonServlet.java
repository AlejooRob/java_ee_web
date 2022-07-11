package ec.com.alexdevfs.sga.web;

import ec.com.alexdecfs.sga.service.PersonService;
import ec.com.alexdevfs.sga.domain.Person;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/personas")
public class PersonServlet extends HttpServlet {
    
    @Inject
    PersonService personService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Person> persons = personService.listPersons();
        System.out.println("persons = " + persons);
        req.setAttribute("persons", persons);
        req.getRequestDispatcher("/listPersons.jsp").forward(req, res);
    }
}
