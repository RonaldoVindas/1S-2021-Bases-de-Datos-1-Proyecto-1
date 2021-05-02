--__________________________tabla Publisher___________________________________________________

insert into Publisher(publisher_name) values('Norma Editorial');
insert into Publisher(publisher_name) values('Grup 62');
insert into Publisher(publisher_name) values('Dark Horse');
insert into Publisher(publisher_name) values('DC Comics');
insert into Publisher(publisher_name) values('Marvel');
insert into Publisher(publisher_name) values('Nintendo');
insert into Publisher(publisher_name) values('Microsoft');
insert into Publisher(publisher_name) values('Sony');
insert into Publisher(publisher_name) values('DEBOLSILLO');
insert into Publisher(publisher_name) values('Salamandra');
insert into Publisher(publisher_name) values('CINCO TINTAS');
insert into Publisher(publisher_name) values('NOVA');
insert into Publisher(publisher_name) values('CANTERBURY CLASSICS');
insert into Publisher(publisher_name) values('Summit Entertainment');
insert into Publisher(publisher_name) values('20th Century Studios');
insert into Publisher(publisher_name) values('Buena Vista Pictures Distribution');
insert into Publisher(publisher_name) values('Toho');
insert into Publisher(publisher_name) values('Universal Pictures');
insert into Publisher(publisher_name) values('Walt Disney Studios Motion Pictures');
insert into Publisher(publisher_name) values('Warner Bros. Pictures');
insert into Publisher(publisher_name) values('New Line Cinema');
insert into Publisher(publisher_name) values('Metro Goldwyn Mayer');
insert into Publisher(publisher_name) values('Lionsgate');
insert into Publisher(publisher_name) values('Activision');
insert into Publisher(publisher_name) values('Sega');
insert into Publisher(publisher_name) values('Electronic Arts');
insert into Publisher(publisher_name) values('Square enix');
insert into Publisher(publisher_name) values('Konami');





--__________________________tabla genre__________________________________________________________

insert into genre(genre_name,description) values('Mystery',' The plot always revolves around a crime of sorts that must be solved—or foiled—by the protagonists.');
insert into genre(genre_name,description) values('Adventure','Main character repeatedly finds themselves in high stakes situations.');
insert into genre(genre_name,description) values('Fantasy',' While usually set in a fictional imagined world.');
insert into genre(genre_name,description) values('Horror','Meant to cause discomfort and fear for both the character and readers, horror writers often make use of supernatural and paranormal.');
insert into genre(genre_name,description) values('Romance','The genre that makes your heart all warm and fuzzy focuses on the love story of the main protagonists.');
insert into genre(genre_name,description) values('Science Fiction','Science fiction stories is that they lean heavily on themes of technology and future science.');
insert into genre(genre_name,description) values('Cookbooks','Collection of recipes, specific to a theme, cuisine, or experience chosen by the author.');
insert into genre(genre_name,description) values('Biography',' Detailed description of a person s life. It involves more than just the basic facts like education, work, relationships, and death.');
insert into genre(genre_name,description) values('Action','The protagonist or protagonists are thrust into a series of events that typically include violence.');
insert into genre(genre_name,description) values('Comedy','Consisting of discourses or works intended to be humorous');


--__________________________tabla status__________________________________________________________

insert into status(status_name,description) values('Blue','Actually in stock');
insert into status(status_name,description) values('Green','Loaned on business days');
insert into status(status_name,description) values('Yellow ','In tolerance days');
insert into status(status_name,description) values('Red','Has not been returned');

--__________________________tabla  ItemType__________________________________________________________

insert into itemtype(itemtype_name) values('Book');
insert into itemtype(itemtype_name) values('Movies');
insert into itemtype(itemtype_name) values('Comic');
insert into itemtype(itemtype_name) values('VideoGame');

--__________________________tabla  Review__________________________________________________________


insert into Review(stars) values(1);
insert into Review(stars) values(2);
insert into Review(stars) values(3);
insert into Review(stars) values(4);
insert into Review(stars) values(5);

--__________________________tabla relationtype___________________________________________________

insert into  relationtype(relationtype_name) values('Friend');
insert into  relationtype(relationtype_name) values('Known');
insert into  relationtype(relationtype_name) values('Family');
insert into  relationtype(relationtype_name) values('Co-worker');

--__________________________tabla PersonType___________________________________________________

insert into  PersonType(persontype_name) values('Admin');
insert into  PersonType(persontype_name) values('User');
insert into  PersonType(persontype_name) values('Author');

--__________________________tabla Person___________________________________________________

insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(117610138,'Ronaldo','Vindas','rony1211@gmail.com','falcon12','88778841',DATE '1999-11-12',0);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(801200838,'Renzo','Barra','rony1211@gmail.com','Renzo12','98753215',DATE '1999-1-2',0);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(402140028,'Alvaro','Moreira','conker@gmail.com','conker19','87258021',DATE '1992-2-19',0);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000000,'Joseph','Chaves','jox@gmail.com','jox127','87946321',DATE '2000-5-15',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000001,'Emely','Zarate','Emezar18@gmail.com','Emezar18','26887451',DATE '1995-7-5',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000002,'Valeria','Aguilar','VAguilar@yahoo.com','agva68','22698725',DATE '2002-06-02',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000003,'Anthony','Vargas','Tony1522@gmail.com','tova15','22672146',DATE '2003-06-01',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000004,'Krissia','Pérez','KrissPM@hotmail.com','pekrpm105','22676548',DATE '1999-05-31',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000005,'Emmanuel','Jarquín','Emma123@gmail.com','jaem12','22651278',DATE '1998-05-30',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000006,'Jesús','Aguilar','ChusAM@gmail.com','agjeAm','82654820',DATE '1988-05-29',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000007,'Javier','Barquero','Raydertre@outlook.com','Bajaray','22621897',DATE '1972-05-28',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000008,'Rebecca','Madrigal','RebboxMad@gmail.com','MareMAD','89632570',DATE '2001-05-26',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000009,'Justin','Bogantes','Justino@tec.com','BoJu25','83654015',DATE '1985-05-24',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000010,'Alejandra','Rivera','alitadepol@yahoo.com','holahola','81254798',DATE '1993-05-23',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000011,'Joselyn','Rodríguez','Joss45451@gmail.com','Rojo54','78965215',DATE '1987-05-22',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000012,'Keylor','Navas','SanNavas@hotmail.com','Nakegol','89215821',DATE '1999-05-21',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000013,'Valery','Vega','VValery@yahoo.com.com','vevaer','89646851',DATE '2001-05-19',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000014,'Josue','Siles','Siles@gmail.com','130cm','72357801',DATE '1998-05-18',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000015,'Dennis','angulo','Dernudo@outlook.com','ande8','98746526',DATE '1993-05-17',1);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(100000016,'Ishtar','Saborio','servantesCD@outlook.com','DCishr','98746526',DATE '1994-01-10',1);

insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000000,'Joanne','Rowling', 'J.K.Rowling@pottermore.com', '1234556', '98765432',DATE '1965-07-30',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000001,'Stephen','King ', 'StephenKing@hotmail.com', '1234557', '98765433',DATE '1947-09-21',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000002,'Isabel','Allende', 'Allende@hotmail.com', '1234558', '98765434',DATE '1942-08-02',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000003,'Brian','Herbert', 'Herbert@hotmail.com', '1234559', '987654355',DATE '1947-06-29',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000004,'Ana','Frank', 'AnaFrank@hotmail.com', '1234560', '98765436',DATE '1929-06-12',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000005,'Joseph','Gelinek', 'JosephGelinek@hotmail.com', '1234561', '98765437',DATE '1758-12-03',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000006,'kimberly','parsons', 'yohalife@hotmail.com', '1234562', '98765438',DATE '1983-07-30',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000007,'Ernest','Cline', 'rpy@hotmail.com', '1234563', '98765439',DATE '1972-03-29',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000008,'Daniel','Defoe', 'dd@hotmail.com', '1234564', '98765440',DATE '1960-10-10',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000009,'Derek','Kolstad', 'Kolstad@hotmail.com', '1234565', '98765441',DATE '1974-07-30',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000010,'George','Lucas', 'jjbean@hotmail.com', '1234566', '98765442',DATE '1944-05-14',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000011,'Brad','Bird', 'Bird@hotmail.com', '1234567', '98765443',DATE '1957-09-24',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000012,'Hayao','Miyazaki', 'Miyazaki@jpn.com', '1234568', '98765444',DATE '1941-01-05',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000013,'Ted','Elliot', 'Elliot@hotmail.com', '1234569', '98765445',DATE ' 1961-07-04',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000014,'Ron','Clements', 'Clements@hotmail.com', '1234570', '98765446',DATE '1953-04-25',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000015,'Peter','Ramsey', 'Ramsey@hotmail.com', '1234571', '98765447',DATE '1962-12-23',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000016,'Roger','Allers', 'Allers@hotmail.com', '1234572', '98765448',DATE '1949-06-29',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000017,'Andy','Muschietti', 'Muschietti@hotmail.com', '1234573', '98765449',DATE '1973-08-26',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000018,'Steven','Spielberg', 'Spielberg@hotmail.com', '1234574', '98765450',DATE '1946-12-18',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000019,'Peter','Jackson', 'Jackson@hotmail.com', '1234575', '98765451',DATE '1961-10-31',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000020,'Gary ','Ross', 'Ross@hotmail.com', '1234576', '98765452',DATE '1956-11-03',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000021,'James','Cameron', 'Cameron@hotmail.com', '1234577', '98765453',DATE '1954-08-16',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000022,'John','Lasseter', 'Lasseter@hotmail.com', '1234578', '98765454',DATE '1957-01-12',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000023,'Jerry','Siegel', 'Siegel@hotmail.com', '1234579', '98765455',DATE '1914-10-17',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000024,'Jim','Starlin', 'Starlin@hotmail.com', '1234580', '98765456',DATE '1949-10-09',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000025,'Scott','Snyder', 'Snyder@hotmail.com', '1234581', '98765457',DATE '1976-01-01',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000026,'Alan','Moore', 'Moore@hotmail.com', '1234582', '98765458',DATE '1953-11-18',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000027,'Mac','Walters', 'Walters@hotmail.com', '1234583', '98765459',DATE '1981-12-21',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000028,'Tom','Taylor', 'Taylor@hotmail.com', '1234583', '98765460',DATE '2001-07-16',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000029,'Nick','Spencer', 'Spencer@hotmail.com', '1234584', '98765461',DATE '1991-10-07',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000030,'Jim','Shooter', 'Shooter@hotmail.com', '1234585', '98765462',DATE '1951-09-27',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000031,'Geoff','Johns', 'Johns@hotmail.com', '1234586', '98765463',DATE '1973-01-25',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000032,'Frank','Miller', 'Miller@hotmail.com', '1234587', '98765464',DATE '1957-01-27',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000033,'Bryan','omalley', 'omalleys@hotmail.com', '1234588', '98765465',DATE '1943-03-16',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000034,'Stan','Lee', 'gstanoleed@hotmail.com', '1234589', '98765466',DATE '1922-12-28',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000035,'Jason','Uyeda', 'Uyeda@hotmail.com', '1234590', '98765467',DATE '1992-05-06',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000036,'Andy','Gavin', 'Gavin@hotmail.com', '1234591', '98765468',DATE '1970-06-11',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000037,'Takao','Shimizu', 'Shimizu@hotmail.com', '1234592', '98765468',DATE '1965-06-29',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000038,'Jason','Jones', 'Jones@hotmail.com', '1234593', '98765469',DATE '1973-06-03',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000039,'Takashi','Tezuka ', 'Tezuka@hotmail.com', '1234594', '98765470',DATE '1960-11-17',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000040,'Alez','Ward', 'Ward@hotmail.com', '1234595', '98765471',DATE '1990-04-30',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000041,'Shun','Nakamura', 'Nakamura@hotmail.com', '1234596', '98765472',DATE '1978-06-24',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000042,'Bernd','Diemer', 'Diemer@hotmail.com', '1234597', '98765473',DATE '1983-02-28',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000043,'Naoto','Oshima', 'Oshima@hotmail.com', '1234598', '98765474',DATE '1964-02-26',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000044,'Yoshinori','Kitase', 'Kitase@hotmail.com', '1234599', '98765474',DATE '1966-09-23',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000045,'Toru','Hagihara', 'Hagihara@hotmail.com', '12345600', '98765475',DATE '1958-04-04',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000046,'Chris','Seavor', 'Seavor@hotmail.com', '1234601', '98765476',DATE '1968-07-20',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000047,'Toshihiro','Nagoshi', 'Nagoshi@hotmail.com', '1234602', '98765477',DATE '1965-06-17',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000048,'Cory','Barlog', 'Barlog@hotmail.com', '1234603', '98765478',DATE '1975-09-02',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000049,'Chris','Colunbus', 'Colunbus@hotmail.com', '1234604', '98765479',DATE '1958-09-10',2);
insert into  Person(person_id,first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(990000050,'kenji','Kanno', 'Kanno@hotmail.com', '1234605', '98765480',DATE '1952-02-28',2);

--__________________________tabla item___________________________________________________

insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y la piedra filosofal','primera','000000000001',0,0,9,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y la cámara secreta','primera','000000000002',0,0,9,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y el prisionero de Azkaban','primera','000000000003',0,0,9,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y el cáliz de fuego','primera','000000000004',0,0,9,2);3
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y la Orden del Fénix','primera','000000000005',0,0,9,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y el misterio del príncipe','primera','000000000006',0,0,9,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y las reliquias de la Muerte','primera','000000000007',0,0,9,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El Instituto','Best Seller','000000000008',0,0,8,0);7
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('DE AMOR Y DE SOMBRA','Best Seller','000000000009',0,0,8,4);8
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('DUNE LA BATALLA DE CORRIN','Best Seller','000000000010',0,0,8,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('DIARIO DE ANA FRANK','2007','000000000011',0,0,8,7);10
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('VIOLIN DEL DIABLO','Best Seller','000000000012',0,0,8,0);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('YOGA KITCHEN','2020','000000000013',0,0,10,6);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('READY PLAYER ONE (ESPAÑOL)','2018','000000000014',0,0,11,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('LIFE AND ADVENTURES OF ROBINSON CRUSOE','2019','000000000015',0,0,12,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('John Wick','DVD','000000000016',1,0,13,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Star Wars: Episodio III - La venganza de los Sith','Blu-ray','000000000017',2,1,15,6);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Los Increíbles','DVD','000000000018',1,0,15,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El increíble castillo vagabundo','DVD','000000000019',1,0,16,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Shrek','blu-ray','000000000020',1,0,17,9);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El planeta del tesoro','dvd','000000000021',1,0,18,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Spider-Man: Un nuevo universo','blu-ray','000000000022',1,0,7,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El rey león','dvd','000000000023',1,0,15,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('it(2017)','blu-ray','000000000024',1,0,19,3);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Parque Jurásico','DVD','000000000025',1,0,17,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Mi pobre angelito','DVD','000000000026',1,0,14,9);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El Señor de los Anillos: la Comunidad del Anillo','DVD','000000000027',1,0,20,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Los juegos del hambre','blu-ray','000000000028',1,0,22,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Terminator','DVD','000000000029',1,0,20,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Cars','DVD','000000000030',1,0,15,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Action Comics 1','primera','000000000031',2,0,3,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('The Infinity Gauntlet','primera','000000000032',2,0,4,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Dark Nights: Metal','Limited series','000000000033',2,0,3,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Watchmen','1987','000000000034',2,0,3,0);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('mass effect','to cool','000000000035',2,0,2,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Injustice: Gods Among Us','luxe','000000000036',2,0,3,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Secret Empire','Limited series','000000000037',2,0,4,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Secret Wars','Limited series','000000000038',2,0,4,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('The Court of Owls','batman series','000000000039',2,0,3,0);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Flashpoint','Limited series','000000000040',2,0,3,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('300','Limited series','000000000041',2,0,2,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('V de Vendetta','edge','000000000042',2,0,2,0);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Scott Pilgrim s Precious Little Life','Badass edition','000000000043',2,0,0,4);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Batman: The Dark Knight Returns','batman siries','000000000044',2,0,3,0);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('X-Men','plus ultra colection','000000000045',2,0,4,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('tony hawk pro skater 2','PS1','000000000046',3,0,19,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Crash Bandicoot','PS1','000000000047',3,0,19,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('pokemon stadium 2','N64','000000000048',3,0,5,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('halo 2','xbox','000000000049',3,0,6,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Super Mario World','snes','000000000050',3,0,5,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('crazy taxi 2','dreamcast','000000000051',3,0,20,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('burnout revenge','PS2','000000000052',3,0,21,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Sonic the Hedgehog','PS3','000000000053',3,0,20,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('star wars battlefront ii','PS5','000000000054',3,0,21,5);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Nights into Dreams','Drea,cast','000000000055',3,1,20,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('final fantasy 7','PS1','000000000056',3,0,22,2);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('castlevania symphony of the night','PS1','000000000057',3,0,23,3);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('conker bad fur day','N64','000000000058',3,0,5,1);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('f zero gx','Gamecube','000000000059',3,0,20,8);
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('God of War','PS2','000000000060',3,0,7,1);


--__________________________table PersonHasItem___________________________________________________

insert into PersonHasItem(person_id,item_id) values(117610138,9);
insert into PersonHasItem(person_id,item_id) values(117610138,46);
insert into PersonHasItem(person_id,item_id) values(117610138,31);
insert into PersonHasItem(person_id,item_id) values(117610138,58);
insert into PersonHasItem(person_id,item_id) values(801200838,10);
insert into PersonHasItem(person_id,item_id) values(801200838,16);
insert into PersonHasItem(person_id,item_id) values(801200838,40);
insert into PersonHasItem(person_id,item_id) values(402140028,57);
insert into PersonHasItem(person_id,item_id) values(402140028,15);
insert into PersonHasItem(person_id,item_id) values(402140028,21);
insert into PersonHasItem(person_id,item_id) values(100000000,0);
insert into PersonHasItem(person_id,item_id) values(100000000,1);
insert into PersonHasItem(person_id,item_id) values(100000000,2);
insert into PersonHasItem(person_id,item_id) values(100000001,3);
insert into PersonHasItem(person_id,item_id) values(100000001,4);
insert into PersonHasItem(person_id,item_id) values(100000001,5);
insert into PersonHasItem(person_id,item_id) values(100000002,7);
insert into PersonHasItem(person_id,item_id) values(100000002,17);
insert into PersonHasItem(person_id,item_id) values(100000002,47);
insert into PersonHasItem(person_id,item_id) values(100000003,8);
insert into PersonHasItem(person_id,item_id) values(100000003,22);
insert into PersonHasItem(person_id,item_id) values(100000003,41);
insert into PersonHasItem(person_id,item_id) values(100000004,19);
insert into PersonHasItem(person_id,item_id) values(100000004,34);
insert into PersonHasItem(person_id,item_id) values(100000004,54);
insert into PersonHasItem(person_id,item_id) values(100000005,11);
insert into PersonHasItem(person_id,item_id) values(100000005,23);
insert into PersonHasItem(person_id,item_id) values(100000005,33);
insert into PersonHasItem(person_id,item_id) values(100000006,20);
insert into PersonHasItem(person_id,item_id) values(100000006,42);
insert into PersonHasItem(person_id,item_id) values(100000006,53);
insert into PersonHasItem(person_id,item_id) values(100000007,12);
insert into PersonHasItem(person_id,item_id) values(100000007,26);
insert into PersonHasItem(person_id,item_id) values(100000007,59);
insert into PersonHasItem(person_id,item_id) values(100000008,13);
insert into PersonHasItem(person_id,item_id) values(100000008,52);
insert into PersonHasItem(person_id,item_id) values(100000008,27);
insert into PersonHasItem(person_id,item_id) values(100000009,14);
insert into PersonHasItem(person_id,item_id) values(100000009,24);
insert into PersonHasItem(person_id,item_id) values(100000009,44);
insert into PersonHasItem(person_id,item_id) values(100000010,18);
insert into PersonHasItem(person_id,item_id) values(100000010,25);
insert into PersonHasItem(person_id,item_id) values(100000010,50);
insert into PersonHasItem(person_id,item_id) values(100000011,28);
insert into PersonHasItem(person_id,item_id) values(100000011,39);
insert into PersonHasItem(person_id,item_id) values(100000011,55);
insert into PersonHasItem(person_id,item_id) values(100000012,29);
insert into PersonHasItem(person_id,item_id) values(100000012,38);
insert into PersonHasItem(person_id,item_id) values(100000012,49);
insert into PersonHasItem(person_id,item_id) values(100000013,30);
insert into PersonHasItem(person_id,item_id) values(100000013,48);
insert into PersonHasItem(person_id,item_id) values(100000013,45);
insert into PersonHasItem(person_id,item_id) values(100000014,32);
insert into PersonHasItem(person_id,item_id) values(100000014,35);
insert into PersonHasItem(person_id,item_id) values(100000014,43);
insert into PersonHasItem(person_id,item_id) values(100000015,36);
insert into PersonHasItem(person_id,item_id) values(100000015,51);
insert into PersonHasItem(person_id,item_id) values(100000015,37);
insert into PersonHasItem(person_id,item_id) values(100000016,6);
insert into PersonHasItem(person_id,item_id) values(100000016,56);

--__________________________table Person1KnowsPerson2___________________________________________________

insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(117610138,801200838,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(117610138,402140028,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(117610138,100000009,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000009,117610138,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(402140028,117610138,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(801200838,117610138,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000000,100000002,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000002,100000000,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(402140028,100000016,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000016,402140028,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(402140028,100000007,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000007,402140028,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000000,100000011,2);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000011,100000000,2);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000000,100000012,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000012,100000000,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000001,100000013,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000013,100000001,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000001,100000015,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000015,100000001,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000002,100000006,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000006,100000002,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000003,100000014,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000014,100000003,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000003,801200838,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(801200838,100000003,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000004,100000011,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000011,100000004,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000004,100000005,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000005,100000004,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000005,100000007,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000007,100000005,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000006,100000010,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000010,100000006,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000010,100000008,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000008,100000010,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000006,801200838,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(801200838,100000006,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000007,100000013,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000013,100000007,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000007,100000003,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000003,100000007,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000008,402140028,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(402140028,100000008,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000008,100000007,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000007,100000008,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000009,100000004,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000004,100000009,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000009,100000002,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000002,100000009,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000010,801200838,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(801200838,100000010,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000010,100000015,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000015,100000010,3);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000011,100000016,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000016,100000011,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000012,100000009,2);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000009,100000012,2);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000012,100000014,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000014,100000012,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000012,100000004,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000004,100000012,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000013,117610138,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(117610138,100000013,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000014,100000010,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000010,100000014,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000014,100000015,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000015,100000014,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000015,100000006,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000006,100000015,1);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000016,100000004,0);
insert into Person1KnowsPerson2(person1_id,person2_id,relationtype_id) values(100000004,100000016,0);

--__________________________table PersonLendItem___________________________________________________

insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(117610138,100000009,9,TO_DATE('2021/01/01', 'yyyy/mm/dd'),TO_DATE('2021/02/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/02/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/01', 'yyyy/mm/dd')) from dual),5,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(117610138,402140028,31,TO_DATE('2021/02/19', 'yyyy/mm/dd'),TO_DATE('2021/03/19', 'yyyy/mm/dd'),(select to_date ('2021/03/19', 'yyyy/mm/dd') - trunc(TO_DATE('2021/02/19', 'yyyy/mm/dd')) from dual),5,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(801200838,100000006,16,TO_DATE('2021/01/20', 'yyyy/mm/dd'),TO_DATE('2021/03/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/03/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/20', 'yyyy/mm/dd')) from dual),3,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(801200838,100000003,39,TO_DATE('2021/01/24', 'yyyy/mm/dd'),TO_DATE('2021/03/01', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/03/01', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/24', 'yyyy/mm/dd')) from dual),3,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(402140028,100000016,15,TO_DATE('2020/06/26', 'yyyy/mm/dd'),TO_DATE('2020/8/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/8/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/06/26', 'yyyy/mm/dd')) from dual),10,4);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(402140028,117610138,57,TO_DATE('2020/01/01', 'yyyy/mm/dd'),TO_DATE('2021/01/01', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/01/01', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/01/01', 'yyyy/mm/dd')) from dual),10,4);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000000,100000002,0,TO_DATE('2021/03/05', 'yyyy/mm/dd'),TO_DATE('2021/04/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/03/05', 'yyyy/mm/dd')) from dual),3,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000000,100000011,1,TO_DATE('2020/06/15', 'yyyy/mm/dd'),TO_DATE('2020/07/08', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/07/08', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/06/15', 'yyyy/mm/dd')) from dual),3,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000001,100000015,3,TO_DATE('2020/04/26', 'yyyy/mm/dd'),TO_DATE('2020/06/01', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/06/01', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/04/26', 'yyyy/mm/dd')) from dual),10,3);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000001,100000013,4,TO_DATE('2021/02/10', 'yyyy/mm/dd'),TO_DATE('2021/02/28', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/02/28', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/02/10', 'yyyy/mm/dd')) from dual),2,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000002,100000000,7,TO_DATE('2021/03/10', 'yyyy/mm/dd'),TO_DATE('2021/4/20', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/4/20', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/03/10', 'yyyy/mm/dd')) from dual),9,3);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000002,100000006,47,TO_DATE('2020/12/22', 'yyyy/mm/dd'),TO_DATE('2021/02/03', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/02/03', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/12/22', 'yyyy/mm/dd')) from dual),10,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000003,100000014,22,TO_DATE('2021/01/01', 'yyyy/mm/dd'),TO_DATE('2021/03/12', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/03/12', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/01', 'yyyy/mm/dd')) from dual),2,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000003,100000007,41,TO_DATE('2020/03/25', 'yyyy/mm/dd'),TO_DATE('2020/07/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/07/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/03/25', 'yyyy/mm/dd')) from dual),8,3);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000004,100000005,34,TO_DATE('2021/02/01', 'yyyy/mm/dd'),TO_DATE('2021/01/29', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/01/29', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/02/01', 'yyyy/mm/dd')) from dual),5,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000004,100000009,19,TO_DATE('2021/02/25', 'yyyy/mm/dd'),TO_DATE('2021/04/15', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/15', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/02/25', 'yyyy/mm/dd')) from dual),6,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000005,100000004,11,TO_DATE('2021/01/13', 'yyyy/mm/dd'),TO_DATE('2021/04/15', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/15', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/13', 'yyyy/mm/dd')) from dual),12,3);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000005,100000007,23,TO_DATE('2020/08/01', 'yyyy/mm/dd'),TO_DATE('2020/12/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/12/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/08/01', 'yyyy/mm/dd')) from dual),10,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000006,100000010,42,TO_DATE('2020/07/25', 'yyyy/mm/dd'),TO_DATE('2020/08/25', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/08/25', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/07/25', 'yyyy/mm/dd')) from dual),6,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000006,100000002,53,TO_DATE('2021/01/01', 'yyyy/mm/dd'),TO_DATE('2021/01/27', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/01/27', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/01', 'yyyy/mm/dd')) from dual),3,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000007,100000013,12,TO_DATE('2021/02/19', 'yyyy/mm/dd'),TO_DATE('2021/04/26', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/26', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/02/19', 'yyyy/mm/dd')) from dual),9,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000007,100000008,59,TO_DATE('2020/07/18', 'yyyy/mm/dd'),TO_DATE('2021/02/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/02/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/07/18', 'yyyy/mm/dd')) from dual),15,5);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000008,402140028,13,TO_DATE('2021/01/27', 'yyyy/mm/dd'),TO_DATE('2021/04/23', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/23', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/27', 'yyyy/mm/dd')) from dual),4,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000008,100000007,52,TO_DATE('2021/08/28', 'yyyy/mm/dd'),TO_DATE('2020/09/02', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/09/02', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/08/28', 'yyyy/mm/dd')) from dual),7,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000009,100000004,14,TO_DATE('2021/01/24', 'yyyy/mm/dd'),TO_DATE('2021/03/30', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/03/30', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/24', 'yyyy/mm/dd')) from dual),10,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000009,100000012,24,TO_DATE('2021/01/05', 'yyyy/mm/dd'),TO_DATE('2021/01/13', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/01/13', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/05', 'yyyy/mm/dd')) from dual),2,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000010,100000006,18,TO_DATE('2020/11/21', 'yyyy/mm/dd'),TO_DATE('2021/01/17', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/01/17', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/11/21', 'yyyy/mm/dd')) from dual),7,4);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000010,100000008,25,TO_DATE('2021/03/01', 'yyyy/mm/dd'),TO_DATE('2021/04/17', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/17', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/03/01', 'yyyy/mm/dd')) from dual),5,3);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000011,100000016,39,TO_DATE('2021/02/12', 'yyyy/mm/dd'),TO_DATE('2021/04/10', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/10', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/02/12', 'yyyy/mm/dd')) from dual),5,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000011,100000000,28,TO_DATE('2021/04/05', 'yyyy/mm/dd'),TO_DATE('2021/04/20', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/20', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/04/05', 'yyyy/mm/dd')) from dual),2,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(117610138,801200838,9,TO_DATE('2021/03/10', 'yyyy/mm/dd'),TO_DATE('2021/4/15', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/04/15', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/03/10', 'yyyy/mm/dd')) from dual),5,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000012,100000009,49,TO_DATE('2021/01/01', 'yyyy/mm/dd'),TO_DATE('2021/01/29', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/01/29', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/01', 'yyyy/mm/dd')) from dual),3,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000012,100000014,29,TO_DATE('2020/12/01', 'yyyy/mm/dd'),TO_DATE('2020/12/25', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/12/25', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/12/01', 'yyyy/mm/dd')) from dual),5,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000013,100000001,30,TO_DATE('2020/01/01', 'yyyy/mm/dd'),TO_DATE('2020/02/20', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/02/20', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/01/01', 'yyyy/mm/dd')) from dual),5,3);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000013,100000007,45,TO_DATE('2020/02/15', 'yyyy/mm/dd'),TO_DATE('2020/04/15', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/04/15', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/02/15', 'yyyy/mm/dd')) from dual),8,1);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000014,100000012,32,TO_DATE('2020/02/08', 'yyyy/mm/dd'),TO_DATE('2020/06/09', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/06/09', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/02/08', 'yyyy/mm/dd')) from dual),7,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000014,100000015,43,TO_DATE('2020/04/01', 'yyyy/mm/dd'),TO_DATE('2020/08/20', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/08/20', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/04/01', 'yyyy/mm/dd')) from dual),10,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000015,100000010,37,TO_DATE('2020/03/27', 'yyyy/mm/dd'),TO_DATE('2020/05/28', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/05/28', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/03/27', 'yyyy/mm/dd')) from dual),6,2);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000015,100000006,38,TO_DATE('2020/05/10', 'yyyy/mm/dd'),TO_DATE('2020/09/13', 'yyyy/mm/dd'),(select to_date (TO_DATE('2020/09/13', 'yyyy/mm/dd')) - trunc(TO_DATE('2020/05/10', 'yyyy/mm/dd')) from dual),11,5);
insert into PersonLendItem(person1_id,person2_id,item_id,lend_date,return_date,amount_days,tolerance_days_yellow,tolerance_days_red) values(100000016,100000004,6,TO_DATE('2021/01/02', 'yyyy/mm/dd'),TO_DATE('2021/02/12', 'yyyy/mm/dd'),(select to_date (TO_DATE('2021/02/12', 'yyyy/mm/dd')) - trunc(TO_DATE('2021/01/02', 'yyyy/mm/dd')) from dual),8,2);

