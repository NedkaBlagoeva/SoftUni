SELECT 
    e.employee_id, e.first_name, e.last_name, d.name
FROM
    employees AS e
        LEFT JOIN
    departments AS d ON e.department_id = d.department_id
    WHERE d.name = 'Sales'
ORDER BY employee_id DESC;