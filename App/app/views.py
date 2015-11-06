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
    
    return render_template('library.html')