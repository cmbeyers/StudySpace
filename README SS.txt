MainFile
Opens the Homescreen window, responsible for starting of the project and contains
the main method

HomeScreen 
The layout of all of the working pieces of the project
The Listener class is responsible for grabbing any user interaction
Once a selection is made, the listener contains the code to updating each of the
different statistics to be displayed
The color status bars are set in intervals (0-.33 is green, .33-.66 is yellow, .66-1 is red)
All of this is handled through switch statements
Overall capacities of floors are hard coded into the switch statements
(Need to store these in database for future computation, color should be handled by HTML/Javascript)
Order of Events:
getTextFile retrieves the text file from the Email to the java code
getData takes in a file type (the attachment) and places all access points into a 
string (name) to integer (current clients) map, as well as adds the name string to a string vector
Perform Update updates the DB statistics based on the map and AP names (rework this DB function)'
updateGUI updates all of the colors and current stats from the DB
All of this is run from the AutoUpdate class which is a timer executed function that runs every 5 minutes

SSDatabase
The database setup through MongoDB as well as all the communication with the values

MailReader
Reads the emails from the umichstudyspace@gmail.com account (password currently UC270008)
Grabs the most recent attachment and marks all others it has found as read

emailSender
Does nothing so far, was using to make a suggestion button but unable to get to work

mySearch
Part of what is needed for MailReader

The rest of the files are just floorplan images used to show regions described