package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:oracle:thin:@54.204.212.30:1521:XE";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from regions");

        resultSet.next();
        System.out.println(resultSet.getString("region_name"));

        System.out.println(resultSet.getString(2));

        System.out.println("----------------------------");

        do{
            System.out.println(resultSet.getInt(1)+ " "+resultSet.getString(2));
        }while(resultSet.next());

        //close connection...
        resultSet.close();
        statement.close();
        connection.close();
    }
}