package ru.pfr;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.UUID;

import static org.junit.Assert.*;

public class EmployeeTest {



    @Test
    public void compareTo() {
        LinkedList<Employee> employees = new LinkedList<Employee>();
        String uuidPachka= UUID.randomUUID().toString();
        String uuidRecord1= UUID.randomUUID().toString();
        employees.add(new Employee.Builder(new StringBuffer("186-914-271 09")).getPolicyholder(
                new StringBuffer(uuidPachka),
                new StringBuffer(uuidRecord1),
                new StringBuffer("Гончар"),
                new StringBuffer("Владимир"),
                new StringBuffer("Владимирович"),
                LocalDate.parse("07.06.1983", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                true).buidl());
        String uuidRecord2= UUID.randomUUID().toString();
        employees.add(new Employee.Builder(new StringBuffer("187-914-241 09")).getPolicyholder(
                new StringBuffer(uuidPachka),
                new StringBuffer(uuidRecord2),
                new StringBuffer("Петров"),
                new StringBuffer("Владимир"),
                new StringBuffer("Владимирович"),
                LocalDate.parse("07.06.1983", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                true).buidl());
        String uuidRecord3= UUID.randomUUID().toString();
        employees.add(new Employee.Builder(new StringBuffer("188-914-221 09")).getPolicyholder(
                new StringBuffer(uuidPachka),
                new StringBuffer(uuidRecord3),
                new StringBuffer("Иванов"),
                new StringBuffer("Владимир"),
                new StringBuffer("Владимирович"),
                LocalDate.parse("07.06.1983", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                true).buidl());
        Collections.sort(employees);
        for (Employee s: employees){
            System.out.println(s.toString());
        }
    }
}