CREATE TABLE Lieferung (
	lnum VARCHAR (10) NOT NULL,
	anum VARCHAR (10) NOT NULL,
	datum DATE NOT NULL,
	anzahl INTEGER,
	PRIMARY KEY (lnum, anum, datum));
