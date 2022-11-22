
CREATE TABLE IF NOT EXISTS T1(
    id INT ,
    name VARCHAR,
    age INT
);

INSERT INTO T1(id,name,age)
VALUES (23,'Tar',46),
(12,'Bar',32),
(14,'Foo',70);

CREATE TABLE IF NOT EXISTS T2(
     id INT ,
     name VARCHAR,
     age INT
);

INSERT INTO T2(id,name,age)
VALUES (14,'Foobar',70),
       (12,'Bar',32);


SELECT DISTINCT *
from T1 a
where not exists (
        SELECT *
        FROM T2
        WHERE name = a.name
        ORDER BY name ASC
    )
