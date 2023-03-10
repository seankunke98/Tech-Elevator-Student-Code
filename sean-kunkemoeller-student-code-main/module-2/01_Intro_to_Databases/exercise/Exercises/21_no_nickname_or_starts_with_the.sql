-- 21. The name and nickname for all records in the state table with no official nickname (NULL) or nickname starts with the word "The" (13 rows)
SELECT state_name, state_nickname
FROM state
<<<<<<< HEAD
WHERE state_nickname LIKE 'The%' OR state_nickname IS NULL;
=======
WHERE state_nickname IS NULL OR state_nickname LIKE 'The%';
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
