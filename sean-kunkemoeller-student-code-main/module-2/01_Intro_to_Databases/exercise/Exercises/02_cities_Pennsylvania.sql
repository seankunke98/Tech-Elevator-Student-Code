-- 2. The name and area of all cities in Pennsylvania (PA) (4 rows)
<<<<<<< HEAD
SELECT city_name, area
FROM city
WHERE state_abbreviation LIKE '%PA%';
=======

SELECT city_name, area
FROM city
WHERE state_abbreviation = 'PA';

>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
