SELECT e.employee_id, e.first_name, IF(YEAR(p.start_date) >= 2005, NULL, p.name)
FROM employees_projects AS ep
LEFT JOIN employees AS e ON e.employee_id = ep.employee_id
LEFT JOIN projects AS p ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY p.name;