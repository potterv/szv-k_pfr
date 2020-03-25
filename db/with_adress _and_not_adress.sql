select 
table1.*
From
(

select * from (

    Select EMPLOYEES_FROM_POLICYHOLDER.id,
           EMPLOYEES_FROM_MIC.id as id_mic,
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
           EMPLOYEES_FROM_MIC.city
    FROM db2admin.EMPLOYEES_FROM_MIC  
    RIGHT JOIN db2admin.EMPLOYEES_FROM_POLICYHOLDER 
    ON EMPLOYEES_FROM_MIC.snils = EMPLOYEES_FROM_POLICYHOLDER.snils order by EMPLOYEES_FROM_POLICYHOLDER.id) 
    where id_mic is null
UNION ALL
    select * from (

    Select EMPLOYEES_FROM_POLICYHOLDER.id,
           EMPLOYEES_FROM_MIC.id as id_mic,
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
           EMPLOYEES_FROM_MIC.city
    FROM db2admin.EMPLOYEES_FROM_MIC  
    RIGHT JOIN db2admin.EMPLOYEES_FROM_POLICYHOLDER 
    ON EMPLOYEES_FROM_MIC.snils = EMPLOYEES_FROM_POLICYHOLDER.snils order by EMPLOYEES_FROM_POLICYHOLDER.id) 
    where id_mic is not null
    order by id) as table1;
    
    
    SELECT City FROM Customers
UNION ALL
SELECT City FROM Suppliers
ORDER BY City;