CREATE DATABASE IF NOT EXISTS labs;
USE labs;

CREATE TABLE IF NOT EXISTS client_master (
clientNo VARCHAR(6) PRIMARY KEY,
name VARCHAR(20) NOT NULL,
address1 VARCHAR(30) NOT NULL,
address2 VARCHAR(30) NOT NULL, 
city VARCHAR(15) NOT NULL,
pincode INT(8) NOT NULL,
state VARCHAR(15) NOT NULL,
balDue INT(20) NOT NULL
);

DESC client_master;

INSERT INTO client_master VALUES 
('C001', 'client 1 name', 'address line 1', 'address line 2', 'city name', 123456, 'state name', 30000), 
('C002', 'client 2 name', 'address line 3', 'address line 4', 'city name', 123456, 'state name', 50000),
('C003', 'client 3 name', 'address line 5', 'address line 6', 'city name', 123456, 'state name', 65000),
('C004', 'client 4 name', 'address line 7', 'address line 8', 'city name', 123456, 'state name', 20000)
;

SELECT name FROM client_master;
SELECT * FROM client_master;
SELECT name, city, state FROM client_master;

DROP TABLE client_master;
