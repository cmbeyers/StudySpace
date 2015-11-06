
--THESE WILL ALL BE USED IN THE JAVA CODE AFTER GRABBING AN EMAIL ATTACHMENT


UPDATE regions reg SET (current_occupancy) = 'new value from java' 
where reg.region_name = 'region string' 
and reg.floor_name = 'floor string'
and reg.library_name = 'library string';

UPDATE libraries lib SET (current_occupancy) = 'new value from java'
where lib.library_name = 'library string';

UPDATE floors floor SET (current_occupancy) = "new value from java" 
where floor.floor_name = 'floor string' 
and floor.library_name = 'library string';