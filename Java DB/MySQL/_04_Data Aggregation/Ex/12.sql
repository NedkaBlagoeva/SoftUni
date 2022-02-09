SELECT 
    department_id, 
    MIN(salary)
FROM
    employees
WHERE
    department_id IN (2 , 5, 7)
	AND hire_date > '2000-01-01'
GROUP BY department_id
ORDER BY department_id;