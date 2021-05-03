Create or replace package control_item is

PROCEDURE insert_item (ptitle IN VARCHAR2, pedition IN VARCHAR2, pcover IN BLOB, pbarcode IN VARCHAR2, pitemtype_id IN NUMBER, pstatus_id IN NUMBER, ppublisher_id IN NUMBER);
PROCEDURE remove_item (pitem_id IN Number);
PROCEDURE update_item (pitem_id IN Number, ptitle IN VARCHAR2, pedition IN VARCHAR2, pcover IN BLOB, pbarcode IN VARCHAR2, pitemtype_id IN NUMBER, pstatus_id IN NUMBER, ppublisher_id IN NUMBER);
PROCEDURE update_item_cover (pitem_id IN NUMBER, pcover IN BLOB);
PROCEDURE update_item_status (pitem_id IN NUMBER, pstatus_id IN NUMBER);

FUNCTION getitemId(ptitle IN VARCHAR2) RETURN NUMBER;
FUNCTION getitemTitle(pid IN NUMBER) RETURN VARCHAR2;
FUNCTION getitemEdition(pid IN NUMBER) RETURN VARCHAR2;
FUNCTION getitemCoverImage(pid IN NUMBER) RETURN BLOB;
FUNCTION getitemBarcode(pid IN NUMBER) RETURN VARCHAR2;
FUNCTION getitemItemType(pid IN NUMBER) RETURN NUMBER;
FUNCTION getitemStatus(pid IN NUMBER) RETURN NUMBER;
FUNCTION getitemPublisher(pid IN NUMBER) RETURN NUMBER;



end control_item;

/
CREATE OR REPLACE PACKAGE BODY control_item IS

PROCEDURE insert_item (ptitle IN VARCHAR2, pedition IN VARCHAR2, pcover IN BLOB, pbarcode IN VARCHAR2, pitemtype_id IN NUMBER, pstatus_id IN NUMBER, ppublisher_id IN NUMBER) AS
BEGIN
    INSERT INTO item(title, edition, cover_image, barcode, itemtype_id, status_id, publisher_id)
    VALUES(ptitle, pedition, pcover, pbarcode, pitemtype_id, pstatus_id, ppublisher_id);
END insert_item;


PROCEDURE remove_item (pitem_id IN Number) AS
e_invalid_item EXCEPTION;
BEGIN
    DELETE FROM item
    WHERE item_id = pitem_id;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_item;
    END IF;
    EXCEPTION
    WHEN e_invalid_item THEN
        DBMS_OUTPUT.PUT_LINE('No such Item.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_item;


PROCEDURE update_item (pitem_id IN Number, ptitle IN VARCHAR2, pedition IN VARCHAR2, pcover IN BLOB, pbarcode IN VARCHAR2, pitemtype_id IN NUMBER, pstatus_id IN NUMBER, ppublisher_id IN NUMBER) AS
e_invalid_item EXCEPTION;
BEGIN
    UPDATE item
    SET title = ptitle,
        edition = pedition, 
        cover_image = pcover, 
        barcode = pbarcode, 
        itemtype_id = pitemtype_id, 
        status_id = pstatus_id, 
        publisher_id = ppublisher_id
    WHERE item_id = pitem_id;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_item;
    END IF;
    EXCEPTION
    WHEN e_invalid_item THEN
        DBMS_OUTPUT.PUT_LINE('No such Item.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_item;


PROCEDURE update_item_cover (pitem_id IN NUMBER, pcover IN BLOB) AS
e_invalid_item EXCEPTION;
BEGIN
    UPDATE item
    SET
        cover_image = pcover
    WHERE item_id = pitem_id;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_item;
    END IF;
    EXCEPTION
    WHEN e_invalid_item THEN
        DBMS_OUTPUT.PUT_LINE('No such Item.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_item_cover;



PROCEDURE update_item_status (pitem_id IN NUMBER, pstatus_id IN NUMBER) AS
e_invalid_item EXCEPTION;
BEGIN
    UPDATE item
    SET status_id = pstatus_id
    WHERE item_id = pitem_id;
    COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_item;
    END IF;
    EXCEPTION
    WHEN e_invalid_item THEN
        DBMS_OUTPUT.PUT_LINE('No such Item.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_item_status;



FUNCTION getitemId(ptitle IN VARCHAR2) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT item_id
        INTO vcId
        FROM item
        WHERE title = ptitle;
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

FUNCTION getitemTitle(pid IN NUMBER) RETURN VARCHAR2
IS 
    vcTitle VARCHAR2(50);
    BEGIN
        SELECT title
        INTO vcTitle
        FROM item
        WHERE item_id = pid;
        RETURN (vcTitle);
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

FUNCTION getitemEdition(pid IN NUMBER) RETURN VARCHAR2
IS 
    vcEdition VARCHAR2(30);
    BEGIN
        SELECT edition
        INTO vcEdition
        FROM item
        WHERE item_id = pid;
        RETURN (vcEdition);
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


FUNCTION getitemCoverImage(pid IN NUMBER) RETURN BLOB
IS 
    vcCover BLOB;
    BEGIN
        SELECT cover_image
        INTO vcCover
        FROM item
        WHERE item_id = pid;
        RETURN (vcCover);
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


FUNCTION getitemBarcode(pid IN NUMBER) RETURN VARCHAR2
IS 
    vcBarcode VARCHAR2(12);
    BEGIN
        SELECT barcode
        INTO vcBarcode
        FROM item
        WHERE item_id = pid;
        RETURN (vcBarcode);
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



FUNCTION getitemItemType(pid IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(11);
    BEGIN
        SELECT item_id
        INTO vcId
        FROM item
        WHERE item_id = pid;
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


FUNCTION getitemStatus(pid IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(8);
    BEGIN
        SELECT status_id
        INTO vcId
        FROM item
        WHERE item_id = pid;
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


FUNCTION getitemPublisher(pid IN NUMBER) RETURN NUMBER
IS 
    vcId NUMBER(8);
    BEGIN
        SELECT publisher_id
        INTO vcId
        FROM item
        WHERE item_id = pid;
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

end control_item;