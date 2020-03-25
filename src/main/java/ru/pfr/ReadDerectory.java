package ru.pfr;




import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.util.*;


//    Класс для  просмотра  папки  на наличие файлов
public class ReadDerectory {
    private static ReadDerectory instance = null;
    private ReadDerectory(){
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
    }
    public static ReadDerectory getInstance(){
        if (instance==null){
            instance = new ReadDerectory();
        }
        return instance;
    }
    public  List<StringBuffer> getListFiles(String pathDir) {

        File dir = new File(pathDir);
        List<StringBuffer> listF = new LinkedList<StringBuffer>();
        if (dir.exists()) {
            log.info(String.join(" ","Папка ",pathDir," существует"));
            if (dir.isDirectory()) {

                for (File item : dir.listFiles()) {
                    if (item.isFile()) {

                        log.info(String.join(" ","Будет проанализирован файл",item.getAbsolutePath()));
                        listF.add(new StringBuffer(item.toString()));
                    }
                }
            }

        }else {
            dir.mkdir();

        }
        log.info(String.join(" ","Список файлов в папке",pathDir,"получен"));
        return listF;
    }


    //    признак что БУДЕТ обработка СМЗВК
    public void setSZVKFiles(boolean szvkFiles) {
        this.SZVKFiles = szvkFiles;
    }

    public String getPathInSZVM() {
        return PATHINSZVK;
    }

    public static final String PATHRESPONCE = "".join("",new File("").getAbsolutePath(),"/mail/responce/");
    public static final String PATHINSZVK = "".join("",new File("").getAbsolutePath(),"mail/inSZVK/");
    private static final String PATHOUT = "".join("",new File("").getAbsolutePath(),"mail/out/");
    private static final String PATHREQUEST = "".join("",new File("").getAbsolutePath(),"mail/request");
    private File inFolder;//= new File(pathInSZVM);
    //    private File request=new File(PATHREQUEST);
//    private File outFolder = new File(PATHOUT);
    private File[] files;// = inFolder.listFiles();
    private boolean SZVKFiles;
    private static final Logger log = Logger.getLogger(ReadDerectory.class);


}
