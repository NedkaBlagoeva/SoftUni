SELECT department_id, count(*) AS `Number of employees` From employees
GROUP BY department_id
ORDER BY department_id;