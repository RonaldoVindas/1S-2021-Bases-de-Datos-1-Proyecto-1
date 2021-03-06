CREATE OR REPLACE PACKAGE Statistics_Queries IS
    FUNCTION totalBookGenre RETURN SYS_REFCURSOR;
    FUNCTION totalLendedBookNow RETURN SYS_REFCURSOR;
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


-- Total y porcentaje de libros prestados actualmente
    FUNCTION totalLendedBookNow RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
            SELECT (
                    SELECT Distinct Count(item_id) from item where status_id = 0), (SELECT Count(item_id) from item where status_id > 0
                    ) 
            from personlenditem  where rownum = 1;
        RETURN vcCursor;
    END totalLendedBookNow;



-- Total y porcentaje de libros prestados desde siempre
    FUNCTION totalLendedBook RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                select x.title, count(y.item_id) AS total_lended_items, TRUNC(count(x.item_id)/(select count(item_id)from loan_history )*100,2) as percentage
                from item x
                inner join loan_history y
                on y.item_id = x.item_id
                GROUP by x.title
                order by  total_lended_items desc;
        RETURN vcCursor;
    END totalLendedBook;

    
-- Total y porcentaje de libros prestados y por clasificación
    FUNCTION totalLendedBookGenre RETURN SYS_REFCURSOR
        IS
            vcCursor SYS_REFCURSOR;
        BEGIN
            OPEN vcCursor FOR
                SELECT COUNT(plitem) AS total_lended_items, TRUNC(COUNT(plitem)/(SELECT COUNT(plitem) FROM PersonLendItem)*100,2) AS percentage, genre
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