/*==================================================CREACIÓN DE TABLAS======================================================*/
create table PersonType(
  persontype_id Number(11),
  persontype_name varchar2(20),

);
/
/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE PersonType
IS 'Repository to storage information about the person types in the database.';

/

COMMENT ON Column PersonLendItem.persontype_id
IS 'Person Type identification code.';

/

COMMENT ON Column PersonLendItem.persontype_name
IS 'Person Type name.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/


alter table PersonType
  add constraint pk_PersonType primary key (persontype_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);


/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS======================================================*/


ALTER TABLE PersonType
ADD creation_date DATE
ADD creation_user VARCHAR(10)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR(10);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_PersonType
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 999999999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertPersonType
BEFORE INSERT
ON pe.PersonType
FOR EACH ROW
BEGIN
    :new.persontype_id := s_PersonType.nextval;
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
END beforeInsertPersonType; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEPersonType
BEFORE UPDATE
ON pe.PersonType
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEPersonType; 