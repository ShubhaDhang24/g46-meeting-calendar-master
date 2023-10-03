package se.lexicon.Dao.Impl.db;

import se.lexicon.exception.DbConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {
    private static final  String db_Name="meeting_calender_db";
    private static final String url="jdbc:mysql://localhost:3306/"+db_Name;
    private static final String userName="root";
    private static final String password="2424";

    public static Connection getConnection() {
        try{
           return DriverManager.getConnection(url,userName,password);
        }
        catch (SQLException e) {
            throw new DbConnectionException("fAILED TO CONEECT TO DATABASE "+db_Name,e);
        }
    }
}
