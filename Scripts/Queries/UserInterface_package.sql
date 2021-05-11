Create or replace package UserInterface_package is

FUNCTION Getcollection  (Pperson_id in number)return sys_refcursor;
FUNCTION GetItems  (pPerson_id in number)return sys_refcursor;

FUNCTION GetPublishers return sys_refcursor;
FUNCTION GetItemTypes return sys_refcursor;
FUNCTION GetGenres return sys_refcursor;
FUNCTION GetGenresWithDescription return sys_refcursor;
FUNCTION GetRelationTypes return sys_refcursor;
FUNCTION GetStatus return sys_refcursor;
FUNCTION GetAuthors return sys_refcursor;
FUNCTION GetKnownPeople (Pperson1_id in number) return sys_refcursor;
FUNCTION GetLendedItems (pPerson1_id in number) return sys_refcursor;

FUNCTION updateToleranceDays (Pperson_id in number) return sys_refcursor;

FUNCTION GetcollectionNoReviews  (Pperson_id in number) return sys_refcursor;

end UserInterface_package;


/

CREATE OR REPLACE PACKAGE BODY UserInterface_package IS

FUNCTION Getcollection  (Pperson_id in number) 
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select i.item_id, i.title, p.publisher_name, i.edition, LISTAGG(g.genre_name, ', ') WITHIN GROUP(ORDER BY g.genre_name), r.stars, s.status_name

        from item i
        INNER JOIN publisher p
        ON i.publisher_id = p.publisher_id
        INNER JOIN itemhasgenre ihg
        ON i.item_id = ihg.item_id
        INNER JOIN genre g 
        ON ihg.genre_id = g.genre_id
        INNER JOIN itemhasreview ihr 
        ON i.item_id = ihr.item_id
        INNER JOIN review r
        ON ihr.review_id = r.review_id
        INNER JOIN personhasitem phi
        ON phi.item_id = i.item_id 
        INNER JOIN status s 
        ON i.status_id = s.status_id 
        WHERE phi.person_id = pPerson_id
        GROUP BY i.item_id, i.title, p.publisher_name, i.edition, r.stars,  s.status_name
    );

return vcCursor;
end;


FUNCTION GetItems (pPerson_id in number)return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
   SELECT i.title
   FROM item i
   INNER JOIN personhasitem phi
   ON i.item_id = phi.item_id
   WHERE phi.person_id = pPerson_id AND i.status_id = 0
    );

return vcCursor;
end;


FUNCTION GetPublishers
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select publisher_name
    from publisher
);
return vcCursor;
end;


FUNCTION GetItemTypes
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select itemtype_name
    from itemtype
);
return vcCursor;
end;


FUNCTION GetGenres
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select genre_name
    from genre
);

return vcCursor;
end;


FUNCTION GetGenresWithDescription
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select genre_name, description
    from genre
);

return vcCursor;
end;


FUNCTION GetRelationTypes
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select relationtype_name
    from relationtype
);

return vcCursor;
end;

FUNCTION GetStatus
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select status_name, description
    from status
);
return vcCursor;
end;



FUNCTION GetAuthors
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select first_name, last_name, email
    from person
    where persontype_id = 2
);

-----------------------------


return vcCursor;
end;

FUNCTION GetKnownPeople  (Pperson1_id in number) 
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select p.first_name, p.last_name, p.email, p.phone_number, r.relationtype_name as relation
    from person1knowsperson2 pkp
    inner join person p
    on pkp.person2_id = p.person_id 
    inner join relationtype r
    on pkp.relationtype_id = r.relationtype_id
    where pkp.person1_id = Pperson1_id
    );

return vcCursor;
end;


FUNCTION GetLendedItems (pPerson1_id in number) return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    SELECT i.title, p.first_name, p.last_name, p.email, p.phone_number, pli.lend_date, pli.return_date, pli.amount_days, pli.tolerance_days_yellow, pli.tolerance_days_red
    from item i
    INNER JOIN personhasitem phi
    on i.item_id = phi.item_id
    INNER JOIN personlenditem pli
    on phi.item_id = pli.item_id
    INNER JOIN person p
    ON pli.person2_id = p.person_id
    WHERE (select sysdate from dual) BETWEEN To_Date(pli.lend_date) AND To_Date(pli.return_date) AND pli.person1_id = pPerson1_id AND i.status_id > 0
   );

return vcCursor;
end;


FUNCTION GetcollectionNoReviews  (Pperson_id in number) 
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select i.item_id, i.title, p.publisher_name, i.edition, LISTAGG(g.genre_name, ', ') WITHIN GROUP(ORDER BY g.genre_name)

        from item i
        INNER JOIN publisher p
        ON i.publisher_id = p.publisher_id
        INNER JOIN itemhasgenre ihg
        ON i.item_id = ihg.item_id
        INNER JOIN genre g 
        ON ihg.genre_id = g.genre_id
        INNER JOIN personhasitem phi
        ON phi.item_id = i.item_id 
        INNER JOIN status s 
        ON i.status_id = s.status_id 
        WHERE phi.person_id = pPerson_id
        GROUP BY i.item_id, i.title, p.publisher_name, i.edition
    );

return vcCursor;
end;


FUNCTION updateToleranceDays (Pperson_id in number) 
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
        select pli.person2_id, pli.item_id,pli.lend_date, pli.return_date, pli.amount_days,pli.tolerance_days_yellow, pli.tolerance_days_red, i.status_id
        from personlenditem pli
        inner join item i
        on pli.item_id = i.item_id
        where pli.person1_id = Pperson_id    
    );

return vcCursor;
end;



end UserInterface_package;
