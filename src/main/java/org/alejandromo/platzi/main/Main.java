package org.alejandromo.platzi.main;

import org.alejandromo.platzi.model.Employee;
import org.alejandromo.platzi.repository.EmployeeRepository;
import org.alejandromo.platzi.repository.Repository;
import org.alejandromo.platzi.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(Connection myConn = DatabaseConnection.getInstance()) {
            if (myConn.getAutoCommit()) {
                myConn.setAutoCommit((false));
            }

            try {
                Repository<Employee> repository = new EmployeeRepository((myConn));

                System.out.println("----Insertar un nuevo cliente----");
                Employee employee = new Employee();
                /*employee.setFirst_name("America");
                employee.setPa_surname("Lopez");
                employee.setMa_surname("Villa");
                employee.setEmail("ame2@example.com");
                employee.setSalary(3000F);
                employee.setCurp("AMEC234Y91JOLPSDET");
                repository.save(employee);*/

                employee.setFirst_name("David");
                employee.setPa_surname("Gutierrez");
                employee.setMa_surname("Olvera");
                employee.setEmail("olv2@example.com");
                employee.setSalary(32000F);
                employee.setCurp("AMEC234Y91JOLPSDET");
                repository.save(employee);
                myConn.commit();
            } catch (SQLException e) {
                myConn.rollback();
                throw new RuntimeException(e);
            }
        }
    }

}