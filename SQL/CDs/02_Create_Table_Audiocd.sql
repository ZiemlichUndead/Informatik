CREATE TABLE Audiocd (
	id VARCHAR (10) NOT NULL PRIMARY KEY,
	diskid VARCHAR (10),
	title VARCHAR (64),
	albumyear VARCHAR (4),
	albumtime INTEGER,
	trackcount INTEGER
);