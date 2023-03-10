-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
INSERT INTO park (park_name, date_established, area)
VALUES ('Disneyland', '07/17/1955', '2.1', 'false')

INSERT INTO park (park_name, date_established, area, has_camping)
VALUES ('Great Falls National Park', '1970-04-14', 1, false)
RETURNING park_id;

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
INSERT INTO city (city_name, state_abbreviation, population, area)
VALUES ('Hawkins', 'IN', '30000', '38.1'), ('Cicely', 'AK', '839', '11.4')

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
INSERT INTO park_state (park_id, state_abbreviation)
VALUES ('65', 'CA')


-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
UPDATE state SET state_nickname = 'The Happiest Place on Earth'
WHERE state_name = 'California'

-- Increase the population of California by 1,000,000.
UPDATE state SET population + 1000000
WHERE state_abbreviation = 'CA'

-- Change the capital of California to Anaheim.
UPDATE state SET capital = '9'
WHERE state_abbreviation = 'CA'


-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
UPDATE state SET state_nickname = 'The Golden State', population = population - 1000000, capital = '264'
WHERE state_abbreviation = 'CA'


-- DELETE

-- Delete Hawkins, IN from the city table.
DELETE FROM city
WHERE city_name = 'Hawkins'

-- Delete all cities with a population of less than 1,000 people from the city table.
DELETE FROM city
WHERE population < 1000


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
INSERT INTO city (city_name, state_abbreviation, population, area)
VALUES ('Hawkins', 'XX', '100000', '34.2')
FOREIGN KEY CONSTRAINT


-- Try deleting California from the state table.
DELETE FROM state
WHERE state_abbreviation = 'CA'
FOREIGN KEY CONSTRAINT


-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
DELETE FROM park
WHERE park_name = 'Disneyland'

MUST DELETE KEY FIRST


-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
INSERT INTO city (city_name, state_abbreviation)
VALUES ('Smallville', 'KS')
NOT NULL CONSTRAINT

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (city_name, state_abbreviation, area)
VALUES ('Smallville', 'KS', '98.2')
DEFAULT POPULATION OF 0 ADDED

-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SET DEFAULT VALUE CORRECTLY

-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
UPDATE state SET state_nickname = 'Vacationland'
WHERE state_abbreviation = 'CA'
UNIQUE VALUE CONSTRAINT

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
UPDATE state SET census_region = 'Southeast'
WHERE state_abbreviation = 'FL'
CHECK DOES NOT ALLOW INVALID ENTRIES


-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
BEGIN TRANSACTION;
DELETE FROM city WHERE city_name = 'Smallville';
COMMIT

-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
BEGIN TRANSACTION;
DELETE FROM park_state;
ROLLBACK

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
BEGIN TRANSACTION;
UPDATE city SET state_abbreviation = 'TX';
ROLLBACK

-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
BEGIN TRANSACTION;
UPDATE city SET city_name = 'Trenton 2'
WHERE city_name = 'Trenton'

SELECT *
FROM city
WHERE city_name = 'Trenton 2'