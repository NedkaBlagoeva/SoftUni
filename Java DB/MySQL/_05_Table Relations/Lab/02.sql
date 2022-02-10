SELECT 
    v.driver_id, v.vehicle_type, CONCAT(c.first_name, ' ', c.last_name) AS driver_name
FROM
    campers AS c, vehicles AS v
WHERE
    v.driver_id = c.id;
-- -----------------------------
SELECT 
    v.driver_id, v.vehicle_type, CONCAT(c.first_name, ' ', c.last_name) AS driver_name
FROM
    campers AS c
        JOIN
    vehicles AS v ON v.driver_id = c.id;