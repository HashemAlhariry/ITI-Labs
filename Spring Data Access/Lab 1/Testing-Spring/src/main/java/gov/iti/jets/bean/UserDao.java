package gov.iti.jets.bean;

import gov.iti.jets.bean.models.User;

import java.util.List;

public interface UserDao {
    int count();
    User getUserByName(String name);

    int countByAgeGreaterThan(int age);

    User findByCustomerId(int customerId);

    User findByCustomerIdWithRowMapper(int customerId);

    List<User> findAll();

    List<User> findAllWithBeanPropertyRowMapper();

    void insert(User user);

    void update(User user);

    void createXTable(String tableName);
}
