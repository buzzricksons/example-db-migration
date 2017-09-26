DROP TABLE IF EXISTS TCITY;
CREATE TABLE TCITY (
    code VARCHAR(255),
    name VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255),
    CONSTRAINT CITY_PK PRIMARY KEY (code)
);

INSERT INTO tcity (code, name, state, country) VALUES ('asdfjljklk234kj234', 'San Francisco', 'CA', 'US');