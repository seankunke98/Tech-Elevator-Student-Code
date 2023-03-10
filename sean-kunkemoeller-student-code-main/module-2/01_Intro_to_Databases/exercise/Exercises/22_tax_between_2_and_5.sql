-- 22. The name and sales tax for states and territories with sales tax greater than or equal to 2% and less than or equal to 5% (15 rows)
SELECT state_name, sales_tax
FROM state
<<<<<<< HEAD
WHERE sales_tax >= 2 AND sales_tax <= 5;
=======
WHERE sales_tax BETWEEN 2 AND 5;
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
