CREATE DATABASE IF NOT EXISTS labs;
USE labs;

CREATE TABLE IF NOT EXISTS customer (
customer_id INT(6) PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL
);


CREATE TABLE IF NOT EXISTS orders (
order_id INT(6) PRIMARY KEY AUTO_INCREMENT,
customer_id INT(6),
order_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
total_amount INT(6) NOT NULL,
FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

INSERT INTO customer VALUES 
(DEFAULT, 'fname1', 'lname1'),
(DEFAULT, 'fname2', 'lname2'),
(DEFAULT, 'fname3', 'lname3'),
(DEFAULT, 'fname4', 'lname4'),
(DEFAULT, 'fname5', 'lname5');

INSERT INTO orders VALUES
(DEFAULT, 1, DEFAULT, 3000),
(DEFAULT, 2, DEFAULT, 4000),
(DEFAULT, 3, DEFAULT, 5000),
(DEFAULT, 1, DEFAULT, 3500),
(DEFAULT, 4, DEFAULT, 6000),
(DEFAULT, 4, DEFAULT, 8000);

SELECT customer.first_name, customer.last_name, orders.order_date, orders.total_amount FROM customer INNER JOIN orders ON customer.customer_id = orders.customer_id;

DROP TABLE IF EXISTS customer, orders;