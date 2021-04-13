/*==================================================CREACIÓN DE TABLAS======================================================*/
create table PersonLendItem(
  person1_id  Number(11),
  person2_id  Number(11),
  item_id Number(11),
  lend_date DATE,
  return_date DATE,
  amount_days Number(10)
);
/
/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE PersonLendItem
IS 'Repository to storage information about the items a person lends.';

/

COMMENT ON Column PersonLendItem.person1_id
IS 'Person1 identification code.';

/

COMMENT ON Column PersonLendItem.person2_id
IS 'Person2 identification code.';

/

COMMENT ON Column PersonLendItem.item_id
IS 'Item identification code.';

/

COMMENT ON Column PersonLendItem.lend_date
IS 'Item Lend Date.';

/

COMMENT ON Column PersonLendItem.return_date
IS 'Item Return Date.';

/

COMMENT ON Column PersonLendItem.amount_days
IS 'Total amount of days.';


/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/


alter table PersonLendItem
  add constraint pk_PersonLendItem primary key (person1_id,person2_id,item_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);



/*==================================================CREACIÓN DE LLAVES FORANEAS======================================================*/

ALTER TABLE PersonLendItem
ADD CONSTRAINT fk_PersonLendItem_person1_id FOREIGN KEY
(person1_id) REFERENCES person(person1_id);
/
ALTER TABLE PersonLendItem
ADD CONSTRAINT fk_PersonLendItem_person2_id FOREIGN KEY
(person2_id) REFERENCES person(person2_id);
/
ALTER TABLE PersonLendItem
ADD CONSTRAINT fk_PersonLendItem_item_id FOREIGN KEY
(item_id) REFERENCES item(item_id);




/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS======================================================*/


ALTER TABLE PersonLendItem
ADD creation_date DATE
ADD creation_user VARCHAR(10)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR(10);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

No aplica

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertPersonLendItem
BEFORE INSERT
ON pe.PersonLendItem
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
END beforeInsertPersonLendItem; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEPersonLendItem
BEFORE UPDATE
ON pe.PersonLendItem
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEPersonLendItem; 