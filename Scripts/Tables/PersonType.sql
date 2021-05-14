/*==================================================CREACIÓN DE TABLAS======================================================*/
create table PersonType(
  persontype_id NUMBER(8),
  persontype_name VARCHAR2(50)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE PersonType
IS 'Repository to storage information about the person types in the database.';

COMMENT ON Column PersonType.persontype_id
IS 'Person Type identification code.';

COMMENT ON Column PersonType.persontype_name
IS 'Person Type name.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/
ALTER TABLE PersonType
  ADD CONSTRAINT pk_PersonType PRIMARY KEY (persontype_id)
  USING INDEX
  TABLESPACE pe_ind PCTFREE 20
  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0);

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS======================================================*/


ALTER TABLE PersonType
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_PersonType
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertPersonType
BEFORE INSERT
ON pe.PersonType
FOR EACH ROW
BEGIN
    :new.persontype_id := s_PersonType.nextval;
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON TYPE IS INSERTED', 'PERSON TYPE', 'INSERT');
END beforeInsertPersonType; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEPersonType
BEFORE UPDATE
ON pe.PersonType
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON TYPE IS UPDATED', 'PERSON TYPE', 'UPDATE');
END beforeUPDATEPersonType;

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEPersonType
BEFORE DELETE
ON pe.PersonType
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON TYPE IS DELETED', 'PERSON TYPE', 'DELETE');
END beforeDELETEPersonType;