package ru.pfr;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StaxStreamProcessorTest {

//    @Before
//    public static void  getStax(){
////        System.out.println("hhhh");
////        StaxStreamProcessor staxStreamProcessor = new StaxStreamProcessor();
//    }

    @Test
    public void readXml() throws IOException, XMLStreamException {

        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        String pathD = "".join("",new File("").getAbsolutePath(),"/mail/inSZVK") ;

        ReadDerectory rf= ReadDerectory.getInstance();

        StaxStreamProcessor staxStreamProcessor = new StaxStreamProcessor();



        List<Employee> employees = new ArrayList<Employee>();


        for (StringBuffer file:rf.getListFiles(pathD)) {
            staxStreamProcessor.readXml(file.toString());
//            System.out.println(staxStreamProcessor.getAllEmployee());
            for (Employee employee:staxStreamProcessor.getAllEmployee()) {
                System.out.println(employee);
//                Employee employeedb =dbHandler.findHumen(employee.getSnils().toString());
//                employee.setCountry(employeedb.getCountry());
//                employee.setArea(employeedb.getArea());
//                employee.setRegion(employeedb.getRegion());
//                employee.setCity(employeedb.getCity());
//                employees.add(employee);
//                log.info(String.join(" ", "В employees добавлена запись"));
                 }
            }
//        StaxStreamProcessor staxStreamProcessor = new StaxStreamProcessor();
//        staxStreamProcessor.readXml("D:\\IdeaProject\\szvk\\mail\\inSZVK\\PFR-700-Y-2020-ORG-092-001-017951-DCK-00003-DPT-000000-DCK-00000.XML");
//        System.out.println(staxStreamProcessor.getAllEmployee());
//       assertNotEquals(staxStreamProcessor.getAllEmployee(), new ArrayList<>());
    }

//    @Test
//    public void getAllEmployee() {
//    }

}