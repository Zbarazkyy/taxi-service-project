package mate.controller.driver;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteDriverController extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_ID = "user_id";
    private static final Logger logger = LogManager.getLogger(DeleteDriverController.class);
    private static final String ID = "id";
    private static final Injector injector = Injector.getInstance("mate");
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        driverService.delete(Long.parseLong(req.getParameter(ID)));
        logger.info("User with ID '" + req.getSession().getAttribute(SESSION_ATTRIBUTE_ID)
                + "' delete driver '" + req.getParameter(ID) + "'. ");
        resp.sendRedirect("/drivers/all");
    }
}
