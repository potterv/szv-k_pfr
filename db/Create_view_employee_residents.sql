-- Создание View  для проекта СЗВ-К
CREATE VIEW db2admin.view_employee_residents
     (id,id_mic,snils,uuid_p,uuid_r,surname,name,patronymic,birthday,country, area, region, city,date_load_file_xml,resident_crimea,commentary,date_load_file_from_fms_xls)
     AS SELECT ALL
           view_employee_with_adress.id,
           view_employee_with_adress.id_mic ,
           view_employee_with_adress.snils,
           view_employee_with_adress.uuid_p,
           view_employee_with_adress.uuid_r,
           view_employee_with_adress.surname,
           view_employee_with_adress.name,
           view_employee_with_adress.patronymic,
           view_employee_with_adress.birthday,
           view_employee_with_adress.country, 
          view_employee_with_adress.area, 
           view_employee_with_adress.region, 
           view_employee_with_adress.city,
           view_employee_with_adress.date_load_file_xml,
           fms_data.resident_crimea,
           fms_data.commentary,
           fms_data.date_load_file_from_fms_xls
    FROM db2admin.view_employee_with_adress  
    INNER JOIN db2admin.fms_data 
    ON view_employee_with_adress.uuid_r = fms_data.uuid_r; 
 
    select * From view_employee_residents order by view_employee.id;
    
    select * From view_employee_residents where view_employee.id_mic is null;
    
    drop view db2admin.view_employee_residents;
                          