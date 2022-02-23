CREATE TABLE `mountains` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`mountain_id` INT,
 CONSTRAINT `fk_peaks_mountains`
 FOREIGN KEY (mountain_id)
 REFERENCES mountains(id)
);