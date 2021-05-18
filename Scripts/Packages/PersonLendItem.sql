Create or replace package control_personlenditem is


PROCEDURE insert_personlenditem (pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER, preturn_date IN VARCHAR2, ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER);
PROCEDURE remove_personlenditem (pitem_id IN NUMBER);
PROCEDURE update_personlenditem (ppersonid1_old in NUMBER, ppersonid1_new IN NUMBER, ppersonid2_old IN NUMBER, ppersonid2_new IN NUMBER, pitem_id IN NUMBER, plend_date IN VARCHAR2, preturn_date IN VARCHAR2,  ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER);
PROCEDURE update_personlenditemRetDate (pperson1_id in NUMBER, pperson2_id IN NUMBER,preturn_date IN DATE);


FUNCTION getpersonlenditemPerson1ID(pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getpersonlenditemPerson2ID(pperson1_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getpersonlenditemItemID (pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN NUMBER;

FUNCTION getpersonlenditemLendDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN DATE;
FUNCTION getpersonlenditemReturnDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN DATE;
FUNCTION getpersonlenditemAmountDays(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getpersonlenditemToleranceDY(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getpersonlenditemToleranceDR(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;


end control_personlenditem;

/

CREATE OR REPLACE PACKAGE BODY control_personlenditem IS


PROCEDURE insert_personlenditem (pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER, preturn_date IN VARCHAR2,  ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER) AS
BEGIN
    INSERT INTO personlenditem (person1_id, person2_id, item_id, lend_date, return_date, amount_days, tolerance_days_yellow, tolerance_days_red)
    VALUES (pperson1_id, pperson2_id, pitem_id, SYSDATE, TO_DATE(preturn_date, 'YYYY-MM-DD'), (select to_date (preturn_date, 'yyyy-mm-dd') - trunc(SYSDATE) from dual), ptoleranceDaysYellow, ptoleranceDaysRed);
    --Select se encarga de calcular la cantidad de días entre la fecha de préstamos y la fecha de retorno del ítem.
     COMMIT;
END insert_personlenditem;


PROCEDURE remove_personlenditem (pitem_id IN NUMBER) AS
e_invalid_personlenditem EXCEPTION;
BEGIN
    DELETE FROM personlenditem
    WHERE item_id = pitem_id ;
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


PROCEDURE update_personlenditem (ppersonid1_old in NUMBER, ppersonid1_new IN NUMBER, ppersonid2_old IN NUMBER, ppersonid2_new IN NUMBER, pitem_id IN NUMBER, plend_date IN VARCHAR2, preturn_date IN VARCHAR2, ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER) AS
e_invalid_personhasitem EXCEPTION;
BEGIN
    UPDATE personlenditem 
    SET person1_id = ppersonid1_new,
    person2_id = ppersonid2_new,
    item_id = pitem_id,
    lend_date = TO_DATE(plend_date, 'YYYY-MM-DD'),
    return_date = TO_DATE(preturn_date, 'YYYY-MM-DD'),
    amount_days = (select to_date (preturn_date, 'yyyy-mm-dd') - trunc(SYSDATE) from dual),
    tolerance_days_yellow = ptoleranceDaysYellow,
    tolerance_days_red = ptoleranceDaysRed
    WHERE person1_id = ppersonid1_old AND person2_id = ppersonid2_old;
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
END update_personlenditem;


PROCEDURE update_personlenditemRetDate (pperson1_id in NUMBER, pperson2_id IN NUMBER,preturn_date IN DATE) AS
e_invalid_personhasitem EXCEPTION;
BEGIN
    UPDATE personlenditem 
    SET return_date = preturn_date
     --   amount_days = (select to_date (preturn_date, 'yyyy-mm-dd') - trunc(lend_date) from dual)
    WHERE person1_id = pperson1_id AND person2_id = pperson2_id;
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
END update_personlenditemRetDate;


FUNCTION getpersonlenditemPerson1ID(pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(9);
    BEGIN
        SELECT person1_id
        INTO vcId
        FROM personlenditem
        WHERE person2_id = pperson2_id AND item_id = pitem_id;
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
    

FUNCTION getpersonlenditemPerson2ID(pperson1_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(9);
    BEGIN
        SELECT person2_id
        INTO vcId
        FROM personlenditem
        WHERE person1_id = pperson1_id AND item_id = pitem_id;
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
    

FUNCTION getpersonlenditemItemID (pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(9);
    BEGIN
        SELECT item_id
        INTO vcId
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id;
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


FUNCTION getpersonlenditemLendDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER,pitem_id IN NUMBER) RETURN DATE
IS 
    vcDATE DATE;
    BEGIN
        SELECT lend_date
        INTO vcDate
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id AND item_id = pitem_id;
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


FUNCTION getpersonlenditemReturnDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN DATE
IS 
    vcDATE DATE;
    BEGIN
        SELECT return_date
        INTO vcDate
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id AND item_id = pitem_id;
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


FUNCTION getpersonlenditemAmountDays(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcDays NUMBER(8);
    BEGIN
        SELECT amount_days
        INTO vcDays
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id AND item_id = pitem_id;
        RETURN (vcDays);
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

FUNCTION getpersonlenditemToleranceDY(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcDays NUMBER(8);
    BEGIN
        SELECT tolerance_days_yellow
        INTO vcDays
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id AND item_id = pitem_id;
        RETURN (vcDays);
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

FUNCTION getpersonlenditemToleranceDR(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcDays NUMBER(8);
    BEGIN
        SELECT tolerance_days_red
        INTO vcDays
        FROM personlenditem
        WHERE person1_id = pperson1_id AND person2_id = pperson2_id AND item_id = pitem_id;
        RETURN (vcDays);
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



end control_personlenditem;
