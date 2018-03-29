DROP TABLE IF EXISTS ITEM;

CREATE TABLE ITEM (id serial PRIMARY KEY, item_id varchar, name varchar, description varchar, quantity smallint);

INSERT INTO ITEM(item_id, name, description, quantity) VALUES ('dbf67f4d-f1c9-4fd4-96a8-65ee1a22b9ff',  'turtle', 'Slow friendly reptile. Let your busy self see how it spends 100 years of his life laying on sand and swimming.', 5);
INSERT INTO ITEM(item_id, name, description, quantity) VALUES ('fc7ee3ea-8f82-4144-bcc8-9a71f4d871bd', 'hamster', 'Energetic rodent - great as a first pet. Will be your only inmate that takes his fitness training serviously.', 10);
INSERT INTO ITEM(item_id, name, description, quantity) VALUES ('725dfad2-0b4d-455c-9385-b46c9f356e9b','goldfish', 'With its beauty it will be the decoration of you aquarium. Likes gourmet fish feed and postmodern poetry.', 3);
INSERT INTO ITEM(item_id, name, description, quantity) VALUES ('a2aa1ca7-add8-4aae-b361-b7f92d82c3f5', 'lion', 'Big cat with fancy mane. Loves playing the tag and cuddling with other animals and people.', 9);
