package ec.com.alexdevfs.sga.web;

import ec.com.alexdecfs.sga.service.UserService;
import ec.com.alexdevfs.sga.domain.User;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/usuarios")
public class UserServlet extends HttpServlet {
    
    @Inject
    UserService userService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<User> users = userService.listUsers();
        System.out.println("users = " + users);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/listUsers.jsp").forward(req, res);
    }
    
}
