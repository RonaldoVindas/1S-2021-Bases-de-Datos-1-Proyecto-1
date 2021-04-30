Create or replace package control_itemHasGenre is
PROCEDURE insert_itemHasGenre (pitem_id IN Number,pgenre_id IN Number);
PROCEDURE remove_itemHasGenre (pitem_id IN Number);
PROCEDURE update_itemHasGenre(oldpitem_id IN Number,pitem_id IN Number,pgenre_id IN Number);
FUNCTION getitemHasGenreitem_id(pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getitemHasGenregenre_id(pgenre_id IN NUMBER) RETURN NUMBER;
end control_itemHasGenre;
/
CREATE OR REPLACE PACKAGE BODY control_itemHasGenre IS

PROCEDURE insert_itemHasGenre (pitem_id IN Number,pgenre_id IN Number) AS
BEGIN
	INSERT INTO itemHasGenre(item_id,genre_id)
	VALUES(pitem_id,pgenre_id);
END insert_itemHasGenre;


PROCEDURE remove_itemHasGenre (pitem_id IN Number) AS
e_invalid_itemHasGenre EXCEPTION;
BEGIN
	DELETE FROM itemHasGenre
	WHERE item_id = pitem_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_itemHasGenre;
    END IF;
    EXCEPTION
    WHEN e_invalid_itemHasGenre THEN
        DBMS_OUTPUT.PUT_LINE('No such itemHasGenre.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_itemHasGenre;


PROCEDURE update_itemHasGenre(oldpitem_id IN Number,pitem_id IN Number,pgenre_id IN Number) AS
e_invalid_itemHasGenre EXCEPTION;
BEGIN
	UPDATE itemHasGenre
	SET item_id = pitem_id,
        genre_id = pgenre_id 
	WHERE item_id = oldpitem_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_itemHasGenre;
    END IF;
    EXCEPTION
    WHEN e_invalid_itemHasGenre THEN
        DBMS_OUTPUT.PUT_LINE('No such genre.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_itemHasGenre;



FUNCTION getitemHasGenreitem_id(pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcitem_id NUMBER(11);
    BEGIN
        SELECT item_id
        INTO vcitem_id
        FROM itemHasGenre
        WHERE item_id = pitem_id;
        RETURN (vcitem_id);
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

FUNCTION getitemHasGenregenre_id(pgenre_id IN NUMBER) RETURN NUMBER
IS 
    vcgenre_id NUMBER(11);
    BEGIN
        SELECT genre_id
        INTO vcgenre_id
        FROM itemHasGenre
        WHERE genre_id = pgenre_id;
        RETURN (vcgenre_id);
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
end control_itemHasGenre;