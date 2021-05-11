create table loan_history(
  loan_history_id Number(8),
  person1_id  Number(9),
  person2_id  Number(9),
  item_id Number(8),
  lend_date DATE,
  return_date DATE,
  amount_days Number(8),
  tolerance_days_yellow Number(8),
  tolerance_days_red Number(8)
);

/*==================================================COMENTARIOS EN TABLAS Y COLUMNAS======================================================*/

COMMENT ON TABLE loan_history
IS 'Repository to storage information about the items a person loan_history.';

COMMENT ON Column loan_history.loan_history_id 
IS 'loan_history  identification code.';

COMMENT ON Column loan_history.person1_id
IS 'Person1 identification code.';

COMMENT ON Column loan_history.person2_id
IS 'Person2 identification code.';

COMMENT ON Column loan_history.item_id
IS 'Item identification code.';

COMMENT ON Column loan_history.return_date
IS 'Item Return Date.';

COMMENT ON Column loan_history.amount_days
IS 'Total amount of days.';

COMMENT ON Column loan_history.tolerance_days_yellow
IS 'Item Return Tolerance Days Yellow.';

COMMENT ON Column loan_history.tolerance_days_red
IS 'Item Return Tolerance Days Red.';

/*==================================================CREACIÓN DE LLAVES PRIMARIAS======================================================*/

alter table loan_history
  add constraint pk_loan_history primary key (loan_history_id)
  using index
  tablespace pe_ind pctfree 20
  storage (initial 10k next 10k pctincrease 0);
  
/*==================================================CAMPOS DE AUDITORÃ?A PARA TABLAS======================================================*/
ALTER TABLE loan_history
ADD creation_date DATE
ADD creation_user VARCHAR2(50)
ADD date_last_modification DATE
ADD user_last_modification VARCHAR2(50);

/*==================================================CREACIÃ“N DE SECUENCIAS PARA TABLAS======================================================*/
CREATE SEQUENCE s_loan_history
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999
NOCACHE
NOCYCLE;

/*==================================================CREACIÃ“N DE TRIGGERS PARA TABLAS======================================================*/

CREATE OR REPLACE TRIGGER pe.beforeInsertloan_history
BEFORE INSERT
ON pe.loan_history
FOR EACH ROW
BEGIN
    :new.loan_history_id := s_loan_history.nextval;
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE INSERTA UN LOAN HISTORY', 'LOAN HISTORY', 'INSERT');
END beforeInsertloan_history; 

/

CREATE OR REPLACE TRIGGER pe.beforeUPDATEloan_history
BEFORE UPDATE
ON pe.loan_history
FOR EACH ROW
BEGIN
    :new.date_last_modification:= SYSDATE;
    :new.user_last_modification:= USER;
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE ACTUALIZA UN LOAN HISTORY', 'LOAN HISTORY', 'UPDATE');
END beforeUPDATEloan_history;

/

CREATE OR REPLACE TRIGGER pe.beforeDELETEloan_history
BEFORE DELETE
ON pe.loan_history
FOR EACH ROW
BEGIN
    INSERT INTO systemLog(systemLog_id, description, object, type_change)
    VALUES(s_systemlog.NEXTVAL, 'SE BORRA UN LOAN HISTORY', 'LOAN HISTORY', 'DELETE');
END beforeDELETEloan_history; 