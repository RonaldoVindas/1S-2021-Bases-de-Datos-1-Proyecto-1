USE `pe`;
DROP procedure IF EXISTS `ADMIN_QUERIES_NotBorrowed`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `ADMIN_QUERIES_NotBorrowed` ()
BEGIN
select * 
from(
    Select i.item_id, i.title, i.barcode, it.itemType_name type
    FROM item i
    INNER JOIN itemType it
    ON i.itemtype_id = it.itemtype_id
    WHERE i.status_id = 1
    ORDER BY i.title
    ) as a;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `ADMIN_QUERIES_NotBorrowedTotal`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `ADMIN_QUERIES_NotBorrowedTotal` ()
BEGIN
select * 
from(
  SELECT Count(item_id)
    FROM item
    WHERE status_id = 1
    ) as a;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `ADMIN_QUERIES_TopMostBorrowed`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADMIN_QUERIES_TopMostBorrowed`(pNumber int)
BEGIN
select * 
from(
    Select  i.title, count(lh.item_id) as top
    from loan_history lh
    inner join item i
    on lh.item_id = i.item_id
    group by i.title
    order By top desc
    ) as a 
    LIMIT pNumber;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `ADMIN_QUERIES_MostBorrowedPerMonth`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADMIN_QUERIES_MostBorrowedPerMonth`(pTimes int, pMonth int)
BEGIN
select * 
from(
    select i.title, count(lh.item_id)
    from loan_history lh
    inner join item i
    on lh.item_id = i.item_id
    where lh.lend_date >= (DATE_SUB(sysdate(),INTERVAL pMonth month))
    group by i.title
    having count(lh.item_id) >= pTimes
    ) as a ;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `ADMIN_QUERIES_AgeOfPeopleLoan`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADMIN_QUERIES_AgeOfPeopleLoan`()
BEGIN
Select CASE
    when age<=18 then '0-18'
    when age<=30 then '19-30'
    when age <=45 then '31-45'
    when age<=60 then '46-60'
    when age <=75 then '61-75'
    else '75+'
    end
    as 'ageFilter',
    count(*) as person_cuantity
    
from(
select  truncate((TIMESTAMPDIFF(MONTH,p.birth_day, sysdate()))/12,0) as age
	from loan_history lh
	inner join person p
	on lh.person2_id = p.person_id
    
)  as a
group by CASE

    when age<=18 then '0-18'
    when age<=30 then '19-30'
    when age<=45 then '31-45'
    when age<=60 then '46-60'
    when age<=75 then '61-75'
    else '75+'

    end
    order by age asc;


END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `CONTROL_GENRE_insert_genre`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `CONTROL_GENRE_insert_genre` (in pname VARCHAR(20),in pdescription VARCHAR(140))
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
	DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
	DECLARE EXIT HANDLER FOR 1172 SELECT 'Result consisted of more than one row.' Message;
	DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
	DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
	DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
	
    INSERT INTO genre(genre_name,description)
    VALUES(pname,pdescription);
    COMMIT;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_Gendre_RemoveGenre`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Gendre_RemoveGenre` (IN pid_genre int)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1172 SELECT 'Result consisted of more than one row.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
	DELETE FROM genre
    WHERE genre_id = pid_genre;
    COMMIT;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_Genre_UpdateGenre`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Genre_UpdateGenre` (IN pId INT, IN pName VARCHAR(20), IN pDescription VARCHAR(140))
BEGIN

DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1172 SELECT 'Result consisted of more than one row.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE genre 
SET 
    genre_name = pName,
    description = pDescription
WHERE
    genre_id = pId;
    COMMIT;

END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Genre_getGenreName`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_Genre_getGenreName`(pId INT) RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(20);
SET vcName = (SELECT genre_name FROM genre WHERE genre_id = pId);
RETURN vcName;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Genre_getGenreDescription`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Genre_getGenreDescription` (pId INT)
RETURNS VARCHAR(140)
DETERMINISTIC
BEGIN
DECLARE vcDescription VARCHAR(140);
SET vcDescription = (SELECT description FROM genre WHERE genre_id = pId);
RETURN vcDescription;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Genre_getGenreId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Genre_getGenreId` (pName VARCHAR(20))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT genre_id FROM genre WHERE genre_name = pName);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `pe`.`Control_Item_InsertItemA`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Control_Item_InsertItemA`(IN pTitle VARCHAR(50), IN pEdition VARCHAR(30), IN pCover LONGBLOB, IN pBarcode VARCHAR(12), IN pItemType_id INT, IN pStatus_id INT, IN pPublisher INT 	)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
	INSERT INTO item(title, edition, cover_image, barcode, itemtype_id, status_id, publisher_id)
	VALUES(ptitle, pedition, pcover, pbarcode, pitemtype_id, pstatus_id, ppublisher_id);
	COMMIT;
END$$


DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Item_InsertItemB`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_InsertItemB` ( )
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;


SET vcId = last_insert_id();
RETURN vcId;
END$$

DELIMITER ;




DELIMITER ;
;




USE `pe`;
DROP procedure IF EXISTS `Control_Item_UpdateItem`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Control_Item_UpdateItem`(IN pItem_id INT, IN pTitle VARCHAR(50), IN pEdition VARCHAR(30), IN pBarcode VARCHAR(12), IN pItemType_id INT, IN pStatus_id INT, IN pPublisher_id INT )
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE item
SET
	title = pTitle,
	edition = pEdition,
	barcode = pBarcode,
	itemtype_id = pItemType_id,
	status_id = pStatus_id,
	publisher_id = pPublisher_id
