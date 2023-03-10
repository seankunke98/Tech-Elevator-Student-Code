-- 3. The name, population, and sales tax of the states in the "West" census region (13 rows)
SELECT state_name, population, sales_tax
FROM state
<<<<<<< HEAD
WHERE census_region LIKE '%West%';
=======
WHERE census_region = 'West';
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
