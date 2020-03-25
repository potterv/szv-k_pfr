package ru.pfr.xlsmodel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import ru.pfr.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class StreamExcel implements InterfaceExcel {

    public StreamExcel(){

        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
    }

    private HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    @Override
    public void writeToXls(List<Employee> employees) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees");

        List<Employee> list = employees;

        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // uuidPachki
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("uuidPachki");
        cell.setCellStyle(style);
        // uuidrecord
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("uuidrecord");
        cell.setCellStyle(style);
        // snils
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("snils");
        cell.setCellStyle(style);
        // surname
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("surname");
        cell.setCellStyle(style);
        // name
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("name");
        cell.setCellStyle(style);

        // Patronymic
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Patronymic");
        cell.setCellStyle(style);
        // birthday
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("birthday");
        cell.setCellStyle(style);
        // country
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("country");
        cell.setCellStyle(style);
        // area
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("area");
        cell.setCellStyle(style);
        // region
        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("region");
        cell.setCellStyle(style);
        // city
        cell = row.createCell(10, CellType.STRING);
        cell.setCellValue("city");
        cell.setCellStyle(style);
        // residenceCrimeaFromFms
        cell = row.createCell(11, CellType.STRING);
        cell.setCellValue("residenceCrimeaFromFms");
        cell.setCellStyle(style);

        // commentsFms
        cell = row.createCell(12, CellType.STRING);
        cell.setCellValue("commentsFms");
        cell.setCellStyle(style);



        // Data
        for (Employee emp : list) {
            rownum++;
            row = sheet.createRow(rownum);

            // UuidPachka (A)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(emp.getUuidPachka().toString());
            // UuidRecord (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getUuidRecord().toString());
            // Snilsy (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(emp.getSnils().toString());
            // Surname (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(emp.getSurname().toString());
            // Name (E)

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(emp.getName().toString());

            // Patronymic (F)
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(emp.getPatronymic().toString());
            // Birthday (G)
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(emp.getBirthday().toString());
            // Country (H)
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue(emp.getCountry().toString());

            //Area (J)
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(emp.getArea().toString());

            //getRegion (K)
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue(emp.getRegion().toString());

            //City (L)
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue(emp.getCity().toString());




        }
        File file = new File(String.join("",new File("").getAbsolutePath(),"\\mail\\requests\\toFMS_", new Date().toString().replaceAll("\\s","_").replaceAll(":","_"),".xls"));
//        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        log.info(String.join(" ","Created file: -",file.getAbsolutePath()));


    }

    @Override
    public List<Employee> readFromXls() {

        return  Collections.emptyList();
    }

    private static final Logger log = Logger.getLogger(StreamExcel.class);
}
