SELECT first_name, last_name, department_id
FROM employees AS e
WHERE e.salary > 
    (SELECT AVG(e2.salary)
        FROM employees AS e2
        WHERE e.department_id = e2.department_id)
ORDER BY e.department_id , e.employee_id
LIMIT 10;