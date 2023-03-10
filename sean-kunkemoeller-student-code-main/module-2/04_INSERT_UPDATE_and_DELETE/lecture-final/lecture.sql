-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 
-- 2.1 square kilometers and does not offer camping.)
INSERT INTO park (park_name, date_established, area, has_camping)
    VALUES ('Disneyland', '1955-07-17', 2.1, false);

-- Adding Great Falls National Park returning the ID
INSERT INTO park (park_name, date_established, area, has_camping)
    VALUES ('Great Falls National Park', '1970-04-14', 1, false) 
	RETURNING park_id;

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) 
-- and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
INSERT INTO city (city_name, state_abbreviation, population, area)
    VALUES('Hawkins', 'IN', 30000, 38.1);
INSERT INTO city (city_name, state_abbreviation, population, area)
    VALUES('Cicely', 'AK', 839, 11.4);
INSERT INTO city (city_name, state_abbreviation, population, area)
    VALUES('Hawkins', 'IN', 30000, 38.1), ('Cicely', 'AK', 839, 11.4);

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.

INSERT INTO park_state (park_id, state_abbreviation)
	VALUES((SELECT park_id FROM park WHERE park_name = 'Disneyland'), 'CA');

-- The cheating way would have you look up the value and then manually add it
SELECT park_id
FROM park
WHERE park_name = 'Great Falls National Park';

INSERT INTO park_state (park_id, state_abbreviation)
	VALUES(66, 'NJ');

-- UPDATE

-- Change the state nickname of California to 
-- "The Happiest Place on Earth."
UPDATE state
SET state_nickname = 'The Happiest Place on Earth'
WHERE state_abbreviation = 'CA';

SELECT state_nickname
FROM state
WHERE state_abbreviation = 'CA';


-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population + 1000000
WHERE state_abbreviation = 'CA';

SELECT *
FROM state
WHERE state_abbreviation = 'CA';

-- Change the capital of California to Anaheim.
-- Inefficient but works way
SELECT *
FROM city
WHERE city_name = 'Anaheim';

UPDATE state
SET capital = 9
WHERE state_abbreviation = 'CA';

-- Fancy pants way
UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';

SELECT *
FROM state
WHERE state_abbreviation = 'CA';


-- Change California's nickname back to "The Golden State", reduce the population by 
-- 1,000,000, and change the capital back to Sacramento.
UPDATE state
SET state_nickname = 'The Golden State',
    population = population - 1000000,
    capital = (SELECT city_id FROM city WHERE city_name = 'Sacramento')
WHERE state_abbreviation = 'CA';


-- DELETE

-- Delete Hawkins, IN from the city table.
DELETE
FROM city
WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';

SELECT *
FROM city
WHERE state_abbreviation = 'IN';

-- Delete all cities with a population of less than 1,000 people from the city table.
SELECT *
FROM city
WHERE population < 1000;

DELETE 
FROM city
WHERE population < 1000;


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
INSERT INTO city (city_name, state_abbreviation, population, area)
    VALUES('I dont know city', 'XX', 10000, 3.1415)
-- Result: 
-- ERROR:  insert or update on table "city" violates foreign key constraint "fk_city_state"
-- DETAIL:  Key (state_abbreviation)=(XX) is not present in table "state".


-- Try deleting California from the state table.
DELETE
FROM state
WHERE state_abbreviation = 'CA';
--Result:
--ERROR:  update or delete on table "state" violates foreign key constraint "fk_city_state" on table "city"
--DETAIL:  Key (state_abbreviation)=(CA) is still referenced from table "city".

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
DELETE 
FROM park
WHERE park_name = 'Disneyland';

-- Result
-- ERROR:  update or delete on table "park" violates foreign key constraint "fk_park_state_park" on table "park_state"
-- DETAIL:  Key (park_id)=(64) is still referenced from table "park_state".
DELETE
FROM park_state
WHERE park_id = (SELECT park_id FROM park WHERE park_name='Disneyland');

DELETE 
FROM park
WHERE park_name = 'Disneyland';

-- Result: Great success

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its
-- population or area.
INSERT INTO city (city_name, state_abbreviation)
    VALUES('Smallville', 'KS');
--Result
--ERROR:  null value in column "area" violates not-null constraint
--DETAIL:  Failing row contains (349, Smallville, KS, 0, null).
-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a 
-- population.
INSERT INTO city (city_name, state_abbreviation, area)
    VALUES('Smallville', 'KS', 8);

-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SELECT *
FROM city
WHERE state_abbreviation = 'KS';


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" 
-- (which is already the nickname of Maine).
UPDATE state
SET state_nickname = 'Vacationland'
WHERE state_abbreviation = 'CA';

-- Result:
-- ERROR:  duplicate key value violates unique constraint "uq_state_nickname"
-- DETAIL:  Key (state_nickname)=(Vacationland) already exists.

-- We can verify by doing this:
SELECT *
FROM state
WHERE state_nickname = 'Vacationland';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" 
-- (which is not a valid census region).
UPDATE state
SET census_region = 'Southeast'
WHERE state_abbreviation = 'FL';

--Result:
--ERROR:  new row for relation "state" violates check constraint "chk_census_region"
--DETAIL:  Failing row contains (FL, Florida, 21477737, 170312, 308, 6.000, Sunshine State, Southeast).

--We can however, do this:
UPDATE state
SET census_region = 'Southeast'
WHERE state_abbreviation = null;

--Because the constraint is:
--	CHECK (census_region IS NULL OR census_region IN ('Northeast', 'South', 'Midwest', 'West'))
--  (I found the constraint in the resources folder in the UnitedStates creation)

-- TRANSACTIONS

-- Delete the record for Smallville, KS 
-- (within a transaction).
BEGIN TRANSACTION;
DELETE
FROM city
WHERE state_abbreviation = 'KS' AND city_name = 'Smallville';
COMMIT;  -- or ROLLBACK to undo

SELECT *
FROM city
WHERE city_name = 'Smallville' AND state_abbrevation = 'KS';

-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
BEGIN TRANSACTION;

DELETE
FROM park_state;

ROLLBACK;

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.


-- Demonstrate two different SQL connections trying to access the same table where one is 
-- inside of a transaction but hasn't committed yet.
BEGIN TRANSACTION;

UPDATE city
SET city_name = 'Trenton 2'
WHERE city_name = 'Trenton'

SELECT *
FROM city
WHERE city_name = 'Trenton';

COMMIT;