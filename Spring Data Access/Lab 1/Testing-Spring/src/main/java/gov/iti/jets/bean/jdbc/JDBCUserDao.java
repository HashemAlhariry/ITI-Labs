package gov.iti.jets.bean.jdbc;


import gov.iti.jets.bean.UserDao;
import gov.iti.jets.bean.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int count() {
        String sql = "select count(*) from users";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int countByAgeGreaterThan(int age) {
        String sql = "select count(*) from users where age >= ?";
        int rowCount = jdbcTemplate.queryForObject(sql, new Object[]{age}, Integer.class);
        return rowCount;
    }

    @Override
    public User findByCustomerId(int customerId){
        String sql = "SELECT * FROM users where id = ?";
        Object[] args = new Object[]{customerId};
        User user = (User) jdbcTemplate.queryForObject(sql,new Object[]{customerId},new UserRowMapper());
        return user;
    }

    @Override
    public User findByCustomerIdWithRowMapper(int customerId){
        String sql = "SELECT * FROM users where id = ?";
        Object[] args = new Object[]{customerId};
        User user  = jdbcTemplate.queryForObject(sql,args, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public List<User> findAll() {
        String sql ="SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql,new UserResultSetExtractor());
        return users;
    }


    @Override
    public List<User> findAllWithBeanPropertyRowMapper() {
        String sql ="SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public void insert(User user) {
        String sql = "insert into users  (id,   name,age) values (?,?,?)";
        Object[] args = new Object[]{user.getId(),user.getName(),user.getAge()};
        jdbcTemplate.update(sql,args);
    }

    @Override
    public void update(User user) {
        String sql = "update users set age = ? , name = ? where id = ?";
        Object [] args = new Object[]{user.getAge(),user.getName(),user.getId()};
        jdbcTemplate.update(sql,args);
    }

    @Override
    public User getUserByName(String name) {
        String sql = "select * from users where name = ?";
        Object [] args = new Object[]{name};
        User user = (User) jdbcTemplate.queryForObject(sql,args,new UserRowMapper());
        return user;
    }

    @Override
    public void createXTable(String tableName){
        String sql = "create table "+ tableName +" (id integer ,name varchar(100))";
        jdbcTemplate.execute(sql);
    }



}
