/*==================================================CREACIÓN DE TABLAS======================================================================*/
CREATE TABLE status
(
  status_id NUMBER(8),
  status_name VARCHAR2(50),
  description VARCHAR2(250)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS========================================================*/

COMMENT ON TABLE status
IS 'Repository to storage information about status.';


COMMENT ON COLUMN status.status_id
IS 'status identification code.';


COMMENT ON COLUMN status.status_name
IS 'status name.';


COMMENT ON COLUMN status.description
IS 'status description.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS============================================================*/

ALTER TABLE status
  ADD CONSTRAINT pk_status PRIMARY KEY (status_id)
  USING INDEX
  TABLESPACE pe_ind PCTFREE 20
  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0);

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS=========================================================*/

ALTER TABLE status
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_status
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS========================================================*/

CREATE OR REPLACE TRIGGER pe.beforeINSERTstatus
BEFORE INSERT
ON pe.status
FOR EACH ROW
BEGIN
	:new.status_id := s_status.NEXTVAL;
	:new.creation_date := SYSDATE;
	:new.creation_user := USER;
END beforeINSERTstatus;

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEstatus
BEFORE UPDATE
ON pe.status
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEstatus;