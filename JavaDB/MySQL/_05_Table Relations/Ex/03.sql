CREATE TABLE students(
student_id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50));

INSERT INTO students(name)
VALUES ('Mila'),
('Toni'),
('Ron');

CREATE TABLE exams(
exam_id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50))
AUTO_INCREMENT = 101;

INSERT INTO exams(name)
VALUES ('Spring MVC'),
('Neo4j'),
('Oracle 11g');

CREATE TABLE students_exams (
student_id INT,
exam_id INT,
CONSTRAINT `pk_students_exams`
PRIMARY KEY (student_id, exam_id),
CONSTRAINT `fk_students_exam_students`
FOREIGN KEY (student_id)
REFERENCES students(student_id),
CONSTRAINT `fk_students_exam_exams`
FOREIGN KEY (exam_id)
REFERENCES exams(exam_id)
);

INSERT INTO students_exams
VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);