package ru.pfr;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

//        log.info(String.join(" ", "Инициализирован класс  DbHandler"));
        List<Employee> employees = new ArrayList<Employee>();
        log.info(String.join(" ", "Инициализирован список employees"));
        for (StringBuffer file:rf.getListFiles(pathD)) {
            staxStreamProcessor.readXml(file.toString());
            log.info(String.join(" ", "обрабатывается файл", file.toString()));
            for (Employee employee:staxStreamProcessor.getAllEmployee()) {

                Employee employeedb =dbHandler.findHumen(employee.getSnils().toString());
                employee.setCountry(employeedb.getCountry());
                employee.setArea(employeedb.getArea());
                employee.setRegion(employeedb.getRegion());
                employee.setCity(employeedb.getCity());
                employees.add(employee);
                log.info(String.join(" ", "В employees добавлена запись"));

            }
        }
//        dbHandler.close();
        return employees;
    }

    public CsvWriter getCsv(){

        return new CsvWriter();
    }

    public DbHandler getConnectDb(){
        try {
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

    private static final Logger log = Logger.getLogger(Model.class);
}
