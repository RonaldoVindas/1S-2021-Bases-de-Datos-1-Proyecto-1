Create or replace package control_publisher is

PROCEDURE insert_publisher (pname IN VARCHAR2);
PROCEDURE remove_publisher (pid IN NUMBER);
PROCEDURE update_publisher (pid IN NUMBER, pname IN VARCHAR2);


FUNCTION getpublisherId(pname IN VARCHAR) RETURN NUMBER;
FUNCTION getpublisherName(pid IN NUMBER) RETURN VARCHAR;

end control_publisher;

/

CREATE OR REPLACE PACKAGE BODY control_publisher IS

PROCEDURE insert_publisher (pname IN VARCHAR2) AS
BEGIN
	INSERT INTO publisher(publisher_name)
	VALUES(pname);
END insert_publisher;

PROCEDURE remove_publisher (pid IN NUMBER) AS
e_invalid_publisher EXCEPTION;
BEGIN
	DELETE FROM publisher
	WHERE publisher_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_publisher;
    END IF;
    EXCEPTION
    WHEN e_invalid_publisher THEN
        DBMS_OUTPUT.PUT_LINE('No such publisher.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_publisher;

PROCEDURE update_publisher(pid IN NUMBER, pname IN VARCHAR2) AS
e_invalid_publisher EXCEPTION;
BEGIN
	UPDATE publisher
	SET publisher_name = pname 
	WHERE publisher_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_publisher;
    END IF;
    EXCEPTION
    WHEN e_invalid_publisher THEN
        DBMS_OUTPUT.PUT_LINE('No such publisher.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_publisher;

FUNCTION getpublisherId(pname IN VARCHAR) RETURN NUMBER
IS 
    vcId NUMBER(8);
    BEGIN
        SELECT publisher_id
        INTO vcId
        FROM publisher
        WHERE publisher_name = pname;
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
    

FUNCTION getpublisherName(pid IN NUMBER) RETURN VARCHAR2

IS 
    vcName VARCHAR2(100);
    BEGIN
        SELECT publisher_name
        INTO vcName
        FROM publisher
        WHERE publisher_id = pid;
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



end control_publisher;