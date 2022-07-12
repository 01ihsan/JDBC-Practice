package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class DynamicList {

    String dbUrl = "jdbc:oracle:thin:@54.204.212.30:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select first_name,last_name,salary,Job_id from employees where rownum<6");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Map<String, Object>> queryData = new ArrayList<>();

        int colCount= resultSetMetaData.getColumnCount();

        while(resultSet.next()){
            Map<String,Object> row = new LinkedHashMap<>();
            for (int i=1;i<=colCount;i++){
                row.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
            }
            queryData.add(row);
        }

        //Printing..
        for(Map<String,Object> row : queryData)
            System.out.println(row.toString());

        //close connection...
        resultSet.close();
        statement.close();
        connection.close();
    }
}
