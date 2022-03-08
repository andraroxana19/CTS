import operations.Read;

import java.sql.*;

public class ReadData implements Read {

    @Override
    public void readData(Connection connection) {
        String sqlSelect = "SELECT * FROM employees";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            while(rs.next()) {
                int id = rs.getInt("id");
                System.out.println("id: " + id);
                String name = rs.getString(2);
                System.out.println("name: " + name);
                String address = rs.getString("address");
                System.out.println("address: " + address);
                double salary = rs.getDouble("salary");
                System.out.println("salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
