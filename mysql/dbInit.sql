CREATE USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'itmo';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;

CREATE TABLE Language
(
	id 		INT 			NOT NULL AUTO_INCREMENT,
	name 	VARCHAR(30) 	NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO Language (id, name)
VALUES (1, 'Русский'),
	   (2, 'Английский'),
	   (3, 'Испанский'),
	   (4, 'Итальянский'),
	   (5, 'Немецкий'),
	   (6, 'Французский');

CREATE TABLE Publication_type
(
	id 		INT				NOT NULL AUTO_INCREMENT,
	name 	VARCHAR(30) 	NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO Publication_type (id, name)
VALUES (1, 'ВАК'),
	   (2, 'РИНЦ'),
	   (3, 'Прочие');

CREATE TABLE Location
(
	id 		INT 			NOT NULL AUTO_INCREMENT,
	name 	VARCHAR(30) 	NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO Location (id, name)
VALUES (1, 'Москва'),
	   (2, 'Санкт-Петербург'),
	   (3, 'Тверь'),
	   (4, 'Новосибирск'),
	   (5, 'Волгоград'),
	   (6, 'Владивосток');

CREATE TABLE Type
(
	id 		INT 			NOT NULL AUTO_INCREMENT,
	name 	VARCHAR(30) 	NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO Type (id, name)
VALUES (1, 'Статья'),
	   (2, 'Доклад'),
	   (3, 'Реферат'),
	   (4, 'Тезисы'),
	   (5, 'Монография');

CREATE TABLE Project
(
	id 		BIGINT 			NOT NULL AUTO_INCREMENT,
	name 	VARCHAR(255) 	NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Participant
(
    id          BIGINT 		NOT NULL AUTO_INCREMENT,
    first_name  VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    last_name   VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Position
(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(20),
	PRIMARY KEY(id)
);

INSERT INTO Position (id, name)
VALUES (1, 'Бакалавр'),
       (2, 'Магистр'),
       (3, 'Доцент');

CREATE TABLE Publication
(
	id 					BIGINT 			NOT NULL AUTO_INCREMENT,
	name 				VARCHAR(255) 	NOT NULL,
	language 			INT 			NOT NULL,
	type 				INT 			NOT NULL,
	volume 				INT 			NOT NULL,
	location 			INT 			NOT NULL,
	publication_type 	INT 			NOT NULL,
	citation_index		INT 			NOT NULL,
	publication_date	TIMESTAMP 		NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(language) 			REFERENCES Language (id),
	FOREIGN KEY(publication_type) 	REFERENCES Publication_type (id),
	FOREIGN KEY(location) 			REFERENCES Location (id),
	FOREIGN KEY(type) 				REFERENCES Type (id)
);

CREATE TABLE Authorship
(
	participant_id BIGINT NOT NULL,
	publication_id BIGINT NOT NULL,
	PRIMARY KEY(participant_id, publication_id),
	CONSTRAINT authorship_participant_fk
		FOREIGN KEY(participant_id) REFERENCES Participant(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT authorship_publication_fk
		FOREIGN KEY(publication_id) REFERENCES Publication(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Project_participants
(
	participant_id 	BIGINT 		NOT NULL,
	project_id 		BIGINT 		NOT NULL,
	date_joined 	TIMESTAMP 	NOT NULL,
	date_left 		TIMESTAMP 	NOT NULL,
	PRIMARY KEY(participant_id, project_id),
	CONSTRAINT participant_fk
		FOREIGN KEY(participant_id) REFERENCES Participant(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT project_fk
		FOREIGN KEY(project_id) REFERENCES Project(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Conference
(
	id 			BIGINT 			NOT NULL AUTO_INCREMENT,
	name 		VARCHAR(255) 	NOT NULL,
	date 		TIMESTAMP 		NOT NULL,
	location 	INT 			NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(location) REFERENCES Location (id)
);

CREATE TABLE Book
(
	id 					BIGINT 			NOT NULL AUTO_INCREMENT,
	name 				VARCHAR(255) 	NOT NULL,
	language 			INT 			NOT NULL,
	volume 				INT 			NOT NULL,
	location 			INT 			NOT NULL,
	publication_date	TIMESTAMP 		NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(language) 	REFERENCES Language (id),
	FOREIGN KEY(location) 	REFERENCES Location (id)
);

CREATE TABLE Reader_sheet
(
	id 				BIGINT 		NOT NULL AUTO_INCREMENT,
	book_id 		BIGINT 		NOT NULL,
	reader_id 		BIGINT 		NOT NULL,
	date_taken 		TIMESTAMP 	NOT NULL,
	date_returned 	TIMESTAMP,
	PRIMARY KEY(id),
	CONSTRAINT reader_sheet_reader_fk
		FOREIGN KEY(reader_id) REFERENCES Participant(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT reader_sheet_book_fk
		FOREIGN KEY(book_id) REFERENCES Book(id) ON DELETE CASCADE ON UPDATE CASCADE
);