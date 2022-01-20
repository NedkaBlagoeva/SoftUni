UPDATE employees 
SET salary = 1.12 * salary
WHERE department_id IN (1, 2, 4, 11);

SELECT salary FROM employees;