CREATE DATABASE  event_management;
Use event_management;
CREATE TABLE events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT
);
select * from events;

CREATE TABLE registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
select * from registrations;
CREATE TABLE IF NOT EXISTS venue (
    id INT AUTO_INCREMENT PRIMARY KEY,
    space_name VARCHAR(255) NOT NULL,
    capacity INT
);
select * from venue;
CREATE TABLE IF NOT EXISTS speakers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    topic VARCHAR(255),
    affiliation VARCHAR(255)
);
select * from speakers;
CREATE TABLE IF NOT EXISTS scheduled_sessions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    session_title VARCHAR(255) NOT NULL,
    speaker_name VARCHAR(255) NOT NULL,
    session_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL
);
INSERT INTO scheduled_sessions VALUES ('1','Introduction to AI', 'John Doe', '2024-05-10', '09:00:00', '10:00:00');
INSERT INTO scheduled_sessions VALUES('2','Data Science Fundamentals', 'Jane Smith', '2024-05-11', '14:00:00', '16:00:00');
INSERT INTO scheduled_sessions VALUES('3','Machine Learning Techniques', 'Alice Johnson', '2024-05-12', '11:00:00', '13:00:00');
select * from scheduled_sessions;
drop table scheduled_sessions;
     