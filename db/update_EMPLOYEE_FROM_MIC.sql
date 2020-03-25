-- Удаление существующей таблицы  EMPLOYEES_FROM_MIC
DROP TABLE EMPLOYEES_FROM_MIC;
--Создание новой таблицы  EMPLOYEES_FROM_MIC
CREATE TABLE EMPLOYEES_FROM_MIC (
	id	INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
	SNILS	varchar(15),
	surname	varchar(100),
	name	varchar(100),
	patronymic	varchar(100),
	birthday	date,
	sex	varchar(1),
	country	varchar(254),
	area	varchar(254),
	region	varchar(254),
	city	varchar(254),
	numberInsured	varchar(12),
	nameInsured	varchar(254));
-- Перенос  данных из полученой  таблицы от МАЦа в оптимизировнную внутреннюю таблицу
INSERT INTO EMPLOYEES_FROM_MIC (SNILS, surname,name,patronymic, country, area, region, city, numberInsured)
select SNILS, surname,name,patronymic, country, area, region, city, numberInsured  from HUMEN
-- индексировние по СНИЛС
create unique index snils_indx_mic on
db2admin.EMPLOYEES_FROM_MIC(SNILS);

ALTER TABLE db2admin.EMPLOYEES_FROM_MIC
ALTER COLUMN ARE varchar(200);