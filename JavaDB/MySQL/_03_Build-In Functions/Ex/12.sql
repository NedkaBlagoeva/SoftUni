SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS `start`
FROM
    games
WHERE
    YEAR(`start`) = 2011 OR YEAR(`start`) = 2012
ORDER BY `start`, `name`
LIMIT 50;
