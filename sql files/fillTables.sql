USE miStudySpace;

-- Create the libraries
INSERT INTO Libraries(library_name, current_occupancy, max_occupancy)
VALUES ('Shapiro', 0, 1400);


-- Create the floors
INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ('Shapiro', 'Basement', 0, 219);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ('Shapiro', 'First', 0, 404);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ('Shapiro', 'Second', 0, 342);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ('Shapiro', 'Third', 0, 206);

INSERT INTO Floors(library_name, floor_name, current_occupancy, max_occupancy)
VALUES ('Shapiro', 'Fourth', 0, 228);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('North', 'Basement', 'Shapiro', 0, 59);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('Center', 'Basement', 'Shapiro', 0, 110);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('South', 'Basement', 'Shapiro', 0, 49);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('North', 'First', 'Shapiro', 0, 156);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('Center', 'First', 'Shapiro', 0, 158);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('South', 'First', 'Shapiro', 0, 90);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('North', 'Second', 'Shapiro', 0, 79);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('Center', 'Second', 'Shapiro', 0, 138);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('South', 'Second', 'Shapiro', 0, 125);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('North', 'Third', 'Shapiro', 0, 139);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('South', 'Third', 'Shapiro', 0, 67);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('North', 'Fourth', 'Shapiro', 0, 74);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('Center', 'Fourth', 'Shapiro', 0, 79);

INSERT INTO Regions(region_name, floor_name, library_name, current_occupancy, max_occupancy)
VALUES ('South', 'Fourth', 'Shapiro', 0, 75);

-- Create the hour intervals for shapiro

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 0, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 1, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 2, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 3, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 4, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 5, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 6, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 7, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 8, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 9, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 10, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 11, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 12, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 13, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 14, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 15, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 16, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 17, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 18, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 19, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 20, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 21, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 22, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Basement', 23, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 0, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 1, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 2, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 3, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 4, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 5, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 6, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 7, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 8, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 9, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 10, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 11, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 12, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 13, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 14, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 15, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 16, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 17, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 18, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 19, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 20, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 21, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 22, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'First', 23, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 0, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 1, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 2, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 3, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 4, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 5, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 6, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 7, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 8, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 9, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 10, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 11, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 12, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 13, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 14, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 15, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 16, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 17, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 18, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 19, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 20, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 21, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 22, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Second', 23, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 0, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 1, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 2, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 3, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 4, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 5, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 6, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 7, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 8, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 9, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 10, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 11, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 12, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 13, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 14, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 15, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 16, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 17, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 18, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 19, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 20, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 21, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 22, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Third', 23, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 0, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 1, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 2, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 3, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 4, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 5, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 6, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 7, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 8, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 9, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 10, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 11, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 12, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 13, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 14, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 15, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 16, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 17, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 18, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 19, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 20, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 21, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 22, 0.0);

INSERT INTO Hour_Average(library_name, floor_name, hour, fill_average)
VALUES ('Shapiro', 'Fourth', 23, 0.0);
