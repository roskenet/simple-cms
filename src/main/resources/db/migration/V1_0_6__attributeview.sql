CREATE VIEW attribute_view AS
SELECT DISTINCT ON(attribute.name) attribute.name, attribute.value, page.id
  FROM attribute 
  JOIN attribute_level ON attribute_level.id=level 
  JOIN page ON page_selector=page.id OR category_selector=page.category_id OR level='GLOBAL' 
  ORDER BY attribute.name, precedence DESC, attribute.level;