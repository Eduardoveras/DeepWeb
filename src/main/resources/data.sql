INSERT INTO users (email, first_name, last_name, password, role, shipping_address, status)
VALUES ('dj@gmail.com', 'Djidjely', 'Siclait', '81dc9bdb52d04dc20036dbd8313ed055', 0, 'nowhere', 0);

INSERT INTO users (email, first_name, last_name, password, role, shipping_address, status)
VALUES ('ev@gmail.com', 'Eduardo', 'Veras', '81dc9bdb52d04dc20036dbd8313ed055', 0, 'nowhere', 0);

INSERT INTO users (email, first_name, last_name, password, role, shipping_address, status)
VALUES ('er@gmail.com', 'Ernesto', 'Rodriguez', '81dc9bdb52d04dc20036dbd8313ed055', 0, 'nowhere', 0);

INSERT INTO history (history_id, user_email) VALUES (-1, 'dj@gmail.com');
INSERT INTO history (history_id, user_email) VALUES (-2, 'ev@gmail.com');
INSERT INTO history (history_id, user_email) VALUES (-3, 'er@gmail.com');

INSERT INTO items (product_id, product_description, product_in_stock, product_name, product_price, supplier)
VALUES (-4, 'New Gucci fall line sunglasses', 45, 'Gucci Sunset Sunglasses', 190.99, 'Macys');

INSERT INTO items (product_id, product_description, product_in_stock, product_name, product_price, supplier)
VALUES (-5, 'Women chique couture lace bra', 45, 'Fearless Brasier', 80.99, 'Victoria Secret');

INSERT INTO items (product_id, product_description, product_in_stock, product_name, product_price, supplier)
VALUES (-6, 'Men football sports gear with nylon padding', 45, 'Bioshock Endurance Helmet', 350.00, 'Bioshock');

INSERT INTO items (product_id, product_description, product_in_stock, product_name, product_price, supplier)
VALUES (-7, 'Kid friendly edible wall paint with easy wash technology', 45, 'Crayola Magic Mural Paint', 190.99, 'Crayola');
