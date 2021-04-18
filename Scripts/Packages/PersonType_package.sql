Create or replace package control_PersonType is
PROCEDURE insert_PersonType (pname IN VARCHAR2);
PROCEDURE remove_PersonType (pid IN NUMBER);
PROCEDURE update_PersonType(pid IN NUMBER,pname IN VARCHAR2);
FUNCTION getpersontypeId(pname IN VARCHAR2) RETURN NUMBER;
FUNCTION getpersontypeName (pid IN NUMBER) return VARCHAR2;

end control_PersonType;
/
CREATE OR REPLACE PACKAGE BODY control_PersonType IS

PROCEDURE insert_PersonType(pname IN VARCHAR2) AS
BEGIN
	INSERT INTO PersonType(name)
	VALUES(pname);
END insert_PersonType;

ROCEDURE remove_PersonType (pid IN NUMBER) AS
e_invalid_PersonType EXCEPTION;
BEGIN
	DELETE FROM PersonType
	WHERE persontype_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_PersonType;
    END IF;
    EXCEPTION
    WHEN e_invalid_PersonType THEN
        DBMS_OUTPUT.PUT_LINE('No such Person Type.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_PersonType;

PROCEDURE update_PersonType(pid IN NUMBER, pname IN VARCHAR2) AS
e_invalid_PersonType EXCEPTION;
BEGIN
	UPDATE PersonType
	SET persontype_name = pname
	WHERE persontype_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_PersonType;
    END IF;
    EXCEPTION
    WHEN e_invalid_PersonType THEN
        DBMS_OUTPUT.PUT_LINE('No such Person Type.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_PersonType;



FUNCTION getpersontypeId(pname IN varchar2) return number
IS 
    vcId Number(11);
    BEGIN
        SELECT persontype_id
        INTO vcId
        FROM PersonType
        WHERE persontype_name = pname;
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



FUNCTION getpersontypeName(pid IN NUMBER) RETURN VARCHAR2
IS 
    vcName VARCHAR2(20);
    BEGIN
        SELECT persontype_name  
        INTO vcName 
        FROM PersonType
        WHERE persontype_id = pid;
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

end control_PersonType;

