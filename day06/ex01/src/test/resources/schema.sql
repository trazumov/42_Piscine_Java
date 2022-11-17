CREATE TABLE IF NOT EXISTS product (
    identifier  INTEGER IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    price       INTEGER NOT NULL
);