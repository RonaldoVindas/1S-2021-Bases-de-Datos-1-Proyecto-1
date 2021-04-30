/*==================================================CREACIÓN DE TABLAS======================================================*/
create table Item(
  item_id NUMBER(11),
  title VARCHAR2(50) CONSTRAINT item_title_nn NOT NULL,
  edition VARCHAR(30),
  cover_image BLOB, ---------------------------TIPO DE DATO DE IMAGEN----------AVERIGUAR BIEN!
  barcode VARCHAR(12) CONSTRAINT item_barcode_nn NOT NULL,
  itemtype_id NUMBER(11),
  status_id NUMBER(8),
  publisher_id NUMBER(8),
  genre_id NUMBER(11)  
);
/

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE Item
IS 'Repository to storage information about the items in the database.';

/

COMMENT ON Column Item.item_id
IS 'Item identification code.';

/

COMMENT ON Column Item.edition
IS 'Item edition.';

/


COMMENT ON Column Item.cover_image
IS 'Item cover image.';


/

COMMENT ON Column Item.barcode
IS 'Item barcode.';

/


COMMENT ON Column Item.itemtype_id
IS 'Item type identification.';

/

COMMENT ON Column Item.status_id
IS 'Item status identification.';

/


COMMENT ON Column Item.genre_id
IS 'Item genre identification.';

/

COMMENT ON Column Item.publisher_id
IS 'Item publisher identification.';


/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/


alter table Item
  add constraint pk_Item primary key (item_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);



/*==================================================CREACIÓN DE LLAVES FORANEAS======================================================*/

ALTER TABLE Item
ADD CONSTRAINT fk_Item_itemtype_id FOREIGN KEY
(itemtype_id) REFERENCES ItemType (itemtype_id);
/
ALTER TABLE Item
ADD CONSTRAINT fk_Item_status_id FOREIGN KEY
(status_id) REFERENCES status(status_id);
/
ALTER TABLE Item
ADD CONSTRAINT fk_Item_publisher_id FOREIGN KEY
(publisher_id) REFERENCES publisher(publisher_id);
/
ALTER TABLE Item
ADD CONSTRAINT fk_Item_genre_id FOREIGN KEY
(genre_id) REFERENCES genre(genre_id);



/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS======================================================*/


ALTER TABLE Item
ADD creation_date DATE
ADD creation_user VARCHAR(10)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR(10);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

No aplica

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertItem
BEFORE INSERT
ON pe.Item
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
END beforeInsertItem; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEItem
BEFORE UPDATE
ON pe.Item
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEItem; 