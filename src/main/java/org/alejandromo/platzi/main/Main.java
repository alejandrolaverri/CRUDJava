package org.alejandromo.platzi.main;

import org.alejandromo.platzi.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (Connection myConn = DatabaseConnection.getInstance();
             Statement myStamt = myConn.createStatement();
             ResultSet myRes = myStamt.executeQuery("select * from employees")) {

            while (myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal ");
        }
    }

}