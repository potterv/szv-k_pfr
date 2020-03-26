package ru.pfr.xlsmodel;

import ru.pfr.Employee;
import ru.pfr.fromfms.RowFromFms;

import java.io.IOException;
import java.util.List;

interface InterfaceExcel {
     void writeToXls (List<Employee> employees) throws IOException;
     List<RowFromFms> readFromXls() throws IOException;
}
