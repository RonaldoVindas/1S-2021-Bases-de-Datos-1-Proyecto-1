CREATE OR REPLACE PACKAGE Statistics_Queries IS
    FUNCTION totalBookGenre RETURN SYS_REFCURSOR;
    FUNCTION totalLendedBook RETURN SYS_REFCURSOR;
    FUNCTION totalLendedBookGenre RETURN SYS_REFCURSOR;
    FUNCTION totalLendedBookAge RETURN SYS_REFCURSOR;
END Statistics_Queries;
/

CREATE OR REPLACE PACKAGE BODY Statistics_Queries IS
--Total y porcentaje de libros por clasificación
    FUNCTION totalBookGenre RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(item_id) AS total_items, TRUNC( COUNT(item_id)/(SELECT COUNT(item_id) FROM itemHasGenre)*100,2) AS percentage, genre
                FROM (
                    SELECT item_id, ge.genre_name AS genre
                    FROM itemHasGenre ihg
                    INNER JOIN genre ge ON ihg.genre_id = ge.genre_id)
                GROUP BY genre;
        RETURN vcCursor;
    END totalBookGenre;


-- Total y porcentaje de libros prestados 
    FUNCTION totalLendedBook RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(item_id) AS total_lended_items, COUNT(item_id)/(SELECT COUNT(item_id) FROM PersonLendItem)*100 AS percentage
                FROM (
                    SELECT item_id
                    FROM PersonLendItem)
                GROUP BY item_id
                ORDER BY percentage DESC;
        RETURN vcCursor;
    END totalLendedBook;
    
-- Total y porcentaje de libros prestados y por clasificación
    FUNCTION totalLendedBookGenre RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(plitem) AS total_lended_items, COUNT(plitem)/(SELECT COUNT(plitem) FROM PersonLendItem)*100 AS percentage, genre
                FROM (
                    SELECT pLi.item_id AS plitem, ge.genre_name AS genre
                    FROM PersonLendItem pLi
                    INNER JOIN itemHasGenre ihg ON pLi.item_id = ihg.item_id
                    INNER JOIN genre ge ON ihg.genre_id = ge.genre_id
                    WHERE ihg.item_id = pLi.item_id)
                GROUP BY genre
                ORDER BY percentage DESC;
        RETURN vcCursor;
    END totalLendedBookGenre;
-- Total de libros prestados por edad de la persona que lo tiene prestado
    FUNCTION totalLendedBookAge RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(item_id) AS total_lended_items, edad
                FROM (
                    SELECT item_id, TRUNC(months_between(SYSDATE, p.birth_day)/12) AS edad
                    FROM PersonLendItem pLi
                    INNER JOIN person p ON p.person_id = pLi.person2_id)
                GROUP BY edad
                ORDER BY edad DESC;
        RETURN vcCursor;
    END totalLendedBookAge;
END;