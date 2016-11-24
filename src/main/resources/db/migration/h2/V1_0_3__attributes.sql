CREATE TABLE attribute_level (
  id VARCHAR(256) PRIMARY KEY
);

INSERT INTO attribute_level
  VALUES ('GLOBAL'),
         ('CATEGORY'),
         ('PAGE');

CREATE TABLE attribute (
  id SERIAL PRIMARY KEY,
  level VARCHAR(256) NOT NULL REFERENCES attribute_level (id),
  category_selector VARCHAR(256) NOT NULL REFERENCES category (id) ON DELETE CASCADE,
  page_selector VARCHAR(256) NOT NULL REFERENCES page (id) ON DELETE CASCADE,
  name VARCHAR(256) NOT NULL,
  value VARCHAR(256) NOT NULL
);

CREATE INDEX ON attribute (level);
CREATE INDEX ON attribute (category_selector);
CREATE INDEX ON attribute (page_selector);