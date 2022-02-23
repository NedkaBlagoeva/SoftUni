CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT, 
`name` VARCHAR (100) NOT NULL);

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT, 
`name` VARCHAR (10) NOT NULL);

CREATE TABLE clients (
id INT PRIMARY KEY AUTO_INCREMENT, 
full_name VARCHAR (50) NOT NULL,
phone_number VARCHAR (20) NOT NULL);

CREATE TABLE drivers (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR (30) NOT NULL,
last_name VARCHAR (30) NOT NULL,
age INT NOT NULL,
rating FLOAT DEFAULT(5.5)
);

CREATE TABLE cars(
id INT AUTO_INCREMENT PRIMARY KEY,
make VARCHAR (20) NOT NULL,
model VARCHAR (20),
`year` INT DEFAULT(0) NOT NULL,
mileage INT DEFAULT(0),
`condition` CHAR NOT NULL,
category_id INT NOT NULL,
CONSTRAINT `fk_cars_categories`
FOREIGN KEY (category_id)
REFERENCES categories(id)
);

CREATE TABLE cars_drivers(
car_id INT NOT NULL,
driver_id INT NOT NULL,
CONSTRAINT `fk_cars_drivers_cars`
FOREIGN KEY (car_id)
REFERENCES cars(id),
CONSTRAINT `fk_cars-drivers_drivers`
FOREIGN KEY (driver_id)
REFERENCES drivers(id),
CONSTRAINT `pk_cars_drivers`
PRIMARY KEY (car_id, driver_id)
);

CREATE TABLE courses(
id INT AUTO_INCREMENT PRIMARY KEY,
from_address_id INT NOT NULL,
`start` DATETIME NOT NULL,
bill DECIMAL(10,2) DEFAULT(10),
car_id INT NOT NULL,
client_id INT NOT NULL,
CONSTRAINT `fk_courses_addresses`
FOREIGN KEY (from_address_id)
REFERENCES addresses(id),
CONSTRAINT `fk_courses_cars`
FOREIGN KEY (car_id)
REFERENCES cars(id),
CONSTRAINT `fk_courses_clients`
FOREIGN KEY (client_id)
REFERENCES clients(id)
);