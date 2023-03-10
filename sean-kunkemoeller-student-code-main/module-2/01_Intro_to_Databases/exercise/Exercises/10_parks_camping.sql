-- 10. The name and area of parks that have an area less than or equal to 700 square kilometers and provides camping (21 rows)
<<<<<<< HEAD
SELECT park_name, area
FROM park
WHERE area <= 700 AND has_camping;
=======

SELECT park_name, area
FROM park
WHERE area <= 700 AND has_camping = true;
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