__________________________table PersonCREATESItem___________________________________________________

INSERT INTO personcreatesitem(person_id,item_id) values(990000000,0);
INSERT INTO personcreatesitem(person_id,item_id) values(990000000,1);
INSERT INTO personcreatesitem(person_id,item_id) values(990000000,2);
INSERT INTO personcreatesitem(person_id,item_id) values(990000000,3);
INSERT INTO personcreatesitem(person_id,item_id) values(990000000,4);
INSERT INTO personcreatesitem(person_id,item_id) values(990000000,5);
INSERT INTO personcreatesitem(person_id,item_id) values(990000000,6);
INSERT INTO personcreatesitem(person_id,item_id) values(990000001,7);
INSERT INTO personcreatesitem(person_id,item_id) values(990000002,8);
INSERT INTO personcreatesitem(person_id,item_id) values(990000003,9);
INSERT INTO personcreatesitem(person_id,item_id) values(990000004,10);
INSERT INTO personcreatesitem(person_id,item_id) values(990000005,11);
INSERT INTO personcreatesitem(person_id,item_id) values(990000006,12);
INSERT INTO personcreatesitem(person_id,item_id) values(990000007,13);
INSERT INTO personcreatesitem(person_id,item_id) values(990000008,14);
INSERT INTO personcreatesitem(person_id,item_id) values(990000009,15);
INSERT INTO personcreatesitem(person_id,item_id) values(990000010,16);
INSERT INTO personcreatesitem(person_id,item_id) values(990000011,17);
INSERT INTO personcreatesitem(person_id,item_id) values(990000012,18);
INSERT INTO personcreatesitem(person_id,item_id) values(990000013,19);
INSERT INTO personcreatesitem(person_id,item_id) values(990000014,20);
INSERT INTO personcreatesitem(person_id,item_id) values(990000015,21);
INSERT INTO personcreatesitem(person_id,item_id) values(990000016,22);
INSERT INTO personcreatesitem(person_id,item_id) values(990000017,23);
INSERT INTO personcreatesitem(person_id,item_id) values(990000018,24);
INSERT INTO personcreatesitem(person_id,item_id) values(990000049,25);
INSERT INTO personcreatesitem(person_id,item_id) values(990000019,26);
INSERT INTO personcreatesitem(person_id,item_id) values(990000020,27);
INSERT INTO personcreatesitem(person_id,item_id) values(990000021,28);
INSERT INTO personcreatesitem(person_id,item_id) values(990000022,29);
INSERT INTO personcreatesitem(person_id,item_id) values(990000023,30);
INSERT INTO personcreatesitem(person_id,item_id) values(990000024,31);
INSERT INTO personcreatesitem(person_id,item_id) values(990000025,32);
INSERT INTO personcreatesitem(person_id,item_id) values(990000026,33);
INSERT INTO personcreatesitem(person_id,item_id) values(990000027,34);
INSERT INTO personcreatesitem(person_id,item_id) values(990000028,35);
INSERT INTO personcreatesitem(person_id,item_id) values(990000029,36);
INSERT INTO personcreatesitem(person_id,item_id) values(990000030,37);
INSERT INTO personcreatesitem(person_id,item_id) values(990000025,38);
INSERT INTO personcreatesitem(person_id,item_id) values(990000031,39);
INSERT INTO personcreatesitem(person_id,item_id) values(990000032,40);
INSERT INTO personcreatesitem(person_id,item_id) values(990000026,41);
INSERT INTO personcreatesitem(person_id,item_id) values(990000033,42);
INSERT INTO personcreatesitem(person_id,item_id) values(990000032,43);
INSERT INTO personcreatesitem(person_id,item_id) values(990000034,44);
INSERT INTO personcreatesitem(person_id,item_id) values(990000035,45);
INSERT INTO personcreatesitem(person_id,item_id) values(990000036,46);
INSERT INTO personcreatesitem(person_id,item_id) values(990000037,47);
INSERT INTO personcreatesitem(person_id,item_id) values(990000038,48);
INSERT INTO personcreatesitem(person_id,item_id) values(990000039,49);
INSERT INTO personcreatesitem(person_id,item_id) values(990000050,50);
INSERT INTO personcreatesitem(person_id,item_id) values(990000040,51);
INSERT INTO personcreatesitem(person_id,item_id) values(990000041,52);
INSERT INTO personcreatesitem(person_id,item_id) values(990000042,53);
INSERT INTO personcreatesitem(person_id,item_id) values(990000043,54);
INSERT INTO personcreatesitem(person_id,item_id) values(990000044,55);
INSERT INTO personcreatesitem(person_id,item_id) values(990000045,56);
INSERT INTO personcreatesitem(person_id,item_id) values(990000046,57);
INSERT INTO personcreatesitem(person_id,item_id) values(990000047,58);
INSERT INTO personcreatesitem(person_id,item_id) values(990000048,59);
