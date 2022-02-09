CREATE TABLE `high_paid_empl` AS 
SELECT * FROM employees
WHERE salary > 30000;

DELETE FROM high_paid_empl 
WHERE manager_id = 42;

UPDATE high_paid_empl 
SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id, AVG(salary) AS `avg_salary`
FROM high_paid_empl
GROUP BY department_id
ORDER BY department_id;