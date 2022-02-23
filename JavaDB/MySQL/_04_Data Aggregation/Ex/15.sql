SELECT 
    COUNT(*)
FROM
    employees
GROUP BY manager_id
HAVING manager_id IS NULL
;