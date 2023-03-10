-- 6. The name, abbreviation, population, and area of states with an area greater than 200,000 square kilometers (16 rows)
<<<<<<< HEAD
SELECT state_name, state_abbreviation, area, population
=======

SELECT state_name, state_abbreviation, population, area
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
FROM state
WHERE area > 200000;
