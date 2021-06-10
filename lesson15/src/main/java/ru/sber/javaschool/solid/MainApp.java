package ru.sber.javaschool.solid;

import ru.sber.javaschool.solid.connection.DatabaseConnection;
import ru.sber.javaschool.solid.dto.Employee;
import ru.sber.javaschool.solid.notification.SalaryHtmlReportNotifier;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        try {
            connection.connect();
            List<Employee> listEmployees = connection.getListEmployees(10010, 10020);
            listEmployees.forEach(System.out::println);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        //SalaryHtmlReportNotifier reportNotifier = new SalaryHtmlReportNotifier(connection);
        //reportNotifier.sendHtmlListEmployeesReport(10010,10020,"somebody@gmail.com");
    }
}
