package prepbatching;

import java.sql.*;

public class Main {

    private static DatabaseConnection databaseConnection =  new DatabaseConnection();
    private static PreparedStatement preStatement = null;
    public static void main(String[] args) {
        try {

            ResultSet resultSet=null;
            //statement.executeUpdate(DatabaseConnection.CREATE_TABLE_SQL);
            for(int i=0;i<DatabaseConnection.employee.length;i++) {
                preStatement = databaseConnection.getConnection().prepareStatement(
                        "INSERT INTO jdbc.employee" +
                                "(ID,F_Name,L_Name,Sex,Age,Address,Phone_Number,Vaction_Balance)" +
                                "VALUES(?,?,?,?,?,?,?,?)");
                preStatement.setInt(1,  DatabaseConnection.employee[i].id);
                preStatement.setString(2,DatabaseConnection.employee[i].fname);
                preStatement.setString(3,DatabaseConnection.employee[i].lname);
                preStatement.setInt(4,DatabaseConnection.employee[i].sex);
                preStatement.setInt(5,DatabaseConnection.employee[i].age);
                preStatement.setString(6,DatabaseConnection.employee[i].address);
                preStatement.setString(7,DatabaseConnection.employee[i].phoneNumber);
                preStatement.setInt(8,DatabaseConnection.employee[i].vacationBalance);
                preStatement.executeUpdate();
                System.out.println("Records Updated");
            }
            String updatingVacation = "update jdbc.employee set Vaction_Balance = 45 where age > 30";
            String changingTitle = "ALTER TABLE jdbc.employee RENAME COLUMN F_Name TO MrMrs";
            preStatement = databaseConnection.getConnection().prepareStatement(updatingVacation);
            databaseConnection.getConnection().setAutoCommit(false);
            preStatement.addBatch();

            preStatement.execute(changingTitle);
            preStatement.addBatch();
            preStatement.executeBatch();
            databaseConnection.getConnection().commit();

            //resultSet.close();
            preStatement.close();
            databaseConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
