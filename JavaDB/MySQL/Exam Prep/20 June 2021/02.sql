INSERT INTO clients (full_name , phone_number)
SELECT concat(first_name, ' ', last_name), concat('(088) 9999', id * 2)
FROM drivers AS d
WHERE d.id BETWEEN 10 AND 20;