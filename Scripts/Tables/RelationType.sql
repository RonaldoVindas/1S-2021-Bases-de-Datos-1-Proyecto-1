/*==================================================CREACIÓN DE TABLAS======================================================================*/

CREATE TABLE relationType
(
  relationType_id NUMBER (8),
  relationType_name VARCHAR2 (100)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS========================================================*/

COMMENT ON TABLE relationType
IS 'Repository to storage information about relationTypes.';

/

COMMENT ON COLUMN relationType.relationType_id
IS 'RelationType identification code.';

/

COMMENT ON COLUMN relationType.relationType_name
IS 'RelationType name.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS============================================================*/

ALTER TABLE relationType
  ADD CONSTRAINT pk_relationType PRIMARY KEY (relationtype_id)
  USING INDEX
  TABLESPACE pe_ind PCTFREE 20
  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0);

/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS=========================================================*/

ALTER TABLE relationType
ADD creation_date DATE
ADD creation_user VARCHAR2 (100)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2 (100);

/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_relationType
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS========================================================*/

CREATE OR REPLACE TRIGGER pe.beforeINSERTrelationType
BEFORE INSERT
ON pe.relationType
FOR EACH ROW
BEGIN
	:new.relationType_id := s_relationType.NEXTVAL;
	:new.creation_date := SYSDATE;
	:new.creation_user := USER;
END beforeINSERTrelationType;

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATErelationType
BEFORE UPDATE
ON pe.relationType
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATErelationType;