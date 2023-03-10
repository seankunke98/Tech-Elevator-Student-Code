-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ) (22 rows)
SELECT city_name, state_abbreviation, population
FROM city
<<<<<<< HEAD
WHERE state_abbreviation LIKE '%CO%' OR state_abbreviation LIKE '%AZ%';
=======
WHERE state_abbreviation IN ('CO', 'AZ');
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
