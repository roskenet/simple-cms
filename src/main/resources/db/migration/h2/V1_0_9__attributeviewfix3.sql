CREATE VIEW attribute_view AS
   SELECT distinct attribute.name, attribute.value, page.id AS page_id, precedence            
  from page, attribute, attribute_level 
 where attribute.level = attribute_level.id
   AND (page.id = attribute.page_selector OR page.category_id = attribute.category_selector OR level='GLOBAL')
   order by attribute.name, page.id, precedence desc;