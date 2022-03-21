package my.javabrains.utility;

import javax.naming.InitialContext;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.*;
import javax.sql.DataSource;
import my.javabrains.dao.UserDao;

public class DataBaseConnection {

    public DataBaseConnection() {

    }

    public List<UserDao> connectDB(String name) {

        String nameToSearch = name;

        try {
            if (!nameToSearch.isBlank()) {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
                Connection conn = ds.getConnection();
                PreparedStatement preparedStatement = conn
                        .prepareStatement("select * from  user where username like ?");
                preparedStatement.setString(1, "%" + nameToSearch + "%");
                ResultSet rs = preparedStatement.executeQuery();

                List<UserDao> users = new ArrayList<>();

                while (rs.next()) {
                    users.add(new UserDao(rs.getString("username"), rs.getString("userfullname")));
                }
                return users;

            } else {
                return null;
            }

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    

    }

}
