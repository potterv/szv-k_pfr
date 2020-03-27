DROP TABLE FMS_DATA;
CREATE TABLE FMS_DATA (
	id	INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
	uuid_p	varchar(37),
	uuid_r	varchar(37),
    resident_crimea	varchar(5),
    commentary varchar(254),
    date_load_file_from_fms_xls date
	);
    
DELETE FROM FMS_DATA;
    
ALTER TABLE FMS_DATA
 ADD date_load_file_from_fms_xls date;
 
  ALTER TABLE FMS_DATA
drop snils;
 
 UPDATE FMS_DATA
SET date_load_file_from_fms_xls = '2020-03-12'