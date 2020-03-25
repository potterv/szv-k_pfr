package ru.pfr.xlsmodel;

import ru.pfr.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

interface InterfaceExcel {
     void writeToXls (List<Employee> employees) throws IOException;
     Employee readFromXls();
}
