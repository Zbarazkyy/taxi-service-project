package mate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {
    private static final Logger logger = LogManager.getLogger(ConnectionUtil.class);
    private static final String URL = "jdbc:mysql://localhost:3306/taxi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "passroot";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("Can't find SQL Driver " + JDBC_DRIVER, e);
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        try {
            return DriverManager.getConnection(URL, dbProperties);
        } catch (SQLException e) {
            logger.error("Can't create connection to DB by URL " + URL, e);
            throw new RuntimeException("Can't create connection to DB ", e);
        }
    }
}
