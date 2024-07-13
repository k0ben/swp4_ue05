package swp4.koch.ue05.ex1.app.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDaoJdbc {


    String DATABASE_URL = "jdbc:derby://localhost:1527/swpDB;user=user;password=password;create=true";
    private Connection connection;

    protected Connection createConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            this.connection = DriverManager.getConnection(DATABASE_URL);
        }
        return connection;
    }
}