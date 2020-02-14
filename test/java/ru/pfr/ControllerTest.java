package ru.pfr;

import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ControllerTest {

@Test
public void test() throws XMLStreamException, IOException, SQLException {
    new Controller();
}

}