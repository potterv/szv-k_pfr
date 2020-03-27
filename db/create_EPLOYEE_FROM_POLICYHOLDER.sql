--удаление таблицы EMPLOYEES_FROM_POLICYHOLDER
DROP TABLE EMPLOYEES_FROM_POLICYHOLDER;

--Создание таблицы EMPLOYEES_FROM_POLICYHOLDER
 CREATE TABLE EMPLOYEES_FROM_POLICYHOLDER (
	id	INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
	uuid_p	varchar(37),
	uuid_r	varchar(37),
    SNILS	varchar(15),
	surname	varchar(100),
	name	varchar(100),
	patronymic	varchar(100),
	birthday	date,
	residencecrimea	varchar(5),
	date_load_file_xml date
	);
--Очистка таблицы EMPLOYEES_FROM_POLICYHOLDER
DELETE FROM EMPLOYEES_FROM_POLICYHOLDER;


create unique index snils_indx on
db2admin.EMPLOYEES_FROM_POLICYHOLDER(snils);

ALTER TABLE EMPLOYEES_FROM_POLICYHOLDER
 ADD date_load_file_xml date;
 
 
 UPDATE EMPLOYEES_FROM_POLICYHOLDER
SET date_load_file_xml = '2020-03-25'