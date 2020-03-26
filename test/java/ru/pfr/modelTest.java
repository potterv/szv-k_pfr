package ru.pfr;

import org.junit.Test;
import ru.pfr.xlsmodel.StreamExcel;

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
    @Test
    public void loadDataFromFms() throws SQLException, IOException {
        StreamExcel streamExcel = new StreamExcel();

        Model m = new Model();
        DbHandler dbHandler = DbHandler.getInstance();
        m.loadDataFromFms(dbHandler,streamExcel.readFromXls());
    }
}