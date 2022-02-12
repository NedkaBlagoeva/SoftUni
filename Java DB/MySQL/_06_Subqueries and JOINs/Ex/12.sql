SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM countries AS c
JOIN mountains_countries AS mc ON c.country_code = mc.country_code
JOIN mountains AS m ON mc.mountain_id = m.id
JOIN peaks AS p ON p.mountain_id = mc.mountain_id
WHERE c.country_name = 'Bulgaria' AND p.elevation > 2835
ORDER BY p.elevation DESC;