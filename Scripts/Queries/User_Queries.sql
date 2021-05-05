-- Hecho por Renzo Barra, 4/24/2021
CREATE OR REPLACE PACKAGE users_queries IS
    FUNCTION allItemsTotal RETURN SYS_REFCURSOR;
    FUNCTION allLendedItemsTotal RETURN SYS_REFCURSOR;
    FUNCTION allItems (pTitle IN VARCHAR2, pAuthorFirstName IN VARCHAR2, pAuthorLastName IN VARCHAR2, pPublisher IN VARCHAR2) RETURN SYS_REFCURSOR;
    FUNCTION allLendedItems (pPersonFirstName IN VARCHAR2, pPersonLastName IN VARCHAR2, pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER, pNumberToleranceDaysMax IN NUMBER) RETURN SYS_REFCURSOR;
END users_queries;
/

CREATE OR REPLACE PACKAGE BODY users_queries IS
-- Cuenta la cantidad de items
    FUNCTION allItemsTotal RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT *
                FROM (
                    SELECT COUNT(item_id)
                    FROM item);
        RETURN vcCursor;
    END allItemsTotal;

-- Cuenta la cantidad de items prestados
    FUNCTION allLendedItemsTotal RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT *
                FROM (
                    SELECT COUNT(item_id)
                    FROM PersonLendItem);
        RETURN vcCursor;
    END allLendedItemsTotal;
    
-- Consulta que devuelve todos los libros
    FUNCTION allItems (pTitle IN VARCHAR2, pAuthorFirstName IN VARCHAR2, pAuthorLastName IN VARCHAR2, pPublisher IN VARCHAR2) RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT cover, title, itemEdition, barcode, itemType, status, publisher, genre, firstName, lastName
                FROM (
                    SELECT DBMS_LOB.SUBSTR(cover_image) AS cover, i.title AS title,i.edition AS itemEdition, i.barcode AS barcode, iT.itemType_name AS itemType,
                    s.status_name AS status, pu.publisher_name AS publisher, LISTAGG(ge.genre_name, ', ') WITHIN GROUP(ORDER BY ge.genre_name) AS genre,
                    p.first_name AS firstName, p.last_name AS lastName
                    FROM item i
                    INNER JOIN itemType iT ON i.itemtype_id = iT.itemtype_id
                    INNER JOIN status s ON i.status_id = s.status_id
                    INNER JOIN publisher pu ON i.publisher_id = pu.publisher_id
                    INNER JOIN itemHasGenre ihg ON i.item_id = ihg.item_id
                    INNER JOIN genre ge ON ihg.genre_id = ge.genre_id
                    INNER JOIN personCreatesItem pCi ON i.item_id = pCi.item_id
                    INNER JOIN person p ON pCi.person_id = p.person_id 
                    GROUP BY DBMS_LOB.SUBSTR(cover_image), i.title, i.edition, i.barcode, iT.itemType_name, 
                    s.status_name, pu.publisher_name, p.first_name, p.last_name)
                WHERE title LIKE CONCAT(pTitle, '%')
                AND firstName LIKE CONCAT(pAuthorFirstName, '%')
                AND lastName LIKE CONCAT(pAuthorLastName, '%')
                AND publisher LIKE CONCAT(pPublisher, '%')
                GROUP BY cover, title, itemEdition, barcode, itemType, status, publisher, genre, firstName, lastName
                ORDER BY title ASC;
        RETURN vcCursor;
    END allItems;

-- Devuelve los libros que se encuentran en prestamos con filtros de persona a quien se le presto el libro,
-- numero de dias, tolerancia minima y maxima de dias prestados y por status
    FUNCTION allLendedItems (pPersonFirstName IN VARCHAR2, pPersonLastName IN VARCHAR2, pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER, pNumberToleranceDaysMax IN NUMBER)
    RETURN SYS_REFCURSOR
        IS 
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT cover, title, itemEdition, barcode, itemType, status, publisher, genre,
                firstName, lastName, lendDate, returnDate, amountDays, yellowDays, redDays
                FROM (
                    SELECT DBMS_LOB.SUBSTR(cover_image) AS cover, i.title AS title, i.edition AS itemEdition, i.barcode AS barcode, iT.itemType_name AS itemType,
                    s.status_name AS status, pu.publisher_name AS publisher, LISTAGG(ge.genre_name, ', ') WITHIN GROUP(ORDER BY ge.genre_name) AS genre,
                    p.first_name AS firstName, p.last_name AS lastName, pLi.lend_date AS lendDate, pLi.return_date AS returnDate, pLi.amount_days AS amountDays, pLi.tolerance_days_yellow AS yellowDays,
                    pLi.tolerance_days_red AS redDays
                    FROM PersonLendItem pLi
                    INNER JOIN item i ON pLi.item_id = i.item_id
                    INNER JOIN itemType iT ON i.itemtype_id = iT.itemtype_id
                    INNER JOIN status s ON i.status_id = s.status_id
                    INNER JOIN publisher pu ON i.publisher_id = pu.publisher_id
                    INNER JOIN person p ON pLi.person2_id = p.person_id
                    INNER JOIN itemHasGenre ihg ON pLi.item_id = ihg.item_id
                    INNER JOIN genre ge ON ihg.genre_id = ge.genre_id
                    GROUP BY DBMS_LOB.SUBSTR(cover_image), i.title, i.edition, i.barcode, 
                    iT.itemType_name, s.status_name, pu.publisher_name, p.first_name, p.last_name, 
                    pLi.amount_days, pLi.tolerance_days_yellow, pLi.tolerance_days_red, pLi.lend_date, pLi.return_date)
                WHERE firstName LIKE CONCAT(pPersonFirstName, '%')
                AND lastName LIKE CONCAT(pPersonLastName, '%')
                AND amountDays <= NVL(pNumberDays, amountDays)
                AND yellowDays <= NVL(pNumberToleranceDays, yellowDays)
                AND redDays <= NVL(pNumberToleranceDaysMax, redDays)
                AND TRUNC(ABS(lendDate - returnDate), 0) + yellowDays + redDays
                <= NVL(pNumberDays, amountDays) + NVL(pNumberToleranceDays, yellowDays) + NVL(pNumberToleranceDaysMax, redDays)
                GROUP BY cover, title, itemEdition, barcode, itemType, 
                status, publisher, genre, firstName, lastName, 
                amountDays, yellowDays, redDays, lendDate, returnDate
                ORDER BY title ASC;
        RETURN vcCursor;
    END allLendedItems;
END;