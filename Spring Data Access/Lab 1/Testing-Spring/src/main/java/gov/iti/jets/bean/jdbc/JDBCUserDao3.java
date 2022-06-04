package gov.iti.jets.bean.jdbc;

import gov.iti.jets.bean.UserDao;
import gov.iti.jets.bean.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCUserDao3 {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertCustomer;

    public void setDataSource(DataSource dataSource){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertCustomer = new SimpleJdbcInsert(dataSource).withTableName("users").usingColumns( "name","age").usingGeneratedKeyColumns("id");
    }

    public void insert(User user){
        Map<String , Object> parameters =new HashMap<>(3);
        parameters.put("id",user.getId());
        parameters.put("name",user.getName());
        parameters.put("age",user.getAge());
        insertCustomer.execute(parameters);
    }

}
