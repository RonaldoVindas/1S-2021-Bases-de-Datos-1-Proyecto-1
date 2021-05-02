Create or replace package control_ItemType is
PROCEDURE insert_ItemType (pitemType_name IN VARCHAR2);
PROCEDURE remove_ItemType (pitemtype_id IN NUMBER);
PROCEDURE update_ItemType(pitemtype_id IN NUMBER,pitemType_name IN VARCHAR2);
FUNCTION getitemType_name(pitemtype_id IN NUMBER) RETURN VARCHAR2;
FUNCTION get_itemtype_id (pitemType_name IN VARCHAR2) return number;

end control_ItemType;
/
CREATE OR REPLACE PACKAGE BODY control_ItemType IS

PROCEDURE insert_ItemType (pitemType_name IN VARCHAR2) AS
BEGIN
	INSERT INTO ItemType(itemType_name)
	VALUES(pitemType_name);
END insert_ItemType;

PROCEDURE remove_ItemType (pitemtype_id IN NUMBER) AS
e_invalid_ItemType EXCEPTION;
BEGIN
	DELETE FROM ItemType
	WHERE itemtype_id = pitemtype_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_ItemType;
    END IF;
    EXCEPTION
    WHEN e_invalid_ItemType THEN
        DBMS_OUTPUT.PUT_LINE('No such ItemType.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_ItemType;

PROCEDURE update_ItemType(pitemtype_id IN NUMBER,pitemType_name IN VARCHAR2) AS
e_invalid_ItemType EXCEPTION;
BEGIN
	UPDATE ItemType
	SET itemType_name  = pitemType_name
	WHERE itemtype_id = pitemtype_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_ItemType;
    END IF;
    EXCEPTION
    WHEN e_invalid_ItemType THEN
        DBMS_OUTPUT.PUT_LINE('No such ItemType.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_ItemType;

FUNCTION getitemType_name(pitemtype_id IN NUMBER) RETURN VARCHAR2
IS 
    vcitemType_name VARCHAR2(50);
    BEGIN
        SELECT itemType_name
        INTO vcitemType_name
        FROM itemtype
        WHERE itemtype_id = pitemtype_id;
        RETURN (vcitemType_name);
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

FUNCTION get_itemtype_id (pitemType_name IN VARCHAR2) return number

IS 
    vcitemtype_id Number(11);
    BEGIN
        SELECT itemtype_id
        INTO vcitemtype_id
        FROM itemType
        WHERE itemType_name = pitemType_name;
        RETURN (vcitemtype_id);
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



end control_ItemType;