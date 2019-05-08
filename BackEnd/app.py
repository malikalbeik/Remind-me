import os
import uuid
from datetime import datetime
from werkzeug.security import check_password_hash, generate_password_hash
from flask import Flask, redirect, flash, render_template, request, session, url_for, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_marshmallow import Marshmallow
from flask_migrate import Migrate
from config import Config

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

@app.route("/event", method["GET", "POST"])
def event():
    """event"""
    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":
        # get name, location, date, description and gepoints from form.
        name = request.args.get("name")
        location = request.args.get("location")
        date = request.args.get("date")
        description = request.args.get("description")
        gepoints = request.args.get("gepoints")

    return True

@app.route("/events", method["GET", "POST"])
def events():
    """events"""
    # User reached route via POST (as by submitting a form via POST)
    if request.method =="POST":
        # get event from form.
