CREATE TABLE IF NOT EXISTS todo (
    id UUID NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    completed boolean NOT NULL
);