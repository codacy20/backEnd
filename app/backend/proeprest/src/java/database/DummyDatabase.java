/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Version;

/**
 *
 * @author Amir
 */
public class DummyDatabase {

    Connection c;
    Statement st;
    ResultSet rs;

    public static void main(String[] args) throws SQLException {
        DummyDatabase d = new DummyDatabase();
    }

    public DummyDatabase() throws SQLException {
        try {

            c = DriverManager.getConnection("jdbc:mysql://192.168.15.56/dbi271837?", 
                    "dbi271837", 
                    "O3JUJwTWhi");
            st = c.createStatement();
            rs = st.executeQuery("SELECT user_name from users");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (c != null) {
                    c.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }

    }
}
