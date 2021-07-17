CREATE DATABASE isitech;
USE isitech;

CREATE TABLE son (
    id INT(10),
    type VARCHAR(255),
    groupeArtiste VARCHAR(255),
    titre VARCHAR(255),
    anneeSortie VARCHAR(255),
    CONSTRAINT pk_son PRIMARY KEY (id) 
);

CREATE TABLE bo (
    id INT(10),
    titreFilm VARCHAR(255),
    CONSTRAINT pk_bo PRIMARY KEY (id),
    CONSTRAINT fk_bo_id FOREIGN KEY (id) REFERENCES son (id)
);

CREATE TABLE live (
    id INT(10),
    lieuConcert VARCHAR(255),
    CONSTRAINT pk_live PRIMARY KEY (id),
    CONSTRAINT fk_live_id FOREIGN KEY (id) REFERENCES son (id)
);