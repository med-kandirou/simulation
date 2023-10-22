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
                               number serial PRIMARY KEY,
                               etat VARCHAR(255) CHECK (etat IN ('encours', 'accepte', 'refuse')) DEFAULT 'encours',
                               taux REAL,
                               montant REAL,
                               mensualite REAL,
                               dure INT,
                               remarks TEXT,
                               date DATE DEFAULT current_date,
                               Client_code VARCHAR(50),
                               FOREIGN KEY (Client_code) REFERENCES client (code)
);

CREATE TABLE agence (
                        code serial primary key,
                        name VARCHAR(255),
                        adresse VARCHAR(255),
                        phone VARCHAR(20)
);



CREATE TABLE historique_modifications_demande (
                       id SERIAL PRIMARY KEY,
                       demande_id INT,
                       ancien_statut VARCHAR(255),
                       nouveau_statut VARCHAR(255),
                       date_modification TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);







CREATE OR REPLACE FUNCTION enregistrer_historique_modification()
RETURNS TRIGGER AS $$
BEGIN

INSERT INTO historique_modifications_demande (demande_id, ancien_statut, nouveau_statut)
VALUES (OLD.number, OLD.etat, NEW.etat);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;


   CREATE TRIGGER historique_modification_trigger
    AFTER UPDATE ON demandecredit
    FOR EACH ROW
    EXECUTE FUNCTION enregistrer_historique_modification();

