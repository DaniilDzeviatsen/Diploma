CREATE TABLE users
(
    id       BIGSERIAL,
    username VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    email    VARCHAR UNIQUE

);
CREATE UNIQUE INDEX ON users (lower(username));

CREATE TABLE admin
(
    id   BIGSERIAL,
    name VARCHAR NOT NULL UNIQUE ,
    email VARCHAR NOT NULL UNIQUE ,
    password VARCHAR NOT NULL UNIQUE

);

CREATE TABLE poems
(
    id BIGSERIAL PRIMARY KEY,
    title Text NOT NULL,
    user_id BIGINT PRIMARY KEY REFERENCES users,
    content TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    likes   BIGINT

);

