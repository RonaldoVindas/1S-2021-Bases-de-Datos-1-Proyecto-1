/*==================================================CREACIÓN DE TABLAS======================================================*/
create table ItemType(
  itemtype_id Number(8),
  itemType_name VARCHAR2(50)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/
COMMENT ON TABLE ItemType
IS 'Repository to storage information about ItemType.';

COMMENT ON Column ItemType.itemtype_id
IS 'itemtype identification code.';

COMMENT ON Column itemtype.itemtype_id
IS 'itemtype name.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/
alter table ItemType
  add constraint pk_ItemType primary key (itemtype_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS======================================================*/
ALTER TABLE itemtype
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/
CREATE SEQUENCE s_ItemType
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertItemType
BEFORE INSERT
ON pe.ItemType
FOR EACH ROW
BEGIN
    :new.itemtype_id := s_ItemType.nextval;
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE INSERTA UN ITEM TYPE', 'ITEM TYPE', 'INSERT');
END beforeInsertItemType; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEItemType
BEFORE UPDATE
ON pe.ItemType
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE ACTUALIZA UN ITEM TYPE', 'ITEM TYPE', 'UPDATE');
END beforeUPDATEItemType; 

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEItemType
BEFORE DELETE
ON pe.ItemType
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE BORRA UN ITEM TYPE', 'ITEM TYPE', 'DELETE');
END beforeDELETEItemType;