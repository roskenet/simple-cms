DROP VIEW category_view;

CREATE RECURSIVE VIEW category_view (level, main, id, supercat, page_id) AS (
    SELECT 1, category.id as main, category.id as catid, supercat, page_id FROM category 
  UNION 
    SELECT category_view.level+1, main, category.id, category.supercat, category.page_id 
      FROM category_view, category 
      WHERE category.id=category_view.supercat
)