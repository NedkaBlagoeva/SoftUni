SELECT cl.full_name, count(co.car_id) AS count_of_cars, sum(co.bill) AS total_sum
FROM clients AS cl
LEFT JOIN courses AS co ON cl.id = co.client_id
GROUP BY cl.full_name
HAVING cl.full_name LIKE '_a%' And count_of_cars > 1
ORDER BY cl.full_name;