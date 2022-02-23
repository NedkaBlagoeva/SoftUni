SELECT 
    department_id,
    (SELECT DISTINCT
            (salary)
        FROM
            employees AS e
        WHERE
            e.department_id = e2.department_id
        ORDER BY e.salary DESC
        LIMIT 1 OFFSET 2) AS `third_highest_salary`
FROM
    employees AS e2
GROUP BY e2.department_id
HAVING third_highest_salary IS NOT NULL
ORDER BY department_id;