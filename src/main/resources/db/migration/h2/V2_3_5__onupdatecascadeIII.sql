ALTER TABLE attribute 
DROP CONSTRAINT attribute_category_selector_fkey,
DROP CONSTRAINT attribute_page_selector_fkey,
 ADD CONSTRAINT attribute_category_selector_fkey FOREIGN KEY (category_selector) 
   REFERENCES category (id)
   ON UPDATE CASCADE ON DELETE CASCADE,
 ADD CONSTRAINT attribute_page_selector_fkey FOREIGN KEY (page_selector) 
   REFERENCES page (id)
   ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE page_tag 
DROP CONSTRAINT page_tag_page_idfkey,
 ADD CONSTRAINT page_tag_page_id_fkey FOREIGN KEY (page_id) 
   REFERENCES page (id)
   ON UPDATE CASCADE ON DELETE CASCADE;