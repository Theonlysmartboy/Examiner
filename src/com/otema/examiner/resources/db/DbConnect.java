package com.otema.examiner.resources.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheOnlySmartBoy
 */
public class DbConnect {

    static String host = "jdbc:mysql://localhost:3309/";
    static String db = "ihis";
    static String dbuser = "Tosby";
    static String dbuserpass = "MasterTosby2";

    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(host + db, dbuser, dbuserpass);
            if (conn != null) {
                System.out.println("Connection successfull");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
