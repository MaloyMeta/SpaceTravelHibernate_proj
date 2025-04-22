INSERT INTO client(name) VALUES
('Alice'),
('Bob'),
('Charlie'),
('Diana'),
('Eve'),
('Frank'),
('Grace'),
('Ilya'),
('Ivan'),
('Nikolas');

INSERT INTO planet (id, name) VALUES
('EARTH', 'Earth'),
('MARS', 'Mars'),
('VEN', 'Venus'),
('JUP', 'Jupiter'),
('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'EARTH', 'MARS'),
(2, 'MARS', 'EARTH'),
(3, 'VEN', 'JUP'),
(4, 'EARTH', 'SAT'),
(5, 'JUP', 'VEN'),
(6, 'SAT', 'EARTH'),
(7, 'EARTH', 'VEN'),
(8, 'VEN', 'MARS'),
(9, 'MARS', 'SAT'),
(10, 'JUP', 'EARTH');