ALTER TABLE category
  ADD COLUMN page_id VARCHAR(256);

ALTER TABLE category
  ADD FOREIGN KEY (page_id) REFERENCES page (id);
 
-- This is not very clever with two outer joins
-- Fix this. 
CREATE RECURSIVE VIEW category_view (main, id, supercat, pagepath) AS (
    SELECT category.id as main, category.id as catid, supercat, page.id as pagepath FROM category 
      LEFT JOIN page ON page_id=page.id
  UNION 
    SELECT main, category.id, category.supercat, page.path 
      FROM category_view, category 
      LEFT JOIN page ON page.id=page_id
      WHERE category.id=category_view.supercat
)