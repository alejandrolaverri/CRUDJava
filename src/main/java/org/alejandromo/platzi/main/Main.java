package org.alejandromo.platzi.main;

import org.alejandromo.platzi.model.Employee;
import org.alejandromo.platzi.repository.EmployeeRepository;
import org.alejandromo.platzi.repository.Repository;
import org.alejandromo.platzi.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (Connection myConn = DatabaseConnection.getInstance()) {
             Repository<Employee> repository = new EmployeeRepository();

            System.out.println("---Listando---");
            repository.findAll().forEach(System.out::println);

            System.out.println("---Insertamos un empleado---");
            Employee employee = new Employee();
            employee.setFirst_name("Diego");
            employee.setPa_surname("Pimentel");
            employee.setMa_surname("Gutierrez");
            employee.setEmail("diego@example.com");
            employee.setSalary((float)19000);
            repository.save(employee);
            System.out.println(employee);

            System.out.println("---Actualizando un empleado---");
            Employee employee2 = new Employee();
            employee2.setId(3);
            employee2.setFirst_name("Michael");
            employee2.setPa_surname("Johnson");
            employee2.setMa_surname("Browny");
            employee2.setEmail("emily.browny@example.com");
            employee2.setSalary((float)55000);
            repository.save(employee2);
            System.out.println(employee2);

            System.out.println("---Empleado elminado---");
            repository.delete(18);

            System.out.println("---Listando---");
            repository.findAll().forEach(System.out::println);
        }
    }

}