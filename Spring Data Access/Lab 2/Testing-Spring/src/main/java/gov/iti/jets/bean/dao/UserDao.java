package gov.iti.jets.bean.dao;


import gov.iti.jets.bean.models.User;

public interface UserDao {
    long count();
    long countByAgeGreaterThan(int age);

    User save (User user);


    User saveWithAnotherWay(User user1);
}
