package gov.iti.jets.bean.jdbc;


import gov.iti.jets.bean.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user =new User();
        user.setId(rs.getInt("id"));
        user.setAge(rs.getInt("age"));
        user.setName(rs.getString("name"));

        return user;
    }
}
