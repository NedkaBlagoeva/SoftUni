SELECT * FROM towns
WHERE
    LEFT(name, 1) REGEXP '[^rbd]+'
ORDER BY 'name';
