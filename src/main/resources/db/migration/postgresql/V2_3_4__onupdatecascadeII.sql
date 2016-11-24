ALTER TABLE suser_sgroup 
DROP CONSTRAINT suser_sgroup_suser_id_fkey,
 ADD CONSTRAINT suser_sgroup_suser_id_fkey FOREIGN KEY (suser_id) 
   REFERENCES suser (id)
   ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE suser_sgroup 
DROP CONSTRAINT suser_sgroup_sgroup_id_fkey,
 ADD CONSTRAINT suser_sgroup_sgroup_id_fkey FOREIGN KEY (sgroup_id) 
   REFERENCES sgroup (id)
   ON UPDATE CASCADE ON DELETE CASCADE;
 
ALTER TABLE sgroup_srole
DROP CONSTRAINT sgroup_srole_sgroup_id_fkey,
 ADD CONSTRAINT sgroup_srole_sgroup_id_fkey FOREIGN KEY (sgroup_id) 
   REFERENCES sgroup (id)
   ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sgroup_srole 
DROP CONSTRAINT sgroup_srole_srole_id_fkey,
 ADD CONSTRAINT sgroup_srole_srole_id_fkey FOREIGN KEY (srole_id) 
   REFERENCES srole (id)
   ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE category 
DROP CONSTRAINT category_supercat_fkey,
DROP CONSTRAINT category_page_id_fkey,
 ADD CONSTRAINT category_supercat_fkey FOREIGN KEY (supercat) 
   REFERENCES category (id)
   ON UPDATE CASCADE ON DELETE CASCADE,
 ADD CONSTRAINT category_page_id_fkey FOREIGN KEY (page_id)
   REFERENCES page (id)
   ON UPDATE CASCADE ON DELETE CASCADE;
 
ALTER TABLE page_tag 
DROP CONSTRAINT page_tag_page_id_fkey,
DROP CONSTRAINT page_tag_tag_id_fkey,
 ADD CONSTRAINT page_tag_page_idfkey FOREIGN KEY (page_id) 
   REFERENCES page (id)
   ON UPDATE CASCADE ON DELETE CASCADE,
 ADD CONSTRAINT page_tag_tag_id_fkey FOREIGN KEY (tag_id)
   REFERENCES tag (id)
   ON UPDATE CASCADE ON DELETE CASCADE;
 
   
   