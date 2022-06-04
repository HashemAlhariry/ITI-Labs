package gov.iti.jets.bean.jdbc;

import gov.iti.jets.bean.UserDao;
import gov.iti.jets.bean.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import java.util.List;

public class JDBCUserDao2 extends JdbcDaoSupport implements UserDao {


    @Override
    public int count() {
        String sql = "select count(*) from users";
        return getJdbcTemplate().queryForObject(sql, Integer.class);
    }

    @Override
    public int countByAgeGreaterThan(int age) {
        String sql = "select count(*) from users where age >= ?";
        int rowCount = getJdbcTemplate().queryForObject(sql, new Object[]{age}, Integer.class);
        return rowCount;
    }

    @Override
    public User findByCustomerId(int customerId){
        String sql = "SELECT * FROM users where id = ?";
        Object[] args = new Object[]{customerId};
        User user = (User) getJdbcTemplate().queryForObject(sql,new Object[]{customerId},new UserRowMapper());
        return user;
    }

    @Override
    public User findByCustomerIdWithRowMapper(int customerId){
        String sql = "SELECT * FROM users where id = ?";
        Object[] args = new Object[]{customerId};
        User user  = getJdbcTemplate().queryForObject(sql,args, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public List<User> findAll() {
        String sql ="SELECT * FROM users";
        List<User> users = getJdbcTemplate().query(sql,new UserResultSetExtractor());
        return users;
    }


    @Override
    public List<User> findAllWithBeanPropertyRowMapper() {
        String sql ="SELECT * FROM users";
        List<User> users = getJdbcTemplate().query(sql,new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public void insert(User user) {
        String sql = "insert into users  (id,   name,age) values (?,?,?)";
        Object[] args = new Object[]{user.getId(),user.getName(),user.getAge()};
        getJdbcTemplate().update(sql,args);
    }

    @Override
    public void update(User user) {
        String sql = "update users set age = ? , name = ? where id = ?";
        Object [] args = new Object[]{user.getAge(),user.getName(),user.getId()};
        getJdbcTemplate().update(sql,args);
    }

    @Override
    public User getUserByName(String name) {
        String sql = "select * from users where name = ?";
        Object [] args = new Object[]{name};
        User user = (User) getJdbcTemplate().queryForObject(sql,args,new UserRowMapper());
        return user;
    }

    @Override
    public void createXTable(String tableName){
        String sql = "create table "+ tableName +" (id integer ,name varchar(100))";
        getJdbcTemplate().execute(sql);
    }

}
