/*==================================================CREACIÓN DE TABLESPACES======================================================*/
/*TABLESPACE para Person*/

CREATE TABLESPACE pe_data
DATAFILE 'C:\app\Ronaldo\oradata\DBRONALDO\pedata01.dbf'          /*Cuidado con la ruta de ubicación de fichero - Cambiar de acuerdo a su máquina*/
SIZE 10M
REUSE
AUTOEXTEND ON
NEXT 512K
MAXSIZE 200M;

CREATE TABLESPACE pe_ind
DATAFILE 'C:\app\Ronaldo\oradata\DBRONALDO\peind01.dbf'         /*Cuidado con la ruta de ubicación de fichero - Cambiar de acuerdo a su máquina*/
SIZE 10M
REUSE
AUTOEXTEND ON
NEXT 512K
MAXSIZE 200M;

/*==================================================CREACIÓN DE ESQUEMAS======================================================*/

CREATE USER PE
IDENTIFIED BY PE
DEFAULT TABLESPACE pe_data
QUOTA 10M ON pe_data
TEMPORARY TABLESPACE temp
QUOTA 5M ON system;

/*==================================================PERMISOS DE ESQUEMAS======================================================*/
/*PERMISOS DE PE*/

GRANT CONNECT TO pe;
GRANT CREATE SESSION TO pe;
GRANT CREATE TABLE TO pe;

GRANT CREATE SEQUENCE TO pe;
GRANT CREATE ANY TRIGGER, ALTER ANY TRIGGER, DROP ANY TRIGGER TO pe;
GRANT CREATE PROCEDURE TO pe;
GRANT CREATE JOB TO pe;

ALTER USER pe QUOTA UNLIMITED ON pe_data;
ALTER USER pe QUOTA UNLIMITED ON pe_ind;