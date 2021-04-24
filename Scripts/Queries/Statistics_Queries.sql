-- AUTOR: Renzo Barra 4/24/2021
CREATE OR REPLACE PACKAGE bookStatistics IS
    FUNCTION totalBookGenre RETURN SYS_REFCURSOR;
    FUNCTION totalLendedBook RETURN SYS_REFCURSOR;
    FUNCTION totalLendedBookGenre RETURN SYS_REFCURSOR;
    FUNCTION totalLendedBookAge RETURN SYS_REFCURSOR;
END bookStatistics;
/

CREATE OR REPLACE PACKAGE BODY bookStatistics IS
--Total y porcentaje de libros por clasificación
    FUNCTION totalBookGenre RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(i.item_id) AS total_items, COUNT(i.item_id)/(SELECT COUNT(item_id) FROM item)*100 AS percentage
                FROM (
                    SELECT *
                    FROM item i
                    INNER JOIN genre ge ON i.genre_id = ge.genre_id)
                GROUP BY i.genre;
    END totalBookGenre;
-- Total y porcentaje de libros prestados 
    FUNCTION totalLendedBook RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(pLi.item_id) AS total_lended_items, COUNT(pLi.item_id)/(SELECT COUNT(item_id) FROM item)*100 AS percentage
                FROM (
                    SELECT *
                    FROM PersonLendItem pLi);
    END totalLendedBook;
-- Total y porcentaje de libros prestados y por clasificación
    FUNCTION totalLendedBookGenre RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(pLi.item_id) AS total_lended_items, COUNT(pLi.item_id)/(SELECT COUNT(item_id) FROM item)*100 AS percentage
                FROM (
                    SELECT *
                    FROM PersonLendItem pLi
                    INNER JOIN item i ON pLi.item_id = i.item_id
                    INNER JOIN genre ge ON i.genre_id = ge.genre_id)
                GROUP BY i.genre;
    END totalLendedBookGenre;
-- Total de libros prestados por edad de la persona que lo tiene prestado
    FUNCTION totalLendedBookAge RETURN SYS_REFCURSOR
    IS
        vcCursor SYS_REFCURSOR;
    BEGIN
        OPEN vcCursor FOR
            SELECT COUNT(pLi.item_id) AS total_lended_items
            FROM (
                SELECT *
                FROM PersonLendItem pLi
                INNER JOIN person p ON p.person_id = pLi.person_id)
            ORDER BY TRUNC(months_between(p.birth_day, SYSDATE)/12) DESC;
    END totalLendedBookAge;
END;