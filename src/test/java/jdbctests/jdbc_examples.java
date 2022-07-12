package jdbctests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {
    String dbUrl="jdbc:oracle:thin:@54.204.212.30:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from departments");

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+ " "+resultSet.getString(2)+" "+resultSet.getInt(3)+ " "+resultSet.getInt(4));
        }


        //close connection...
        resultSet.close();
        statement.close();
        connection.close();
    }
    @DisplayName("ResultSet Methods")
    @Test
    public void test2() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //move freely and read only
        ResultSet resultSet = statement.executeQuery("select * from departments");
        resultSet.last();
        System.out.println(resultSet.getRow());

        resultSet.beforeFirst();

        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
        //close connection...
        resultSet.close();
        statement.close();
        connection.close();
    }
    @Test
    public void test3() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //move freely and read only
        ResultSet resultSet = statement.executeQuery("select * from departments");

        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println(dbMetadata.getUserName());
        System.out.println(dbMetadata.getDatabaseProductName());
        System.out.println(dbMetadata.getDatabaseProductVersion());
        System.out.println(dbMetadata.getDriverName());
        System.out.println(dbMetadata.getDriverVersion());

        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

        //how many columns do we have?
        int colCount=resultSetMetaData.getColumnCount();
        System.out.println(colCount);

        //what is the columns' name?
        System.out.println(resultSetMetaData.getColumnName(1));
        System.out.println(resultSetMetaData.getColumnName(2));
        System.out.println("-----------------------------");
        for (int i =1; i<=resultSetMetaData.getColumnCount();i++)
            System.out.println(resultSetMetaData.getColumnName(i));
        //close connection...
        resultSet.close();
        statement.close();
        connection.close();
    }
}