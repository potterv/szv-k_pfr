--удаление таблицы EMPLOYEES_FROM_POLICYHOLDER
DROP TABLE UNKNOWN_ARDASS;

--Создание таблицы EMPLOYEES_FROM_POLICYHOLDER
 CREATE TABLE UNKNOWN_ARDASS (
	id	INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
	id_view_employee	INTEGER,
	uuid_p	varchar(37),
	uuid_r	varchar(37),
    country	varchar(254),
	area	varchar(254),
	region	varchar(254),
	city	varchar(254)
	);
--Очистка таблицы EMPLOYEES_FROM_POLICYHOLDER
DELETE FROM UNKNOWN_ARDASS;

INSERT INTO UNKNOWN_ARDASS (id_view_employee,uuid_p, uuid_r,country, area, region, city)
select view_employee.id, uuid_p, uuid_r,country, area, region, city   from view_employee where view_employee.id_mic is null;

create unique index snils_indx on
db2admin.EMPLOYEES_FROM_POLICYHOLDER(snils);