package userpackage.dbconnection;
import java.io.*;
import java.sql.*;
import java.util.Properties;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnection {

    private Properties properties = new Properties();
    private InputStream inputStream;
    private Connection connection;
    private MysqlDataSource mysqlDataSource;
    public  DatabaseConnection(){

        try {
        if(connection==null) {
            inputStream = new FileInputStream("db.properties");
            properties.load(inputStream);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl(properties.getProperty("MYSQL_DB_URL"));
            mysqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            mysqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
            connection = mysqlDataSource.getConnection();
          }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection(){
        return connection;
    }

}
