SELECT 
    COUNT(*) AS country_count
FROM
    countries AS c
        LEFT JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
WHERE
    mountain_id IS NULL
GROUP BY mountain_id;