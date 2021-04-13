/*==================================================CREACIÓN DE TABLAS======================================================*/
create table Person(
  person_id  Number(11),
  first_name varchar(20) CONSTRAINT person_firname_nn NOT NULL,
  last_name varchar(20) CONSTRAINT person_lasname_nn NOT NULL,
  email varchar2(40) CONSTRAINT person_email_nn NOT NULL,
  password varchar2(15) CONSTRAINT person_password_nn NOT NULL,
  phone_number varchar(15) CONSTRAINT person_phonenum_nn NOT NULL,
  birth_day DATE,
  age varchar(3),
  persontype_id Number(11)
);

/

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE Person
IS 'Repository to storage information about people in the database.';

/
COMMENT ON Column person.person_id
IS 'Person identification code';

/

COMMENT ON Column person.firts_name
IS 'Person first name.';

/

COMMENT ON Column person.last_name
IS 'Person last name.';

/

COMMENT ON Column person.email
IS 'Person email.';

/

COMMENT ON Column person.password
IS 'Person password.';

/

COMMENT ON Column person.phone_number
IS 'Person phone number.';

/

COMMENT ON Column person.birth_day
IS 'Person birth day.';

/

COMMENT ON Column person.age
IS 'Person age.';

/

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

/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS======================================================*/


ALTER TABLE Person
ADD creation_date DATE
ADD creation_user VARCHAR(10)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR(10);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

No aplica

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertperson
BEFORE INSERT
ON pe.person
FOR EACH ROW
BEGIN
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
END beforeInsertperson; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEperson
BEFORE UPDATE
ON pe.person
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEperson; 



