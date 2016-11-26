CREATE TABLE PLACES(
	id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    address VARCHAR(50) NOT NULL
    );

CREATE TABLE EVENTS(
    id SERIAL PRIMARY KEY NOT NULL,
    eventName VARCHAR(30) NOT NULL,
    user_id INT NOT NULL,
    rating INT NOT NULL,
    place_id INT REFERENCES PLACES(id),
    date DATE NOT NULL
    );

CREATE TABLE USERS(
    id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL
    );
    	
CREATE TABLE GOINGEVENTS(
	id SERIAL PRIMARY KEY NOT NULL,
	event_id INT REFERENCES EVENTS(id),
	user_id INT REFERENCES USERS(id)
);