package ru.sber.javaschool.solid.generator;

import ru.sber.javaschool.solid.dto.Employee;

import java.sql.SQLException;
import java.util.List;

public interface GeneratorForm {
    String generate(List<Employee> list) throws SQLException;
}
