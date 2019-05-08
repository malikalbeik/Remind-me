from app import db, ma


class User(db.Model):
    """User is the table to store users"""
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(32), index=True, unique=True, nullable=False)
    hash = db.Column(db.String(128), nullable=False)
    firstname = db.Column(db.String(32), unique=False, nullable=False)
    lastname = db.Column(db.String(32), unique=False, nullable=False)

    def __repr__(self):
        return '<User {}>'.format(self.username)

class Event(db.Model):
    """Event is the table to store Items"""
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=False, nullable=False)
    description = db.Column(db.String(256), unique=False, nullable=True)
    location = db.Column(db.String(64), unique=False, nullable=True)
    gepoints = db.Column(db.String(32), unique=False, nullable=True)

    def __repr__(self):
        return '<Item {}>'.format(self.title)

class EventSchema(ma.ModelSchema):
    """for flask_marshmallow to be able to jsonify Items"""
    class Meta:
        """let model be the Item class"""
        model = Event

class UserSchema(ma.ModelSchema):
    """for flask_marshmallow to be able to jsonify Items"""
    class Meta:
        """let model be the Item class"""
        model = User