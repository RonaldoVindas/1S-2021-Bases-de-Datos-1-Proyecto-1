/*==================================================CREACIÓN DE TABLAS======================================================*/
create table Person(
    person_id  Number(9),
    first_name varchar2(50) CONSTRAINT person_firname_nn NOT NULL,
    last_name varchar2(50) CONSTRAINT person_lasname_nn NOT NULL,
    email varchar2(50) CONSTRAINT person_email_nn NOT NULL,
    password varchar2(25) CONSTRAINT person_password_nn NOT NULL,
    phone_number varchar2(8) CONSTRAINT person_phonenum_nn NOT NULL,
    birth_day DATE,
    --age varchar(3),
    persontype_id Number(8)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/
COMMENT ON TABLE Person
IS 'Repository to storage information about people in the database.';

COMMENT ON Column person.person_id
IS 'Person identification code';

COMMENT ON Column person.first_name
IS 'Person first name.';

COMMENT ON Column person.last_name
IS 'Person last name.';

COMMENT ON Column person.email
IS 'Person email.';

COMMENT ON Column person.password
IS 'Person password.';

COMMENT ON Column person.phone_number
IS 'Person phone number.';

COMMENT ON Column person.birth_day
IS 'Person birth day.';

/*COMMENT ON Column person.age
IS 'Person age.';*/

COMMENT ON Column person.persontype_id
IS 'Person type identification.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/
alter table Person
  add constraint pk_person primary key (person_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);

/*==================================================CREACIÓN DE LLAVES FORANEAS======================================================*/
ALTER TABLE Person
ADD CONSTRAINT fk_person_persontype_id  FOREIGN KEY
(persontype_id) REFERENCES persontype(persontype_id );

/*==================================================CAMPOS DE AUDITOR�?A PARA TABLAS======================================================*/
ALTER TABLE Person
ADD creation_date DATE
ADD creation_user varchar2(50)
ADD date_last_modification DATE
ADD user_last_modification varchar2(50);

/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

-- No aplica

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/
CREATE OR REPLACE TRIGGER pe.beforeInsertperson
BEFORE INSERT
ON pe.person
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON IS INSERTED', 'PERSON', 'INSERT');
END beforeInsertperson; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEperson
BEFORE UPDATE
ON pe.person
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON IS UPDATED', 'PERSON', 'UPDATE');
END beforeUPDATEperson;

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEperson
BEFORE DELETE
ON pe.person
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'A PERSON IS DELETED', 'PERSON', 'DELETE');
END beforeDELETEperson;