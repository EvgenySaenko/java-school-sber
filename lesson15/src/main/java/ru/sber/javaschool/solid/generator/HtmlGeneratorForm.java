package ru.sber.javaschool.solid.generator;

import ru.sber.javaschool.solid.dto.Employee;

import java.sql.SQLException;
import java.util.List;

public class HtmlGeneratorForm implements GeneratorForm {
    private StringBuilder htmlPage;

    public HtmlGeneratorForm() {
        this.htmlPage = new StringBuilder();
    }

    @Override
    public String generate(List<Employee> list) throws SQLException {
        htmlPage.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        for(Employee e : list){
            htmlPage.append("<tr>"); // add row start tag
            htmlPage.append("<td>").append(e.getId()).append("</td>"); // appending employee name
            htmlPage.append("<td>").append(e.getFirstName()).append("</td>"); // appending employee salary for period
            htmlPage.append("<td>").append(e.getLastName()).append("</td>"); // appending employee salary for period
            htmlPage.append("</tr>"); // add row end tag
        }
        htmlPage.append("</table></body></html>");
        return htmlPage.toString();
    }
}
