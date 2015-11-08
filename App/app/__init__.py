from flask import *
from flask.ext.mysqldb import MySQL
import os

app = Flask(__name__, static_url_path = "/static", static_folder = "static")

mysql = MySQL()
app.config.from_object('config')

app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_HOST'] = 'localhost'
#app.config['MYSQL_USER'] = 'root'
#app.config['MYSQL_PASSWORD'] = 'studyspace441'

mysql.init_app(app)

from app import views
