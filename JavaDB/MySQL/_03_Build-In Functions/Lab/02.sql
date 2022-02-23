SELECT replace(title, 'The', '***') FROM books
WHERE title LIKE 'The%'
ORDER BY id;