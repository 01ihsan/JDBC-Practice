package jdbctests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {
    @Test
    public void test1(){
        DBUtils.createConnection();
        String query = "select first_name,last_name,salary,job_id from employees where rownum<6";
        List<Map<String,Object>> querryData = DBUtils.getQueryResultMap(query);

        for (Map<String,Object> row : querryData)
            System.out.println(row.toString());
        DBUtils.destroy();
    }
}
