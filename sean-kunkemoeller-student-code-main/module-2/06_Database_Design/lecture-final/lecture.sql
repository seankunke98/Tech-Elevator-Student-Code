DROP TABLE IF EXISTS Artist CASCADE;
DROP TABLE IF EXISTS Artist_Painting;
DROP TABLE IF EXISTS Purchase;
DROP TABLE IF EXISTS Painting;
DROP TABLE IF EXISTS Customer;


CREATE TABLE Artist(
	artist_id SERIAL PRIMARY KEY,
	artist_name varchar(50)
    
);

CREATE TABLE Customer(
	customer_id SERIAL PRIMARY KEY,
    customer_name varchar(30) NOT NULL,
    customer_street_name varchar(50),
	customer_street_2 varchar(50),
	customer_city varchar(30),
	customer_state varchar(30),
	customer_zip varchar(10),
    customer_phone_number varchar(15)
);

CREATE TABLE Painting(
	painting_id SERIAL PRIMARY KEY,
    painting_name varchar(50) NOT NULL,
    artist_id int NOT NULL, --FK ref Artist Table
    listing_price numeric(19,2),
	CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE Purchase(
    purchase_id SERIAL PRIMARY KEY,
    customer_id int, --FK ref Customer Table
    purchase_date date,
    sales_price numeric (19,2),
    painting_id int NOT NULL, --FK ref Painting Table
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	CONSTRAINT fk_painting_id FOREIGN KEY (painting_id) REFERENCES painting(painting_id)
);
	
	
INSERT INTO customer ( customer_name, customer_street_name,
	customer_city,
	customer_state,
	customer_zip,
    customer_phone_number)
VALUES ('Elizabeth Jackson','123 4th Avenue','Fonthill', 'Ontario', 'L3J4S4', '(206)284-6783');


INSERT INTO artist(artist_name)
VALUES ('Carol Channing');
INSERT INTO artist(artist_name)
VALUES ('Dennis Frings');



INSERT INTO painting(
	painting_name,
    artist_id,
    listing_price
)
VALUES ('Laugh with Teeth',(SELECT artist_id FROM artist WHERE artist_name = 'Carol Channing'),7000.00);
INSERT INTO painting(
	painting_name,
    artist_id,
    listing_price
)
VALUES ('At the Movies',(SELECT artist_id FROM artist WHERE artist_name = 'Carol Channing'),5550.00);
INSERT INTO painting(
	painting_name,
    artist_id,
    listing_price
)
VALUES ('South toward Emerald Sea',(SELECT artist_id FROM artist WHERE artist_name = 'Dennis Frings'),1800.00);
INSERT INTO painting(
	painting_name,
    artist_id,
    listing_price
)
VALUES ('North toward Diamond Ocean',(SELECT artist_id FROM artist WHERE artist_name = 'Dennis Frings'),2200.00);

INSERT INTO purchase(
	customer_id,
    purchase_date,
    sales_price,
    painting_id
)
VALUES((SELECT customer_id FROM customer WHERE customer_name = 'Elizabeth Jackson'),'2022-08-08',7000.00,(SELECT painting_id FROM painting WHERE painting_name = 'Laugh with Teeth'));

SELECT * FROM purchase
JOIN customer ON customer.customer_id = purchase.customer_id
JOIN painting ON purchase.painting_id = painting.painting_id
JOIN artist ON painting.artist_id = artist.artist_id;

