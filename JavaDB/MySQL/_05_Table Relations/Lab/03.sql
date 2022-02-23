SELECT r.starting_point, r.end_point, r.leader_id, CONCAT_WS(' ', c.first_name, c.last_name)
FROM routes as r
JOIN campers as c ON r.leader_id = c.id;