CREATE DATABASE test;
USE test;

CREATE TABLE energy_drinks
(
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  cost DECIMAL(8, 2),
  rate DECIMAL(3, 1)
)
COLLATE='utf8_general_ci';
CREATE UNIQUE INDEX energy_drinks_name_uindex ON energy_drinks (title);

INSERT INTO `energy_drinks` (`title`, `cost`, `rate`)
VALUES
  ("Red Bull", 2.50, 4.5),
  ("Monster Energy", 2.00, 4.2),
  ("Rockstar Energy Drink", 1.75, 4.0),
  ("Bang Energy", 2.25, 4.3),
  ("5-hour Energy", 3.00, 3.8),
  ("NOS Energy Drink", 2.50, 4.1),
  ("Full Throttle", 2.25, 3.9),
  ("AMP Energy", 2.00, 4.0),
  ("Xyience Energy", 2.75, 4.2),
  ("Celsius Energy Drink", 2.50, 4.4);


CREATE TABLE games
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  year INT,
  cost DECIMAL(8, 2),
  rate DECIMAL(3, 1)
)
COLLATE='utf8_general_ci';

CREATE UNIQUE INDEX games_title_uindex ON games (title);

INSERT INTO games (title, year, cost, rate)
VALUES
  ('Cyberpunk 2077', 2020, 59.99, 4.0),
  ('The Witcher 3: Wild Hunt', 2015, 39.99, 4.9),
  ('Red Dead Redemption 2', 2018, 49.99, 4.8),
  ('The Last of Us Part II', 2020, 49.99, 4.7),
  ('Hades', 2020, 24.99, 4.9),
  ('God of War', 2018, 39.99, 4.8),
  ('Fallout 4', 2015, 29.99, 4.3),
  ('Dark Souls III', 2016, 39.99, 4.7),
  ('Animal Crossing: New Horizons', 2020, 59.99, 4.6),
  ('Among Us', 2018, 4.99, 4.5);