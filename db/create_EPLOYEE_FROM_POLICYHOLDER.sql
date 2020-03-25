--удаление таблицы EMPLOYEES_FROM_POLICYHOLDER
DROP TABLE EMPLOYEES_FROM_POLICYHOLDER;

--Создание таблицы EMPLOYEES_FROM_POLICYHOLDER
 CREATE TABLE EMPLOYEES_FROM_POLICYHOLDER (
	id	INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
	id_humen	INTEGER,
	uuid_p	varchar(37),
	uuid_r	varchar(37),
    SNILS	varchar(15),
	surname	varchar(100),
	name	varchar(100),
	patronymic	varchar(100),
	birthday	date,
	residencecrimea	varchar(5)
	);
--Очистка таблицы EMPLOYEES_FROM_POLICYHOLDER
DELETE FROM EMPLOYEES_FROM_POLICYHOLDER;

create unique index snils_indx on
db2admin.EMPLOYEES_FROM_POLICYHOLDER(snils);