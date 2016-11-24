ALTER TABLE page
  DROP CONSTRAINT page_template_fkey;

ALTER TABLE page
  ALTER COLUMN template DROP NOT NULL;

DROP TABLE template;