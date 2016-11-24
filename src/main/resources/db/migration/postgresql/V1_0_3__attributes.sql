CREATE TABLE attribute_level (
  id TEXT PRIMARY KEY
);

INSERT INTO attribute_level
  VALUES ('GLOBAL'),
         ('CATEGORY'),
         ('PAGE');

CREATE TABLE attribute (
  id SERIAL PRIMARY KEY,
  level TEXT NOT NULL REFERENCES attribute_level (id),
  category_selector TEXT NOT NULL REFERENCES category (id) ON DELETE CASCADE,
  page_selector TEXT NOT NULL REFERENCES page (id) ON DELETE CASCADE,
  name TEXT NOT NULL,
  value TEXT NOT NULL
);

CREATE INDEX ON attribute (level);
CREATE INDEX ON attribute (category_selector);
CREATE INDEX ON attribute (page_selector);