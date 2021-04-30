Create or replace package control_person1knowsperson2 is


PROCEDURE insert_person1knowsperson2 (pid_person1 IN NUMBER, pid_person2 IN NUMBER, prelationtype_id IN NUMBER);
PROCEDURE remove_person1knowsperson2 (pid_person2 IN NUMBER);
PROCEDURE update_person1knowsperson2 (pid_person1_old in NUMBER, pid_person1 IN NUMBER, pid_person2 IN NUMBER, prelationtype_id IN NUMBER);

FUNCTION getper1knowsper2person1Id(pid_person2 IN NUMBER) RETURN NUMBER;
FUNCTION getper1knowsper2person2Id(pid_person1 IN NUMBER) RETURN NUMBER;
FUNCTION getper1knowsper2reltypeId(pid IN NUMBER) RETURN NUMBER;


end control_person1knowsperson2;

/

CREATE OR REPLACE PACKAGE BODY control_person1knowsperson2 IS


PROCEDURE insert_person1knowsperson2 (pid_person1 IN NUMBER, pid_person2 IN NUMBER, prelationtype_id IN NUMBER) AS
BEGIN
    INSERT INTO person1knowsperson2(person1_id, person2_id, relationtype_id)
    VALUES(pid_person1,pid_person2, prelationtype_id );
END insert_person1knowsperson2;


PROCEDURE remove_person1knowsperson2 (pid_person2 IN NUMBER) AS
e_invalid_person1knowsperson2 EXCEPTION;
BEGIN
    DELETE FROM person1knowsperson2
    WHERE person2_id = pid_person2;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_person1knowsperson2;
    END IF;
    EXCEPTION
    WHEN e_invalid_person1knowsperson2 THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_person1knowsperson2;


PROCEDURE update_person1knowsperson2 (pid_person1_old in NUMBER, pid_person1 IN NUMBER, pid_person2 IN NUMBER, prelationtype_id IN NUMBER) AS
e_invalid_person1knowsperson2 EXCEPTION;
BEGIN
    UPDATE person1knowsperson2
    SET person1_id = pid_person1,
        person2_id = pid_person2,
        relationtype_id = prelationtype_id
    WHERE person1_id = pid_person1_old;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_person1knowsperson2;
    END IF;
    EXCEPTION
    WHEN e_invalid_person1knowsperson2 THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_person1knowsperson2;


FUNCTION getper1knowsper2person1Id(pid_person2 IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT person1_id
        INTO vcId
        FROM person1knowsperson2
        WHERE person2_id = pid_person2;
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
    
FUNCTION getper1knowsper2person2Id(pid_person1 IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT person2_id
        INTO vcId
        FROM person1knowsperson2
        WHERE person1_id = pid_person1;
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


FUNCTION getper1knowsper2reltypeId(pid IN NUMBER)  RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT relationtype_id
        INTO vcId
        FROM person1knowsperson2
        WHERE person1_id = pid;
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


end control_person1knowsperson2;