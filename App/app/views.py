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



@app.route("/")
def index():
    
    return render_template('index.html')

@app.route("/library")
def library():
    entries = None;
    libName=request.args['name']
    cur = mysql.connection.cursor()

    #Library Occupancy
    cur.execute("SELECT * FROM miStudySpace.Libraries WHERE library_name=%s", {str(libName)})
    libraryInfo = cur.fetchall()
    libraryOccupancy = int(round((libraryInfo[0][1]/libraryInfo[0][2])*100))
    libraryName=libraryInfo[0][0]
    

    #Floors Occupancy
    cur.execute("SELECT * FROM miStudySpace.Floors WHERE library_name=%s ORDER BY floor_index ASC", {str(libName)})
    floorName = []
    floorOccupancy = []
    entries = cur.fetchall()
    for entry in entries:
        floorName.append(entry[1])
        floorOccupancy.append(int(round((entry[3]/entry[4])*100)))
    floorInfo=zip(floorName, floorOccupancy)


    #Averages
    cur.execute("SELECT * FROM miStudySpace.Library_Hour_Average WHERE library_name=%s ORDER BY hour ASC", {str(libName)})
    entries = cur.fetchall();
    hour = []
    fillAverage = []
    label = []
    for entry in entries:
        print entry[1]
        hour.append(entry[1])
        fillAverage.append(entry[2]*100)
        label.append(str(entry[2]*100)+"%")
    averageInfo = zip(hour, fillAverage, label)
    print averageInfo

    if libraryInfo:
        return render_template('library.html', libraryOccupancy=libraryOccupancy, floorInfo=floorInfo, averageInfo=averageInfo, libraryName= libraryName)

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
    
    #Region Occupancy
    cur.execute("SELECT * FROM miStudySpace.Regions WHERE library_name=%s and floor_name=%s ORDER BY region_index ASC", ({str(libName)}, {str(floorName)}))
    entries = cur.fetchall()
    regionName = []
    regionOccupancy = []
    for entry in entries:
        regionName.append(entry[0])
        regionOccupancy.append(int(round((entry[4]/entry[5])*100)))
    regionInfo = zip(regionName, regionOccupancy)


    if entries:
        return render_template('floor.html', regionInfo=regionInfo, floorName=entry[1], libraryName=entry[2], floorOccupancy = floorOccupancy)
                               
    else:
        return render_template('404.html')





