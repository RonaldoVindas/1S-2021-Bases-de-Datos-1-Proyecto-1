/*==================================================CREACIÓN DE TABLESPACES======================================================*/
/*TABLESPACE para Parameter*/

CREATE TABLESPACE par_data
DATAFILE 'C:\app\Ronaldo\oradata\DBRONALDO\pardata01.dbf'          /*Cuidado con la ruta de ubicación de fichero - Cambiar de acuerdo a su máquina*/
SIZE 10M
REUSE
AUTOEXTEND ON
NEXT 512K
MAXSIZE 200M;

CREATE TABLESPACE par_ind
DATAFILE 'C:\app\Ronaldo\oradata\DBRONALDO\parind01.dbf'         /*Cuidado con la ruta de ubicación de fichero - Cambiar de acuerdo a su máquina*/
SIZE 10M
REUSE
AUTOEXTEND ON
NEXT 512K
MAXSIZE 200M;

/*==================================================CREACIÓN DE ESQUEMAS======================================================*/

CREATE USER PAR
IDENTIFIED BY PAR
DEFAULT TABLESPACE par_data
QUOTA 10M ON par_data
TEMPORARY TABLESPACE temp
QUOTA 5M ON system;

/*==================================================PERMISOS DE ESQUEMAS======================================================*/
/*PERMISOS DE PAR*/

GRANT CONNECT TO par;
GRANT CREATE SESSION TO par;
GRANT CREATE TABLE TO par;

GRANT CREATE SEQUENCE TO par;
GRANT CREATE ANY TRIGGER, ALTER ANY TRIGGER, DROP ANY TRIGGER TO par;
GRANT CREATE PROCEDURE TO par;
GRANT CREATE JOB TO par;

ALTER USER par QUOTA UNLIMITED ON par_data;
ALTER USER par QUOTA UNLIMITED ON par_ind;