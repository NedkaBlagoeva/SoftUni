DELETE FROM games 
WHERE
    release_date IS NULL
    AND id NOT IN (SELECT game_id FROM games_categories);