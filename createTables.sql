--DROP DATABASE if EXISTS miStudySpace;
--CREATE DATABASE miStudySpace;

--USE miStudySpace;

CREATE TABLE contains(
	albID VARCHAR2(100),
	 phoID VARCHAR2(100),
	  PRIMARY KEY(albID, phoID),
	   FOREIGN KEY(albID) REFERENCES albums ON DELETE CASCADE,
	    FOREIGN KEY(phoID) REFERENCES photos ON DELETE CASCADE);

CREATE TABLE Access_Points (
	ap_name VARCHAR(20) NOT NULL,
	current_clients INTEGER,
	PRIMARY KEY (ap_name)
);
CREATE TABLE Libraries (
	library_name VARCHAR(40) NOT NULL,
	current_occupancy INTEGER,
	max_occupancy INTEGER,
	PRIMARY KEY (library_name)
);
CREATE TABLE Floors (
	library_name VARCHAR(40) NOT NULL,
	floor_name VARCHAR(40),
	current_occupancy INTEGER,
	max_occupancy INTEGER,
	PRIMARY KEY (library_name, floor_name),
	FOREIGN KEY (library_name) REFERENCES Libraries(library_name)
);

CREATE TABLE Regions (
	region_name VARCHAR(40) NOT NULL,
	floor_name VARCHAR(40),
	library_name VARCHAR(40),
	current_occupancy INTEGER,
	max_occupancy INTEGER,
	PRIMARY KEY (region_name, floor_name, library_name),
	FOREIGN KEY (floor_name, library_name) REFERENCES Floors(floor_name, library_name)
	--FOREIGN KEY (library_name) REFERENCES Libraries(library_name)
);
CREATE TABLE Hour_Average (
	floor_name VARCHAR(40),
	library_name VARCHAR(40),
	hour INTEGER, --Hour from 0-23
	fill_average FLOAT(5), --Precision of 8 numbers, 7 decimal places
	PRIMARY KEY (floor_name, library_name, hour),
	FOREIGN KEY (floor_name, library_name) REFERENCES Floors(floor_name, library_name)
	--FOREIGN KEY (library_name) REFERENCES Libraries(library_name)
);

--For updating this, pull the current value, multiply by
--How many time intervals have been passed - 1, then add the current level
--Divide by how many time intervals have passed
--Restart interval count after 12 intervals (60 minutes)
--And increment the hour number

