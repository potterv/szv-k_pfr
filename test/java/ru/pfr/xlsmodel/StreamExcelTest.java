package ru.pfr.xlsmodel;

import org.junit.Test;
import ru.pfr.Employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class StreamExcelTest {



    @Test
    public void writeToXls() throws IOException {
        Employee employee = new Employee.Builder( new StringBuffer("183-694-793 31")).getPolicyholder(  new StringBuffer("d43c1d2a-ecb1-4891-b632-7ce49723afc7"),
                new StringBuffer("07ab9a09-25f8-4d82-b9aa-0e0e999dc5da"), new StringBuffer("АБЛЯЗИМОВА"),
                new StringBuffer("ЭЛЛИНА"), new StringBuffer("МУБЛЕТОВНА"), LocalDate.parse("1995-07-06"),true).buidl();
        employee.setArea(new StringBuffer("АР КРЫМ УКРАИНА"));
        employee.setCountry( new StringBuffer("-"));
        employee.setRegion(new StringBuffer("-"));
        employee.setCity( new StringBuffer("КЕРЧЬ"));

        List<Employee> employeeList = new LinkedList<Employee>();
        employeeList.add(employee );


        StreamExcel streamExcel = new StreamExcel();

        streamExcel.writeToXls(employeeList);
    }

    @Test
    public void readFromXls() {
    }
}