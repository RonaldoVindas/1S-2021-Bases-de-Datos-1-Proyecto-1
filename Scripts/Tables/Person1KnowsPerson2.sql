/*==================================================CREACIÓN DE TABLAS======================================================*/
create table Person1KnowsPerson2(
  person1_id  Number(11),
  person2_id Number(11),
  relationtype_id Number(11)

);
/
/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE Person1KnowsPerson2
IS 'Repository to storage information about relationships between people in the database.';

/
COMMENT ON Column Person1KnowsPerson2.person1_id
IS 'Person 1 identification code';

/

COMMENT ON Column Person1KnowsPerson2.person2_id
IS 'Person 2 identification code.';

/

COMMENT ON Column Person1KnowsPerson2.relationtype_id
IS 'Relation Type identification code.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/


alter table Person1KnowsPerson2
  add constraint pk_Person1KnowsPerson2 primary key (person1_id ,person2_id, relationtype_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);



/*==================================================CREACIÓN DE LLAVES FORANEAS======================================================*/

ALTER TABLE Person1KnowsPerson2
ADD CONSTRAINT fk_Per1KnowsPer2_person1id FOREIGN KEY
(person1_id) REFERENCES person(person1_id);
/
ALTER TABLE Person1KnowsPerson2
ADD CONSTRAINT fk_Per1KnowsPer2_person2id FOREIGN KEY
(person2_id) REFERENCES person(person_id);
/
ALTER TABLE Person1KnowsPerson2
ADD CONSTRAINT fk_Per1KnowsPer2_relationid FOREIGN KEY
(relationtype_id) REFERENCES relationtype(relationtype_id);





/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS======================================================*/


ALTER TABLE Person1KnowsPerson2
ADD creation_date DATE
ADD creation_user VARCHAR(10)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR(10);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

No aplica

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertPer1knowPer2
BEFORE INSERT
ON pe.Person1KnowsPerson2
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
END beforeInsertPer1knowPer2; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEPer1knowPer2
BEFORE UPDATE
ON pe.Person1KnowsPerson2
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEPer1knowPer2; 
