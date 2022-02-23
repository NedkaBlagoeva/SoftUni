SELECT count(*) AS items_count , c.name, sum(quantity_in_stock) AS total_quantity
FROM categories AS c
LEFT JOIN products AS p ON c.id = p.category_id
GROUP BY c.name
ORDER BY items_count DESC, total_quantity
LIMIT 5;