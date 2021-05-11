/*==================================================CREACIÓN DE TABLAS======================================================*/
create table ItemHasReview(
  item_id  Number(8),
  review_id Number(8)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/
COMMENT ON TABLE ItemHasReview
IS 'Repository to storage information about the review an Item has.';

COMMENT ON Column ItemHasReview.item_id
IS 'item identification code.';

COMMENT ON Column ItemHasReview.review_id
IS 'review identification code.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/
alter table ItemHasReview
  add constraint pk_ItemHasReview primary key (item_id ,review_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);

/*==================================================CREACIÓN DE LLAVES FORANEAS======================================================*/
ALTER TABLE ItemHasReview
ADD CONSTRAINT fk_ItemHasReview_item_id FOREIGN KEY
(item_id) REFERENCES item(item_id);

ALTER TABLE ItemHasReview
ADD CONSTRAINT fk_ItemHasReview_genre_id FOREIGN KEY
(review_id) REFERENCES review(review_id);

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS======================================================*/
ALTER TABLE ItemHasReview
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/
CREATE OR REPLACE TRIGGER pe.beforeInsertItemHasReview
BEFORE INSERT
ON pe.ItemHasReview
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE INSERTA UN ITEM HAS REVIEW', 'ITEM HAS REVIEW', 'INSERT');
END beforeInsertItemHasReview; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEItemHasReview
BEFORE UPDATE
ON pe.ItemHasReview
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE ACTUALIZA UN ITEM HAS REVIEW', 'ITEM HAS REVIEW', 'UPDATE');
END beforeUPDATEItemHasReview;

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEItemHasReview
BEFORE DELETE
ON pe.ItemHasReview
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE BORRA UN ITEM HAS REVIEW', 'ITEM HAS REVIEW', 'DELETE');
END beforeDELETEItemHasReview;