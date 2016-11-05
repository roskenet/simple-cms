DROP VIEW attribute_view;

CREATE VIEW attribute_view AS
   SELECT distinct on(attribute.name, page.id) attribute.name, attribute.value, page.id AS page_id            
  from page, attribute, attribute_level 
 where attribute.level = attribute_level.id
   AND (page.id = attribute.page_selector OR page.category_id = attribute.category_selector OR level='GLOBAL')
   order by attribute.name, page.id, precedence desc;