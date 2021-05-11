Create or replace package control_relationtype is

PROCEDURE insert_relationtype (pname IN VARCHAR2);
PROCEDURE remove_relationtype (pid IN NUMBER);
PROCEDURE update_relationtype (pid IN NUMBER, pname IN VARCHAR2);


FUNCTION getrelationtypeId(pname IN VARCHAR2) RETURN NUMBER;
FUNCTION getrelationtypeName(pid IN NUMBER) RETURN VARCHAR2;

end control_relationtype;

/

CREATE OR REPLACE PACKAGE BODY control_relationtype IS

PROCEDURE insert_relationtype (pname IN VARCHAR2) AS
BEGIN
	INSERT INTO relationtype(relationtype_name)
	VALUES(pname); 
    COMMIT;  
END insert_relationtype;

PROCEDURE remove_relationtype (pid IN NUMBER) AS
e_invalid_relationtype EXCEPTION;
BEGIN
	DELETE FROM relationtype
	WHERE relationtype_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_relationtype;
    END IF;
    EXCEPTION
    WHEN e_invalid_relationtype THEN
        DBMS_OUTPUT.PUT_LINE('No such Relation Type.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_relationtype;

PROCEDURE update_relationtype (pid IN NUMBER, pname IN VARCHAR2) AS
e_invalid_relationtype EXCEPTION;
BEGIN
	UPDATE relationtype
	SET relationtype_name = pname 
	WHERE relationtype_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_relationtype;
    END IF;
    EXCEPTION
    WHEN e_invalid_relationtype THEN
        DBMS_OUTPUT.PUT_LINE('No such Relation Type.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_relationtype;

FUNCTION getrelationtypeId(pname IN VARCHAR2) RETURN NUMBER
IS 
    vcId NUMBER(8);
    BEGIN
        SELECT relationtype_id
        INTO vcId
        FROM relationtype
        WHERE relationtype_name = pname;
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
    

FUNCTION getrelationtypeName(pid IN NUMBER) RETURN VARCHAR2

IS 
    vcName VARCHAR2(50);
    BEGIN
        SELECT relationtype_name
        INTO vcName
        FROM relationtype
        WHERE relationtype_id = pid;
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



end control_relationtype;