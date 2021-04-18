Create or replace package control_personlenditem is


PROCEDURE insert_personlenditem (pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id, plend_date IN DATE, preturn_date IN DATE, pamount_days IN NUMBER);
PROCEDURE remove_personlenditem (pperson1_id IN NUMBER);

PROCEDURE update_personlenditem (ppersonid1_old in NUMBER,pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id, plend_date IN DATE, preturn_date IN DATE, pamount_days IN NUMBER);


FUNCTION getpersonlenditemPerson1ID(pperson2_id IN NUMBER) RETURN NUMBER;
FUNCTION getpersonlenditemPerson2ID(pperson1_id IN NUMBER) RETURN NUMBER;
FUNCTION getpersonlenditemItemID (pperson1_id IN NUMBER) RETURN NUMBER;
/*
FUNCTION getpersonlenditemLendDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN DATE;
FUNCTION getpersonlenditemReturnDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN DATE;
*/



end control_personlenditem;

/

CREATE OR REPLACE PACKAGE BODY control_personhasitem IS


PROCEDURE insert_personlenditem (pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id, plend_date IN DATE, preturn_date IN DATE, pamount_days IN NUMBER) AS
BEGIN
	INSERT INTO personlenditem (person1_id, person2_id, item_id, lend_date, return_date, amount_days)
	VALUES (pperson1_id, pperson2_id, pitem_id, plend_date, preturn_date, (select to_date (return_date, 'yyyy-mm-dd') - trunc(lend_date) from dual)      );    --Select se encarga de calcular la cantidad de días entre la fecha de préstamos y la fecha de retorno del ítem
END personlenditem;


PROCEDURE remove_personlenditem (pperson1_id IN NUMBER) AS
e_invalid_personlenditem EXCEPTION;
BEGIN
	DELETE FROM personlenditem
	WHERE person1_id = pperson1_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_personlenditem;
    END IF;
    EXCEPTION
    WHEN e_invalid_personlenditem THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_personlenditem;


PROCEDURE update_personhasitem (ppersonid_old in NUMBER, pperson_id IN NUMBER, pitem_id IN NUMBER) AS
e_invalid_personhasitem EXCEPTION;
BEGIN
	UPDATE personhasitem
	SET person_id, item_id = pperson_id, pitem_id
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


FUNCTION getpersonlenditemPerson1ID(pperson2_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT person1_id
        INTO vcId
        FROM personlenditem
        WHERE person2_id = pperson2_id;
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
    

FUNCTION getpersonlenditemPerson2ID(pperson1_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT person2_id
        INTO vcId
        FROM personlenditem
        WHERE person1_id = pperson1_id;
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
    

FUNCTION getpersonlenditemItemID(pperson1_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT item_id
        INTO vcId
        FROM personlenditem
        WHERE person1_id = pperson1_id;
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


/*Problemas en condiciones de búsqueda para Funciones get lend_date, get return_date, get amount_days




======================================================================================================================================


FUNCTION getpersonlenditemLendDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN DATE
IS 
    vcDATE NUMBER(11);
    BEGIN
        SELECT lend_date
        INTO vcDate
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id;
        RETURN (vcDATE);
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


FUNCTION getpersonlenditemLendDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN DATE
IS 
    vcDATE NUMBER(11);
    BEGIN
        SELECT lend_date
        INTO vcDate
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id;
        RETURN (vcDATE);
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


*/


end control_personlenditem;