WHERE
	item_id = pItem_id;
	COMMIT;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `pe`.`Control_Item_UpdateItemCover`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Control_Item_UpdateItemCover`(IN pItem_id INT, IN pCover LONGBLOB)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

	UPDATE item
	SET
    	cover_image = pCover
	WHERE item_id = pItem_id;
	COMMIT;
END$$

DELIMITER ;
;

USE `pe`;
DROP procedure IF EXISTS `Control_Item_UpdateItemStatus`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Item_UpdateItemStatus` (IN pId INT, IN pStatus_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


UPDATE item
SET
	status_id = pStatus_id
WHERE
	item_id = pId;
	COMMIT;

END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Item_getItemTitle`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getItemTitle` (pId INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(50);
SET vcName = (SELECT title FROM item WHERE item_id = pId);
RETURN vcName;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Item_getItemEdition`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getItemEdition` (pId INT)
RETURNS VARCHAR(30)
DETERMINISTIC
BEGIN
DECLARE vcEdition VARCHAR(30);
SET vcEdition = (SELECT edition FROM item WHERE item_id = pId);
RETURN vcEdition;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Item_getItemCover`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getItemCover` (pId int)
RETURNS LONGBLOB
DETERMINISTIC
BEGIN
DECLARE vcCover LONGBLOB;
SET vcCover = (SELECT cover_image FROM item WHERE item_id = pid);
RETURN vcCover;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Item_getItemBarcode`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getItemBarcode` (pId INT)
RETURNS varchar(12)
DETERMINISTIC
BEGIN
DECLARE vcBarcode VARCHAR(12);
SET vcBarcode = (SELECT barcode FROM item WHERE item_id = pId);
RETURN vcBarcode;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Item_getItemItemType`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getItemItemType` (pid INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT itemtype_id FROM item WHERE item_id = pid);
RETURN vcId;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Item_getStatus`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getStatus` (pId INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT status_id FROM item WHERE item_id = pId);
RETURN vcId;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Item_getItemPublisher`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getItemPublisher` (pId INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT publisher_id FROM item WHERE item_id = pid);
RETURN vcId;
END$$

DELIMITER ;USE `pe`;

DROP procedure IF EXISTS `Control_ItemHasGenre_InsertItemHasGenre`;
DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemHasGenre_InsertItemHasGenre` (IN pItem_id INT, IN pGenre_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO itemHasGenre(item_id,genre_id)
VALUES(pItem_id,pGenre_id);
COMMIT;

END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_ItemHasGenre_RemoveItemHasGenre`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemHasGenre_RemoveItemHasGenre` ( IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM itemHasGenre
WHERE item_id = pItem_id;
COMMIT;


END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_ItemHasGenre_UpdateItemHasGenre`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemHasGenre_UpdateItemHasGenre` (IN pId_old INT, IN pItem_id INT, IN pGenre_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


UPDATE itemHasGenre
SET
	item_id = pItem_id,
	genre_id = pGenre_id
WHERE
	item_id = pId_old;
COMMIT;

END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_ItemHasGenre_getItemHasGenreItemId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_ItemHasGenre_getItemHasGenreItemId` (pGenre_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT item_id FROM itemHasGenre WHERE genre_id = pGenre_id);
RETURN vcId;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Item_getItemId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Item_getItemId` (pTitle VARCHAR(50))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = ( SELECT item_id FROM item WHERE title = ptitle);
RETURN vcId;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_ItemHasGenre_getItemHasGenreGenreId`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_ItemHasGenre_getItemHasGenreGenreId`(pItem_id INT) RETURNS int
	DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = ( SELECT genre_id FROM itemHasGenre WHERE item_id = pItem_id limit 1);

RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_ItemHasReview_InsertItemHasReview`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemHasReview_InsertItemHasReview` (IN pItem_id INT, IN pReview_id INT )
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO ItemHasReview(item_id,review_id)
VALUES(pItem_id,pReview_id);
COMMIT;


END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_ItemHasReview_RemoveItemHasReview`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemHasReview_RemoveItemHasReview` (IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM ItemHasReview
WHERE item_id = pItem_id;
COMMIT;

END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_ItemHasReview_UpdateItemHasReview`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemHasReview_UpdateItemHasReview` (IN pItem_id_old INT, IN pItem_id INT, IN pReview_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE ItemHasReview
SET
	item_id = pItem_id,
	review_id = pReview_id
WHERE
	item_id = pItem_id_old;

END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_ItemHasReview_getItemHasReviewItemId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_ItemHasReview_getItemHasReviewItemId` (pReview_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcID = (SELECT item_id FROM ItemHasReview WHERE review_id = pReview_id limit 1);
RETURN vcID;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_ItemHasReview_getItemHasReviewReview_id`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_ItemHasReview_getItemHasReviewReview_id` (pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT review_id FROM ItemHasReview WHERE item_id = pItem_id);

RETURN vcId;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_ItemType_InsertItemType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemType_InsertItemType` (IN pItemtype_name VARCHAR(20))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


INSERT INTO ItemType(itemType_name)
VALUES(pItemtype_name);
COMMIT;


END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_ItemType_RemoveItemType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemType_RemoveItemType` (IN pItemType_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM ItemType
WHERE itemtype_id = pItemType_id;
COMMIT;

END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_ItemType_UpdateItemType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_ItemType_UpdateItemType` (IN pItemtype_id INT, IN pItemtype_name VARCHAR(20))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE ItemType
SET itemType_name  = pItemtype_name
WHERE itemtype_id = pItemtype_id;
COMMIT;

END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_ItemType_getItemTypeName`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_ItemType_getItemTypeName` (pItemType_id INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
DECLARE vcName INT;
SET vcName = (SELECT itemType_name FROM itemtype WHERE itemtype_id = pItemType_id);
RETURN vcName;
END$$

DELIMITER ;
USE `pe`;
DROP function IF EXISTS `Control_ItemType_getItemTypeId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_ItemType_getItemTypeId` (pItemType_name VARCHAR(20))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcID INT;
SET vcId = ( SELECT itemtype_id FROM itemType WHERE itemType_name = pItemType_name);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_Person_InsertPerson`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Person_InsertPerson` (IN pId INT, IN pFirname VARCHAR(50),IN pLasname VARCHAR(50), In pEmail VARCHAR(50), In pPassword VARCHAR(25), In pPhone VARCHAR(25), IN pDate VARCHAR(100), IN pPersonType_id INT )
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


INSERT INTO person(person_id,first_name,last_name,email,password,phone_number,birth_day,persontype_id)
VALUES(pId, pFirname, pLasname, pEmail, SHA(pPassword), pPhone, str_to_date(pDate, '%Y/%m/%d'), pPersonType_id);
COMMIT;

END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_Person_RemovePerson`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Person_RemovePerson` (IN pId INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM person
WHERE person_id = pId;
COMMIT;


END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_Person_UpdatePerson`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Person_UpdatePerson` (IN pId INT, IN pFirname VARCHAR(50), IN pLasname VARCHAR(50), IN pEmail VARCHAR(50), IN pPassword VARCHAR(25), IN pPhone VARCHAR(8), IN pDate VARCHAR(100) )
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE person
    SET first_name = pFirname,
    	last_name = pLasname,
    	email = pEmail,
    	password = RSA(pPassword),
    	phone_number = pPhone,
    	birth_day = str_to_date(pDate, '%Y/%m/%d')
    WHERE person_id = pId;
    COMMIT;

END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonId` (pEmail VARCHAR(50))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = ( SELECT person_id FROM person WHERE email = pemail);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonId2`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonId2` (pFirname VARCHAR(50), pLasname VARCHAR(50))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcID = (   SELECT person_id FROM person WHERE first_name = pFirname AND last_name = pLasname);
RETURN vcID;
END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonFirstName`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonFirstName` (pId int)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(50);
SET vcName = (SELECT first_name FROM person WHERE person_id = pId);
RETURN vcName;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonLastName`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonLastName` (pId INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(50);
SET vcName = (SELECT last_name FROM person WHERE person_id = pId);
RETURN vcName;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonEmail`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonEmail` (pId INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
DECLARE vcEmail VARCHAR(50);
SET vcEmail = (SELECT email FROM person WHERE person_id = pId);
RETURN vcEmail;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonPassword`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonPassword` (pId INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
DECLARE vcPassword VARCHAR(100);
SET vcPassword =  ( SELECT person.Password FROM person WHERE person_id = pid);
RETURN vcPassword;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonPhoneNumber`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonPhoneNumber` (pId INT)
RETURNS VARCHAR(8)
DETERMINISTIC
BEGIN
DECLARE vcPhone VARCHAR(8);
SET vcPhone = (SELECT phone_number FROM person WHERE person_id = pId);
RETURN vcPhone;
END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonBirthDay`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonBirthDay` (pId INT)
RETURNS DATETIME
DETERMINISTIC
BEGIN
DECLARE vcBirthday DATETIME;
SET vcBirthday = (SELECT birth_day FROM person WHERE person_id = pId);
RETURN vcBirthday;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Person_getPersonPersonType`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person_getPersonPersonType` (pId INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT persontype_id FROM person WHERE person_id = pId);
RETURN vcId;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `EncryptPassword`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `EncryptPassword`(pPassword VARCHAR(100)) RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
DECLARE vcEncrypt VARCHAR(100);
SET vcEncrypt = ( SELECT SHA(pPassword) );
RETURN vcEncrypt;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_Person1KnowsPerson2_InsertPer1KnowsPer2`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Person1KnowsPerson2_InsertPer1KnowsPer2` (IN pPerson1_id INT, IN pPerson2_id INT, IN pRelationType_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO person1knowsperson2(person1_id, person2_id, relationtype_id)
VALUES(pPerson1_id,pPerson2_id, pRelationType_id );
COMMIT;

END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_Person1KnowsPerson2_RemovePer1KnowsPer2`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Person1KnowsPerson2_RemovePer1KnowsPer2` (IN pPerson1_id INT, IN pPerson2_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM person1knowsperson2
WHERE person1_id = pPerson1_id AND person2_id = pPerson2_id;
COMMIT;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_Person1KnowsPerson2_UpdatePer1KnowsPer2`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Person1KnowsPerson2_UpdatePer1KnowsPer2` (IN pPerson1_idold INT, IN pPerson1_id INT, IN pPerson2_id INT, IN pRelationType_id INT)
BEGIN

DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE person1knowsperson2
SET
	person1_id = pPerson1_id,
	person2_id = pPerson2_id,
	relationtype_id = pRelationType_id
WHERE
	person1_id = pPerson1_idold;
	COMMIT;
END$$

DELIMITER ;





USE `pe`;
DROP function IF EXISTS `Control_Person1KnosPerson2_getPer1KnowsPer2Person1Id`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person1KnosPerson2_getPer1KnowsPer2Person1Id` (pPerson2_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT person1_id FROM person1knowsperson2 WHERE person2_id = pid_perpPerson2_idson2);
RETURN vcId;
END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_Person1KnowsPerson2_getPer1KnowsPer2Person2Id`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person1KnowsPerson2_getPer1KnowsPer2Person2Id` (pPerson1_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT person2_id FROM person1knowsperson2 WHERE person1_id = pPerson1_id);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Person1KnowsPerson2_getPer1KnowsPer2RelTypeId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Person1KnowsPerson2_getPer1KnowsPer2RelTypeId` (pPerson1_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT relationtype_id FROM person1knowsperson2 WHERE person1_id = pPerson1_id);
RETURN vcID;
END$$

DELIMITER ;






	
USE `pe`;
DROP procedure IF EXISTS `Control_PersonCreatesItem_InserPersonCreatesItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonCreatesItem_InserPersonCreatesItem` (IN pPerson_id INT, pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO personcreatesitem(person_id, item_id)
VALUES(pPerson_id, pItem_id);
COMMIT;

END$$

DELIMITER ;







USE `pe`;
DROP procedure IF EXISTS `Control_PersonCreatesItem_RemovePersonCreatesItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonCreatesItem_RemovePersonCreatesItem` (IN pPerson_id INT, IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM personcreatesitem
WHERE person_id = pPerson_id AND item_id = pItem_id;
COMMIT;
    
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_PersonCreatesItem_UpdatePersonCreatesItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonCreatesItem_UpdatePersonCreatesItem` (IN pPerson_idold INT, IN pPerson_id INT, IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE personcreatesitem
SET
	person_id = pPerson_id,
	item_id = pItem_id
WHERE
	person_id = pPerson_idold;
COMMIT;


END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_PersonCreatesItem_getPersonCreatesItemPersonId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonCreatesItem_getPersonCreatesItemPersonId` (pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
set vcId = ( SELECT person_id FROM personcreatesitem WHERE item_id = pItem_id);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_PersonCreatesItem_getPersonCreatesItemItemId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonCreatesItem_getPersonCreatesItemItemId` (pPerson_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT item_id FROM personcreatesitem WHERE person_id = pid_person);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_PersonCreatesItem_getPersonCreatesItemItemId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonCreatesItem_getPersonCreatesItemItemId` (pPerson_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT item_id FROM personcreatesitem WHERE person_id = pid_person);
RETURN vcId;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_PersonHasItem_InsertPersonHasItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonHasItem_InsertPersonHasItem` (IN pPerson_id INT, IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO personhasitem (person_id, item_id)
VALUES (pPerson_id, pItem_id);
COMMIT;

END$$

DELIMITER ;









USE `pe`;
DROP procedure IF EXISTS `Control_PersonHasItem_RemovePersonHasItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonHasItem_RemovePersonHasItem` (IN pPerson_id INT, IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM personhasitem
WHERE person_id = pPerson_id AND item_id = pItem_id;
COMMIT;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_PersonHasItem_UpdatePersonHasItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonHasItem_UpdatePersonHasItem` (IN pPerson_idold INT, IN pPerson_id INT, IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE personhasitem
SET person_id = pPerson_id,
    	item_id = pItem_id
WHERE person_id = pPerson_idold;
COMMIT;
END$$

DELIMITER ;









USE `pe`;
DROP function IF EXISTS `Control_PersonHasItem_getPersonHasItemPerson`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonHasItem_getPersonHasItemPerson` (pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT person_id FROM personhasitem WHERE item_id = pItem_id);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_PersonHasITem_getPersonHasItemItemId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonHasITem_getPersonHasItemItemId` (pPerson_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT item_id FROM personhasitem WHERE person_id = pPerson_id);
RETURN vcId;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_PersonLendItem_InsertPersonLendItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonLendItem_InsertPersonLendItem` (IN pPerson1_id INT, IN pPerson2_id INT, IN pItem_id INT, IN pReturnDate VARCHAR(100), IN pToleranceYellow INT, IN pToleranceRed INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


INSERT INTO personlenditem (person1_id, person2_id, item_id, lend_date, return_date, amount_days, tolerance_days_yellow, tolerance_days_red)
 VALUES (pPerson1_id, pPerson2_id, pItem_id,(SELECT curdate() ), (SELECT str_to_date(pReturnDate, '%Y-%m-%d') ), (SELECT DATEDIFF(pReturnDate, CURDATE() ) ), pToleranceYellow, pToleranceRed);
 /*Select se encarga de calcular la cantidad de días entre la fecha de préstamos y la fecha de retorno del ítem.*/
 COMMIT;



END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_PersonLendItem_RemovePersonLendItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonLendItem_RemovePersonLendItem` (IN pItem_id INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


DELETE FROM personlenditem
WHERE
	item_id = pItem_id;
COMMIT;
END$$

DELIMITER ;




USE `pe`;
DROP procedure IF EXISTS `Control_PersonLendItem_UpdatePersonLendItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonLendItem_UpdatePersonLendItem` (IN pPerson1_idold INt, IN pPerson_id INT,IN pPerson2_idold INT, IN pPerson2_id INT, IN pItem_id INT, IN pLendDate VARCHAR(100), IN pReturnDate VARCHAR(100), IN pToleraceYellow INT, IN pToleranceRed INT )
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE personlenditem
SET
	person1_id = pPerson_id,
	person2_id = pPerson2_id,
	item_id = pItem_id,
	lend_date = (SELECT str_to_date(pLendDate, '%Y-%m-%d') ),
	return_date = (SELECT str_to_date(pReturnDate, '%Y-%m-%d') ),
	amount_days = (SELECT DATEDIFF(pReturnDate, CURDATE() ) ),
	tolerance_days_yellow = pToleraceYellow,
	tolerance_days_red = pToleranceRed
WHERE
	person1_id = pPerson1_idold
	AND person2_id = pPerson2_idold;
	COMMIT;


END$$


USE `pe`;
DROP procedure IF EXISTS `Control_PersonLendItem_UpdatePersonLenItemRetDate`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonLendItem_UpdatePersonLenItemRetDate` (IN pPerson1_id INT, IN pPerson2_id INT, IN pReturnDate VARCHAR(100))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


UPDATE personlenditem
SET
	return_date =  (SELECT str_to_date(pReturnDate, '%Y-%m-%d') )
WHERE
	person1_id = pPerson1_id
    	AND person2_id = pPerson2_id;
	COMMIT;

END$$

DELIMITER ;





USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemPerson1Id`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemPerson1Id` (pPerson2_id INT, pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = ( SELECT person1_id FROM personlenditem WHERE person2_id = pPerson2_id AND item_id = pItem_id);
RETURN vcId;
END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemPeron2Id`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemPeron2Id` (pPerson1_id INT, pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = ( SELECT person2_id FROM personlenditem WHERE person1_id = pPerson1_id AND item_id = pItem_id);
RETURN vcId;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemItemId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemItemId` (pPerson1_id INT, pPerson2_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcID INT;
SET vcId = (SELECT item_id FROM personlenditem WHERE person1_id = pperson1_id AND person2_id = pperson2_id);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemLendDate`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemLendDate` ( pPerson1_id INT, pPerson2_id INT, pItem_id INT)
RETURNS DATETIME
DETERMINISTIC
BEGIN
DECLARE vcDate DATETIME;
SET vcDate = (SELECT lend_date FROM personlenditem WHERE person1_id = pPerson1_id AND person2_id = pPerson2_id AND item_id = pItem_id);
RETURN vcDate;
END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemReturnDate`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemReturnDate` (pPerson1_id INT, pPerson2_id INT, pItem_id INT)
RETURNS DATETIME
DETERMINISTIC
BEGIN
DECLARE vcDate DATETIME;
SET vcDate = (SELECT return_date FROM personlenditem WHERE person1_id = pPerson1_id AND person2_id = pPerson2_id AND item_id = pItem_id);
RETURN vcDate;
END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemAmountDays`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemAmountDays` (pPerson1_id INT, pPerson2_id INT, pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcDays INT;
SET vcDays = ( SELECT amount_days FROM personlenditem WHERE person1_id = pPerson1_id AND person2_id = pPerson2_id AND item_id = pItem_id);
RETURN vcDays;
END$$

DELIMITER ;





USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemToleranceYellow`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemToleranceYellow` (pPerson1_id INT, pPerson2_id INT, pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcTolerance INT;
SET vcTolerance = (SELECT tolerance_days_yellow FROM personlenditem WHERE person1_id = pPerson1_id AND person2_id = pPerson2_id AND item_id = pItem_id);
RETURN vcTolerance;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_PersonLendItem_getPersonLendItemToleranceRed`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonLendItem_getPersonLendItemToleranceRed` (pPerson1_id INT, pPerson2_id INt, pItem_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcTolerance INT;
SET vcTolerance = (SELECT tolerance_days_red FROM personlenditem WHERE person1_id = pPerson1_id AND person2_id = pPerson2_id AND item_id = pItem_id);
RETURN vcTolerance;
END$$

DELIMITER ;





USE `pe`;
DROP procedure IF EXISTS `Control_PersonType_InsertPersonType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonType_InsertPersonType` (IN pName VARCHAR(20))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO PersonType(persontype_name)
VALUES(pName);
COMMIT;

END$$

DELIMITER ;




USE `pe`;
DROP procedure IF EXISTS `Control_PersonType_RemovePersonType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonType_RemovePersonType` (IN pId INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM PersonType
WHERE
	persontype_id = pId;
    COMMIT;
    
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_PersonType_UpdatePersonType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_PersonType_UpdatePersonType` (IN pId INT, IN pName VARCHAR(20))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE PersonType
SET
	persontype_name = pName
WHERE
	persontype_id = pId;
    COMMIT;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_PersonType_getPersonTypeId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonType_getPersonTypeId` (pName VARCHAR(20))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT persontype_id FROM PersonType WHERE persontype_name = pname);
RETURN vcId;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_PersonType_getPersonTypeName`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_PersonType_getPersonTypeName` (pId INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(20);
SEt vcName = ( SELECT persontype_name FROM PersonType WHERE persontype_id = pid);
RETURN vcName;
END$$

DELIMITER ;




USE `pe`;
DROP procedure IF EXISTS `Control_Publisher_InsertPublisher`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Publisher_InsertPublisher` (IN pName VARCHAR(100))
BEGIN

DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
INSERT INTO publisher(publisher_name)
    VALUES(pName);
	COMMIT;  
END$$

DELIMITER ;







USE `pe`;
DROP procedure IF EXISTS `Control_Publisher_RemovePublisher`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Publisher_RemovePublisher` (IN pId INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM publisher
    WHERE publisher_id = pId;
    COMMIT;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_Publisher_UpdatePublisher`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Publisher_UpdatePublisher` (IN pId INT, IN pName VARCHAR(100))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
UPDATE publisher
SET
	publisher_name = pName
WHERE
	publisher_id = pId;

END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_Publisher_getPublisherId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Publisher_getPublisherId` (pName VARCHAR(100))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT publisher_id FROM publisher WHERE publisher_name = pName);
RETURN vcId;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Publisher_getPublisherName`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Publisher_getPublisherName` (pId INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(100);
SET vcName = ( SELECT publisher_name FROM publisher WHERE publisher_id = pId);
RETURN vcName;
END$$

DELIMITER ;




USE `pe`;
DROP procedure IF EXISTS `Control_RelationType_InsertRelationType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_RelationType_InsertRelationType` (IN pName VARCHAR(100))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO relationtype(relationtype_name)
    VALUES(pName);
	COMMIT;  

END$$

DELIMITER ;








USE `pe`;
DROP procedure IF EXISTS `Control_RelationType_RemoveRelationType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_RelationType_RemoveRelationType` (IN pId INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM relationtype
    WHERE relationtype_id = pId;
    COMMIT;
END$$

DELIMITER ;







USE `pe`;
DROP procedure IF EXISTS `Control_RelationType_UpdateRelationType`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_RelationType_UpdateRelationType` (IN pId INT, IN pName VARCHAR(100))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
UPDATE relationtype
    SET relationtype_name = pName
    WHERE relationtype_id = pId;
END$$

DELIMITER ;




USE `pe`;
DROP function IF EXISTS `Control_RelationType_getrelationTypeId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_RelationType_getrelationTypeId` (pName VARCHAR(100))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT relationtype_id FROM relationtype WHERE relationtype_name = pname);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_RelationType_getrelationTypeName`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_RelationType_getrelationTypeName` (pId INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(100);
SET vcName = ( SELECT relationtype_name FROM relationtype WHERE relationtype_id = pId);
RETURN vcName;
END$$

DELIMITER ;





USE `pe`;
DROP procedure IF EXISTS `Control_Review_InsertReview`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Review_InsertReview` (IN pStars INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO review(stars)
    VALUES(pStars);
	COMMIT;
END$$

DELIMITER ;




USE `pe`;
DROP procedure IF EXISTS `Control_Review_RemoveReview`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Review_RemoveReview` (IN pId INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

DELETE FROM review
WHERE
	review_id = pId;
    COMMIT;
END$$

DELIMITER ;





USE `pe`;
DROP procedure IF EXISTS `Control_Review_UpdateReview`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Review_UpdateReview` (IN pId INT, IN pStars INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE review
SET
	stars = pStars
WHERE
	review_id = pId;
    COMMIT;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Review_getReviewId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Review_getReviewId` (pStars INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT review_id FROM review WHERE stars = pstars);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_Review_getReviewStars`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Review_getReviewStars` (pId INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcStars INT;
SET vcStars = (SELECT stars FROM review WHERE review_id = pId);
RETURN vcStars;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_Status_InsertStatus`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Status_InsertStatus` (IN pName VARCHAR(100), IN pDescription VARCHAR(250))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO status(status_name, description)
    VALUES(pName, pDescription);
	COMMIT;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_Status_RemoveStatus`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Status_RemoveStatus` (IN pId INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
DELETE FROM status
    WHERE status_id = pId;
    COMMIT;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_Status_UpdateStatus`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Status_UpdateStatus` (IN pId INT, IN pName VARCHAR(100), IN pDescription VARCHAR(250))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE status
SET
	status_name = pName,
	description = pDescription
WHERE
	status_id = pId;
    COMMIT;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Status_getStatusId`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Status_getStatusId` (pName VARCHAR(100))
RETURNS INTEGER
DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = ( SELECT status_id FROM status WHERE status_name = pName);
RETURN vcId;
END$$

DELIMITER ;



USE `pe`;
DROP function IF EXISTS `Control_Status_getStatusName`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Status_getStatusName` (pId INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
DECLARE vcName VARCHAR(100);
SET vcName = ( SELECT status_name FROM status WHERE status_id = pid);
RETURN vcName;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Status_getStatusDescription`;

DELIMITER $$
USE `pe`$$
CREATE FUNCTION `Control_Status_getStatusDescription` (pId INT)
RETURNS VARCHAR(250)
DETERMINISTIC
BEGIN
DECLARE vcDescription VARCHAR(250);
SEt vcDescription = (SELECT description FROM status WHERE status_id = pid);
RETURN vcDescription;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `Control_LoanHistory_InsertLoanHistory`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Control_LoanHistory_InsertLoanHistory`(IN pPerson1_id INT, IN pPerson2_id INT, IN pItem_id INT, IN pReturnDate VARCHAR(100), IN pToleranceYellow INT, IN pToleranceRed INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


INSERT INTO loan_history (person1_id, person2_id, item_id, lend_date, return_date, amount_days, tolerance_days_yellow, tolerance_days_red)
 VALUES (pPerson1_id, pPerson2_id, pItem_id,(SELECT curdate() ), (SELECT str_to_date(pReturnDate, '%Y-%m-%d') ), (SELECT DATEDIFF(pReturnDate, CURDATE() ) ), pToleranceYellow, pToleranceRed);
 /*Select se encarga de calcular la cantidad de días entre la fecha de préstamos y la fecha de retorno del ítem.*/
 /**/
 COMMIT;


END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_Item_UpdateItem`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Control_Item_UpdateItem`(IN pItem_id INT, IN pTitle VARCHAR(50), IN pEdition VARCHAR(30), IN pBarcode VARCHAR(12), IN pItemType_id INT, IN pStatus_id INT, IN pPublisher_id INT )
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;
/**/
UPDATE item
SET
	title = pTitle,
	edition = pEdition,
	barcode = pBarcode,
	itemtype_id = pItemType_id,
	status_id = pStatus_id,
	publisher_id = pPublisher_id
WHERE
	item_id = pItem_id;
	COMMIT;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Users_Queries_AllItemsTotal`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Users_Queries_AllItemsTotal` ()
BEGIN
SELECT *
FROM (
 	SELECT COUNT(item_id)
 	FROM item) as a;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Users_Queries_AllLendedItemsTotal`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Users_Queries_AllLendedItemsTotal`()
BEGIN
SELECT *
FROM (
  	SELECT COUNT(item_id)
  	FROM PersonLendItem) as a;
END$$

DELIMITER ;







USE `pe`;
DROP procedure IF EXISTS `Users_Queries_AllItems`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Users_Queries_AllItems`(IN pTitle VARCHAR(50), IN pAuthorFirname VARCHAR(50),IN pAuthorLasname VARCHAR(50), IN pPublisher VARCHAR(100) )
BEGIN
SELECT title, itemEdition, barcode, itemType, status, publisher, genre, firstName, lastName
FROM (
   		  SELECT  i.title AS title,i.edition AS itemEdition, i.barcode AS barcode, iT.itemType_name AS itemType,
         	s.status_name AS status, pu.publisher_name AS publisher, GROUP_CONCAT(ge.genre_name, ', ')  AS genre,
         	p.first_name AS firstName, p.last_name AS lastName
         	FROM item i
         	INNER JOIN itemType iT ON i.itemtype_id = iT.itemtype_id
         	INNER JOIN status s ON i.status_id = s.status_id
         	INNER JOIN publisher pu ON i.publisher_id = pu.publisher_id
         	INNER JOIN itemHasGenre ihg ON i.item_id = ihg.item_id
         	INNER JOIN genre ge ON ihg.genre_id = ge.genre_id
         	INNER JOIN personCreatesItem pCi ON i.item_id = pCi.item_id
   		  INNER JOIN person p ON pCi.person_id = p.person_id
         	GROUP BY i.title, i.edition, i.barcode, iT.itemType_name,
   		  s.status_name, pu.publisher_name, p.first_name, p.last_name)
as a   		 
WHERE title LIKE CONCAT(pTitle, '%')
AND firstName LIKE CONCAT(pAuthorFirname, '%')
AND lastName LIKE CONCAT(pAuthorLasname, '%')
AND publisher LIKE CONCAT(pPublisher, '%')
GROUP BY title, itemEdition, barcode, itemType, status, publisher, genre, firstName, lastName
ORDER BY title ASC;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `User_Queries_AllLendedItems`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `User_Queries_AllLendedItems`(IN pPersonFirstName VARCHAR(50), IN pPersonLastName VARCHAR(50), IN pNumberDays INT, IN pNumberToleranceDays INT, IN pNumberToleranceDaysMax INT, IN pStatus VARCHAR(100))
BEGIN
SELECT title, itemEdition, barcode, itemType, status, publisher, genre,
            	firstName, lastName, lendDate, returnDate, amountDays, yellowDays, redDays
            	FROM (
                	SELECT i.title AS title, i.edition AS itemEdition, i.barcode AS barcode, iT.itemType_name AS itemType,
                	s.status_name AS status, pu.publisher_name AS publisher, GROUP_CONCAT(ge.genre_name, ', ') AS genre,
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
                	GROUP BY i.title, i.edition, i.barcode,
                	iT.itemType_name, s.status_name, pu.publisher_name, p.first_name, p.last_name,
                	pLi.amount_days, pLi.tolerance_days_yellow, pLi.tolerance_days_red, pLi.lend_date, pLi.return_date) as a
            	WHERE firstName LIKE CONCAT(pPersonFirstName, '%')
            	AND lastName LIKE CONCAT(pPersonLastName, '%')
            	AND status LIKE CONCAT(pStatus, '%')
            	AND amountDays = coalesce(pNumberDays, amountDays)  
            	AND yellowDays = coalesce(pNumberToleranceDays, yellowDays)
            	AND redDays = coalesce(pNumberToleranceDaysMax, redDays)
            	AND TRUNCATE(lendDate - returnDate,0) + yellowDays + redDays
            	<= coalesce(pNumberDays, amountDays) + coalesce(pNumberToleranceDays, yellowDays) + coalesce(pNumberToleranceDaysMax, redDays)
            	GROUP BY title, itemEdition, barcode, itemType,
            	status, publisher, genre, firstName, lastName,
            	amountDays, yellowDays, redDays, lendDate, returnDate
            	ORDER BY title ASC;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Statistics_Queries_TotalItemsPerGenre`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Statistics_Queries_TotalItemsPerGenre` ()
BEGIN
 SELECT COUNT(item_id) AS total_items, TRUNCATE( COUNT(item_id)/(SELECT COUNT(item_id) FROM itemHasGenre)*100,2) AS percentage, genre
 FROM (
   	SELECT item_id, ge.genre_name AS genre
   	FROM itemHasGenre ihg
   	INNER JOIN genre ge ON ihg.genre_id = ge.genre_id) as a
 GROUP BY genre;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Statistics_Queries_TotalLendedItemsNow`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Statistics_Queries_TotalLendedItemsNow` ()
BEGIN
SELECT( SELECT Distinct Count(item_id) from item where status_id = 1), (SELECT Count(item_id) from item where status_id > 1)
from personlenditem  
limit 1;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Statistics_Queries_TotalLendedItems`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Statistics_Queries_TotalLendedItems` ()
BEGIN
   			 select x.title, count(y.item_id) AS total_lended_items, TRUNCATE(count(x.item_id)/(select count(item_id)from loan_history )*100,2) as percentage
            	from item x
            	inner join loan_history y
            	on y.item_id = x.item_id
            	GROUP by x.title
            	order by  total_lended_items desc;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Statistics_Queries_TotalLendedItemAge`;


DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Statistics_Queries_TotalLendedItemAge` ()
BEGIN
SELECT COUNT(item_id) AS total_lended_items, edad
            	FROM (
                	SELECT item_id, TRUNCATE( TIMESTAMPDIFF(MONTH, p.birth_day, SYSDATE() )/12, 0) AS edad
                	FROM PersonLendItem pLi
                	INNER JOIN person p ON p.person_id = pLi.person2_id) as a
            	GROUP BY edad
            	ORDER BY edad DESC;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetCollection`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetCollection` (IN pPerson_id INT)
BEGIN
select *
from(
	select i.item_id, i.title, p.publisher_name, i.edition,  GROUP_CONCAT(g.genre_name, ', '), r.stars, s.status_name

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
	)as a;
END$$

DELIMITER ;





USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetCollection`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserInterface_Queries_GetCollection`(IN pPerson_id INT)
BEGIN
select *
from(
	select i.item_id, i.title, p.publisher_name, i.edition,  GROUP_CONCAT(g.genre_name, ', '), r.stars, s.status_name

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
	)as a;
END$$

DELIMITER ;









USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetPublishers`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetPublishers` ()
BEGIN
select *
from(
	select publisher_name
	from publisher
)as a;
END$$

DELIMITER ;
USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetItemTypes`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetItemTypes` ()
BEGIN
select *
from(
	select itemtype_name
	from itemtype
)as a;
END$$

DELIMITER ;






USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetGenres`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetGenres` ()
BEGIN
select *
from(
	select genre_name
	from genre
)as a;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetGenresWithDescription`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetGenresWithDescription` ()
BEGIN
select *
from(
	select genre_name, description
	from genre
)as a;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetRelationTypes`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetRelationTypes` ()
BEGIN
select *
from(
	select relationtype_name
	from relationtype
)as a;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetStatus`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserInterface_Queries_GetStatus`()
BEGIN
select *
from(
	select status_name, description
	from status
)as a;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Statistics_Queries_TotalLendedItemsPerGenre`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Statistics_Queries_TotalLendedItemsPerGenre` ()
BEGIN
 SELECT COUNT(plitem) AS total_lended_items ,TRUNCATE(COUNT(plitem)/(SELECT COUNT(item_id) FROM PersonLendItem)*100,2) AS percentage ,  genre
 FROM (
SELECT pLi.item_id AS plitem, ge.genre_name AS genre
FROM PersonLendItem pLi
INNER JOIN itemHasGenre ihg ON pLi.item_id = ihg.item_id
INNER JOIN genre ge ON ihg.genre_id = ge.genre_id
WHERE ihg.item_id = pLi.item_id) a
GROUP BY genre
ORDER BY percentage DESC;
END$$

DELIMITER ;





USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetRelationTypes`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserInterface_Queries_GetRelationTypes`()
BEGIN
select *
from(
	select relationtype_name
	from relationtype
)as a;
/**/
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetAuthors`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserInterface_Queries_GetAuthors`()
BEGIN
select *
from(
	select first_name, last_name, email
	from person
	where persontype_id = 2
)as a;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetKnownPeople`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetKnownPeople` (IN pPerson1_id INT)
BEGIN
select *
from(
	select p.first_name, p.last_name, p.email, p.phone_number, r.relationtype_name as relation
	from person1knowsperson2 pkp
	inner join person p
	on pkp.person2_id = p.person_id
	inner join relationtype r
	on pkp.relationtype_id = r.relationtype_id
	where pkp.person1_id = pPerson1_id
	)as a;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetLendedItems`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetLendedItems` (IN pPerson_id INT)
BEGIN
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
	WHERE curdate() BETWEEN  str_to_date(pli.lend_date, '%Y-%m-%d') AND str_to_date(pli.return_date, '%Y-%m-%d') AND pli.person1_id = pPerson_id AND i.status_id > 1
   ) as a;
END$$

DELIMITER ;



USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetCollectionNoReviews`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_GetCollectionNoReviews` (IN pPerson_id INT)
BEGIN
select *
from(
	select i.item_id, i.title, p.publisher_name, i.edition, GROUP_CONCAT(g.genre_name, ', ')

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
	)as a;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_UpdateToleranceDays`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `UserInterface_Queries_UpdateToleranceDays` (IN pPerson_id INT)
BEGIN
select *
from(
    	select pli.person2_id, pli.item_id,pli.lend_date, pli.return_date, pli.amount_days,pli.tolerance_days_yellow, pli.tolerance_days_red, i.status_id
    	from personlenditem pli
    	inner join item i
    	on pli.item_id = i.item_id
    	where pli.person1_id = pPerson_id    
	)as a;
END$$

DELIMITER ;


USE `pe`;
DROP procedure IF EXISTS `Control_Genre_InsertGenre`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Control_Genre_InsertGenre`(IN pName VARCHAR(20), IN pDescription VARCHAR(140))
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

INSERT INTO genre(genre_name, description)
VALUES(pName, pDescription);
COMMIT;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `pe`.`Control_ItemHasReview_getItemHasReviewReview_id`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_ItemHasReview_getItemHasReviewReviewId`(pItem_id INT) RETURNS int
	DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT review_id FROM ItemHasReview WHERE item_id = pItem_id);

RETURN vcId;
END$$

DELIMITER ;
;

USE `pe`;
DROP function IF EXISTS `pe`.`Control_Person1KnosPerson2_getPer1KnowsPer2Person1Id`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_Person1KnowsPerson2_getPer1KnowsPer2Person1Id`(pPerson2_id INT) RETURNS int
	DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT person1_id FROM person1knowsperson2 WHERE person2_id = pid_perpPerson2_idson2);
RETURN vcId;
END$$

DELIMITER ;
;

USE `pe`;
DROP function IF EXISTS `pe`.`Control_PersonLendItem_getPersonLendItemPeron2Id`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_PersonLendItem_getPersonLendItemPerson2Id`(pPerson1_id INT, pItem_id INT) RETURNS int
	DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = ( SELECT person2_id FROM personlenditem WHERE person1_id = pPerson1_id AND item_id = pItem_id);
RETURN vcId;
END$$

DELIMITER ;
;

USE `pe`;
DROP function IF EXISTS `Control_RelationType_getrelationTypeId`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_RelationType_getrelationTypeId`(pName VARCHAR(100)) RETURNS int
	DETERMINISTIC /**/
BEGIN
DECLARE vcId INT;
SET vcId = (SELECT relationtype_id FROM relationtype WHERE relationtype_name = pName);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP function IF EXISTS `Control_RelationType_getrelationTypeName`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_RelationType_getrelationTypeName`(pId INT) RETURNS varchar(100) CHARSET utf8mb4
	DETERMINISTIC/**/
BEGIN
DECLARE vcName VARCHAR(100);
SET vcName = ( SELECT relationtype_name FROM relationtype WHERE relationtype_id = pId);
RETURN vcName;
END$$

DELIMITER ;
USE `pe`;
DROP function IF EXISTS `Control_ItemType_getItemTypeName`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_ItemType_getItemTypeName`(pItemType_id INT) RETURNS varchar(20) CHARSET utf8mb4
 DETERMINISTIC
BEGIN
DECLARE vcName varchar(20);
SET vcName = (SELECT itemType_name FROM itemtype WHERE itemtype_id = pItemType_id);
RETURN vcName;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetAuthors`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserInterface_Queries_GetAuthors`()
BEGIN
select *
from(
	select first_name, last_name, email
	from person
	where persontype_id = 3
)as a;
END$$

DELIMITER ;


USE `pe`;
DROP function IF EXISTS `Control_Item_InsertItemB`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Control_Item_InsertItemB`() RETURNS int
	DETERMINISTIC
BEGIN
DECLARE vcId INT;
SET vcId = (select max(item_id) from item);
RETURN vcId;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_Item_RemoveItem`;

DELIMITER $$
USE `pe`$$
CREATE PROCEDURE `Control_Item_RemoveItem` (IN pId INT)
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;


DELETE FROM item
	WHERE item_id = pId;
	COMMIT;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Control_Person_UpdatePerson`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Control_Person_UpdatePerson`(IN pId INT, IN pFirname VARCHAR(50), IN pLasname VARCHAR(50), IN pEmail VARCHAR(50), IN pPassword VARCHAR(25), IN pPhone VARCHAR(8), IN pDate VARCHAR(100) )
BEGIN
DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered.' Message;
DECLARE EXIT HANDLER FOR 1105 SELECT 'Unknown error encountered.' Message;
DECLARE EXIT HANDLER FOR 1176 SELECT 'Key does not exist.' Message;
DECLARE EXIT HANDLER FOR 1231 SELECT 'Variable cannot be set to that value.' Message;
DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable.' Message;

UPDATE person
    SET first_name = pFirname,
    	last_name = pLasname,
    	email = pEmail,
    	password = SHA(pPassword),
    	phone_number = pPhone,
    	birth_day = str_to_date(pDate, '%Y-%m-%d')
    WHERE person_id = pId;
    COMMIT;

END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `UserInterface_Queries_GetItems`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserInterface_Queries_GetItems`(IN pPerson_id INT)
BEGIN
select * 
from(/**/
   SELECT i.title
   FROM item i
   INNER JOIN personhasitem phi
   ON i.item_id = phi.item_id
   WHERE phi.person_id = pPerson_id AND i.status_id = 1
    ) as a;
END$$

DELIMITER ;

USE `pe`;
DROP procedure IF EXISTS `Admin_Queries_TopMostBorrowedPerMonth`;

DELIMITER $$
USE `pe`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Admin_Queries_TopMostBorrowedPerMonth`(pTimes INT, pMonth INT)
BEGIN
select * /**/
from(
    select i.title, count(lh.item_id)
    from loan_history lh
    inner join item i
    on lh.item_id = i.item_id
    where lh.lend_date >= DATE_SUB(curdate(),INTERVAL pMonth month)
    group by i.title
    having count(lh.item_id) >= pTimes
    )as a;
END$$

DELIMITER ;
