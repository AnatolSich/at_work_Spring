DROP TABLE IF EXISTS bouquets;
DROP SEQUENCE IF EXISTS seq_bouquets;
DROP TABLE IF EXISTS events;
DROP SEQUENCE IF EXISTS seq_events;

CREATE SEQUENCE seq_events
  START 1000;
CREATE SEQUENCE seq_bouquets
  START 5000;

CREATE TABLE events (
  id        INTEGER PRIMARY KEY DEFAULT nextval('seq_events'),
  eventName VARCHAR(50) NOT NULL,
  eventDate DATE        NOT NULL,
  regDate   TIMESTAMP           DEFAULT now()
);

CREATE TABLE bouquets (
  id          INTEGER PRIMARY KEY        DEFAULT nextval('seq_bouquets'),
  bouquetName VARCHAR(50) NOT NULL,
  color       VARCHAR(50) NOT NULL,
  cost        MONEY       NOT NULL,
  delivery    BOOLEAN     NOT NULL       DEFAULT FALSE,
  eventId     INTEGER     NOT NULL,
  FOREIGN KEY (eventId) REFERENCES events (id) ON DELETE CASCADE
);

SET LC_MONETARY = 'Italian_Italy.1252';
SHOW LC_MONETARY;

SELECT pg_reload_conf();

INSERT INTO events (eventName, eventDate) VALUES
  ('Birthday', make_date(2016, 05, 18)),
  ('St. Barbara Day', make_date(2016, 07, 02)),
  ('Helloween', make_date(2016, 09, 24));

INSERT INTO bouquets (bouquetName, color, cost, delivery, eventId) VALUES
  ('lover', 'red', 154.68, TRUE, 1000),
  ('emotion', 'yellow', 220, FALSE, 1002),
  ('softness', 'white', 120.5, TRUE, 1001),
  ('beauty', 'yellow', 180.8, TRUE, 1000);
