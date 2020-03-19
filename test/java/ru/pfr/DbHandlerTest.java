package ru.pfr;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

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
        String pathD = "".join("", new File("").getAbsolutePath(),"\\mail\\inSZVK") ;

        ReadDerectory rf= ReadDerectory.getInstance();

        StaxStreamProcessor staxStreamProcessor = new StaxStreamProcessor();



        List<Employee> employees = new ArrayList<Employee>();


        for (StringBuffer file:rf.getListFiles(pathD)) {
            staxStreamProcessor.readXml(file.toString());
            employees=staxStreamProcessor.getAllEmployee();
            for (Employee employee:employees
                 ) {
                this.employeesAdd.add(employee);
            }


//            this.employees=employees;
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
            Employee human =dbHandler.getHumen("HUMEN","snils",linkedHashMapParam);
            System.out.println(human);

        }
//        Employee human = dbHandler.getEmployee("181-105-431 24");
//        System.out.println(human);
    }
    private List<String> employeeList= new LinkedList<String>();
    private List<List<Employee>> employees = new LinkedList<List<Employee>>();
    private List<Employee> employeesAdd = new LinkedList<Employee>();

    @Test
    public void addDate() throws SQLException {
        DbHandler dbHandler = DbHandler.getInstance();
        LinkedHashMap linkedHashMap = new LinkedHashMap();


            Collections.sort(employeesAdd);
        System.out.println(employeesAdd);
            for (Employee employee: employeesAdd
                 ) {
                System.out.println(employee.toString());
                linkedHashMap.clear();
                linkedHashMap.put("uuid_P",employee.getUuidPachka());
                linkedHashMap.put("uuid_R",employee.getUuidRecord());
                linkedHashMap.put("snils",employee.getSnils());
                linkedHashMap.put("surname",employee.getSurname());
                linkedHashMap.put("name",employee.getName());
                linkedHashMap.put("patronymic",employee.getPatronymic());
                linkedHashMap.put("birthday",employee.getBirthday());
                linkedHashMap.put("residenceCrimea",employee.getResidenceCrimea());

                dbHandler.addData("EMPLOYEES_POLICYHOLDER",linkedHashMap);


            }





//        dbHandler.addData("EMPLOYEES_POLICYHOLDER",linkedHashMap);
    }

//    @Before
//    public String getUuid(){
//
//        return " ";
//    }
    @Test
    public void getEmployee() throws SQLException {
        DbHandler dbHandler = DbHandler.getInstance();
        LinkedHashMap param = new LinkedHashMap();
        param.put("uuid_P","");
        param.put("uuid_R","");
        param.put("snils","");
        param.put("surname","");
        param.put("name","");
        param.put("patronymic","");
        param.put("birthday","");
        param.put("residenceCrimea","");
        param.put("country","");
        param.put("area","");
        param.put("region","");
        param.put("city","");
        param.put("numberInsured","");
        param.put("nameInsured","");
        List<Employee> employees = new LinkedList<Employee>();
        employees = dbHandler.getEmployee("EMPLOYEES_POLICYHOLDER","UUID_P",param);
        for (Employee employee: employees
             ) {
            System.out.println(employee);
        }
    }
}