DROP VIEW category_view;

CREATE RECURSIVE VIEW category_view (main, id, supercat, page_id) AS (
    SELECT category.id as main, category.id as catid, supercat, page_id FROM category 
--      LEFT JOIN page ON category.page_id=page.id
--      WHERE id='Another_Sub_Test'
  UNION --ALL
    SELECT main, category.id, category.supercat, category.page_id 
      FROM category_view, category 
      --LEFT JOIN page ON page.id=page_id
      WHERE category.id=category_view.supercat
)
