from __future__ import division
from flask.ext.mysqldb import MySQL
from flask import *
import os
from flask import Flask, request, redirect, url_for, session,app
from werkzeug import secure_filename, generate_password_hash
import time
import hashlib
from datetime import timedelta
from app import app
from app import mysql
import time



@app.route("/")
def index():
    
    return render_template('index.html')

@app.route("/about")
def about():
    
    return render_template('about.html')

@app.route("/library")
def library():
    entries = None;
    libName=request.args['name']
    cur = mysql.connection.cursor()
    
    #Library Occupancy
    cur.execute("SELECT * FROM miStudySpace.Libraries WHERE library_name=%s", {str(libName)})
    libraryInfo = cur.fetchall()
    libraryOccupancy = int(round((libraryInfo[0][1]/libraryInfo[0][2])*100))
    if libraryOccupancy > 100:
        libraryOccupancy = 100
    libraryName=libraryInfo[0][0]
    
    
    #Floors Occupancy
    cur.execute("SELECT * FROM miStudySpace.Floors WHERE library_name=%s ORDER BY floor_index ASC", {str(libName)})
    floorName = []
    floorOccupancy = []
    entries = cur.fetchall()
    for entry in entries:
        floorName.append(entry[1])
        currentFloorOccupancy = int(round((entry[3]/entry[4])*100))
        if currentFloorOccupancy > 100:
            currentFloorOccupancy = 100
        floorOccupancy.append(currentFloorOccupancy)
    floorInfo=zip(floorName, floorOccupancy)


    #Week Averages

    currentDay = time.strftime("%w")

    if currentDay == "0":
        currentDay = "7";
    currentDay = "data"+currentDay
    print currentDay
    dayAverageInfo = []
    labels = [(1, "Monday"), (2, "Tuesday"), (3, "Wednesday"), (4, "Thursday"), (5, "Friday"), (6, "Saturday"), (7, "Sunday")]


    for x in range (1, 8):
        print x
        name=[]
        cur.execute("SELECT * FROM miStudySpace.Library_Hour_Average WHERE library_name=%s and day_index=%s ORDER BY hour ASC", ({str(libName)}, str(x)))

        entries = cur.fetchall();

        hour = []
        dayFillAverage = []
        for entry in entries:
            hour.append(entry[1])
            dayFillAverage.append(entry[4]*100)
            #dataLabel.append(str(entry[4]*100)+"%")
            #dayLabel.append(entry[3])
            #weekDay.append(entry[2])
            #name=zip(weekDay, dayFillAverage, dataLabel, dayLabel)
        name = zip(hour, dayFillAverage)
        print name
        dayAverageInfo.append(name)


    if libraryInfo:
        return render_template('library.html', libraryOccupancy=libraryOccupancy, floorInfo=floorInfo, libraryName=libraryName, dayAverageInfo=dayAverageInfo, currentDay=currentDay, labels=labels)


    else:
        return render_template('404.html')



@app.route("/floor")
def floor():
    libName=request.args['name']
    floorName=request.args['floor']
    cur = mysql.connection.cursor()
    
    #Floor Occupancy
    cur.execute("SELECT * FROM miStudySpace.Floors WHERE library_name = %s and floor_name = %s", ({str(libName)}, {str(floorName)}))
    entries = cur.fetchall()
    floorOccupancy = int(round((entries[0][3]/entries[0][4])*100))
    if floorOccupancy > 100:
        floorOccupancy = 100
    #Region Occupancy
    cur.execute("SELECT * FROM miStudySpace.Regions WHERE library_name=%s and floor_name=%s ORDER BY region_index ASC", ({str(libName)}, {str(floorName)}))
    entries = cur.fetchall()
    regionName = []
    regionOccupancy = []
    for entry in entries:
        regionName.append(entry[0])
        currentRegionOccupancy = int(round((entry[4]/entry[5])*100))
        if currentRegionOccupancy > 100:
            currentRegionOccupancy = 100
        regionOccupancy.append(currentRegionOccupancy)
    regionInfo = zip(regionName, regionOccupancy)


    if entries:
        return render_template('floor.html', regionInfo=regionInfo, floorName=entry[1], libraryName=entry[2], floorOccupancy = floorOccupancy)
    
    else:
        return render_template('404.html')


