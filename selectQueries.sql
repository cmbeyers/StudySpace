

--THESE ARE THE QUERIES FOR HOW TO DO SELECTION OF VALUES TO DISPLAY IN THE HTML UI

--Select a specific region
select * from regions where library_name = 'library string' and floor_name = 'floor string' and region_name = 'region string';

--Select all regions from a floor
select * from regions where library_name = 'library string' and floor_name = 'floor string';

--Select all regions in a library
select * from regions where library_name = 'library string';

--Select a floor to get occupancy
select * from floors where library_name = 'library string' and floor_name = 'floor string';

--Select all floors in a lib
select * from floors where library_name = 'library string';

--Select a library to get occupancy
select * from library where library_name = 'library string';


--FOR CALCULATING OCCUPANY LEVELS
select current_occupancy, max_occupancy from regions where library_name = 'library string' and floor_name = 'floor string' and region_name = 'region string';
--FOR THE OCCUPANCY 0-1.0 DO current/max_occupancy                 0-.33 = green    .33-.66 = yellow     .66-1 = red