package ru.pfr;

import ru.pfr.xlsmodel.StreamExcel;

import java.io.IOException;
import java.util.List;

public class View {
    View(List<Employee> employees, CsvWriter csvWriter){
        csvWriter.saveCsv(employees);
    }

    View(List<Employee> employees, StreamExcel xlsWriter) throws IOException {
        xlsWriter.writeToXls(employees);
    }

}
