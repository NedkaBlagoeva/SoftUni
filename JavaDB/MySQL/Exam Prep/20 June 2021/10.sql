DELIMITER %%
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(*) FROM courses AS co
        JOIN clients AS cl ON co.client_id = cl.id
WHERE
    phone_number = phone_num
GROUP BY client_id);
END
%%