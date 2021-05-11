Create or replace package control_loan_history is


PROCEDURE insert_loan_history (pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER, preturn_date IN VARCHAR2, ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER);
PROCEDURE remove_loan_history (pitem_id IN NUMBER);
PROCEDURE update_loan_history (ppersonid1_old in NUMBER, ppersonid1_new IN NUMBER, ppersonid2_old IN NUMBER, ppersonid2_new IN NUMBER, pitem_id IN NUMBER, plend_date IN VARCHAR2, preturn_date IN VARCHAR2,  ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER);
PROCEDURE update_loan_historyRetDate (pperson1_id in NUMBER, pperson2_id IN NUMBER,preturn_date IN VARCHAR2);

FUNCTION getloan_historyPerson1ID(pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getloan_historyPerson2ID(pperson1_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getloan_historyItemID (pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN NUMBER;

FUNCTION getloan_historyLendDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN DATE;
FUNCTION getloan_historyReturnDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN DATE;
FUNCTION getloan_historyAmountDays(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getloan_historyToleranceDY(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getloan_historyToleranceDR(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER;



end control_loan_history;

/

CREATE OR REPLACE PACKAGE BODY control_loan_history IS



PROCEDURE insert_loan_history (pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER, preturn_date IN VARCHAR2,  ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER) AS
BEGIN
    INSERT INTO loan_history (person1_id, person2_id, item_id, lend_date, return_date, amount_days, tolerance_days_yellow, tolerance_days_red)
    VALUES (pperson1_id, pperson2_id, pitem_id, SYSDATE, TO_DATE(preturn_date, 'YYYY-MM-DD'), (select to_date (preturn_date, 'yyyy-mm-dd') - trunc(SYSDATE) from dual), ptoleranceDaysYellow, ptoleranceDaysRed);
    --Select se encarga de calcular la cantidad de días entre la fecha de préstamos y la fecha de retorno del ítem.
     COMMIT;
END insert_loan_history;


PROCEDURE remove_loan_history (pitem_id IN NUMBER) AS
e_invalid_loan_history EXCEPTION;
BEGIN
    DELETE FROM loan_history
    WHERE item_id = pitem_id ;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_loan_history;
    END IF;
    EXCEPTION
    WHEN e_invalid_loan_history THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_loan_history;


PROCEDURE update_loan_history (ppersonid1_old in NUMBER, ppersonid1_new IN NUMBER, ppersonid2_old IN NUMBER, ppersonid2_new IN NUMBER, pitem_id IN NUMBER, plend_date IN VARCHAR2, preturn_date IN VARCHAR2, ptoleranceDaysYellow IN NUMBER, ptoleranceDaysRed IN NUMBER) AS
e_invalid_loan_history EXCEPTION;
BEGIN
    UPDATE loan_history 
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
        RAISE e_invalid_loan_history;
    END IF;
    EXCEPTION
    WHEN e_invalid_loan_history THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_loan_history;


PROCEDURE update_loan_historyRetDate (pperson1_id in NUMBER, pperson2_id IN NUMBER,preturn_date IN VARCHAR2) AS
e_invalid_loan_history EXCEPTION;
BEGIN
    UPDATE loan_history
    SET return_date = TO_DATE(preturn_date, 'YYYY-MM-DD'),
        amount_days = (select to_date (preturn_date, 'yyyy-mm-dd') - trunc(lend_date) from dual)
    WHERE person1_id = pperson1_id AND person2_id = pperson2_id;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_loan_history;
    END IF;
    EXCEPTION
    WHEN e_invalid_loan_history THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_loan_historyRetDate;


FUNCTION getloan_historyPerson1ID(pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(9);
    BEGIN
        SELECT person1_id
        INTO vcId
        FROM loan_history
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
    

FUNCTION getloan_historyPerson2ID(pperson1_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(9);
    BEGIN
        SELECT person2_id
        INTO vcId
        FROM loan_history
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
    

FUNCTION getloan_historyItemID (pperson1_id IN NUMBER, pperson2_id IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(9);
    BEGIN
        SELECT item_id
        INTO vcId
        FROM loan_history
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


FUNCTION getloan_historyLendDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER,pitem_id IN NUMBER) RETURN DATE
IS 
    vcDATE DATE;
    BEGIN
        SELECT lend_date
        INTO vcDate
        FROM loan_history
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


FUNCTION getloan_historyReturnDate(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN DATE
IS 
    vcDATE DATE;
    BEGIN
        SELECT return_date
        INTO vcDate
        FROM loan_history
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


FUNCTION getloan_historyAmountDays(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcDays NUMBER(8);
    BEGIN
        SELECT amount_days
        INTO vcDays
        FROM loan_history
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

FUNCTION getloan_historyToleranceDY(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcDays NUMBER(8);
    BEGIN
        SELECT tolerance_days_yellow
        INTO vcDays
        FROM loan_history
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

FUNCTION getloan_historyToleranceDR(pperson1_id IN NUMBER, pperson2_id IN NUMBER, pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcDays NUMBER(8);
    BEGIN
        SELECT tolerance_days_red
        INTO vcDays
        FROM loan_history
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




end control_loan_history;