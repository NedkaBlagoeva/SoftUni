SELECT t.town_id, t.name, a.address_text
FROM addresses AS a
LEFT JOIN towns AS t ON a.town_id = t.town_id
WHERE t.name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY town_id, address_id;