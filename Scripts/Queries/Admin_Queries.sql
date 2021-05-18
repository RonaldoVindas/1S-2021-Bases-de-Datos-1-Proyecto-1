create or replace package admin_queries is
function NotBorrowed return sys_refcursor;
function NotBorrowedTotal return sys_refcursor;
function TopMostBorrowed(pNumber in number) return sys_refcursor; 
function MostBorrowedPerMonth(pTimes in number, pMonth in number) return sys_refcursor;
function AgeOfPeopleLoan return sys_refcursor;
FUNCTION systemLogOperations(pStartingDate DATE, pEndDate DATE, pObject VARCHAR2, pTypeChange VARCHAR2, pUsername VARCHAR2) RETURN SYS_REFCURSOR;
end admin_queries;

/

create or replace PACKAGE BODY admin_queries IS

function NotBorrowed 
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for 
select * 
from(
    Select i.item_id, i.title, i.barcode, it.itemType_name type
    FROM item i
    INNER JOIN itemType it
    ON i.itemtype_id = it.itemtype_id
    WHERE i.status_id = 0
    ORDER BY i.item_id
    );

return vcCursor;
end;


function NotBorrowedTotal return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for 
select * 
from(
  SELECT Count(item_id)
    FROM item
    WHERE status_id = 0
    );

return vcCursor;
end;

function TopMostBorrowed (pNumber in number) 
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    Select  i.title, count(lh.item_id) as top
    from loan_history lh
    inner join item i
    on lh.item_id = i.item_id
    group by i.title
    order By top desc
    )
where rownum <= pNumber;
return vcCursor;
end;

function  MostBorrowedPerMonth(pTimes in number, pMonth in number)
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select * 
from(
    select i.title, count(lh.item_id)
    from loan_history lh
    inner join item i
    on lh.item_id = i.item_id
    where lh.lend_date >= (sysdate-(pMonth*31))
    group by i.title
    having count(lh.item_id) >= pTimes
    );
return vcCursor;
end;

function AgeOfPeopleLoan
return sys_refcursor
as
vcCursor sys_refcursor;
begin
open vcCursor for
select CASE
    when age<=18 then '0-18'
    when age<=30 then '19-30'
    when age<=45 then '31-45'
    when age<=60 then '46-60'
    when age<=75 then '61-75'
    else '75+'
    end as age,
    count(*) as person_cuantity

    from(
        select Distinct trunc(months_between(sysdate, p.birth_day)/12) as age
        from loan_history lh
        inner join person p
        on lh.person2_id = p.person_id
        
        )
   
    group by case    
    when age<=18 then '0-18'
    when age<=30 then '19-30'
    when age<=45 then '31-45'
    when age<=60 then '46-60'
    when age<=75 then '61-75'
    else '75+' 

end
order by age asc;

return vcCursor;
end;

FUNCTION systemLogOperations(pStartingDate DATE, pEndDate DATE, pObject VARCHAR2, pTypeChange VARCHAR2, pUsername VARCHAR2) RETURN SYS_REFCURSOR
        IS
            vcCursor sys_refcursor;
        BEGIN 
            OPEN vcCursor FOR
                SELECT sl.systemlog_id, sL.description, sL.object, sL.type_change, sl.creation_date, sl.creation_user,
                sl.date_last_modification, sl.user_last_modification
                FROM systemLog sL
                WHERE pStartingDate <= sL.creation_date
                AND sL.creation_date <= pEndDate
                AND sL.object LIKE CONCAT(pObject, '%')
                AND sL.type_change LIKE CONCAT(pTypeChange, '%')
                AND sL.creation_user LIKE CONCAT(pUsername, '%');
        RETURN vcCursor;
END systemLogOperations;

end admin_queries;




  


  
