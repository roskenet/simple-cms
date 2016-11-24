CREATE TABLE sprivilege (
    id VARCHAR(256) PRIMARY KEY
);

INSERT INTO sprivilege (id)
    VALUES ('PAGE_ADMIN'),
           ('PAGE_READ'),
           ('PAGE_UPDATE'),
           ('USER_ADMIN');

CREATE TABLE srole (
    id VARCHAR(256) PRIMARY KEY
);

INSERT INTO srole (id)
    VALUES ('ADMIN'),
           ('PUBLIC');

CREATE TABLE srole_sprivilege (
    srole_id VARCHAR(256) NOT NULL REFERENCES srole (id) ON DELETE CASCADE,
    sprivilege_id VARCHAR(256) NOT NULL REFERENCES sprivilege (id) ON DELETE CASCADE
);

CREATE INDEX ON srole_sprivilege (srole_id, sprivilege_id);

INSERT INTO srole_sprivilege (srole_id, sprivilege_id)
    VALUES ('ADMIN', 'PAGE_ADMIN'),
           ('ADMIN', 'USER_ADMIN'),
           ('PUBLIC', 'PAGE_READ');

CREATE TABLE suser (
    id VARCHAR(256) PRIMARY KEY,
    name VARCHAR(256),
    passwd VARCHAR(256) NOT NULL,
    avatar VARCHAR(256)
);

INSERT INTO suser (id, name, passwd)
    VALUES ('admin', 'Administrator', 'administrator'),
           ('anonymous', 'Anonymous', 'anonymous');    

CREATE TABLE sgroup (
    id VARCHAR(256) PRIMARY KEY
);

INSERT INTO sgroup (id)
    VALUES ('ANONYMOUS_USERS'),
           ('ADMIN_USERS');

CREATE TABLE suser_sgroup (
    suser_id VARCHAR(256) NOT NULL REFERENCES suser (id) ON DELETE CASCADE,
    sgroup_id VARCHAR(256) NOT NULL REFERENCES sgroup (id) ON DELETE CASCADE
);

CREATE INDEX ON suser_sgroup (sgroup_id);
CREATE INDEX ON suser_sgroup (suser_id, sgroup_id);

INSERT INTO suser_sgroup (suser_id, sgroup_id)
    VALUES ('admin', 'ADMIN_USERS'),
           ('anonymous', 'ANONYMOUS_USERS');

CREATE TABLE sgroup_srole (
    sgroup_id VARCHAR(256) NOT NULL REFERENCES sgroup (id) ON DELETE CASCADE,
    srole_id VARCHAR(256) NOT NULL REFERENCES srole (id) ON DELETE CASCADE
);

CREATE INDEX ON sgroup_srole (srole_id);
CREATE INDEX ON sgroup_srole (sgroup_id, srole_id);

INSERT INTO sgroup_srole (sgroup_id, srole_id) 
    VALUES ('ANONYMOUS_USERS', 'PUBLIC'),
           ('ADMIN_USERS', 'ADMIN');

CREATE TABLE category (
    id VARCHAR(256) PRIMARY KEY,
    supercat VARCHAR(256) REFERENCES category (id)
);

INSERT INTO category (id)
    VALUES ('ROOT');

CREATE TABLE template (
    id VARCHAR(256) PRIMARY KEY,
    created TIMESTAMP NOT NULL DEFAULT now(),
    last_modified TIMESTAMP,
    version INTEGER,
    path VARCHAR(256) NOT NULL
);

CREATE TABLE page (
    id VARCHAR(256) PRIMARY KEY,
    created TIMESTAMP NOT NULL DEFAULT now(),
    last_modified TIMESTAMP,
    version INTEGER,
    template VARCHAR(256) NOT NULL REFERENCES template (id),
    path VARCHAR(256) NOT NULL,
    category_id VARCHAR(256) NOT NULL REFERENCES category (id),
    validfrom TIMESTAMP,
    validto TIMESTAMP,
    suser_id VARCHAR(256) NOT NULL REFERENCES suser (id),
    -- visible to the following groups
    sgroup_id VARCHAR(256) NOT NULL REFERENCES sgroup (id)
);

CREATE INDEX ON page (category_id);

CREATE TABLE tag (
    id VARCHAR(256) PRIMARY KEY
);

CREATE TABLE page_tag (
    page_id VARCHAR(256) NOT NULL REFERENCES page (id) ON DELETE CASCADE,
    tag_id VARCHAR(256) NOT NULL REFERENCES tag (id) ON DELETE CASCADE
);

CREATE INDEX ON page_tag (page_id);
CREATE INDEX ON page_tag (tag_id, page_id);

