package ru.pfr;

//import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator.*;
//import org.sqlite.JDBC;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class DbHandler {


    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private PreparedStatement pstmt = null;
    /**
     * @throws SQLException
     */
//    private DbHandler() throws SQLException {
//        // Регистрируем драйвер, с которым будем работать
//        // в нашем случае Sqlite
//        DriverManager.registerDriver(new JDBC());
//        log.info("Драйвер для работы с базой зарегистрирован");
//        // Выполняем подключение к базе данных
//        this.connection = DriverManager.getConnection(CON_STR);
//        log.info("Подключение к базе  выполнено");
//
//    }

    private DbHandler() throws SQLException {
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
        String url="jdbc:db2://10.92.0.71:50000/szvk";
        String user="db2admin";
        String password="dB2@dm1n";
//        Driver driver = new COM.ibm.db2.jdbc.app.DB2Driver();
//        DriverManager.registerDriver(driver);
         this.connection = null;
        try {
            //Load class into memory
            Class.forName(jdbcClassName);
            log.info("Драйвер для работы с базой зарегистрирован");
            //Establish connection
            this.connection = DriverManager.getConnection(url, user, password);
            log.info(this.connection.getMetaData().toString());
            log.info("Подключение к базе  выполнено");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (this.connection != null) {
                log.info("Connected successfully.");

//                connection.close();
            }
        }

        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
//        DriverManager.registerDriver(new JDBC());
//        log.info("Драйвер для работы с базой зарегистрирован");
//        // Выполняем подключение к базе данных
//        this.connection = DriverManager.getConnection(CON_STR);
//        log.info("Подключение к базе  выполнено");

    }
    /**
     * Метод для получения записей из таблицу view_employee_with_adress с параметрами
     *
     */
    public List<Employee> getAllEployees() {
        String snils ="";
        String country = "";
        String area ="";
        String region = "";
        String city = "";
        String uuidpachki="";
        String uuidRecor ="";
        String surname ="";
        String name ="";
        String patronymic="";
        String birthday = "";

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()  ) {

            // В данный список будем загружать людей, полученных из БД
            List<Employee> employees = new ArrayList<Employee>();
            // В resultSet будет храниться результат нашего запроса,
            // который выполняется командой statement.executeQuery()
//            ResultSet resultSet = statement.executeQuery("SELECT snils, country, area, region, city  FROM HUMEN");
            pstmt=this.connection.prepareStatement("SELECT distinct snils,uuid_p, uuid_r,surname, name, country, patronymic,birthday, area, region, city  FROM db2admin.view_employee_with_adress where uuid_p ='bb2a1ab0-db5f-4294-8402-eecd5846b894'");
//            pstmt.setObject(1,snils);
            ResultSet resultSet = pstmt.executeQuery();
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                    snils = resultSet.getString("snils");

                    country = resultSet.getString("country");
                if (country== null){
                    country ="-";
                }
                    area = resultSet.getString("area");
                if (area==null){
                    area ="-";
                }
                region =resultSet.getString("region");
                if (region==null){
                    region ="-";
                }
                city = resultSet.getString("city");
                if (city==null){
                    city ="-";
                }
                employees.add(new Employee.Builder(new StringBuffer(snils)).getPolicyholder(
                        new StringBuffer(resultSet.getString("uuid_p")),
                        new StringBuffer(resultSet.getString("uuid_r")),
                        new StringBuffer(resultSet.getString("surname")),
                        new StringBuffer(resultSet.getString("name")),
                        new StringBuffer(resultSet.getString("patronymic")),
                        LocalDate.parse(resultSet.getString("birthday")),
                        new StringBuffer(country),
                        new StringBuffer(area),
                        new StringBuffer(region),
                        new StringBuffer(city)).buidl());

            }
            log.info("Метод getAllHumen вернул список");
            // Возвращаем наш список
            return employees;
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("Это сообщение ошибки, Метод getAllHumen вернул пустой список");
            log.error(new String(e.getSQLState()));
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }



    /**
     * Метод для выборки информации из таблицы
     * @param nameTable - имя таблицы
     * @param nameColl - слоаврь наименований палей и их значений в таблице
     * @param param - слоаврь наименований палей и их значений в таблице
     */
    //
    public Employee getHumen(String nameTable, String nameColl, LinkedHashMap param) {

        boolean isdDate=false;
        String country = "-";
        String area ="-";
        String region = "-";
        String city = "-";
        String calls =  param.keySet().toString().replaceAll("\\["," ").replaceAll("]"," ");
        String vallColl = param.get(nameColl).toString();

        String sql = "".join("",
                "SELECT ",calls,
                " FROM db2admin.",nameTable," WHERE ",nameColl,"=?");
//        try (Statement statement = this.connection.createStatement()  )
        try (  PreparedStatement statement = this.connection.prepareStatement(sql))
        {
            statement.setObject(1, vallColl);
            // Выполняем запрос
            ResultSet resultSet = statement.executeQuery();

            log.info("Данные из базы получены");
            if (resultSet.next()) {
                if (resultSet.getString("snils")!=null){
                    isdDate =true;
                }
                country = resultSet.getString("country");
                if (country == null) {
                    country = "-";
                }
                area = resultSet.getString("area");
                if (area == null) {
                    area = "-";
                }
                region = resultSet.getString("region");
                if (region == null) {
                    region = "-";
                }
                city = resultSet.getString("city");
                if (city == null) {
                    city = "-";
                }
            }

        } catch (SQLException e) {
            log.error("Ошибка доступности данных");
//            log.error("Это сообщение ошибки, Метод findHumen вернул пустой список");
            log.error(new String(e.getSQLState()));
            log.error(e.getStackTrace().toString());
        }
        finally {
            if (isdDate){

                return new Employee.Builder(new StringBuffer(param.get(nameColl).toString())).getPFR(
                    new StringBuffer(country),
                    new StringBuffer(area),
                    new StringBuffer(region),
                    new StringBuffer(city)).buidl();

            }else {
                log.warn("".join(" ",param.get(nameColl).toString(), " в базе данный снилс не найден"));
                return new Employee.Builder(new StringBuffer(param.get(nameColl).toString())).getPFR(
                        new StringBuffer("-"),
                        new StringBuffer("-"),
                        new StringBuffer("-"),
                        new StringBuffer("-")).buidl();
            }
        }

    }

    /**
     * Метод для получения записей в таблицу с параметрами
     * @param nameTable - имя таблицы
     * @param nameColl - Имя поля в таблице по кторому выполняется фильтр
     */
    // поиск информации о человеке по СНИЛС
    public List<Employee> getEmployees(String nameTable, String nameColl, LinkedHashMap param) {
        List<Employee> employeeList = new LinkedList<Employee>();
        employeeList = null;
        boolean isdDate=false;
//        String country = "-";
//        String area ="-";
//        String region = "-";
//        String city = "-";
        System.out.println(param.keySet().toString());
        String calls =  param.keySet().toString().replaceAll("\\["," ").replaceAll("]"," ");
        System.out.println(calls);
        String vallColl = param.get("uuid_P").toString();
        System.out.println(vallColl);

        String sql = "".join("",
                "SELECT distinct",calls,
                " FROM db2admin.",nameTable," WHERE ",nameColl,"=?");
        System.out.println(sql);
//        try (Statement statement = this.connection.createStatement()  )
        try (  PreparedStatement statement = this.connection.prepareStatement(sql))
        {
            statement.setObject(1, vallColl);
            // Выполняем запрос
            ResultSet resultSet = statement.executeQuery();

            log.info("Данные из базы получены");
            String nameColls[] = calls.split(",");
            System.out.println(nameColls.toString());
            System.out.println(resultSet.next());
            while (resultSet.next()) {

               employeeList.add( new Employee.Builder(new StringBuffer(param.get(nameColls[0]).toString())).getPolicyholder(

                        new StringBuffer(resultSet.getString(nameColls[1].toString())),
                        new StringBuffer(resultSet.getString(nameColls[2].toString())),
                        new StringBuffer(resultSet.getString(nameColls[3].toString())),
                        new StringBuffer(resultSet.getString(nameColls[4].toString())),
                       new StringBuffer(resultSet.getString(nameColls[5].toString())),
                       LocalDate.parse(resultSet.getString(nameColls[5].toString())),
//
                        new StringBuffer(resultSet.getString(nameColls[6].toString())),
                        new StringBuffer(resultSet.getString(nameColls[7].toString())),
                       new StringBuffer(resultSet.getString(nameColls[8].toString())),
                       new StringBuffer(resultSet.getString(nameColls[9].toString()))
                         ).buidl());


//                if (resultSet.getString(nameColl)!=null){
//                    isdDate =true;
//                }
//                country = resultSet.getString("country");
//                if (country == null) {
//                    country = "-";
//                }
//                area = resultSet.getString("area");
//                if (area == null) {
//                    area = "-";
//                }
//                region = resultSet.getString("region");
//                if (region == null) {
//                    region = "-";
//                }
//                city = resultSet.getString("city");
//                if (city == null) {
//                    city = "-";
//                }
            }

           return employeeList;


        } catch (SQLException e) {
            log.error("Ошибка доступности данных");
//            log.error("Это сообщение ошибки, Метод findHumen вернул пустой список");
            log.error(new String(e.getSQLState()));
            log.error(e.getStackTrace().toString());
        }
//        finally {
//            if (isdDate){
//
//
//
//            }else {
////                log.warn("".join(" ",param.get(nameColl).toString(), " в базе данный снилс не найден"));
//                return new Employee.Builder(new StringBuffer(param.get(nameColl).toString())).getPFR(
//                        new StringBuffer("-"),
//                        new StringBuffer("-"),
//                        new StringBuffer("-"),
//                        new StringBuffer("-")).buidl();
//            }
//        }
        finally {
            return Collections.emptyList();
        }
    }



    /**
     * Метод для добовления записей в таблицу с параметрами
     * @param nameTable - имя таблицы
     * @param nameColls - слоаврь наименований палей и их значений в таблице
     */
    public void addData(String nameTable, LinkedHashMap nameColls) throws SQLException {
        StringBuffer volue = new StringBuffer();
        try (PreparedStatement statement = this.connection.prepareStatement("".join("", "SELECT ", "snils, UUID_R ", "FROM db2admin.", nameTable, " Where snils=?")))

         {
            statement.setObject(1,nameColls.get("snils").toString());
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                for (int countValue = 0; countValue<nameColls.size();countValue++){

                    volue.append("?");
                        if (countValue+1<nameColls.size()){
                            volue.append(",");
                        }
                }
                try (PreparedStatement statement1 = this.connection.prepareStatement("".join(" ",
                        "INSERT INTO db2admin.",
                        nameTable,
                        nameColls.keySet().toString().replaceAll("\\[","(").replaceAll("]",")"),
                        "VALUES (",
                        volue,
                        ")"

                        )))
                     {
                    for (int countValue = 0; countValue<nameColls.size();countValue++){
                      statement1.setObject(countValue+1,  nameColls.values().toArray()[countValue].toString());
                    }
                    log.info("".join("","В таблицу ", nameTable," добавлена запись с uuid",nameColls.get("uuid_R").toString()));
                    statement1.executeUpdate();

                }catch (Exception e){
                    log.error(e.getMessage());
                    log.error(e.getStackTrace().toString());
                }
            } else {
                log.warn("".join(" ", "Снилс'",nameColls.get("snils").toString(),"' уже существует","UUID = ", resultSet.getString("UUID_R"),"  и не будет добавлен в таблицу", nameTable));
//                System.out.println();
            }

        }catch (Exception e){
            log.error(e.getMessage());
            log.error(e.getStackTrace().toString());
        }
    }

    // Константа, в которой хранится адрес подключения
//    private static final String CON_STR = "jdbc:sqlite:D:/IdeaProject/szvk/db/szvk.db";
    public void close() throws SQLException {
        this.connection.close();
    }

    private static final Logger log = Logger.getLogger(DbHandler.class);


}
