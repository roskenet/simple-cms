insert into srole values ('ROLE_ADMIN');
insert into srole values ('ROLE_PUBLIC');

update sgroup_srole set srole_id='ROLE_ADMIN' WHERE srole_id='ADMIN';
update sgroup_srole set srole_id='ROLE_PUBLIC' WHERE srole_id='PUBLIC';