package ru.pfr;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class DbHandlerTest {



    @Test
    public void getAllHumen() throws SQLException {
        DbHandler dbHandler = DbHandler.getInstance();
        // Получаем все записи и выводим их на консоль
//        FactoryHuman fh = new FactoryHuman();
//        Human humanFromPFR =  fh.getCurrentHuman(FactoryHuman.InDate.FROMPFR);
        List<Employee> Humen = dbHandler.getAllHumen();
        for (Employee human : Humen) {
            System.out.println(human);
        }
    }
    @Before
    public void outXml() throws IOException, XMLStreamException {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        String pathD = "D:\\IdeaProject\\szvk\\mail\\inSZVK";

        ReadDerectory rf= ReadDerectory.getInstance();

        StaxStreamProcessor staxStreamProcessor = new StaxStreamProcessor();



        List<Employee> employees = new ArrayList<Employee>();


        for (StringBuffer file:rf.getListFiles(pathD)) {
            staxStreamProcessor.readXml(file.toString());
           this.employees.add(staxStreamProcessor.getAllEmployee());
        }
    getListEmployee();
    }


    public void getListEmployee(){
        for (List<Employee> filesEmployee:this.employees
        ) {
            for (Employee employee:filesEmployee
            ) {
//
                employeeList.add(employee.getSnils().toString());

            }

        }
    }

    @Test
    public void findHumen() throws SQLException{
        DbHandler dbHandler = DbHandler.getInstance();
        for (String snils:this.employeeList
             ) {
            System.out.println(snils);
            LinkedHashMap linkedHashMapParam = new LinkedHashMap();
            linkedHashMapParam.put("snils",snils);
            linkedHashMapParam.put("country","");
            linkedHashMapParam.put("area","");
            linkedHashMapParam.put("region","");
            linkedHashMapParam.put("city","");
            Employee human =dbHandler.getEmployee("HUMEN","snils",linkedHashMapParam);
            System.out.println(human);

        }
//        Employee human = dbHandler.getEmployee("181-105-431 24");
//        System.out.println(human);
    }
    private List<String> employeeList= new LinkedList<String>();
    private List<List<Employee>> employees = new LinkedList<List<Employee>>();

    @Test
    public void addDate() throws SQLException {
        DbHandler dbHandler = DbHandler.getInstance();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("snils","186-914-271 12");
        linkedHashMap.put("surname","Гончар");

        dbHandler.addData("EMPLOYEES_POLICYHOLDER",linkedHashMap);
    }
}