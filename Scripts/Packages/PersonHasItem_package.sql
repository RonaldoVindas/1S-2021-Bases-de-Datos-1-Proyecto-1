Create or replace package control_personhasitem is


PROCEDURE insert_personhasitem (pperson_id IN NUMBER, pitem_id IN NUMBER);
PROCEDURE remove_personhasitem (pperson_id IN NUMBER);
PROCEDURE update_personhasitem (ppersonid_old in NUMBER, pperson_id IN NUMBER, pitem_id IN NUMBER);

FUNCTION getpersonhasitemPersonID (pid_item IN NUMBER) RETURN NUMBER;
FUNCTION getpersonhasitemItemID (pid_person IN NUMBER) RETURN NUMBER;

end control_personhasitem;

/

CREATE OR REPLACE PACKAGE BODY control_personhasitem IS


PROCEDURE insert_personhasitem (pperson_id IN NUMBER, pitem_id IN NUMBER) AS
BEGIN
	INSERT INTO personhasitem (person_id, item_id)
	VALUES (pperson_id, pitem_id);
END insert_personhasitem;


PROCEDURE remove_personhasitem (pperson_id IN NUMBER) AS
e_invalid_personhasitem EXCEPTION;
BEGIN
	DELETE FROM personhasitem
	WHERE person_id = pperson_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_personhasitem;
    END IF;
    EXCEPTION
    WHEN e_invalid_personhasitem THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_personhasitem;


PROCEDURE update_personhasitem (ppersonid_old in NUMBER, pperson_id IN NUMBER, pitem_id IN NUMBER) AS
e_invalid_personhasitem EXCEPTION;
BEGIN
	UPDATE personhasitem
	SET person_id = pperson_id, 
        item_id = pitem_id
	WHERE person_id = ppersonid_old;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_personhasitem;
    END IF;
    EXCEPTION
    WHEN e_invalid_personhasitem THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_personhasitem;


FUNCTION getpersonhasitemPersonID (pid_item IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT person_id
        INTO vcId
        FROM personhasitem
        WHERE item_id = pid_item;
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
    
FUNCTION getpersonhasitemItemID (pid_person IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT item_id
        INTO vcId
        FROM personhasitem
        WHERE person_id = pid_person;
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

end control_personhasitem;