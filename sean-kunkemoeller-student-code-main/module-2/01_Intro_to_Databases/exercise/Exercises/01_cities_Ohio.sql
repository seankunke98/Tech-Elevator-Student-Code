-- 1. The name and population of all cities in Ohio (OH) (6 rows)
SELECT city_name, population
FROM city
<<<<<<< HEAD
WHERE state_abbreviation LIKE '%OH%';
=======
WHERE state_abbreviation = 'OH';
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
