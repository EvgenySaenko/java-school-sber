package ru.sber.javaschool.solid.notification;

import ru.sber.javaschool.solid.connection.DatabaseConnection;
import ru.sber.javaschool.solid.dto.Employee;
import ru.sber.javaschool.solid.mailservice.MailService;
import ru.sber.javaschool.solid.generator.GeneratorForm;
import ru.sber.javaschool.solid.generator.HtmlGeneratorForm;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

//Уведомление о зарплате в формате HTML
public class SalaryHtmlReportNotifier {
    private DatabaseConnection connection;
    private GeneratorForm generatorForm;
    private MailService mailService;


    public SalaryHtmlReportNotifier() {
        connection = DatabaseConnection.getInstance();
        generatorForm = new HtmlGeneratorForm();
    }

    public void sendHtmlListEmployeesReport(int idFrom, int idTo, String recipients) {
        try {
            List<Employee> employees = connection.getListEmployees(idFrom, idTo);//list data
            String htmlPage = generatorForm.generate(employees);//html page
            this.mailService = new MailService(recipients, htmlPage);
            mailService.sendMessage();
        } catch (SQLException | MessagingException e) {
            throw new RuntimeException("message sending failed");
        }
    }

    public void sendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) {
        try {
            List<Employee> employees = connection.getSalaryPaymentsByNumberDepartmentsAndGivenPeriodOfTime(departmentId, dateFrom, dateTo);
            String htmlPage = generatorForm.generate(employees);
            this.mailService = new MailService(recipients, htmlPage);
            mailService.sendMessage();
        } catch (ClassNotFoundException | SQLException | MessagingException e) {
            throw new RuntimeException("message sending failed");
        }
    }

}
