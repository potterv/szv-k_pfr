package ru.pfr;

import java.util.List;

public class View {
    View(List<Employee> employees, CsvWriter csvWriter){
        csvWriter.saveCsv(employees);
    }

}
