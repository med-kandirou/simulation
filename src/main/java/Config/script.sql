CREATE TABLE personne (
                          firstName varchar(50) not null,
                          lastName varchar(50) not null,
                          birthday date not null,
                          phone varchar(50) not null
);

CREATE TABLE client (
                        code varchar(20) primary key,
                        adresse varchar(50) not null
) INHERITS (Personne);


CREATE TABLE employe (
                        matricule varchar(20) primary key ,
                        daterecrutement date not null,
                        adresseEmail varchar(50) not null
) INHERITS (Personne);


