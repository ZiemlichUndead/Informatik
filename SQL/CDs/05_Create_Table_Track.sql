CREATE TABLE Track (
	audiocd_id VARCHAR (10) NOT NULL,
	pos INTEGER NOT NULL,
	artist_id INTEGER NOT NULL,
	song_id INTEGER NOT NULL,
	tracktime INTEGER,
	PRIMARY KEY (audiocd_id, pos),
	FOREIGN KEY (audiocd_id) REFERENCES Audiocd (id),
	FOREIGN KEY (artist_id) REFERENCES Artist (id) ON DELETE NO ACTION,
	FOREIGN KEY (song_id) REFERENCES Song (id) ON DELETE CASCADE
);