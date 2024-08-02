-- Active: 1719935433186@@localhost@5432@customer
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    age INT NOT NULL
);

CREATE SEQUENCE person_id_seq;

-- delete from flyway_schema_history where installed_rank = 2 and installed_rank = 1;

-- drop table customer;