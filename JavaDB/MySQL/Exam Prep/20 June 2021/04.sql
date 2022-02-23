DELETE FROM clients
WHERE length(full_name) > 3 AND id NOT IN (SELECT client_id FROM courses);