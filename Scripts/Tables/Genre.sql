-- ====================================CREACION DE TABLAS====================================
CREATE TABLE genre(
    genre_id NUMBER(11),
    genre_name VARCHAR(50) CONSTRAINT genre_name_nn NOT NULL,
    description VARCHAR2(150)
);

-- ====================================COMENTARIOS DE COLUMNAS====================================
COMMENT ON TABLE genre
IS 'Repository to storage information about the genres an item has';

COMMENT ON COLUMN genre.genre_id
IS 'Genre identification code';

COMMENT ON COLUMN genre.genre_name
IS 'Genre name';

COMMENT ON COLUMN genre.description
IS 'Description of a genre';

-- ====================================PRIMARY KEY====================================
ALTER TABLE genre
    ADD CONSTRAINT pk_genre PRIMARY KEY(genre_id)
    USING INDEX
    TABLESPACE pe_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0);
    
-- ====================================CAMPOS DE AUDITORIA====================================
ALTER TABLE genre
    ADD creation_date DATE
    ADD creation_user VARCHAR(50)
    ADD date_last_modification DATE
    ADD user_last_modification VARCHAR(50);

-- ====================================SECUENCIA DE genre====================================
CREATE SEQUENCE s_genre
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 99999999999
NOCACHE
NOCYCLE;

-- ====================================TRIGGERS DE genre====================================
CREATE OR REPLACE TRIGGER pe.beforeInsertGenre
BEFORE INSERT ON pe.genre
FOR EACH ROW
BEGIN
    :new.genre_id := s_genre.nextval;
    :new.creation_date := SYSDATE;
    :new.creation_user := USER;
END beforeInsertGenre;

/

CREATE OR REPLACE TRIGGER pe.beforeUpdateGenre
BEFORE UPDATE ON pe.genre
FOR EACH ROW
BEGIN
    :new.date_last_modification := SYSDATE;
    :new.user_last_modification := USER;
END beforeUpdateGenre;