/*Autor: Renzo Barra, 5/25/2021*/

/*======================================TABLE======================================*/

CREATE TABLE PE.SYSTEMLOG (
	SYSTEMLOG_ID INT COMMENT 'SystemLog identification code.',
	DESCRIPTION VARCHAR(150) COMMENT 'SystemLog description.',
	OBJECT VARCHAR(50) COMMENT 'SystemLog reference object.',
	TYPE_CHANGE VARCHAR(50) COMMENT 'SystemLog type of change.',
	SYS_DATE DATETIME,
	CREATION_USER VARCHAR(50)
    );

/*======================================COMMENTS======================================*/

ALTER TABLE PE.SYSTEMLOG  COMMENT 'Repository to storage information about systemLog.';

/*======================================PRIMARY KEY======================================*/

ALTER TABLE PE.SYSTEMLOG
AUTO_INCREMENT = 0,
CHANGE COLUMN SYSTEMLOG_ID SYSTEMLOG_ID INT NOT NULL AUTO_INCREMENT COMMENT 'SystemLog identification code.',
ADD PRIMARY KEY (SYSTEMLOG_ID);

/*======================================TRIGGERS======================================*/
/*INSERT TRIGGER*/
DROP TRIGGER IF EXISTS PE.SYSTEMLOG_BEFORE_INSERT;
DELIMITER $$
USE PE$$
CREATE DEFINER = CURRENT_USER TRIGGER PE.SYSTEMLOG_BEFORE_INSERT BEFORE INSERT ON SYSTEMLOG FOR EACH ROW
	BEGIN
		SET NEW.SYS_DATE = SYSDATE();
		SET NEW.CREATION_USER = USER();
END$$