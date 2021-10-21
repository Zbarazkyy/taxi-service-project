package mate.dao;

import java.util.Optional;
import mate.model.Driver;

public interface DriverDao extends GenericDao<Driver> {
    Optional<Driver> findByLogin(String login);
}
