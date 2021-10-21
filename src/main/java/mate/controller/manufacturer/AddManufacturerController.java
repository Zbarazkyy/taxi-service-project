package mate.controller.manufacturer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Manufacturer;
import mate.service.ManufacturerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddManufacturerController extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_ID = "user_id";
    private static final Logger logger = LogManager.getLogger(AddManufacturerController.class);
    private static final Injector injector = Injector.getInstance("mate");
    private final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/manufacturers/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        Manufacturer manufacturer = new Manufacturer(name, country);
        manufacturerService.create(manufacturer);
        logger.info("User with ID '" + req.getSession().getAttribute(SESSION_ATTRIBUTE_ID)
                + "' add manufacturer '" + manufacturer.getId() + "'. ");
        resp.sendRedirect("/manufacturers/add");
    }
}
