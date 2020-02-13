package ru.pfr;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class CsvWriter {
    public void saveCsv(List<Employee> employees) {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            log.info("Файл csv создан. Начата запись в файл");
            StringBuilder sb = new StringBuilder();
//            sb.append("namepolicyholdershort");
//            sb.append(',');
//            sb.append("regnumber");
//            sb.append(',');
            sb.append("snils");
            sb.append(',');
            sb.append("surname");
            sb.append(',');
            sb.append("name");
            sb.append(',');
            sb.append("patronymic");
            sb.append(',');
            sb.append("birthday");
            sb.append(',');
            sb.append("residenceCrimea");
            sb.append(',');
            sb.append("country");
            sb.append(',');
            sb.append("area");
            sb.append(',');
            sb.append("region");
            sb.append(',');
            sb.append("city");
            sb.append(',');
            sb.append("residenceCrimeaFromFms");
            sb.append('\n');
            for (Employee employee: employees
                 ) {

                sb.append(employee.toString());
                sb.append(',');
                sb.append('\n');
            }

            writer.write(sb.toString());


            log.info("Запись в Файл csv завершена!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            log.error("Это сообщение ошибки, Метод saveCsv вернул jib,re");
            log.error(new String(e.getMessage()));
        }

    }
    private static final Logger log = Logger.getLogger(CsvWriter.class);
}