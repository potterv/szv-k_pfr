package ru.pfr;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static javax.xml.stream.XMLInputFactory.*;

public class StaxStreamProcessor {

//    инициализация классов для загрузки xml файла

//    public void getInfoPolicyholder(){
////        System.out.println(policyholder.get("regnumber").toString());
//        for (Employee employee:employeeList) {
//            System.out.println(employee.toString());
//        }
//
//    }
    public StaxStreamProcessor(){
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        this.uuidPachka=UUID.randomUUID().toString();
    }


    public List<Employee> getAllEmployee() {
        log.info(String.join(" ","Данные о страхователе и его сотрудниках прочитаны из файла ",policyholder.get("namefile").toString()));
        return this.employeeList;
    }




    public void readXml(String pathFile) throws IOException, XMLStreamException {

        URLSTRING = String.join("",URL,pathFile);
        employeeList = new ArrayList<Employee>();
        policyholder =new HashMap<String, String>();
        residenceCrimea = false;

        URL url = null;

        try {
            url = new URL(URLSTRING);

        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }

        InputStream in = url.openStream();
        XMLInputFactory factory = newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(in);
        parser.standaloneSet();

        while (parser.hasNext()){
            int event = parser.next();

            if (event == XMLStreamConstants.START_ELEMENT) {

//  Записываем  информацию о страхователе который подал данные
              if (parser.getLocalName().equals("ИмяФайла")){
                    policyholder.put("namefile",parser.getElementText());

              }

              if (parser.getLocalName().equals("ИНН")){
                  policyholder.put("inn",parser.getElementText());
              }

              if (parser.getLocalName().equals("КПП")){
                  policyholder.put("kpp",parser.getElementText());
              }

              if (parser.getLocalName().equals("Форма")){

               }
              if (parser.getLocalName().equals("НаименованиеОрганизации")){
                    policyholder.put("namepolicyholder",parser.getElementText());
              }

              if (parser.getLocalName().equals("НаименованиеКраткое")){
                    policyholder.put("namepolicyholdershort",parser.getElementText());
              }
              if (parser.getLocalName().equals("РегистрационныйНомер")){
                    policyholder.put("regnumber",parser.getElementText());
//                  System.out.println(policyholder.get("regnumber"));
              }

//  Записываем  информацию о сотрудниках страхователя который подал данные

              if (parser.getLocalName().equals("СтраховойНомер")){
                  uuidRecord=UUID.randomUUID().toString();
                  snils = new String();
                  snils = parser.getElementText();


              }
              if (parser.getLocalName().equals("Фамилия")){
                  surname= new String();
                  surname = parser.getElementText();

              }
              if (parser.getLocalName().equals("Имя")){
                  name = new String();
                  name = parser.getElementText();
              }
              if (parser.getLocalName().equals("Отчество")){
                   patronymic = new String();
                  patronymic = parser.getElementText();

              }
              if (parser.getLocalName().equals("ДатаРождения")){
                  birthday = new String();
                  birthday = parser.getElementText();
              }
              if (parser.getLocalName().equals("ФактПроживанияКрым")){
                  residenceCrimea = parser.getElementText().equals("1");

              }
//              if (parser.getLocalName().equals("НаименованиеОрганизации")){
//
//                  System.out.println(parser.getElementText());
//              }
//              if (parser.getLocalName().equals("ДатаНачалаПериода")){
//                    System.out.println(parser.getElementText());
//              }
//              if (parser.getLocalName().equals("ДатаКонцаПериода")){
//                    System.out.println(parser.getElementText());
//              }
//              if (parser.getLocalName().equals("ПрофессияДолжность")){
//                    System.out.println(parser.getElementText());
//
//              }

            }

            if (event == XMLStreamConstants.END_ELEMENT) {
                if (parser.getLocalName().equals("СоставительПачки")){
                    log.info(String.join(" ","Начат  процес  чтения и загрузки данных из файла",policyholder.get("namefile").toString()));
                    log.info(String.join(" ","Начат  процес чтения  данных по страхователю",policyholder.get("namepolicyholder").toString(),policyholder.get("regnumber").toString()));
                    continue;
                }
                if (parser.getLocalName().equals("КОНВЕРТАЦИЯ")){


                    employeeList.add(new Employee.Builder(new StringBuffer(snils)).getPolicyholder(
                            new StringBuffer(uuidPachka),
                            new StringBuffer(uuidRecord),
                            new StringBuffer(surname),
                            new StringBuffer(name),
                            new StringBuffer(patronymic),
                            LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                            residenceCrimea,
                            new StringBuffer(policyholder.get("namepolicyholdershort").toString()),
                            new StringBuffer(policyholder.get("regnumber").toString())).buidl());
                    log.info(String.join(" ","Обработан UUID записи ",uuidRecord," в пачке с UUID - ",uuidPachka));

                }

            }
        }
        log.info(String.join(" ","Завершен  процес анализа, чтения и загрузки данных из файла",policyholder.get("namefile").toString()));
        log.info(String.join(" ","Завершен  процес чтения и загрузки  данных по страхователю",policyholder.get("namepolicyholder").toString(),policyholder.get("regnumber").toString()));
    }
    private Map policyholder =null;
    private String uuidPachka=null;
    private String uuidRecord=null;
    private String snils=null;
    private String surname=null;
    private String name =null;
    private String patronymic=null;
    String birthday =null;
    private boolean residenceCrimea;
    private List<Employee> employeeList = null;
    private static final String URL = "file:///";
    private  String URLSTRING;
    private static final Logger log = Logger.getLogger(StaxStreamProcessor.class);

}
