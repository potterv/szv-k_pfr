package ru.pfr;

import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

public class CsvWriterTest {

    @Test
    public void saveCsv() throws XMLStreamException, IOException, SQLException {
//        Model model = new Model();
//        CsvWriter csvWriter = new CsvWriter();
//        csvWriter.saveCsv(model.getEmployee());

        System.out.println(new Date().toString().replaceAll("\\s","_").replaceAll(":","_"));

    }
}