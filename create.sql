CREATE DATABASE herosquad;
\c herosquad;
CREATE TABLE heroes(id SERIAL PRIMARY KEY, name VARCHAR, age INTEGER, power VARCHAR, weakness VARCHAR);
CREATE TABLE squads(id SERIAL PRIMARY KEY, name VARCHAR, mission VARCHAR, participants INTEGER);
CREATE DATABASE herosquad_test WITH TEMPLATE herosquad;