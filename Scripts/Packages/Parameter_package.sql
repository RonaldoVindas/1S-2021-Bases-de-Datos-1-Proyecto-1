Create or replace package control_Parameter is
PROCEDURE insert_Parameter (pvalue IN VARCHAR2,pname IN VARCHAR2);
PROCEDURE remove_Parameter (pParameter_id IN NUMBER);
PROCEDURE update_Parameter(pParameter_id IN NUMBER,pvalue IN VARCHAR2,pname IN VARCHAR2);
FUNCTION getParameterValue(pParameter_id IN NUMBER) RETURN VARCHAR2;
FUNCTION getParameterName(pParameter_id IN NUMBER) RETURN VARCHAR2;
FUNCTION get_Parameter_id(pname varchar2) return number;

end control_Parameter;
/
CREATE OR REPLACE PACKAGE BODY control_Parameter IS

PROCEDURE insert_Parameter(pvalue IN VARCHAR2,pname IN VARCHAR2) AS
BEGIN
	INSERT INTO Parameter(value,name)
	VALUES(pvalue,pname);
    COMMIT;
END insert_Parameter;

PROCEDURE remove_Parameter (pParameter_id IN NUMBER) AS
e_invalid_Parameter EXCEPTION;
BEGIN
	DELETE FROM Parameter
	WHERE Parameter_id = pParameter_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_Parameter;
    END IF;
    EXCEPTION
    WHEN e_invalid_Parameter THEN
        DBMS_OUTPUT.PUT_LINE('No such Parameter_id.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_Parameter;

PROCEDURE update_Parameter(pParameter_id IN NUMBER,pvalue IN VARCHAR2,pname IN VARCHAR2) AS
e_invalid_Parameter EXCEPTION;
BEGIN
	UPDATE Parameter
	SET value = pvalue,
        name = pname
	WHERE Parameter_id = pParameter_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_Parameter;
    END IF;
    EXCEPTION
    WHEN e_invalid_Parameter THEN
        DBMS_OUTPUT.PUT_LINE('No such Parameter.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_Parameter;

FUNCTION getParameterValue(pParameter_id IN NUMBER) RETURN VARCHAR2
IS 
    vcValue VARCHAR2(10);
    BEGIN
        SELECT value 
        INTO vcValue
        FROM Parameter
        WHERE Parameter_id = pParameter_id;
        RETURN (vcValue);
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

FUNCTION getParameterName(pParameter_id IN NUMBER) RETURN VARCHAR2
IS 
    vcName VARCHAR2(40);
    BEGIN
        SELECT name  
        INTO vcName 
        FROM Parameter
        WHERE Parameter_id = pParameter_id;
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

FUNCTION get_Parameter_id(pname varchar2) return number
IS 
    vcParameter_id Number(11);
    BEGIN
        SELECT Parameter_id
        INTO vcParameter_id
        FROM Parameter
        WHERE name = pname;
        RETURN (vcParameter_id);
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
end control_Parameter;

