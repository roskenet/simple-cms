ALTER TABLE srole_sprivilege 
DROP CONSTRAINT srole_sprivilege_sprivilege_id_fkey,
 ADD CONSTRAINT srole_sprivilege_sprivilege_id_fkey FOREIGN KEY (sprivilege_id) 
   REFERENCES sprivilege (id)
   ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE srole_sprivilege 
DROP CONSTRAINT srole_sprivilege_srole_id_fkey,
 ADD CONSTRAINT srole_sprivilege_srole_id_fkey FOREIGN KEY (srole_id) 
   REFERENCES srole (id)
   ON UPDATE CASCADE ON DELETE CASCADE;
