/*==================================================CREACIÓN DE TABLAS======================================================================*/
CREATE TABLE systemLog
(
  systemLog_id NUMBER(8),
  description VARCHAR2 (250),
  sys_date DATE,
  time TIME,
  object VARCHAR2 (100),
  type_change VARCHAR2 (100)
  person_id NUMBER (8)
);
/
/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS========================================================*/

COMMENT ON TABLE systemLog
IS 'Repository to storage information about systemLog.';

/

COMMENT ON COLUMN systemLog.systemLog_id
IS 'systemLog identification code.';

/

COMMENT ON COLUMN systemLog.description
IS 'systemLog description.';

/

COMMENT ON COLUMN systemLog.sys_date
IS 'systemLog system date.';

/

COMMENT ON COLUMN systemLog.time
IS 'systemLog time.';

/

COMMENT ON COLUMN systemLog.object
IS 'systemLog reference object.';

/

COMMENT ON COLUMN systemLog.type_change
IS 'systemLog type of change.';

/

COMMENT ON COLUMN systemLog.person_id
IS 'systemLog person referenced.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS============================================================*/


ALTER TABLE systemLog
  ADD CONSTRAINT pk_systemLog PRIMARY KEY (systemlog_id)
  USING INDEX
  TABLESPACE pe_ind PCTFREE 20
  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0);

/*==================================================CREACIÓN DE LLAVES FORANEAS=============================================================*/

ALTER TABLE systemLog
ADD CONSTRAINT fk_systemLog_person_id FOREIGN KEY
(person_id) REFERENCES person(person_id);

/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS=========================================================*/

ALTER TABLE systemLog
ADD creation_date DATE
ADD creation_user VARCHAR2 (100)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2 (100);

/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_systemLog
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS========================================================*/

CREATE OR REPLACE TRIGGER pe.beforeINSERTsystemLog
BEFORE INSERT
ON pe.systemLog
FOR EACH ROW
BEGIN
	:new.systemLog_id := s_systemLog.NEXTVAL;
	:new.creation_date := SYSDATE;
	:new.creation_user := USER;
END beforeINSERTsystemLog;

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEsystemLog
BEFORE UPDATE
ON pe.systemLog
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEsystemLog;