SELECT c.name, count(*) AS games_count, round(avg(g.budget), 2) AS avg_budget, max(g.rating) AS max_rating
FROM categories AS c
LEFT JOIN games_categories AS gc ON c.id = gc.category_id
LEFT JOIN games AS g ON gc.game_id = g.id
GROUP BY name
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.name;
