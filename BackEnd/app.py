import os
from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_marshmallow import Marshmallow
from flask_migrate import Migrate


app = Flask(__name__)
basedir = os.path.abspath(os.path.dirname(__file__))
app.config["SQLALCHEMY_DATABASE_URI"] = 'sqlite:///' + os.path.join(basedir, 'database.db')
db = SQLAlchemy(app)
ma = Marshmallow(app)
migrate = Migrate(app, db)

from models import User, Event, EventSchema

@app.route("/", methods=["GET", "POST"])
def register():
    if request.method == "GET":
        allevents = Event.query.all()
        response = jsonify(EventSchema(many=True).dump(allevents).data)
        return response

@app.route("/event/<int:eventId>", methods=["GET", "POST"])
def event(eventId):
    if request.method == "GET":
        return jsonify(EventSchema(many=False).dump(Event.query.get(eventId)).data)

@app.route("/register", methods=["GET", "POST"])
def register():
    """Register user """

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":

        # get password, username, name and surname from form.
        password = request.args.get('hash')
        username = request.args.get("username")
        name = request.args.get("name")
        surname = request.args.get("surname")
        # Ensure username was submitted
        if not username:
            return 'Username is required.'

        # Ensure password was submitted
        if not password:
            return 'Password is required.'
        # Ensure name was submitted 
        if not firstname:
            return 'firstname is required.'
        # Ensure surname was submitted
        if not lastname:
            return 'lastname is required.'
        # Ensure username exists and password is correct
        if error is None:
            # myUser = User(username="dgjlskjf", hash="slkjfldfskl", firs )
            db.execute(
                'INSERT INTO user (username, password, name, surname) VALUES (?, ?, ?, ?)',
            )
            db.commit()
            return True

@app.route("/login", methods=["GET", "POST"])
def login():
    """Log user in"""

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":

        # get password and user from form.
        password = request.args.get('hash')
        username = request.args.get("username")

        # Ensure username was submitted
        if not username:
            return 'Username is required.'

        # Ensure password was submitted
        if not password:
            return 'Password is required.'

        # Ensure username exists and password is correct
        if not check_password_hash(user.hash, password):
            return False
    return True