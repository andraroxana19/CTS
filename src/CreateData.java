import operations.Create;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateData implements Create {

    @Override
    public void createTable(Connection connection) {
        String sqlDrop = "DROP TABLE IF EXISTS employees";
        String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
                + "name TEXT, address TEXT, salary REAL)";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
            statement.executeUpdate(sqlCreate);
            statement.close();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
