Create or replace package control_ItemHasReview is
PROCEDURE insert_ItemHasReview (pitem_id IN Number,preview_id IN Number);
PROCEDURE remove_ItemHasReview (pitem_id IN Number);
ROCEDURE update_ItemHasReview(oldpitem_id IN Number,pitem_id IN Number,preview_id IN Number);
FUNCTION getItemHasReviewitem_id(pitem_id IN NUMBER) RETURN NUMBER;
FUNCTION getItemHasReviewreview_id(review_id IN NUMBER) RETURN NUMBER;
end control_ItemHasReview
/
CREATE OR REPLACE PACKAGE BODY control_ItemHasReview IS

PROCEDURE insert_ItemHasReview (pitem_id IN Number,preview_id IN Number) AS
BEGIN
	INSERT INTO ItemHasReview(item_id,review_id )
	VALUES(pitem_id,preview_id);
END insert_ItemHasReview;


PROCEDURE remove_ItemHasReview (pitem_id IN Number) AS
e_invalid_ItemHasReview EXCEPTION;
BEGIN
	DELETE FROM ItemHasReview
	WHERE item_id = pitem_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_ItemHasReview;
    END IF;
    EXCEPTION
    WHEN e_invalid_ItemHasReview THEN
        DBMS_OUTPUT.PUT_LINE('No such ItemHasReview.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to remove.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END remove_ItemHasReview;

PROCEDURE update_ItemHasReview(oldpitem_id IN Number,pitem_id IN Number,preview_id IN Number) AS
e_invalid_ItemHasReview EXCEPTION;
BEGIN
	UPDATE ItemHasReview
	SET item_id,review_id = pitem_id ,preview_id
	WHERE item_id = oldpitem_id;
	COMMIT;
    IF SQL%NOTFOUND THEN 
        RAISE e_invalid_ItemHasReview;
    END IF;
    EXCEPTION
    WHEN e_invalid_ItemHasReview THEN
        DBMS_OUTPUT.PUT_LINE('No such ItemHasReview.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error has ocurred in the attempt to update.');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
END update_ItemHasReview;

FUNCTION getItemHasReviewitem_id(pitem_id IN NUMBER) RETURN NUMBER
IS 
    vcitem_id NUMBER(11);
    BEGIN
        SELECT item_id
        INTO vcitem_id
        FROM ItemHasReview
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

FUNCTION getItemHasReviewreview_id(review_id IN NUMBER) RETURN NUMBER
IS 
    vcreview_idd NUMBER(11);
    BEGIN
        SELECT review_id
        INTO vcreview_id
        FROM ItemHasReview
        WHERE review_id = preview_id;
        RETURN (vcreview_id);
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



end control_ItemHasReview;