SELECT e.employee_id, 
concat(e.first_name, ' ', e.last_name) AS employee_name, 
concat(m.first_name, ' ', m.last_name) AS manager_name, 
d.`name` AS department_name
FROM employees AS e
JOIN employees AS m ON e.manager_id = m.employee_id
JOIN departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;