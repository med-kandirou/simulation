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


CREATE TABLE demandecredit (
                               number serial primary key ,
                               date DATE default current_date,
                               etat VARCHAR(255),
                               montant float,
                               duree INT,
                               remarks VARCHAR(255),
                               Client_code varchar(50),
                               FOREIGN KEY (Client_code) REFERENCES client(code)
);

CREATE TABLE agence (
                        code serial primary key,
                        name VARCHAR(255),
                        adresse VARCHAR(255),
                        phone VARCHAR(20)
);

