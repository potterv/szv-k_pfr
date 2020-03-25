package ru.pfr.viewhtml;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pfr.UploadedFile;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;
@Controller
public class EditEmployee {

    private static final Logger log = Logger.getLogger(EditEmployee.class);


    @RequestMapping(value = "/editemployee",method = {RequestMethod.GET, RequestMethod.POST })
    public ModelAndView editemployee(@ModelAttribute("editparam") UploadedFile editparam, BindingResult result) throws XMLStreamException, IOException, SQLException {
        ModelAndView modelAndView = new ModelAndView();
//
//
        return modelAndView;
    }

}