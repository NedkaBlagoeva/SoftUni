CREATE TABLE manufacturers(
manufacturer_id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) ,
established_on DATE
);

INSERT INTO manufacturers (`name`, established_on)
VALUES ('BMW', 19160301),
('Tesla', 20030101),
('Lada', 19660501);

CREATE TABLE models (
model_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
manufacturer_id INT)
AUTO_INCREMENT = 101;

ALTER TABLE models ADD
CONSTRAINT `fk_models_manufactures`
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id)
;

INSERT INTO models (name, manufacturer_id)
VALUES ('X1', 1),
('i6', 1),
('Model S', 2),
('Model X', 2),
('Model 3', 2),
('Nova', 3);

