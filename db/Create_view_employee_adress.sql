-- Создание View  для проекта СЗВ-К
CREATE VIEW db2admin.view_employee_unknown_adress
     (id,snils,uuid_p,uuid_r,surname,name,patronymic,birthday,country, area, region, city)
     AS SELECT ALL
           view_employee.id,
          
          view_employee.snils,
           view_employee.uuid_p,
           view_employee.uuid_r,
          view_employee.surname,
           view_employee.name,
           view_employee.patronymic,
           view_employee.birthday,
           UNKNOWN_ARDASS.country, 
           UNKNOWN_ARDASS.area, 
           UNKNOWN_ARDASS.region, 
           UNKNOWN_ARDASS.city
    FROM db2admin.view_employee  
    INNER JOIN db2admin.UNKNOWN_ARDASS 
    ON view_employee.id = UNKNOWN_ARDASS.ID_VIEW_EMPLOYEE; 
 
    select * From view_employee_unknown_adress order by view_employee_unknown_adress.id;
    
    select * From view_employee where view_employee.id_mic is null;
    
    drop view db2admin.view_employee;
                          