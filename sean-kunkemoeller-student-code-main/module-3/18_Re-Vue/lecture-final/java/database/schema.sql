BEGIN TRANSACTION;


DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS users;


DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_account_id;



CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_account_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE accounts (
	account_id int DEFAULT nextval('seq_account_id'::regclass) NOT NULL,
	user_id int NOT NULL,
	balance decimal(13, 2) NOT NULL,
	CONSTRAINT PK_accounts PRIMARY KEY (account_id),
	CONSTRAINT FK_accounts_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);


COMMIT TRANSACTION;
