package mate.controller.car;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteCarController extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_ID = "user_id";
    private static final Logger logger = LogManager.getLogger(DeleteCarController.class);
    private static final String ID = "id";
    private static final Injector injector = Injector.getInstance("mate");
    private final CarService carService = (CarService) injector
            .getInstance(CarService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        carService.delete(Long.parseLong(req.getParameter(ID)));
        logger.info("User with ID '" + req.getSession().getAttribute(SESSION_ATTRIBUTE_ID)
                + "' delete car '" + req.getParameter(ID) + "'. ");
        resp.sendRedirect("/cars/all");
    }
}
