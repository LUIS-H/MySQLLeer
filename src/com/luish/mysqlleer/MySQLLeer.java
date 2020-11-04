package com.luish.mysqlleer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLLeer {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/libreriadb?useSSL=false";
        String user = "root";
        String password = "root";
        String query = "SELECT * FROM Autores";

        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MySQLLeer.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
