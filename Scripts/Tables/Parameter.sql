/*==================================================CREACIÓN DE TABLAS======================================================*/
create table Parameter(
  Parameter_id  Number(11),
  value Number(10),
  name varchar2(40)
);
/
/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE Parameter
IS 'Repository to storage information about Parameters.';

/

COMMENT ON Column Parameter.Parameter_id
IS 'Parameter identification code.';

/

COMMENT ON Column Parameter.value
IS 'Parameter value.';

/
COMMENT ON Column Parameter.name
IS 'Parameter name.';


/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/


alter table Parameter
  add constraint pk_Parameter primary key (Parameter_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);


/*==================================================CAMPOS DE AUDITORÍA PARA TABLAS======================================================*/


ALTER TABLE Parameter
ADD creation_date DATE
ADD creation_user VARCHAR(10)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR(10);



/*==================================================CREACIÓN DE SECUENCIAS PARA TABLAS======================================================*/

CREATE SEQUENCE s_Parameter
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÓN DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER par.beforeInsertParameter
BEFORE INSERT
ON par.Parameter
FOR EACH ROW
BEGIN
    :new.Parameter_id := s_Parameter.nextval;
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
END beforeInsertParameter; 

/

CREATE OR REPLACE TRIGGER par.beforeUPDATEParameter
BEFORE UPDATE
ON par.Parameter
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
END beforeUPDATEParameter; 