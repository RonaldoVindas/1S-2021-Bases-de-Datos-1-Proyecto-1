/*==================================================CREACIÃ“N DE TABLAS======================================================*/
create table Item(
    item_id NUMBER(8),
    title VARCHAR2(50) CONSTRAINT item_title_nn NOT NULL,
    edition VARCHAR2(30),
    cover_image BLOB, ---------------------------TIPO DE DATO DE IMAGEN----------AVERIGUAR BIEN!
    barcode VARCHAR2(12) CONSTRAINT item_barcode_nn NOT NULL,
    itemtype_id NUMBER(8),
    status_id NUMBER(8),
    publisher_id NUMBER(8)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/
COMMENT ON TABLE Item
IS 'Repository to storage information about the items in the database.';

COMMENT ON Column Item.item_id
IS 'Item identification code.';

COMMENT ON Column Item.edition
IS 'Item edition.';

COMMENT ON Column Item.cover_image
IS 'Item cover image.';

COMMENT ON Column Item.barcode
IS 'Item barcode.';

COMMENT ON Column Item.itemtype_id
IS 'Item type identification.';

COMMENT ON Column Item.status_id
IS 'Item status identification.';

COMMENT ON Column Item.publisher_id
IS 'Item publisher identification.';

/*==================================================CREACIÃ“N DE LLAVES PRIMARIAS======================================================*/
alter table Item
  add constraint pk_Item primary key (item_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);

/*==================================================CREACIÃ“N DE LLAVES FORANEAS======================================================*/
ALTER TABLE Item
ADD CONSTRAINT fk_Item_itemtype_id FOREIGN KEY
(itemtype_id) REFERENCES ItemType (itemtype_id);

ALTER TABLE Item
ADD CONSTRAINT fk_Item_status_id FOREIGN KEY
(status_id) REFERENCES status(status_id);

ALTER TABLE Item
ADD CONSTRAINT fk_Item_publisher_id FOREIGN KEY
(publisher_id) REFERENCES publisher(publisher_id);

/*==================================================CAMPOS DE AUDITORÃ?A PARA TABLAS======================================================*/
ALTER TABLE Item
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÃ“N DE SECUENCIAS PARA TABLAS======================================================*/
CREATE SEQUENCE s_item
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÃ“N DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertItem
BEFORE INSERT
ON pe.Item
FOR EACH ROW
BEGIN
    :new.item_id := s_item.nextval;
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A ITEM IS INSERTED', 'ITEM', 'INSERT');
END beforeInsertItem; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEItem
BEFORE UPDATE
ON pe.Item
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A ITEM IS UPDATED', 'ITEM', 'UPDATE');
END beforeUPDATEItem;

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEItem
BEFORE DELETE
ON pe.Item
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A ITEM IS DELETED', 'ITEM', 'DELETE');
END beforeDELETEItem;