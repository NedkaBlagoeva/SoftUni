SELECT e.employee_id, e.first_name,	e.salary, d.name
FROM employees AS e
LEFT JOIN departments AS d ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY e.department_id DESC
LIMIT 5;