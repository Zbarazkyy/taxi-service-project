package mate.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Driver;
import mate.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddDriverController extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_ID = "user_id";
    private static final Logger logger = LogManager.getLogger(AddDriverController.class);
    private static final Injector injector = Injector.getInstance("mate");
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String licenseNumber = req.getParameter("license_number");
        Driver driver = new Driver(name, login, password, licenseNumber);
        driverService.create(driver);
        logger.info("User with ID '" + req.getSession().getAttribute(SESSION_ATTRIBUTE_ID)
                + "' add driver '" + driver.getId() + "'. ");
        resp.sendRedirect("/drivers/add");
    }
}
