DROP TABLE IF EXISTS order_items;
DROP SEQUENCE IF EXISTS seq_order_items;
DROP TABLE IF EXISTS bouquets;
DROP SEQUENCE IF EXISTS seq_bouquets;
DROP TABLE IF EXISTS events;
DROP SEQUENCE IF EXISTS seq_events;

CREATE SEQUENCE seq_order_items
  START 10000;
CREATE SEQUENCE seq_events
  START 1000;
CREATE SEQUENCE seq_bouquets
  START 5000;

CREATE TABLE events (
  id        INTEGER PRIMARY KEY        DEFAULT nextval('seq_events'),
  eventName VARCHAR(50) NOT NULL,
  eventDate TIMESTAMP   NOT NULL,
  delivery  BOOLEAN     NOT NULL       DEFAULT FALSE,
  regDate   TIMESTAMP                  DEFAULT now()
);

CREATE TABLE bouquets (
  id          INTEGER PRIMARY KEY        DEFAULT nextval('seq_bouquets'),
  bouquetName VARCHAR(50) NOT NULL,
  color       VARCHAR(50) NOT NULL,
  cost        MONEY       NOT NULL
);

CREATE TABLE order_items (
  id        INTEGER PRIMARY KEY DEFAULT nextval('seq_order_items'),
  eventId   INTEGER NOT NULL,
  bouquetId INTEGER NOT NULL,
  quantity  INT     NOT NULL    DEFAULT 1,
  FOREIGN KEY (eventId) REFERENCES events (id) ON DELETE CASCADE,
  FOREIGN KEY (bouquetId) REFERENCES bouquets (id) ON DELETE CASCADE
);
--set lc_monetary='de_DE(at)euro';
--SET LC_MONETARY = 'Italian_Italy.1252';
--SHOW LC_MONETARY;

--SELECT pg_reload_conf();

INSERT INTO events (eventName, eventDate, delivery) VALUES
  ('Birthday', make_timestamp(2016, 05, 18, 09, 00, 00), TRUE),
  ('St. Barbara Day', make_timestamp(2016, 07, 02, 10, 00, 00), FALSE),
  ('Helloween', make_timestamp(2016, 09, 24, 18, 00, 00), TRUE);

INSERT INTO bouquets (bouquetName, color, cost) VALUES
  ('lover', 'red', 154.68),
  ('emotion', 'yellow', 220),
  ('softness', 'white', 120.5),
  ('brightness', 'mix', 140.4),
  ('beauty', 'yellow', 180.8);

INSERT INTO order_items (eventId, bouquetId, quantity) VALUES
  (1000, 5002, 3),
  (1000, 5002, 5),
  (1002, 5000, 1),
  (1002, 5001, 1),
  (1002, 5002, 1),
  (1002, 5003, 1),
  (1001, 5004, 4),
  (1001, 5002, 2),
  (1001, 5002, 1);

