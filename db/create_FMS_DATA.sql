DROP TABLE FMS_DATA;
CREATE TABLE FMS_DATA (
	id	INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
	snils varchar(37),
    uuid_p	varchar(37),
	uuid_r	varchar(37),
    resident_crimea	varchar(5),
    commentary varchar(254)
	);
    
    DELETE FROM FMS_DATA;