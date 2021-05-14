/*==================================================CREACIÓN DE TABLAS======================================================*/
create table PersonHasItem(
  person_id  Number(9),
  item_id Number(8)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/
COMMENT ON TABLE PersonHasItem
IS 'Repository to storage information the items a person has.';

COMMENT ON Column PersonHasItem.person_id
IS 'Person identification code.';

COMMENT ON Column PersonHasItem.item_id
IS 'Item identification code.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/
alter table PersonHasItem
  add constraint pk_PersonHasItem primary key (person_id ,item_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);

/*==================================================CREACIÓN DE LLAVES FORANEAS======================================================*/
ALTER TABLE PersonHasItem
ADD CONSTRAINT fk_PersonHasItem_person_id FOREIGN KEY
(person_id) REFERENCES person(person_id);
/
ALTER TABLE PersonHasItem
ADD CONSTRAINT fk_PersonHasItem_item_id FOREIGN KEY
(item_id) REFERENCES item(item_id);

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS======================================================*/
ALTER TABLE PersonHasItem
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

-- No aplica

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertPersonHasItem
BEFORE INSERT
ON pe.PersonHasItem
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON HAS ITEM IS INSERTED', 'PERSON HAS ITEM', 'INSERT');
END beforeInsertPersonHasItem; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEPersonHasItem
BEFORE UPDATE
ON pe.PersonHasItem
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON HAS ITEM IS UPDATED', 'PERSON HAS ITEM', 'UPDATE');
END beforeUPDATEPersonHasItem; 

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEPersonHasItem
BEFORE DELETE
ON pe.PersonHasItem
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON HAS ITEM IS DELETED', 'PERSON HAS ITEM', 'DELETE');
END beforeDELETEPersonHasItem;