Create or replace package control_person is

FUNCTION EncryptPassword(pencrypt_password IN VARCHAR2) RETURN VARCHAR2;
FUNCTION DecryptPassword(pdecrypt_password IN VARCHAR2) RETURN VARCHAR2;

PROCEDURE insert_person (pid IN NUMBER, pfirname IN VARCHAR2, plasname IN VARCHAR2, pemail IN VARCHAR2, ppassword IN VARCHAR2, pphonenumber IN VARCHAR2, pdate IN DATE, ppersontype_id IN NUMBER);
PROCEDURE remove_person (pid IN NUMBER);
PROCEDURE update_person(pid IN NUMBER, pfirname IN VARCHAR2, plasname IN VARCHAR2, pemail IN VARCHAR2, ppassword IN VARCHAR2, pphonenumber IN VARCHAR2, pdate IN DATE, ppersontype_id IN NUMBER);

FUNCTION getpersonId(pemail IN VARCHAR) RETURN NUMBER;
FUNCTION getpersonFirstName(pid IN NUMBER) RETURN VARCHAR;
FUNCTION getpersonLastName(pid IN NUMBER) RETURN VARCHAR;
FUNCTION getpersonEmail(pid IN NUMBER) RETURN VARCHAR;
FUNCTION getpersonPassword(pid IN NUMBER) RETURN VARCHAR;
FUNCTION getpersonPhoneNumber(pid IN NUMBER) RETURN VARCHAR;
FUNCTION getpersonBirthDay(pid IN NUMBER) RETURN DATE;
FUNCTION getpersonPersonType(pid IN NUMBER) RETURN NUMBER;

end control_person;

/

CREATE OR REPLACE PACKAGE BODY control_person IS

FUNCTION EncryptPassword(pencrypt_password IN VARCHAR2) RETURN VARCHAR2
AS
    data VARCHAR2(255);
    BEGIN
    data := rpad(pencrypt_password, (trunc(length(pencrypt_password)/8)+1)*8, chr(0) );
    dbms_obfuscation_toolkit.DESEncrypt
          ( input_string => data,
            key_string   => 'DBAKey03',
            encrypted_string=> data );
 
    RETURN data;
  END;

FUNCTION DecryptPassword(pdecrypt_password IN VARCHAR2) RETURN VARCHAR2
AS
    data VARCHAR2(255);
    BEGIN
     dbms_obfuscation_toolkit.DESDecrypt
          ( input_string => pdecrypt_password,
            key_string   => 'DBAKey03',
            decrypted_string=> data );
    return rtrim( data, chr(0) );
    END;


PROCEDURE insert_person (pid IN NUMBER, pfirname IN VARCHAR2, plasname IN VARCHAR2, pemail IN VARCHAR2, ppassword IN VARCHAR2, pphonenumber IN VARCHAR2, pdate IN DATE, ppersontype_id IN NUMBER) AS
BEGIN
	INSERT INTO person(person_id,first_name,last_name,email,password,phone_number,birth_day,persontype_id)
	VALUES(pid, pfirname, plasname, pemail, EncryptPassword(ppasword), pphonenumber, pdate, ppersontype_id);
END insert_person;

PROCEDURE remove_person (pid IN NUMBER) AS
e_invalid_person EXCEPTION;
BEGIN
	DELETE FROM person
	WHERE person_id = pid;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_person;
    END IF;
    EXCEPTION
    WHEN e_invalid_person THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_person;


PROCEDURE update_person(pid_old IN NUMBER, pid IN NUMBER, pfirname IN VARCHAR2, plasname IN VARCHAR2, pemail IN VARCHAR2, ppassword IN VARCHAR2, pphonenumber IN VARCHAR2, pdate IN DATE, ppersontype_id IN NUMBER) AS
e_invalid_person EXCEPTION;
BEGIN
	UPDATE person
	SET person_id,first_name,last_name,email,password,phone_number,date = pid,pfirname,plasname,pemail,EncryptPassword(ppassword),pphonenumber,pdate 
	WHERE person_id = pid_old;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_person;
    END IF;
    EXCEPTION
    WHEN e_invalid_person THEN
        DBMS_OUTPUT.PUT_LINE('No such person.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_person;


FUNCTION getpersonId(pemail IN VARCHAR)RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT person_id
        INTO vcId
        FROM person
        WHERE email = pemail;
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
    
    
    
    
FUNCTION getpersonFirstName(pid IN NUMBER) RETURN VARCHAR2

IS 
    vcFirstName VARCHAR2(20);
    BEGIN
        SELECT first_name
        INTO vcFirstName
        FROM person
        WHERE person_id = pid;
        RETURN (vcFirstName);
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


FUNCTION getpersonLastName(pid IN NUMBER) RETURN VARCHAR2
IS 
    vcLastName VARCHAR2(20);
    BEGIN
        SELECT last_name
        INTO vcLastName
        FROM person
        WHERE person_id = pid;
        RETURN (vcLastName);
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

FUNCTION getpersonEmail(pid IN NUMBER) RETURN VARCHAR2
IS 
    vcEmail VARCHAR2(50);
    BEGIN
        SELECT email
        INTO vcEmail
        FROM person
        WHERE person_id = pid;
        RETURN (vcEmail);
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

FUNCTION getpersonPassword(pid IN NUMBER) RETURN VARCHAR;
IS 
    vcPassword VARCHAR2(15);
    BEGIN
        SELECT password
        INTO vcPassword
        FROM person
        WHERE person_id = pid;
        RETURN (DecryptPassword(vcEmail));
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


FUNCTION getpersonPhoneNumber(pid IN NUMBER) RETURN VARCHAR;
IS 
    vcPhoneNumber VARCHAR2(15);
    BEGIN
        SELECT phone_number
        INTO vcPhoneNumber
        FROM person
        WHERE person_id = pid;
        RETURN (vcPhoneNumber);
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

FUNCTION getpersonPersonType(pid IN NUMBER) RETURN NUMBER;
IS 
    vcPersonType NUMBER(11);
    BEGIN
        SELECT persontype_id
        INTO vcPersonType
        FROM person
        WHERE person_id = pid;
        RETURN (vcPersonType);
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

end control_person;