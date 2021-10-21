package mate.controller.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutController extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_ID = "user_id";
    private static final Logger logger = LogManager.getLogger(LogoutController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("User with ID '" + req.getSession().getAttribute(SESSION_ATTRIBUTE_ID)
                + "' left the session. ");
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }
}
