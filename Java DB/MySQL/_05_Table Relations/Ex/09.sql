SELECT 
    mountain_range, peak_name, elevation
FROM
    mountains AS m
        JOIN
    peaks AS p ON m.id = p.mountain_id
    WHERE mountain_range = 'Rila'
    ORDER BY elevation DESC;