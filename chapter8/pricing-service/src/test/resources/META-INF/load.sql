DROP TABLE IF EXISTS PRICE;

CREATE TABLE PRICE (id serial PRIMARY KEY, name varchar, price smallint);

INSERT INTO PRICE(name, price) VALUES ('test-pet', 5);

