-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
<<<<<<< HEAD
WHERE city_name = 'Columbus'

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, state_name
FROM city
JOIN state ON c.state_abbreviation = s.state_abbreviation
WHERE city_name = 'Columbus'

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT state_abbreviation, park_name
FROM park_state
JOIN park ON park_state.park_id = park.park_id

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT state_name, park_name
FROM park_state
JOIN park ON park_state.park_id = park.park_id
	JOIN state ON park_state.state_abbreviation = state.state_abbreviation
-- Modify the previous query to include the name of the state's capital city.
SELECT state_name, park_name, capital
FROM park_state
JOIN park ON park_state.park_id = park.park_id
	JOIN state ON park_state.state_abbreviation = state.state_abbreviation

-- Modify the previous query to include the area of each park.
SELECT state_name, park_name, city_name, park.area
FROM park_state
JOIN park ON park_state.park_id = park.park_id
	JOIN state ON park_state.state_abbreviation = state.state_abbreviation
		JOIN city ON state.capital = city.city_id
=======
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, state_name
FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE city_name = 'Columbus';

-- Same query using aliasing for the table names
SELECT city_name, state_name
FROM city c JOIN state s ON c.state_abbreviation = s.state_abbreviation
WHERE city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation
FROM park JOIN park_state ON park.park_id = park_state.park_id;


-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name
FROM park JOIN park_state ON park.park_id = park_state.park_id 
	JOIN state ON park_state.state_abbreviation = state.state_abbreviation;


-- Modify the previous query to include the name of the state's capital city.

SELECT park_name, state_name, city_name
FROM park JOIN park_state ON park.park_id = park_state.park_id 
	JOIN state ON park_state.state_abbreviation = state.state_abbreviation
	JOIN city ON state.capital = city.city_id;


-- Modify the previous query to include the area of each park.
-- Notice park.area - the fully qualified name - rather than just area
-- Because there are 3 areas available (city, state, park)
SELECT park_name, state_name, state.state_abbreviation, city_name, park.area
FROM park JOIN park_state ON park.park_id = park_state.park_id 
	JOIN state ON park_state.state_abbreviation = state.state_abbreviation
	JOIN city ON state.capital = city.city_id;
>>>>>>> e2841ed3813fe2db0f269bb5d6c7905286c8f10d


-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, city.population
<<<<<<< HEAD
FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation AND state.census_region = 'Midwest'

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT COUNT(city_id)
FROM city
JOIN state ON state.state_abbreviation = city.state_abbreviation AND state.census_region = 'Midwest'
GROUP BY state.state_name

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT COUNT(city_id) as cities_per_state, state.state_name
FROM city
JOIN state ON state.state_abbreviation = city.state_abbreviation AND state.census_region = 'West'
GROUP BY state.state_name
ORDER BY cities_per_state DESC

=======
FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest';


-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT COUNT(*) AS num_cities, state.state_abbreviation
FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state.state_abbreviation;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT COUNT(*) AS num_cities, state.state_abbreviation
FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state.state_abbreviation
ORDER BY num_cities DESC;
>>>>>>> e2841ed3813fe2db0f269bb5d6c7905286c8f10d

-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT state_name, MIN(date_established)
<<<<<<< HEAD
FROM state
JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
    JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, MIN(date_established)
FROM state
LEFT OUTER JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
	LEFT JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name
=======
FROM state JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation 
	JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name
ORDER BY state_name;


-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, MIN(date_established)
FROM state LEFT JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation 
	LEFT JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name
ORDER BY state_name;

SELECT state_name, MIN(date_established)
FROM park JOIN park_state ON park_state.park_id = park.park_id
	RIGHT JOIN state ON park_state.state_abbreviation = state.state_abbreviation
GROUP BY state_name
ORDER BY state_name;
>>>>>>> e2841ed3813fe2db0f269bb5d6c7905286c8f10d


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
<<<<<<< HEAD
SELECT city_name
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name
FROM state
WHERE state_name LIKE 'W%'
ORDER BY city_name ASC
=======

-- Data types must be the same
-- with a UNION try to break it into two discrete/distinct queries

SELECT city_name
FROM city
WHERE city_name LIKE 'W%'

UNION

SELECT state_name
FROM state
WHERE state_name LIKE 'W%';
>>>>>>> e2841ed3813fe2db0f269bb5d6c7905286c8f10d

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name, 'City' AS type_of_location
FROM city
WHERE city_name LIKE 'W%'
<<<<<<< HEAD
UNION
SELECT state_name, 'State' AS type_of_location
FROM state
WHERE state_name LIKE 'W%'
=======

UNION

SELECT state_name, 'State' AS type_of_location
FROM state
WHERE state_name LIKE 'W%';
>>>>>>> e2841ed3813fe2db0f269bb5d6c7905286c8f10d


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name
<<<<<<< HEAD
FROM genre

-- The titles of all the Comedy movies
SELECT title
FROM movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
    JOIN genre ON movie_genre.genre_id = genre.genre_id
       WHERE genre_name LIKE 'Comedy'
=======
FROM genre;

-- The titles of all the Comedy movies
SELECT title, genre_name
FROM movie JOIN movie_genre ON movie.movie_id = movie_genre.movie_id JOIN genre ON movie_genre.genre_id = genre.genre_id 
WHERE genre_name = 'Comedy';

>>>>>>> e2841ed3813fe2db0f269bb5d6c7905286c8f10d
