CREATE TABLE member (
member_id SERIAL PRIMARY KEY,
member_last_name varchar,
member_first_name varchar,
member_email varchar UNIQUE,
member_phone_number varchar UNIQUE,
member_date_of_birth date,
wantsReminderEmails boolean
);

CREATE TABLE interest_group (
group_id SERIAL PRIMARY KEY,
group_name varchar(100),
member_count int DEFAULT 0
);

CREATE TABLE group_member (
group_id int, 
member_id int,
CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES interest_group(group_id),
CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member(member_id)
);

CREATE TABLE event (
event_number SERIAL PRIMARY KEY,
event_name varchar(100),
event_description varchar,
start_date varchar UNIQUE,
start_time varchar,
event_duration int,
group_id int,
member_count int DEFAULT 0,
CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES interest_group(group_id),
CHECK (event_duration >= 30)
);


INSERT INTO member (member_first_name, member_last_name, member_email, member_phone_number, member_date_of_birth, wantsReminderEmails)
VALUES ('Sean', 'Kunkemoeller', 'seankunke98@gmail.com', '513-335-2575', '03-26-1998', true), ('Member2', 'Membertwo', 'member2@gmail.com', '234-2344-3234', '03-21-1965', false), ('Member3', 'Memberthree', 'member3@gmail.com', '234-235-3234', '03-23-1965', false), ('Member4', 'Memberfour', 'member4@gmail.com', '254-234-3234', '03-21-1975', true), ('Member5', 'Memberfive', 'member5@gmail.com', '234-238-3234', '03-21-1995', false), ('Member6', 'Membersix', 'member6@gmail.com', '234-214-3234', '03-11-1965', false), ('Member7', 'Memberseven', 'member7@gmail.com', '234-224-3234', '03-21-1997', false), ('Member8', 'Membereight', 'member8@gmail.com', '234-784-3234', '03-27-1965', true);

INSERT INTO interest_group (group_name, member_count)
VALUES ('Interest Group One', 2), ('Interest Group Two', 2), ('Interest Group 3', 2);

INSERT INTO group_member (group_id, member_id) 
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'Interest Group One'), (SELECT member_id FROM member WHERE member_first_name = 'Sean')), ((SELECT group_id FROM interest_group WHERE group_name = 'Interest Group One'), (SELECT member_id FROM member WHERE member_first_name = 'Member2')), ((SELECT group_id FROM interest_group WHERE group_name = 'Interest Group Two'), (SELECT member_id FROM member WHERE member_first_name = 'Member3')), ((SELECT group_id FROM interest_group WHERE group_name = 'Interest Group Two'), (SELECT member_id FROM member WHERE member_first_name = 'Member4')), ((SELECT group_id FROM interest_group WHERE group_name = 'Interest Group Three'), (SELECT member_id FROM member WHERE member_first_name = 'Member5')), ((SELECT group_id FROM interest_group WHERE group_name = 'Interest Group Three'), (SELECT member_id FROM member WHERE member_first_name = 'Member6'));

INSERT INTO event (event_name, event_description, start_date, start_time, event_duration, group_id)
VALUES ('Good Event', 'A pretty good event', '08-08-2022', '7:00 PM', 45, (SELECT group_id FROM interest_group WHERE group_name = 'Interest Group One')), ('Awesome Event', 'A pretty awesome event', '08-06-2022', '7:00 PM', 60, (SELECT group_id FROM interest_group WHERE group_name = 'Interest Group Two')), ('Great Event', 'A pretty great event', '08-09-2022', '8:00 PM', 30, (SELECT group_id FROM interest_group WHERE group_name = 'Interest Group Two')), ('Best Event', 'The best event', '08-10-2022', '6:00 PM', 45, (SELECT group_id FROM interest_group WHERE group_name = 'Interest Group Three'));