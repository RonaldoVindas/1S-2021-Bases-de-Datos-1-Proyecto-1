/*==================================================CREACIÓN DE TABLAS======================================================*/
create table ItemHasGenre(
  item_id  Number(8),
  genre_id Number(8)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/
COMMENT ON TABLE ItemHasGenre
IS 'Repository to storage information about the Genres an Item has.';

COMMENT ON Column ItemHasGenre.genre_id
IS 'genre identification code.';

COMMENT ON Column ItemHasGenre.item_id
IS 'item identification code.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/
alter table ItemHasGenre
  add constraint pk_ItemHasGenre primary key (item_id ,genre_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);

/*==================================================CREACIÓN DE LLAVES FORANEAS======================================================*/
ALTER TABLE ItemHasGenre
ADD CONSTRAINT fk_ItemHasGenre_item_id FOREIGN KEY
(item_id) REFERENCES item(item_id);

ALTER TABLE ItemHasGenre
ADD CONSTRAINT fk_ItemHasGenre_genre_id FOREIGN KEY
(genre_id) REFERENCES genre (genre_id);

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS======================================================*/
ALTER TABLE ItemHasGenre
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertItemHasGenre
BEFORE INSERT
ON pe.ItemHasGenre
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'AN ITEM HAS GENRE IS INSERTED', 'ITEM HAS GENRE', 'INSERT');
END beforeInsertItemHasGenre; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEitemHasGenre
BEFORE UPDATE
ON pe.ItemHasGenre
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'AN ITEM HAS GENRE IS UPDATED', 'ITEM HAS GENRE', 'UPDATE');
END beforeUPDATEitemHasGenre;

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEItemHasGenre
BEFORE DELETE
ON pe.ItemHasGenre
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'AN ITEM HAS GENRE IS DELETED', 'ITEM HAS GENRE', 'DELETE');
END beforeDELETEItemHasGenre;