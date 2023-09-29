package org.alejandromo.platzi.main;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null; // Nuestro objeto de conexion
        Statement myStamt = null; // Objeto Statement
        ResultSet myRes = null; // Para procesar nuestros resultados

        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String pass = "1234";

        try {
            // 1. Conexion a nuesta base de datos, pasando 3 argumentos
            myConn = DriverManager.getConnection(url, user, pass);

            // 2 . crear una declaracion obejto
            myStamt = myConn.createStatement();

            //3. Ejecutar la consulta Sql
            myRes = myStamt.executeQuery("select * from employees");

            while (myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal ");
        }
    }

}