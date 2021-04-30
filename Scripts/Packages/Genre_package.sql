Create or replace package control_genre is
PROCEDURE insert_genre (pname IN VARCHAR2,pdescription IN VARCHAR2);
PROCEDURE remove_genre (pid_genre IN NUMBER);
PROCEDURE update_genre(pid_genre IN NUMBER,pname IN VARCHAR2, pdescription IN VARCHAR2);
FUNCTION getgenreName(pid_genre IN NUMBER) RETURN VARCHAR2;
FUNCTION getgenreDescription(pid_genre IN NUMBER) RETURN VARCHAR2;
FUNCTION get_genre_id(pname varchar2) return number;
end control_genre;
/
CREATE OR REPLACE PACKAGE BODY control_genre IS

PROCEDURE insert_genre (pname IN VARCHAR2,pdescription IN VARCHAR2) AS
BEGIN
    INSERT INTO genre(genre_name,description)
    VALUES(pname,pdescription);
END insert_genre;

PROCEDURE remove_genre (pid_genre IN NUMBER) AS
e_invalid_genre EXCEPTION;
BEGIN
    DELETE FROM genre
    WHERE genre_id = pid_genre;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_genre;
    END IF;
    EXCEPTION
    WHEN e_invalid_genre THEN
        DBMS_OUTPUT.PUT_LINE('No such genre.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_genre;


PROCEDURE update_genre(pid_genre IN NUMBER,pname IN VARCHAR2, pdescription IN VARCHAR2) AS
e_invalid_genre EXCEPTION;
BEGIN
    UPDATE genre
    SET genre_name = pname, description = pdescription
    WHERE genre_id = pid_genre;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_genre;
    END IF;
    EXCEPTION
    WHEN e_invalid_genre THEN
        DBMS_OUTPUT.PUT_LINE('No such genre.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_genre;


FUNCTION getgenreName(pid_genre IN NUMBER) RETURN VARCHAR2
IS 
    vcName VARCHAR2(20);
    BEGIN
        SELECT genre_name
        INTO vcName
        FROM genre
        WHERE genre_id = pid_genre;
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

FUNCTION getgenreDescription(pid_genre IN NUMBER) RETURN VARCHAR2
IS 
    vcDescription VARCHAR2(140);
    BEGIN
        SELECT description
        INTO vcDescription
        FROM genre
        WHERE genre_id = pid_genre;
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




FUNCTION get_genre_id(pname varchar2) return number
IS 
    vcID Number(11);
    BEGIN
        SELECT genre_id
        INTO vcID
        FROM genre
        WHERE genre_name = pname;
        RETURN (vcID);
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
end control_genre;