/*==================================================CREACIÓN DE TABLAS======================================================================*/

CREATE TABLE publisher
(
  publisher_id NUMBER (8),
  publisher_name VARCHAR2(50)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS========================================================*/

COMMENT ON TABLE publisher
IS 'Repository to storage information about publishers.';

COMMENT ON COLUMN publisher.publisher_id
IS 'publisher identification code.';

COMMENT ON COLUMN publisher.publisher_name
IS 'publisher name.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS============================================================*/

ALTER TABLE publisher
  ADD CONSTRAINT pk_publisher PRIMARY KEY (publisher_id)
  USING INDEX
  TABLESPACE pe_ind PCTFREE 20
  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0);

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS=========================================================*/

ALTER TABLE publisher
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_publisher
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS========================================================*/

CREATE OR REPLACE TRIGGER pe.beforeINSERTpublisher
BEFORE INSERT
ON pe.publisher
FOR EACH ROW
BEGIN
	:new.publisher_id := s_publisher.NEXTVAL;
	:new.creation_date := SYSDATE;
	:new.creation_user := USER;
END beforeINSERTpublisher;

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEpublisher
BEFORE UPDATE
ON pe.publisher
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEpublisher;