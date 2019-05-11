import os
from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_marshmallow import Marshmallow
from flask_migrate import Migrate


app = Flask(__name__)
basedir = os.path.abspath(os.path.dirname(__file__))
app.config["SQLALCHEMY_DATABASE_URI"] = 'sqlite:///' + os.path.join(basedir, 'events.db')
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)
ma = Marshmallow(app)
migrate = Migrate(app, db)

from models import User, Event, EventSchema

@app.route("/", methods=["GET", "POST"])
def events():
    if request.method == "GET":
        return jsonify(EventSchema(many=True).dump(Event.query.all()).data)

@app.route("/event/<int:eventId>", methods=["GET"])
def event(eventId):
    return jsonify(EventSchema(many=False).dump(Event.query.get(eventId)).data)
