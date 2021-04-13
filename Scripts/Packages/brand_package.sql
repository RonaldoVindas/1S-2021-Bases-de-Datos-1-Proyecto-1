Create or replace package control_brand is
PROCEDURE insert_brand (pdescription IN VARCHAR2);
PROCEDURE remove_brand (pid_brand IN NUMBER);
PROCEDURE update_brand_description(pid_brand IN NUMBER, pdescription IN VARCHAR2);
FUNCTION getbrandDescription(pid_brand IN NUMBER) RETURN VARCHAR2;
FUNCTION get_brand_id(pdescription varchar2) return number;
end control_brand;
/
CREATE OR REPLACE PACKAGE BODY control_brand IS

PROCEDURE insert_brand (pdescription IN VARCHAR2) AS
BEGIN
	INSERT INTO brand(name)
	VALUES(pdescription);
END insert_brand;

PROCEDURE remove_brand (pid_brand IN NUMBER) AS
e_invalid_brand EXCEPTION;
BEGIN
	DELETE FROM brand
	WHERE id_brand = pid_brand;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_brand;
    END IF;
    EXCEPTION
    WHEN e_invalid_brand THEN
        DBMS_OUTPUT.PUT_LINE('No such brand.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_brand;


PROCEDURE update_brand_description(pid_brand IN NUMBER, pdescription IN VARCHAR2) AS
e_invalid_brand EXCEPTION;
BEGIN
	UPDATE brand
	SET name = pdescription
	WHERE id_brand = pid_brand;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_brand;
    END IF;
    EXCEPTION
    WHEN e_invalid_brand THEN
        DBMS_OUTPUT.PUT_LINE('No such brand.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_brand_description;


FUNCTION getbrandDescription(pid_brand IN NUMBER) RETURN VARCHAR2
IS 
    vcDescription VARCHAR2(50);
    BEGIN
        SELECT name
        INTO vcDescription
        FROM brand
        WHERE id_brand = pid_brand;
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
    
    
    
    
FUNCTION get_brand_id(pdescription varchar2) return number

IS 
    vcID VARCHAR2(50);
    BEGIN
        SELECT id_brand
        INTO vcID
        FROM brand
        WHERE name = pdescription;
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
end control_brand;