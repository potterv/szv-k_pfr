package ru.pfr.viewhtml;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.pfr.DbHandler;
import ru.pfr.Employee;
import ru.pfr.FileValidator;
import ru.pfr.Model;



import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class ViewHtml {


    private DbHandler dbHandler;
    private Model modelSzvk;
    private List<Employee> employeeList;
    @Value("${value:none}")
    public String value;
    public ViewHtml() throws XMLStreamException, IOException, SQLException {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        this.modelSzvk = new Model();
        dbHandler=this.modelSzvk.getConnectDb();


    }

    @RequestMapping(value = "/",method = { RequestMethod.GET, RequestMethod.POST })
    public String index(ModelMap model) throws XMLStreamException, IOException, SQLException{

//        model.addAttribute("employeesCount", 0);
        model.addAttribute("namePage", "index");
        return "index";
    }


    @RequestMapping(value = "/getdate",method = { RequestMethod.GET, RequestMethod.POST })
    public String getDate(ModelMap model) throws XMLStreamException, IOException, SQLException {

//        dbHandler=this.modelSzvk.getConnectDb();
        model.addAttribute("namePage", "getdate");
        model.addAttribute("massege", "Данные обрабатываются");
        this.employeeList = this.modelSzvk.getEmployeeList(dbHandler);
        model.addAttribute("massege", "Данные обработаны");
//        model.addAttribute("employees", this.employeeList);
//        model.addAttribute("employeesCount", modelSzvk.getEmployee(dbHandler).size());
        return "redirect:/viewdate";
    }
    @RequestMapping(value = "/viewdate",method = { RequestMethod.GET, RequestMethod.POST })
    public String viewDate(ModelMap model) throws XMLStreamException, IOException, SQLException {

//        dbHandler=this.modelSzvk.getConnectDb();
        model.addAttribute("namePage", "viewdate");
        model.addAttribute("employees", this.employeeList);
//        model.addAttribute("employeesCount", modelSzvk.getEmployee(dbHandler).size());
        return "index";
    }


    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(ModelMap model) throws XMLStreamException, IOException, SQLException{
        model.addAttribute("namePage", "upload");
//        model.addAttribute("employeesCount", 0);
        return "index";
    }





private static final Logger log = Logger.getLogger(ViewHtml.class);
}


