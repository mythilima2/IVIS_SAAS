package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {

    private Connection connection;

    private static final String DB_URL =
            "jdbc:sqlserver://localhost:1433;databaseName=YourDatabase;encrypt=true;trustServerCertificate=true";

    private static final String username = "sa";

    private static final String password = "Password123";

    public DBManager() throws Exception {

        connection = DriverManager.getConnection(
                DB_URL,
                username,
                password);

    }

    public boolean isCustomerPresent(String customerCode) throws Exception {

        PreparedStatement ps = connection.prepareStatement(
                "SELECT customer_name FROM customer WHERE customer_code = ?");

        ps.setString(1, customerCode);

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }
}