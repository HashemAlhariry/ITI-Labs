package prepbatching;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Employee employee[] = new Employee[]{new Employee(1,"Hashem","Alhariry",0,23,"Giza","01149056691",30),
            new Employee(2,"Hany","Alhariry",0,42,"Giza","01129236691",30),
            new Employee(3,"Mohammed","Said",0,35,"Haram","01145556691",30),
            new Employee(4,"Khaled","Mahmoud",0,18,"Cairo","01149057771",30),
            new Employee(5,"Omar","Islam",0,29,"Tagamo","0123056691",30),
    };
    public static final String CREATE_TABLE_SQL="CREATE TABLE jdbc.employee ("
            + "ID INT NOT NULL,"
            + "F_Name VARCHAR(45) NOT NULL,"
            + "L_Name VARCHAR(45) NOT NULL,"
            + "Sex INT NOT NULL,"
            + "Age INT NOT NULL,"
            + "Address VARCHAR(45) NOT NULL,"
            + "Phone_Number VARCHAR(14) NOT NULL,"
            + "Vaction_Balance INT NOT NULL";


    private Properties properties = new Properties();
    private InputStream inputStream;
    private Connection connection;

    public  DatabaseConnection(){

        try {
            inputStream=new FileInputStream("db.properties");
            properties.load(inputStream);
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl(properties.getProperty("MYSQL_DB_URL"));
            mysqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            mysqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));

            if(connection==null)
                 connection=mysqlDataSource.getConnection();

        }   catch (FileNotFoundException e) {
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
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
