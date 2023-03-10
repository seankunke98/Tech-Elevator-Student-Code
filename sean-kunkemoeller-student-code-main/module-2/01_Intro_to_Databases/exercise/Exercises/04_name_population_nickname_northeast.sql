-- 4. The name, population, and nickname of the states in the "Northeast" census region (9 rows)
SELECT state_name, population, state_nickname
FROM state
<<<<<<< HEAD
WHERE census_region LIKE '%Northeast%';
=======
WHERE census_region = 'Northeast';
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
