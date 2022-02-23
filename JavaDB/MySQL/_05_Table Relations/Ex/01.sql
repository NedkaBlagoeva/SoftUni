CREATE TABLE `people` (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2 ),
    passport_id INT UNIQUE
);

INSERT INTO `people` (first_name, salary, passport_id)
VALUES ('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);

CREATE TABLE `passports` (
    passport_id INT AUTO_INCREMENT PRIMARY KEY,
    passport_number VARCHAR(20) UNIQUE
)  AUTO_INCREMENT = 101;

INSERT INTO passports (passport_number)
VALUES ('N34FG21B'),
('K65LO4R7'),
('ZE657QP2');

ALTER TABLE people ADD
CONSTRAINT `fk_ people_passports`
FOREIGN KEY (passport_id)
REFERENCES passports(passport_id);
