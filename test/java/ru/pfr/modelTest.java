package ru.pfr;

import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;

public class modelTest {

    @Test
    public void print() throws IOException, XMLStreamException, SQLException {
        Model m = new Model();
        DbHandler dbHandler = DbHandler.getInstance();
        m.readDataFromXmlToDb(dbHandler);
//        m.getCsv().saveCsv(m.getEmployeeList(dbHandler));

    }
}