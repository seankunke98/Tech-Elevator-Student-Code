-- 20. The name, population, area, and population density (name the column 'population_density') of states, territories, and districts with more than 100 people per square kilometer (12 rows)
-- Population density is expressed as people per square kilometer. In other words, population divided by area.
<<<<<<< HEAD
SELECT state_name, population, area, population / area AS population_density
FROM state
WHERE population / area > 100;
=======
SELECT state_name, population, area, population/area as population_density
FROM state
WHERE population/area > 100;
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
