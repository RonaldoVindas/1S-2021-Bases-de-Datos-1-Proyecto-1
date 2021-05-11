Create or replace package control_review is

PROCEDURE insert_review (pstars IN NUMBER);
PROCEDURE remove_review (pid IN NUMBER);
PROCEDURE update_review (pid IN NUMBER, pstars IN NUMBER);


FUNCTION getreviewId(pstars IN NUMBER) RETURN NUMBER;  --?
FUNCTION getreviewStars(pid IN NUMBER) RETURN NUMBER;

end control_review;

/

CREATE OR REPLACE PACKAGE BODY control_review IS

PROCEDURE insert_review (pstars IN NUMBER) AS
BEGIN
	INSERT INTO review(stars)
	VALUES(pstars);
    COMMIT;    
END insert_review;

PROCEDURE remove_review (pid IN NUMBER) AS
e_invalid_review EXCEPTION;
BEGIN
	DELETE FROM review
	WHERE review_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_review;
    END IF;
    EXCEPTION
    WHEN e_invalid_review THEN
        DBMS_OUTPUT.PUT_LINE('No such review.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_review;

PROCEDURE update_review (pid IN NUMBER, pstars IN NUMBER) AS
e_invalid_review EXCEPTION;
BEGIN
	UPDATE review
	SET stars = pstars
	WHERE review_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_review;
    END IF;
    EXCEPTION
    WHEN e_invalid_review THEN
        DBMS_OUTPUT.PUT_LINE('No such review.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_review;

FUNCTION getreviewId(pstars IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(8);
    BEGIN
        SELECT review_id
        INTO vcId
        FROM review
        WHERE stars = pstars;
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
    

FUNCTION getreviewStars(pid IN NUMBER) RETURN NUMBER

IS 
    vcStars NUMBER(1);
    BEGIN
        SELECT stars
        INTO vcStars
        FROM review
        WHERE review_id = pid;
        RETURN (vcStars);
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

end control_review;