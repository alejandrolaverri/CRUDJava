package org.alejandromo.platzi.main;

import org.alejandromo.platzi.model.Employee;
import org.alejandromo.platzi.repository.EmployeeRepository;
import org.alejandromo.platzi.repository.Repository;
import org.alejandromo.platzi.util.DatabaseConnection;
import org.alejandromo.platzi.view.SwingApp;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        SwingApp app = new SwingApp();
        app.setVisible(true);
    }

}