__________________________tabla Publisher___________________________________________________

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
insert into Publisher(publisher_name) values('Tōhō');
insert into Publisher(publisher_name) values('Universal Pictures');
insert into Publisher(publisher_name) values('Walt Disney Studios Motion Pictures');
insert into Publisher(publisher_name) values('Warner Bros. Pictures');
insert into Publisher(publisher_name) values('New Line Cinema');
insert into Publisher(publisher_name) values('Metro Goldwyn Mayer');
insert into Publisher(publisher_name) values('Lionsgate');
insert into Publisher(publisher_name) values('Activision');
insert into Publisher(publisher_name) values('Sega');
insert into Publisher(publisher_name) values('Electronic Arts');
insert into Publisher(publisher_name) values('square enix');	
insert into Publisher(publisher_name) values('Konami');





__________________________tabla genre__________________________________________________________

insert into genre(genre_name,description) values('Mystery',' The plot always revolves around a crime of sorts that must be solved—or foiled—by the protagonists.');
insert into genre(genre_name,description) values('Adventure','Main character repeatedly finds themselves in high stakes situations.');
insert into genre(genre_name,description) values('Fantasy',' While usually set in a fictional imagined world.');
insert into genre(genre_name,description) values('Horror','Meant to cause discomfort and fear for both the character and readers, horror writers often make use of supernatural and paranormal.');
insert into genre(genre_name,description) values('Romance','The genre that makes your heart all warm and fuzzy focuses on the love story of the main protagonists.');
insert into genre(genre_name,description) values('Science Fiction','Science fiction stories is that they lean heavily on themes of technology and future science.');
insert into genre(genre_name,description) values('Cookbooks','Collection of recipes, specific to a theme, cuisine, or experience chosen by the author.');
insert into genre(genre_name,description) values('Biography',' Detailed description of a person's life. It involves more than just the basic facts like education, work, relationships, and death.');
insert into genre(genre_name,description) values('Action','The protagonist or protagonists are thrust into a series of events that typically include violence.');
insert into genre(genre_name,description) values('Comedy','Consisting of discourses or works intended to be humorous');


__________________________tabla status__________________________________________________________

insert into status(status_name,description) values('Blue','Actually in stock');
insert into status(status_name,description) values('Green','Loaned on business days');
insert into status(status_name,description) values('Yellow ','In tolerance days');
insert into status(status_name,description) values('Red','Has not been returned');

__________________________tabla  ItemType__________________________________________________________

insert into itemtype(itemtype_name) values('Book');
insert into itemtype(itemtype_name) values('Movies');
insert into itemtype(itemtype_name) values('Comic');
insert into itemtype(itemtype_name) values('VideoGame');

__________________________tabla  Review__________________________________________________________


insert into Review(stars) values(1);
insert into Review(stars) values(2);
insert into Review(stars) values(3);
insert into Review(stars) values(4);
insert into Review(stars) values(5);

__________________________tabla relationtype___________________________________________________

insert into  relationtype(relationtype_name) values('Friend');
insert into  relationtype(relationtype_name) values('Known');
insert into  relationtype(relationtype_name) values('Family');
insert into  relationtype(relationtype_name) values('Co-worker');

__________________________tabla PersonType___________________________________________________

insert into  PersonType(persontype_name) values('Admin');
insert into  PersonType(persontype_name) values('User');

__________________________tabla Person___________________________________________________

insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Ronaldo','Vindas','rony1211@gmail.com','falcon12','88778841',DATE '1999-11-12',1);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Renzo','Barra','rony1211@gmail.com','Renzo12','98753215',DATE '1999-1-2',1);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Alvaro','Moreira','conker@gmail.com','conker19','87258021',DATE '1992-2-19',1);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Joseph','Chaves','jox@gmail.com','jox127','87946321',DATE '2000-5-15',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Emely','Zarate','Emezar18@gmail.com','Emezar18','26887451',DATE '1995-7-5',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Valeria','Aguilar','VAguilar@yahoo.com','agva68','22698725',DATE '2002-06-02',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Anthony','Vargas','Tony1522@gmail.com','tova15','22672146',DATE '2003-06-01',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Krissia','Pérez','KrissPM@hotmail.com','pekrpm105','22676548',DATE '1999-05-31',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Emmanuel','Jarquín','Emma123@gmail.com','jaem12','22651278',DATE '1998-05-30',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Jesús','Aguilar','ChusAM@gmail.com','agjeAm','82654820',DATE '1988-05-29',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Javier','Barquero','Raydertre@outlook.com','Bajaray','22621897',DATE '1972-05-28',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Rebecca','Madrigal','RebboxMad@gmail.com','MareMAD','89632570',DATE '2001-05-26',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Justin','Bogantes','Justino@tec.com','BoJu25','83654015',DATE '1985-05-24',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Alejandra','Rivera','alitadepol@yahoo.com','holahola','81254798',DATE '1993-05-23',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values(Joselyn','Rodríguez','Joss45451@gmail.com','Rojo54','78965215',DATE '1987-05-22',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Keylor','Navas','SanNavas@hotmail.com','Nakegol','89215821',DATE '1999-05-21',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Valery','Vega','VValery@yahoo.com.com','vevaer','89646851',DATE '2001-05-19',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Josue','Siles','Siles@gmail.com','130cm','72357801',DATE '1998-05-18',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Dennis','Ángulo','Dernudo@outlook.com','ande8','98746526',DATE '1993-05-17',0);
insert into  Person(first_name,last_name, email, password, phone_number,birth_day, persontype_id) values('Ishtar','Saborio','servantesCD@outlook.com','DCishr','98746526',DATE '1994-01-10',0);

__________________________tabla item___________________________________________________

insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y la piedra filosofal','primera','000000000001',1,1,10,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y la cámara secreta','primera','000000000002',1,1,10,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y el prisionero de Azkaban','primera','000000000003',1,1,10,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y el cáliz de fuego','primera','000000000004',1,1,10,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y la Orden del Fénix','primera','000000000005',1,1,10,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y el misterio del príncipe','primera','000000000006',1,1,10,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Harry Potter y las reliquias de la Muerte','primera','000000000007',1,1,10,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El Instituto','Best Seller','000000000008',1,1,9,1)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('DE AMOR Y DE SOMBRA','Best Seller','000000000009',1,1,9,5)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('DUNE LA BATALLA DE CORRIN ','Best Seller','000000000010',1,1,9,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('DIARIO DE ANA FRANK','2007','000000000011',1,1,9,8)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('VIOLIN DEL DIABLO','Best Seller','000000000012',1,1,9,1)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('YOGA KITCHEN,'2020'','000000000013',1,1,11,7)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('READY PLAYER ONE (ESPAÑOL)','2018','000000000014',1,1,12,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('LIFE AND ADVENTURES OF ROBINSON CRUSOE','2019','000000000015',1,1,13,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('John Wick','DVD','000000000016',2,1,14,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Star Wars: Episodio III - La venganza de los Sith','Blu-ray','000000000017',2,1,15,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Los Increíbles','DVD','000000000018',2,1,16,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El increíble castillo vagabundo','DVD','000000000019',2,1,17,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Shrek','blu-ray','000000000020',2,1,18,10)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El planeta del tesoro','dvd','000000000021',2,1,19,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Spider-Man: Un nuevo universo','blu-ray','000000000022',2,1,8,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El rey león','dvd','000000000023',2,1,16,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('it(2017)','blu-ray','000000000024',2,1,20,4)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Parque Jurásico','DVD','000000000025',2,1,18,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Mi pobre angelito','DVD','000000000026',2,1,15,10)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('El Señor de los Anillos: la Comunidad del Anillo','DVD','000000000027',2,1,21,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Los juegos del hambre','blu-ray','000000000028',2,1,23,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Terminator','DVD','000000000029',2,1,21,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Cars','DVD,'000000000030',2,1,16,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Action Comics 1','primera','000000000031',3,1,4,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('The Infinity Gauntlet','primera','000000000032',3,1,5,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Dark Nights: Metal','Limited series','000000000033',3,1,4,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Watchmen','1987','000000000034',3,1,4,1)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('mass effect','to cool','000000000035',3,1,3,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Injustice: Gods Among Us','luxe','000000000036',3,1,4,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Secret Empire','Limited series','000000000037',3,1,5,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Secret Wars','Limited series','000000000038',3,1,5,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('The Court of Owls','batman series','000000000039',3,4,1)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Flashpoint','Limited series','000000000040',3,1,4,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('300','Limited series','000000000041',3,1,3,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('V de Vendetta','edge','000000000042',3,1,3,1)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Scott Pilgrim's Precious Little Life','Badass edition','000000000043',3,1,1,5)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Batman: The Dark Knight Returns','batman siries','000000000044',3,1,4,1)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('X-Men','plus ultra colection','000000000045',3,1,5,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('tony hawk pro skater 2','PS1','000000000046',4,1,20,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Crash Bandicoot','PS1','000000000047',4,1,20,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('pokemon stadium 2','N64','000000000048',4,1,6,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('halo 2','xbox','000000000049',4,1,7,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Super Mario' World','snes','000000000050',4,1,6,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('crazy taxi 2','dreamcast','000000000051',4,1,21,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('burnout revenge','PS2','000000000052',4,1,22,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Sonic the Hedgehog','PS3','000000000053',4,1,21,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('star wars battlefront ii','PS5','000000000054',4,1,22,6)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('Nights into Dreams','Drea,cast','000000000055',4,1,21,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('final fantasy 7','PS1','000000000056',4,1,23,3)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('castlevania symphony of the night','PS1','000000000057',4,1,24,4)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('conker bad fur day','N64','000000000058',4,1,6,2)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('f zero gx','Gamecube','000000000059',4,1,21,9)
insert into item(title,edition,barcode,itemtype_id,status_id,publisher_id,genre_id) values('God of War','PS2','000000000060',4,1,8,2)

