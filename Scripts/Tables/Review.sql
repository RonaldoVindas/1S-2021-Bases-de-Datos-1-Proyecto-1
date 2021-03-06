/*==================================================CREACIÓN DE TABLAS======================================================================*/
CREATE TABLE review
(
  review_id NUMBER(8),
  stars NUMBER (1)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS========================================================*/

COMMENT ON TABLE review
IS 'Repository to storage information about review.';

COMMENT ON COLUMN review.review_id
IS 'relationType identification code.';

COMMENT ON COLUMN review.stars
IS 'review stars.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS============================================================*/

ALTER TABLE review
  ADD CONSTRAINT review PRIMARY KEY (review_id)
  USING INDEX
  TABLESPACE pe_ind PCTFREE 20
  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0);

/*==================================================CAMPOS DE AUDITOR??A PARA TABLAS=========================================================*/

ALTER TABLE review
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_review
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS========================================================*/

CREATE OR REPLACE TRIGGER pe.beforeINSERTreview
BEFORE INSERT
ON pe.review
FOR EACH ROW
BEGIN
	:new.review_id := s_review.NEXTVAL;
	:new.creation_date := SYSDATE;
	:new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A REVIEW IS INSERTED', 'REVIEW', 'INSERT');
END beforeINSERTreview;

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEreview
BEFORE UPDATE
ON pe.review
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A REVIEW IS UPDATED', 'REVIEW', 'UPDATE');
END beforeUPDATEreview;

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEreview
BEFORE DELETE
ON pe.review
FOR EACH ROW
BEGIN
	INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A REVIEW IS DELETED', 'REVIEW', 'DELETE');
END beforeDELETEreview;