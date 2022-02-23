SELECT t.name, a.name, length(a.name) AS count_of_characters
FROM teams AS t
JOIN offices AS o ON t.office_id = o.id
JOIN addresses AS a ON o.address_id = a.id
WHERE o.website IS NOT NULL
ORDER BY t.name, a.name;