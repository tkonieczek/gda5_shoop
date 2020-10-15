INSERT INTO users(username,password,enabled) VALUES ('marian','$2a$10$cJjRJjX.8dNQXks4fXPoCOqpfd345NL/S3iiViSQprpi5FkwPM6nm', true);
INSERT INTO users(username,password,enabled) VALUES ('mariola','$2a$10$VE5CRqy4yWluBg1dHF15ruZlh7rOixsje5rWB92dR1khQknBIu2q6', true);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$h1QhvyDUYrucItxnY0SD5OOytmHvBHkn56AQfr6YJa4nw8JErWLgu', true);


INSERT INTO authorities (username, authority) VALUES ('marian', 'USER');
INSERT INTO authorities (username, authority) VALUES ('mariola', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');

INSERT INTO products (id, name, description, price) VALUES (1, 'Kalesony', "Super kalesony", 10.0);
INSERT INTO products (id, name, description, price) VALUES (2, 'Salceson', "dobry salceson", 15.0);
INSERT INTO products (id, name, description, price) VALUES (3, 'Skarpety', "Zaszyte skarpety", 5.5);
INSERT INTO products (id, name, description, price) VALUES (4, 'Bigos w puszce', "Stary bigos w puszce", 50.0);