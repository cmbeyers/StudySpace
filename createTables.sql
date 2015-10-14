DROP DATABASE if EXISTS miStudySpace;
CREATE DATABASE miStudySpace;

USE miStudySpace;

CREATE TABLE Access_Points (
	ap_name VARCHAR(20) NOT NULL,
	current_clients INTEGER,
	PRIMARY KEY (ap_name)
);
CREATE TABLE Libraries (
	library_name VARCHAR(20) NOT NULL,
	current_occupancy INTEGER,
	max_occupancy INTEGER,
	PRIMARY KEY (library_name)
);
CREATE TABLE Floors (
	library_name VARCHAR(20) NOT NULL,
	floor_name VARCHAR(40),
	current_occupancy INTEGER,
	max_occupancy INTEGER,
	PRIMARY KEY (library_name, floor_name),
	FOREIGN KEY library_name REFERENCES Libraries
);

CREATE TABLE Regions (
	region_name VARCHAR(40) NOT NULL,
	floor_name VARCHAR(40),
	library_name VARCHAR(40),
	current_occupancy INTEGER,
	max_occupancy INTEGER,
	PRIMARY KEY (region_name, floor_name, library_name),
	FOREIGN KEY floor_name REFERENCES Floors,
	FOREIGN Key library_name REFERENCES libraries
);

--Create the libraries
INSERT INTO Libraries(library_name, current_occupancy, max_occupancy)
VALUES ("Shapiro", 0, 1400);


--Create the floors
INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ("Shapiro", "Basement", 0, 219);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ("Shapiro", "First", 0, 404);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ("Shapiro", "Second", 0, 342);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ("Shapiro", "Third", 0, 206);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ("Shapiro", "Fourth", 0, 228);



INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("North", "Basement", "Shapiro", 0, 59);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("Center", "Basement", "Shapiro", 0, 110);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("South", "Basement", "Shapiro", 0, 49);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("North", "First", "Shapiro", 0, 156);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("Center", "First", "Shapiro", 0, 158);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("South", "First", "Shapiro", 0, 90);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("North", "Second", "Shapiro", 0, 79);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("Center", "Second", "Shapiro", 0, 138);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("South", "Second", "Shapiro", 0, 125);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("North", "Third", "Shapiro", 0, 139);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("South", "Third", "Shapiro", 0, 67);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("North", "Fourth", "Shapiro", 0, 74);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("Center", "Fourth", "Shapiro", 0, 79);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ("South", "Fourth", "Shapiro", 0, 75);






