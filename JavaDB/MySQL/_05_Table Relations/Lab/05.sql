CREATE DATABASE db;
USE db;

CREATE TABLE clients (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(100)
);

CREATE TABLE employees (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    project_id INT(11)
    );
    
    CREATE TABLE projects (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    client_id INT(11),
    project_lead_id INT(11),
    CONSTRAINT `fk_projects_clients`
    FOREIGN KEY (client_id)
    REFERENCES clients(id),
    CONSTRAINT `fk_projects_employees`
    FOREIGN KEY (project_lead_id)
    REFERENCES employees(id)
);

ALTER TABLE `employees` ADD
CONSTRAINT `fk_ employees_projects`
FOREIGN KEY (project_id)
REFERENCES projects(id);