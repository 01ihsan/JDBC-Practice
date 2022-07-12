package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicList {

    String dbUrl = "jdbc:oracle:thin:@54.204.212.30:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select first_name,last_name,salary,Job_id from employees");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Map<String, Object>> queryData = new ArrayList<>();

        int colCount= resultSetMetaData.getColumnCount();

        while(resultSet.next()){

        }
        //close connection...
        resultSet.close();
        statement.close();
        connection.close();
    }
}
