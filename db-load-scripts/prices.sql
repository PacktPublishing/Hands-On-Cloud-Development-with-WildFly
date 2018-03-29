DROP TABLE IF EXISTS PRICE;                                                                                                                                                                                                        
                                                                                                                                                                                                                                   
CREATE TABLE PRICE (id serial PRIMARY KEY, item_id varchar, price smallint);
                                                                                                                                                                                                                                   
INSERT INTO PRICE(item_id, price) VALUES ('dbf67f4d-f1c9-4fd4-96a8-65ee1a22b9ff', 50);
INSERT INTO PRICE(item_id, price) VALUES ('fc7ee3ea-8f82-4144-bcc8-9a71f4d871bd', 30);
INSERT INTO PRICE(item_id, price) VALUES ('725dfad2-0b4d-455c-9385-b46c9f356e9b', 15);
INSERT INTO PRICE(item_id, price) VALUES ('a2aa1ca7-add8-4aae-b361-b7f92d82c3f5', 3000);
                                                                                                                                                                                                                                
