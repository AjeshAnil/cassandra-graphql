
CQLSH
======
CREATE KEYSPACE trops_kickoff WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};


Scripts
=======

CREATE TYPE "trops_kickoff"."info" (
    "displayname" VARCHAR,
    "displaypiclocation" VARCHAR
);
CREATE TABLE "trops_kickoff"."team" (
    "entityid" VARCHAR PRIMARY KEY,
    "displayinfo" frozen < trops_kickoff.Info >,
    "teamname" VARCHAR,
    "chatids"
    SET
        < varchar >,
        "memberids"
    SET
        < varchar >
);
CREATE TABLE "trops_kickoff"."user" (
    "entityid" VARCHAR PRIMARY KEY,
    "displayinfo" frozen < trops_kickoff.Info >,
    "username" VARCHAR,
    "chatids"
    SET
        < varchar >,
        "teamids"
    SET
        < varchar >
);

INSERT INTO
    "trops_kickoff"."user" (
        "entityid",
        "chatids",
        "displayinfo",
        "username",
        "teamids"
    )
VALUES
    (
        'U202107151700001',
        { 'C12345',
        '10000' },
        { displayname :'Aju' },
        'Ajesh Anil',
        { 'T76543',
        'T99998' }
    );
INSERT INTO
    "trops_kickoff"."user" (
        "entityid",
        "chatids",
        "displayinfo",
        "username",
        "teamids"
    )
VALUES
    (
        'U202107151700002',
        { 'C12345',
        '20000' },
        { displayname :'Niv' },
        'Nivin S John',
        { 'T76543',
        'T34567' }
    );
INSERT INTO
    "trops_kickoff"."team" (
        "entityid",
        "chatids",
        "displayinfo",
        "memberids",
        "teamname"
    )
VALUES
    (
        'T99998',
        { 'C87678' },
        { displayname :'MAN' },
        { 'U202107151700001' },
        'Manchester United'
    );
INSERT INTO
    "trops_kickoff"."team" (
        "entityid",
        "chatids",
        "displayinfo",
        "memberids",
        "teamname"
    )
VALUES
    (
        'T76543',
        { 'C24546' },
        { displayname :'ENG' },
        { 'U202107151700001',
        'U202107151700002' },
        'England'
    );
INSERT INTO
    "trops_kickoff"."team" (
        "entityid",
        "chatids",
        "displayinfo",
        "memberids",
        "teamname"
    )
VALUES
    (
        'T34567',
        { 'C45609' },
        { displayname :'RMA' },
        { 'U202107151700002' },
        'Real Madrid'
    );