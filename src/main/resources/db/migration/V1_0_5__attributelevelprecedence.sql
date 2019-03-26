ALTER TABLE attribute_level
  ADD COLUMN precedence INTEGER;

UPDATE attribute_level SET precedence=1 
  WHERE id='GLOBAL';
UPDATE attribute_level SET precedence=51 
  WHERE id='CATEGORY';
UPDATE attribute_level SET precedence=100
  WHERE id='PAGE';  