-- Создание View  для проекта СЗВ-К
CREATE VIEW db2admin.view_employee
     (id,id_mic,snils,uuid_p,uuid_r,surname,name,patronymic,birthday,country, area, region, city, date_load_file_xml)
     AS SELECT ALL
           EMPLOYEES_FROM_POLICYHOLDER.id,
           EMPLOYEES_FROM_MIC.id,
           EMPLOYEES_FROM_POLICYHOLDER.snils,
           EMPLOYEES_FROM_POLICYHOLDER.uuid_p,
           EMPLOYEES_FROM_POLICYHOLDER.uuid_r,
           EMPLOYEES_FROM_POLICYHOLDER.surname,
           EMPLOYEES_FROM_POLICYHOLDER.name,
           EMPLOYEES_FROM_POLICYHOLDER.patronymic,
           EMPLOYEES_FROM_POLICYHOLDER.birthday,
           EMPLOYEES_FROM_MIC.country, 
           EMPLOYEES_FROM_MIC.area, 
           EMPLOYEES_FROM_MIC.region, 
           EMPLOYEES_FROM_MIC.city,
           EMPLOYEES_FROM_POLICYHOLDER.date_load_file_xml
    FROM db2admin.EMPLOYEES_FROM_MIC  
    RIGHT JOIN db2admin.EMPLOYEES_FROM_POLICYHOLDER 
    ON EMPLOYEES_FROM_MIC.snils = EMPLOYEES_FROM_POLICYHOLDER.snils; 
 
    select * From view_employee order by view_employee.id;
    
    select * From view_employee where view_employee.id_mic is null;
    
    drop view db2admin.view_employee;
                          