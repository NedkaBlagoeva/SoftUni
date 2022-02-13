SELECT g.name, g.release_date, concat(substring(g.description, 1, 10), '...') AS summary, 
CASE 
WHEN month(g.release_date) IN (01, 02, 03) THEN 'Q1'
WHEN month(g.release_date) IN (04, 05, 06) THEN 'Q2'
WHEN month(g.release_date) IN (07, 08, 09) THEN 'Q3'
ELSE 'Q4'
END AS quarter, t.name 
FROM games AS g
JOIN teams AS t ON g.team_id = t.id
WHERE month(release_date) % 2 = 0 AND right(g.name, 1) = '2' AND year(g.release_date) = 2022
ORDER BY quarter;