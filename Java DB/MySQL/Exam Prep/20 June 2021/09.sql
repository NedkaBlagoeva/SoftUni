SELECT a.`name`, CASE
WHEN hour(co.start) BETWEEN 6 AND 20 THEN 'Day'
ELSE 'Night'
END AS day_time, 
co.bill, cl.full_name, ca.make, ca.model, cat.name
FROM courses AS co
LEFT JOIN addresses AS a ON co.from_address_id = a.id
LEFT JOIN clients AS cl ON cl.id = co.client_id
LEFT JOIN cars AS ca ON co.car_id = ca.id
LEFT JOIN categories AS cat ON cat.id = ca.category_id
ORDER BY co.id;