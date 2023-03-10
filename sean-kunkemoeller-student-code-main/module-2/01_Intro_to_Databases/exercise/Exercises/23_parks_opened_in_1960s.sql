-- 23. The name and date established of parks opened in the 1960s (6 rows)
<<<<<<< HEAD
SELECT park_name, date_established
FROM park
WHERE date_established > '1960-01-01' AND date_established < '1970-01-01';
=======

SELECT park_name, date_established
FROM park
WHERE date_established between '1960-01-01' AND '1969-12-31';
;
>>>>>>> ea8e776c4a8e72ec68f1615e29730f3215d59f1d
