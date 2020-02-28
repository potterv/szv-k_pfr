package ru.pfr;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Model {

    public List<Employee> getEmployee(DbHandler dbHandler) throws IOException, XMLStreamException, SQLException {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");

        String pathD = "D:\\IdeaProject\\szvk\\mail\\inSZVK";
        log.info(String.join(" ", "Определен mail каталог", pathD));
        ReadDerectory rf= ReadDerectory.getInstance();
        log.info(String.join(" ", "файлы для обработки определены"));
        StaxStreamProcessor staxStreamProcessor = new StaxStreamProcessor();
        log.info(String.join(" ", "Инициализирован класс StaxStreamProcessor"));


        List<Employee> employees = new ArrayList<Employee>();
        log.info(String.join(" ", "Инициализирован список employees"));

        for (StringBuffer file:rf.getListFiles(pathD)) {
            staxStreamProcessor.readXml(file.toString());
            log.info(String.join(" ", "обрабатывается файл", file.toString()));
            for (Employee employee:staxStreamProcessor.getAllEmployee()) {
                LinkedHashMap linkedHashMapParam = new LinkedHashMap();
                linkedHashMapParam.put("snils",employee.getSnils().toString());
                linkedHashMapParam.put("country","");
                linkedHashMapParam.put("area","");
                linkedHashMapParam.put("region","");
                linkedHashMapParam.put("city","");
                Employee employeedb =dbHandler.getEmployee("HUMEN","snils",linkedHashMapParam);
                employee.setCountry(employeedb.getCountry());
                employee.setArea(employeedb.getArea());
                employee.setRegion(employeedb.getRegion());
                employee.setCity(employeedb.getCity());
                employees.add(employee);
                log.info(String.join(" ", "В employees добавлена запись"));

            }
        }
//        dbHandler.close();
        Collections.sort(employees);
        return employees;
    }

    public CsvWriter getCsv(){

        return new CsvWriter();
    }

    public DbHandler getConnectDb(){
        try {
                    log.info(String.join(" ", "Инициализирован класс  DbHandler, Выполнено подключение к базе"));
            return DbHandler.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void setConnectionDB(){
        try {
            DbHandler.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public Connection getConnaction(){

        return null;
    }
    public void addDateToTable(DbHandler dbHandler,List<Employee> employeeList) throws SQLException {

        for (Employee employee:employeeList) {
            LinkedHashMap param = new LinkedHashMap();
            param.put("uuid_P",employee.getUuidPachka());
            param.put("uuid_R",employee.getUuidRecord());
            param.put("snils",employee.getSnils());
            param.put("surname",employee.getSurname());
            param.put("name",employee.getName());
            param.put("patronymic",employee.getPatronymic());
            param.put("birthday",employee.getBirthday().toString());
            param.put("residenceCrimea",employee.getResidenceCrimea());
            param.put("country",employee.getCountry());
            param.put("area",employee.getArea());
            param.put("region",employee.getRegion());
            param.put("city",employee.getCity());
            param.put("numberInsured",employee.getRegnumber().toString());
            param.put("nameInsured",employee.getPolicyholderShort());

            dbHandler.addData("EMPLOYEES_POLICYHOLDER",param);
        }
    }

    private static final Logger log = Logger.getLogger(Model.class);
}
