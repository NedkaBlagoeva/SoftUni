SELECT c.id, c.make, c.mileage, count(co.id) AS count, round(avg(bill), 2) AS avg_bill
FROM cars AS c
LEFT JOIN courses AS co ON c.id = co.car_id
GROUP BY c.id
HAVING count != 2
ORDER BY count DESC, c.id;