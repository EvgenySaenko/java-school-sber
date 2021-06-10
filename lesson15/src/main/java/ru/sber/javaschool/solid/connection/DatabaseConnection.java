package ru.sber.javaschool.solid.connection;

import ru.sber.javaschool.solid.dto.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final DatabaseConnection dbConnection = null;
    private static Connection connection;
    private static Statement stmt;
    private PreparedStatement ps;
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static DatabaseConnection getInstance(){
        return dbConnection == null ? new DatabaseConnection() : dbConnection;
    }


    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",USER_NAME,PASSWORD);
        stmt = connection.createStatement();
    }

    public void disconnect(ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getListEmployees(int fromId, int toId){
        String query = "select e.emp_no,e.first_name,e.last_name from employees e where (e.emp_no>=?) and (e.emp_no <=?)";
        List<Employee> employeeList =  new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,fromId);
            preparedStatement.setInt(2,toId);

            try(ResultSet rs = preparedStatement.executeQuery()){
                while (rs.next()){
                    int id = Integer.parseInt(rs.getString("emp_no"));
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    Employee e = new Employee(id,firstName,lastName);
                    employeeList.add(e);
                    //System.out.println(rs.getString("emp_no") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
                }
            } catch (SQLException throwables) {
                throw new RuntimeException("error getting data from the database");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("error creating prepared Statement");
        }
        return employeeList;
    }

    public List<Employee> getSalaryPaymentsByNumberDepartmentsAndGivenPeriodOfTime(String departmentId,
                                                                                   LocalDate dateFrom, LocalDate dateTo) throws SQLException, ClassNotFoundException {
        String query = "select emp.id as emp_id, emp.name as emp_name, sum(salary) as salary from employee emp left join" +
                "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                " sp.date >= ? and sp.date <= ? group by emp.id, emp.name";
        ps = connection.prepareStatement(query);
        ps.setString(0, departmentId);
        ps.setDate(1, new Date(dateFrom.toEpochDay()));
        ps.setDate(2, new Date(dateTo.toEpochDay()));
        // execute query and get the results
        List<Employee> employeeList =  new ArrayList<>();
        try(ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                int id = Integer.parseInt(rs.getString("emp_no"));
                String firstName = rs.getString("first_name");
                Employee e = new Employee(id,firstName);
                employeeList.add(e);
                //System.out.println(rs.getString("emp.id") + " " + rs.getString("emp.name"));
            }
        }
        return employeeList;
    }
}
