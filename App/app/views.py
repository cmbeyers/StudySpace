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
    libraryOccupancy = int((libraryInfo[0][1]/libraryInfo[0][2])*100)
    print libraryOccupancy

    #Floors Occupancy
    cur.execute("SELECT * FROM miStudySpace.Floors WHERE library_name=%s", {str(libName)})
    floorName = []
    floorOccupancy = []
    entries = cur.fetchall()
    for entry in entries:
        floorName.append(entry[1])
        floorOccupancy.append(int((entry[2]/entry[3])*100))
    floorInfo=zip(floorName, floorOccupancy)



    if libraryInfo:
        return render_template('library.html', libraryOccupancy=libraryOccupancy, floorInfo=floorInfo)

    else:
        return render_template('404.html')