package mate.controller.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mate.exception.AuthenticationException;
import mate.lib.Injector;
import mate.model.Driver;
import mate.service.AuthenticationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginController extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_ID = "user_id";
    private static final Logger logger = LogManager.getLogger(LoginController.class);
    private static final Injector injector = Injector.getInstance("mate");
    private AuthenticationService authenticationService;

    @Override
    public void init() throws ServletException {
        authenticationService = (AuthenticationService) injector
                .getInstance(AuthenticationService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/authentication/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Driver user = authenticationService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute(SESSION_ATTRIBUTE_ID, user.getId());
            logger.info("Successfully connected to the database and received data. "
                    + "With User ID - '" + user.getId() + "'. The user logged in. ");
            resp.sendRedirect("/index");
        } catch (AuthenticationException e) {
            logger.error("Can't login. Incorrect password or username. "
                    + "With user name " + login, e);
            req.setAttribute("errorMag", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/authentication/login.jsp").forward(req, resp);
        }
    }
}
