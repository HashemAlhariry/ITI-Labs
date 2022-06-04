package gov.iti.jets.bean.jdbc;

import gov.iti.jets.bean.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultSetExtractor implements ResultSetExtractor<List<User>> {
    @Override
    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<User> users = new ArrayList<>();
        while (rs.next()){
            User user= new User();
            user.setAge(rs.getInt("age"));
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            users.add(user);
        }
        return users;
    }
}
