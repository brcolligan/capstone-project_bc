-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the toollib database
-- *************************************************************************************************

BEGIN;

CREATE TABLE tool_category (
    tool_category_id integer primary key,
    name varchar(64) not null
);

CREATE TABLE tool (
    tool_id integer primary key,
    tool_category_id integer not null references tool_category(tool_category_id),
    name varchar(64) not null,
    description text,
    loan_period_in_days integer not null
);

CREATE SEQUENCE seq_tool_id;

CREATE TABLE tool_inventory (
    tool_inventory_id integer primary key,
    tool_id integer not null references tool(tool_id),
    tool_available boolean default 'T',
    tool_client_id varchar(20)
);

CREATE SEQUENCE seq_tool_inventory_id;


CREATE TABLE loan (
	loan_id integer primary key,
	inventory_id integer not null references tool_inventory(tool_inventory_id),
	tool_name varchar(64) not null,
	loan_start_date timestamp,
	loan_due_date timestamp,
	loan_end_date timestamp,
	user_first_name varchar(50),
	user_last_name varchar(50),
	user_license_num varchar(20),
	user_phone_num varchar(30),
	late_fee real,
	maintenance_fee real,
	cleaning_fee real
);

CREATE SEQUENCE seq_loan_id;


COMMIT;