/*Autor: Renzo Barra, 5/25/2021*/
CREATE TABLE PE.RELATIONTYPE (
	RELATIONTYPE_ID INT COMMENT 'RelationType identification code.',
	RELATIONTYPE_NAME VARCHAR(50) NOT NULL COMMENT 'RelationType name.',
	CREATION_DATE DATETIME,
	CREATION_USER VARCHAR(50),
	DATE_LAST_MODIFICATION DATETIME,
	USER_LAST_MODIFICATION VARCHAR(50)
    );

ALTER TABLE PE.RELATIONTYPE  COMMENT 'Repository to storage information about relationTypes.';

ALTER TABLE PE.RELATIONTYPE
AUTO_INCREMENT = 0,
CHANGE COLUMN RELATIONTYPE_ID RELATIONTYPE_ID INT NOT NULL AUTO_INCREMENT COMMENT 'RelationType identification code.',
ADD PRIMARY KEY (RELATIONTYPE_ID);

/*======================================TRIGGERS======================================*/
/*INSERT TRIGGER*/
DROP TRIGGER IF EXISTS PE.RELATIONTYPE_BEFORE_INSERT;
DELIMITER $$
USE PE$$
CREATE DEFINER = CURRENT_USER TRIGGER PE.RELATIONTYPE_BEFORE_INSERT BEFORE INSERT ON RELATIONTYPE FOR EACH ROW
	BEGIN
		Set new.creation_date = SYSDATE();
		Set new.creation_user = USER();
		INSERT INTO systemLog( description, object, type_change)
		VALUES('A RELATION TYPE IS INSERTED', 'RELATION TYPE', 'INSERT');
END$$
DELIMITER ;

/*UPDATE TRIGGER*/
DROP TRIGGER IF EXISTS PE.RELATIONTYPE_BEFORE_UPDATE;
DELIMITER $$
USE PE$$
CREATE DEFINER = CURRENT_USER TRIGGER PE.RELATIONTYPE_BEFORE_UPDATE BEFORE UPDATE ON RELATIONTYPE FOR EACH ROW
	BEGIN
		Set new.date_last_modification= SYSDATE();
		Set new.user_last_modification= USER();
		INSERT INTO systemLog(description, object, type_change)
		VALUES('A RELATION TYPE IS UPDATED', 'RELATION TYPE', 'UPDATE');
END$$
DELIMITER;

/*DELETE TRIGGER*/
DROP TRIGGER IF EXISTS PE.RELATIONTYPE_BEFORE_DELETE;
DELIMITER $$
USE PE$$
CREATE DEFINER = CURRENT_USER TRIGGER PE.RELATIONTYPE_BEFORE_DELETE BEFORE DELETE ON RELATIONTYPE FOR EACH ROW
	BEGIN
		INSERT INTO systemLog(description, object, type_change)
		VALUES('A RELATION TYPE IS DELETED', 'RELATION TYPE', 'DELETE');
END$$