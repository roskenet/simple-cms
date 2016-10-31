CREATE TABLE sprivilege (
    id TEXT PRIMARY KEY
);

INSERT INTO sprivilege (id)
    VALUES ('PAGE_ADMIN'),
           ('PAGE_READ'),
           ('PAGE_UPDATE'),
           ('USER_ADMIN');

CREATE TABLE srole (
    id TEXT PRIMARY KEY
);

INSERT INTO srole (id)
    VALUES ('ADMIN'),
           ('PUBLIC');

CREATE TABLE srole_sprivilege (
    srole_id TEXT NOT NULL REFERENCES srole (id) ON DELETE CASCADE,
    sprivilege_id TEXT NOT NULL REFERENCES sprivilege (id) ON DELETE CASCADE
);

CREATE INDEX ON srole_sprivilege (srole_id, sprivilege_id);

INSERT INTO srole_sprivilege (srole_id, sprivilege_id)
    VALUES ('ADMIN', 'PAGE_ADMIN'),
           ('ADMIN', 'USER_ADMIN'),
           ('PUBLIC', 'PAGE_READ');

CREATE TABLE suser (
    id TEXT PRIMARY KEY,
    name TEXT,
    passwd TEXT NOT NULL,
    avatar TEXT
);

INSERT INTO suser (id, name, passwd)
    VALUES ('admin', 'Administrator', 'administrator'),
           ('anonymous', 'Anonymous', 'anonymous');    

CREATE TABLE sgroup (
    id TEXT PRIMARY KEY
);

INSERT INTO sgroup (id)
    VALUES ('ANONYMOUS_USERS'),
           ('ADMIN_USERS');

CREATE TABLE suser_sgroup (
    suser_id TEXT NOT NULL REFERENCES suser (id) ON DELETE CASCADE,
    sgroup_id TEXT NOT NULL REFERENCES sgroup (id) ON DELETE CASCADE
);

CREATE INDEX ON suser_sgroup (sgroup_id);
CREATE INDEX ON suser_sgroup (suser_id, sgroup_id);

INSERT INTO suser_sgroup (suser_id, sgroup_id)
    VALUES ('admin', 'ADMIN_USERS'),
           ('anonymous', 'ANONYMOUS_USERS');

CREATE TABLE sgroup_srole (
    sgroup_id TEXT NOT NULL REFERENCES sgroup (id) ON DELETE CASCADE,
    srole_id TEXT NOT NULL REFERENCES srole (id) ON DELETE CASCADE
);

CREATE INDEX ON sgroup_srole (srole_id);
CREATE INDEX ON sgroup_srole (sgroup_id, srole_id);

INSERT INTO sgroup_srole (sgroup_id, srole_id) 
    VALUES ('ANONYMOUS_USERS', 'PUBLIC'),
           ('ADMIN_USERS', 'ADMIN');

CREATE TABLE category (
    id TEXT PRIMARY KEY,
    supercat TEXT REFERENCES category (id)
);

INSERT INTO category (id)
    VALUES ('ROOT');

CREATE TABLE template (
    id TEXT PRIMARY KEY,
    created TIMESTAMP NOT NULL DEFAULT now(),
    last_modified TIMESTAMP,
    version INTEGER,
    path TEXT NOT NULL
);

CREATE TABLE page (
    id TEXT PRIMARY KEY,
    created TIMESTAMP NOT NULL DEFAULT now(),
    last_modified TIMESTAMP,
    version INTEGER,
    template TEXT NOT NULL REFERENCES template (id),
    path TEXT NOT NULL,
    category_id TEXT NOT NULL REFERENCES category (id),
    validfrom TIMESTAMP,
    validto TIMESTAMP,
    suser_id TEXT NOT NULL REFERENCES suser (id),
    -- visible to the following groups
    sgroup_id TEXT NOT NULL REFERENCES sgroup (id)
);

CREATE INDEX ON page (category_id);

CREATE TABLE tag (
    id TEXT PRIMARY KEY
);

CREATE TABLE page_tag (
    page_id TEXT NOT NULL REFERENCES page (id) ON DELETE CASCADE,
    tag_id TEXT NOT NULL REFERENCES tag (id) ON DELETE CASCADE
);

CREATE INDEX ON page_tag (page_id);
CREATE INDEX ON page_tag (tag_id, page_id);

