-- 8. The name and population of cities in California (CA) with a population less than 150,000 people (37 rows)
SELECT city_name, population
FROM city
<<<<<<< HEAD
WHERE state_abbreviation LIKE '%CA' AND population < 150000;
=======
WHERE population < 150000 AND state_abbreviation = 'CA';
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
