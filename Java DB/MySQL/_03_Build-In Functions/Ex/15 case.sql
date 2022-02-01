SELECT 
    name,
    (CASE
        WHEN HOUR(start) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(start) BETWEEN 12 AND 17 THEN 'Afternoon'
        WHEN HOUR(start) BETWEEN 18 AND 24 THEN 'Evening'
    END) AS `Part of the Day`,
    (CASE
        WHEN duration BETWEEN 0 AND 3 THEN 'Extra Short'
        WHEN duration BETWEEN 4 AND 6 THEN 'Short'
        WHEN duration BETWEEN 6 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END) AS `Duration`
FROM
    games;