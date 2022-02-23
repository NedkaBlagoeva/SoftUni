SELECT 
    user_name,
    SUBSTR(email, LOCATE('@', email) + 1) AS `email provider`
FROM
    users
ORDER BY `email provider` , user_name;