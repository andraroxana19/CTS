import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            CreateData createData=new CreateData();
            createData.createTable(connection);

            InsertData insertData=new InsertData();
            insertData.insertData(connection);

            ReadData readData=new ReadData();
            readData.readData(connection);


            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
