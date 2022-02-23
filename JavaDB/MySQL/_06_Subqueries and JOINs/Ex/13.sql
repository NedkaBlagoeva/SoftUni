SELECT c.country_code, COUNT(m.mountain_range) AS mountain_range
FROM countries AS c 
JOIN mountains_countries AS mc ON mc.country_code = c.country_code
JOIN mountains AS m ON m.id = mc.mountain_id
WHERE c.country_name IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_code
ORDER BY mountain_range DESC;