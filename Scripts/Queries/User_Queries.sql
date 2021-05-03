-- Hecho por Renzo Barra, 4/24/2021

CREATE OR REPLACE PACKAGE users_queries IS
    FUNCTION allBooks (pTitle IN VARCHAR2, pAuthorFirstName IN VARCHAR2, pAuthorLastName IN VARCHAR2, pPublisher IN VARCHAR2) RETURN SYS_REFCURSOR;
    FUNCTION allGreen (pNumberDays IN NUMBER) RETURN VARCHAR2;
    FUNCTION allYellow (pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER) RETURN VARCHAR2;
    FUNCTION allRed (pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER, pNumberToleranceDaysMax IN NUMBER) RETURN VARCHAR2;
    FUNCTION allLendedBooks (pPersonFirstName IN VARCHAR2, pPersonLastName IN VARCHAR2, pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER, pNumberToleranceDaysMax IN NUMBER) RETURN SYS_REFCURSOR;
END users_queries;
/

-- Consulta que devuelve todos los libros
CREATE OR REPLACE PACKAGE BODY users_queries IS
    FUNCTION allBooks (pTitle IN VARCHAR2, pAuthorFirstName IN VARCHAR2, pAuthorLastName IN VARCHAR2, pPublisher IN VARCHAR2) RETURN SYS_REFCURSOR
        IS 
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT *, COUNT(i.title_id)
                FROM (
                    SELECT i.title, i.itemEdition, i.barcode, iT.itemType_name, s.status_name, pu.publisher_name, ge.genre_name
                    FROM PersonCreatesItem pLi
                    INNER JOIN item i ON PersonCreatesItem.item_id = i.item_id
                    INNER JOIN person p ON PersonCreatesItem.person_id = p.person_id
                    INNER JOIN itemType iT ON i.itemtype_id = iT.itemtype_id
                    INNER JOIN status s ON i.status_id = s.status_id
                    INNER JOIN publisher pu ON i.publisher_id = pu.publisher_id
                    INNER JOIN genre ge ON i.genre_id = ge.genre_id
                    WHERE pTitle = i.title OR pAuthorFirstName = p.first_name OR pAuthorLastName = p.last_name OR pPublisher = i.publisher_id)
                ORDER BY i.title;
        RETURN vcCursor;
    END allBooks;
-- Verifica si una cantidad de dias prestamo entra en categoria de Verde

    FUNCTION allGreen (pNumberDays IN NUMBER) RETURN VARCHAR2
        IS
            vcResult VARCHAR2(50);
        BEGIN
            SELECT *
            FROM PersonLendItem;
                IF pNumberDays <= amount_days THEN
                    vcResult := 'GREEN';
                ELSE
                    vcResult := NULL;
                END IF;
            RETURN vcResult;
    END allGreen;
-- Verifica si una cantidad de dias prestamo entra en categoria de Amarillo

    FUNCTION allYellow (pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER) RETURN VARCHAR2
        IS
            vcResult VARCHAR2(50);
        BEGIN
            SELECT *
            FROM PersonLendItem;
                IF amount_days < pNumberDays AND pNumberDays <= pNumberToleranceDays THEN
                    vcResult := 'YELLOW';
                ELSE
                    vcResult := NULL;
                END IF;
            RETURN vcResult;
    END allYellow;
-- Verifica si una cantidad de dias prestamo entra en categoria de Rojo

    FUNCTION allRed (pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER, pNumberToleranceDaysMax IN NUMBER) RETURN VARCHAR2
        IS
            vcResult VARCHAR2(50);
        BEGIN
            SELECT *
            FROM PersonLendItem;
                IF amount_days < pNumberDays AND pNumberToleranceDays < pNumberDays AND pNumberDays <= pNumberToleranceDaysMax THEN
                    vcResult := 'RED';
                ELSE
                    vcResult := NULL;
                END IF;
            RETURN vcResult;
    END allRed;

-- Devuelve los libros que se encuentran en prestamos con filtros de persona a quien se le presto el libro,
-- numero de dias, tolerancia minima y maxima de dias prestados y por status
    FUNCTION allLendedBooks (pPersonFirstName IN VARCHAR2, pPersonLastName IN VARCHAR2, pNumberDays IN NUMBER, pNumberToleranceDays IN NUMBER, pNumberToleranceDaysMax IN NUMBER)
    RETURN SYS_REFCURSOR
        IS 
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT *, COUNT(PersonLendItem.item_id)
                FROM (
                    SELECT i.title, i.itemEdition, i.barcode, iT.itemType_name, s.status_name, pu.publisher_name, ge.genre_name
                    FROM PersonLendItem pLi
                    INNER JOIN item i ON pLi.item_id = i.item_id
                    INNER JOIN person p ON pLi.person_id = p.person_id
                    INNER JOIN itemType iT ON i.itemtype_id = iT.itemtype_id
                    INNER JOIN status s ON i.status_id = s.status_id
                    INNER JOIN publisher pu ON i.publisher_id = pu.publisher_id
                    INNER JOIN genre ge ON i.genre_id = ge.genre_id
                    WHERE pPersonFirstName = p.first_name OR pPersonLastName = p.last_name OR s.status_name = allGreen(pNumberDays)
                    OR s.status_name = allYellow (pNumberDays, pNumberToleranceDays) OR s.status_name = allRed (pNumberDays, pNumberToleranceDays, pNumberToleranceDaysMax))
                ORDER BY item.title;
        RETURN vcCursor;
    END allLendedBooks;
END;