Create or replace package control_status is

PROCEDURE insert_status (pname IN VARCHAR2, pdescription IN VARCHAR2);
PROCEDURE remove_status (pid IN NUMBER);
PROCEDURE update_status(pid IN NUMBER,pname IN VARCHAR2,pdescription IN VARCHAR2);

FUNCTION getstatusId(pname in varchar2) return number;
FUNCTION getstatusName(pid IN NUMBER) RETURN VARCHAR2;
FUNCTION getstatusDescription(pid IN NUMBER) RETURN VARCHAR2;

end control_status;

/

CREATE OR REPLACE PACKAGE BODY control_status IS

PROCEDURE insert_status (pname IN VARCHAR2, pdescription IN VARCHAR2) AS
BEGIN
	INSERT INTO status(status_name, description)
	VALUES(pname, pdescription);
END insert_status;

PROCEDURE remove_status (pid IN NUMBER) AS
e_invalid_status EXCEPTION;
BEGIN
	DELETE FROM status
	WHERE status_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_status;
    END IF;
    EXCEPTION
    WHEN e_invalid_status THEN
        DBMS_OUTPUT.PUT_LINE('No such Status.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_status;

PROCEDURE update_status (pid IN NUMBER,pname IN VARCHAR2,pdescription IN VARCHAR2) AS
e_invalid_status EXCEPTION;
BEGIN
	UPDATE status
	SET status_name = pname,
        description = pdescription
	WHERE status_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_status;
    END IF;
    EXCEPTION
    WHEN e_invalid_status THEN
        DBMS_OUTPUT.PUT_LINE('No such Status.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_status;


FUNCTION getstatusId(pname in varchar2) return number
IS 
    vcId NUMBER(8);
    BEGIN
        SELECT status_id
        INTO vcId
        FROM status
        WHERE status_name = pname;
        RETURN (vcId);
        EXCEPTION
            WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE ('Your SELECT statement retrieved multiple rows.');
            WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE ('Could not find a register with the name||pcnombre.');
            WHEN STORAGE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE ('PL/SQL ran out of memory or memory is corrupted.');
            WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE ('An arithmetic, conversion, truncation, or size constraint error ocurred.');
            WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE ('Unexpected error.');
    END;
    

FUNCTION getstatusName(pid IN NUMBER) RETURN VARCHAR2

IS 
    vcName VARCHAR2(100);
    BEGIN
        SELECT status_name
        INTO vcName
        FROM status
        WHERE status_id = pid;
        RETURN (vcName);
        EXCEPTION
            WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE ('Your SELECT statement retrieved multiple rows.');
            WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE ('Could not find a register with the name||pcnombre.');
            WHEN STORAGE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE ('PL/SQL ran out of memory or memory is corrupted.');
            WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE ('An arithmetic, conversion, truncation, or size constraint error ocurred.');
            WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE ('Unexpected error.');
    END;

FUNCTION getstatusDescription(pid IN NUMBER) RETURN VARCHAR2
IS 
    vcDescription VARCHAR2(100);
    BEGIN
        SELECT description
        INTO vcDescription
        FROM status
        WHERE status_id = pid;
        RETURN (vcDescription);
        EXCEPTION
            WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE ('Your SELECT statement retrieved multiple rows.');
            WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE ('Could not find a register with the name||pcnombre.');
            WHEN STORAGE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE ('PL/SQL ran out of memory or memory is corrupted.');
            WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE ('An arithmetic, conversion, truncation, or size constraint error ocurred.');
            WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE ('Unexpected error.');
    END;

end control_status;