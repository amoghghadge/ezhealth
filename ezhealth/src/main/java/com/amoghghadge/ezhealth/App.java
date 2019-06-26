package com.amoghghadge.ezhealth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class App implements RequestHandler<Map<String, String>, String> {
    public static void main(String[] args) {

        String sql = "SELECT * FROM main_table where Last_Name='Ghadge'";

        try (Connection conn = MySQLJDBCUtil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                System.out.println(rs.getString("First_Name") + "\t" + rs.getString("Middle_Name") + "\t"
                        + rs.getString("Last_Name"));

            }

            try {

                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());
            
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("^^^");

        }

    }

    @Override
    public String handleRequest(Map<String, String> input, Context context) {

        String response = "null";
        String lName = input.get("Last_Name");

        String sql = "select * from main_table where Last_Name='" + lName + "'";

        try (Connection conn = MySQLJDBCUtil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                if (response == "null") {

                    response = rs.getString("First_Name") + "\t" + rs.getString("Middle_Name") + "\t"
                            + rs.getString("Last_Name");

                } else {

                    response = response + rs.getString("First_Name") + "\t" + rs.getString("Middle_Name") + "\t"
                            + rs.getString("Last_Name");

                }

            }

        } catch (SQLException ex) {

            response = ex.getMessage();
            System.out.println("^^^");

        }

        return response;

    }
}
