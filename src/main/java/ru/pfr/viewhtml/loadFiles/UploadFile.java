package ru.pfr.viewhtml.loadFiles;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.pfr.DbHandler;
import ru.pfr.FileValidator;
import ru.pfr.Model;



import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pfr.UploadedFile;

@Controller
@SessionAttributes("filename")
public class UploadFile {

    @Autowired
    private FileValidator fileValidator; //автосвязывание с бином FileValidator

    private static final Logger log = Logger.getLogger(UploadFile.class);

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView uploadFile(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {// имена параметров (тут - "uploadedFile") - из формы JSP.

        ModelAndView modelAndView = new ModelAndView();

        String fileName = null;

        MultipartFile file = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, result);

        if (result.hasErrors()) {
            modelAndView.setViewName("main");
        } else {

            try {
                byte[] bytes = file.getBytes();

                fileName = file.getOriginalFilename();

                String rootPath = "D:\\IdeaProject\\szvk\\mail\\inSZVK\\";
                File dir = new File(rootPath + File.separator + "loadFiles");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File loadFile = new File(dir.getAbsolutePath() + File.separator + fileName);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                log.info("uploaded: " + loadFile.getAbsolutePath());

                RedirectView redirectView = new RedirectView("/upload");
                redirectView.setStatusCode(HttpStatus.FOUND);
                modelAndView.setView(redirectView);
                modelAndView.addObject("filename", fileName);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return modelAndView;
    }


}
