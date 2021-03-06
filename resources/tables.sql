CREATE TABLE EVENTS(
    id INT PRIMARY KEY NOT NULL,
    eventName VARCHAR(30) NOT NULL,
    user_id INT NOT NULL,
    rating INT NOT NULL,
    place_id INT REFERENCES PLACES(id),
    date DATE NOT NULL
    )

CREATE TABLE USERS(
    id INT PRIMARY KEY NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    going_events LIST NOT NULL
    );
    
CREATE TABLE PLACES(
	id INT PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    address VARCHAR(50) NOT NULL
    );