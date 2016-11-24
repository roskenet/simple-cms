CREATE TABLE logging (
  id SERIAL PRIMARY KEY,
  reqtime TIMESTAMP NOT NULL DEFAULT now(),
  method TEXT,
  url TEXT,
  ip TEXT,
  agent TEXT
);