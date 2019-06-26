package com.amoghghadge.ezhealth;

//import java.io.FileInputStream;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class MySQLJDBCUtil {
 
    /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        Connection conn = null;
 
        try {
            
            // assign db parameters
            String url = "jdbc:mysql://localhost:3306/ezhealth?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "aapd717@G";
            
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            System.out.println("^^^^");

        }/*finally {

            try{

                if(conn != null) {

                    conn.close();

                }

            } catch(SQLException ex) {

                System.out.println(ex.getMessage());
                System.out.println("^^^^^");

            }

        }*/
        return conn;

    }
 
}