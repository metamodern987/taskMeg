--Database:testspringboot

--------------------------------------------------------
CREATE TABLE IF NOT EXISTS allusers (
    id LONG PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL
);


INSERT INTO allusers VALUES (2, 'Neo'), (3,'Morpheus');
--------------------------------------------------------

CREATE TABLE IF NOT EXISTS requests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    disp VARCHAR(50) NOT NULL
);

INSERT INTO requests VALUES (3, 'Change PC,plz'), (4,'Oh my God,I have problem');
