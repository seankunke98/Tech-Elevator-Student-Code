-- 16. The name, date established, and area of parks that contain the string "Canyon" anywhere in the name (5 rows)
<<<<<<< HEAD
=======

>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
SELECT park_name, date_established, area
FROM park
WHERE park_name LIKE '%Canyon%';
