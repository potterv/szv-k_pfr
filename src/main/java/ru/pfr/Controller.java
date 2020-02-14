package ru.pfr;
import org.apache.log4j.PropertyConfigurator;
import ru.pfr.Model;
import ru.pfr.View;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;


public class Controller {
    Model model = null;
    View view = null;

    public Controller() throws XMLStreamException, IOException, SQLException {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        model = new Model();
        new View(model.getEmployee(model.getConnectDb()),model.getCsv());
    }
}
