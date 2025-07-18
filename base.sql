\c postgres
DROP DATABASE IF EXISTS biblio;
CREATE DATABASE biblio;

\c biblio;


CREATE TABLE Utilisateur (
    id_U SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- Table Livre
CREATE TABLE Livre (
    id_livre SERIAL PRIMARY KEY,
    nom_livre VARCHAR(100) NOT NULL,
    auteur VARCHAR(100) NOT NULL,
    restreint BOOLEAN DEFAULT FALSE
);

-- Table Exemplaire
CREATE TABLE Exemplaire (
    id_exemplaire SERIAL PRIMARY KEY,
    id_livre INTEGER NOT NULL REFERENCES Livre(id_livre) ON DELETE CASCADE,
    disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE Profil (
    id_profil SERIAL PRIMARY KEY,
    profil VARCHAR(50) NOT NULL,
    quota INTEGER NOT NULL, -- quota pret
    nbr_jour_pret_penalite INTEGER NOT NULL,
    quota_reservation INTEGER NOT NULL DEFAULT 3,
    quota_prolongement INTEGER NOT NULL DEFAULT 2
);

CREATE TABLE Adherent (
    id_adherent SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    mdp VARCHAR(255) NOT NULL,  -- Champ mot de passe ajouté
    telephone VARCHAR(20),
    date_naissance DATE NOT NULL,
    adresse TEXT,
    id_profil INTEGER NOT NULL REFERENCES Profil(id_profil),
    actif BOOLEAN DEFAULT FALSE,
    date_inscription TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Table Penalisation
CREATE TABLE Penalisation (
    id_penalisation SERIAL PRIMARY KEY,
    id_adherent INTEGER NOT NULL REFERENCES Adherent(id_adherent) ON DELETE CASCADE,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    etat VARCHAR(20) CHECK (etat IN ('EN_COURS', 'TERMINE')) DEFAULT 'EN_COURS'
);

-- Table Abonnement
CREATE TABLE Abonnement (
    id_abonnement SERIAL PRIMARY KEY,
    id_adherent INTEGER NOT NULL REFERENCES Adherent(id_adherent) ON DELETE CASCADE,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    actif BOOLEAN NOT NULL DEFAULT true
);
UPDATE abonnement SET actif = (date_fin >= CURRENT_DATE);

-- Table Reservation
CREATE TABLE Reservation (
    id_reservation SERIAL PRIMARY KEY,
    date_reservation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_a_reserver TIMESTAMP NOT NULL,  -- champ ajouté en TIMESTAMP
    id_adherent INTEGER NOT NULL REFERENCES Adherent(id_adherent) ON DELETE CASCADE,
    id_exemplaire INTEGER NOT NULL REFERENCES Exemplaire(id_exemplaire) ON DELETE CASCADE,
    etat VARCHAR(20) CHECK (etat IN ('EN_COURS', 'VALIDE', 'ANNULE')) DEFAULT 'EN_COURS'
);

-- Table Pret (corrigée pour Enum Java)
CREATE TABLE Pret (
    id_pret SERIAL PRIMARY KEY,
    
    id_adherent INTEGER NOT NULL 
        REFERENCES Adherent(id_adherent) ON DELETE CASCADE,
    
    id_exemplaire INTEGER NOT NULL 
        REFERENCES Exemplaire(id_exemplaire) ON DELETE CASCADE,
    
    date_debut TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_retour_prevue DATE NOT NULL,
    date_retour_effective DATE,
    type_pret VARCHAR(20) CHECK (type_pret IN ('SUR_PLACE', 'EMPORTE')),
    statut_pret VARCHAR(20) DEFAULT 'EN_DEMANDE' 
        CHECK (statut_pret IN ('EN_DEMANDE', 'EN_COURS', 'RETOURNE', 'RETARD')),
    etat_traitement VARCHAR(20) DEFAULT 'EN_ATTENTE'
        CHECK (etat_traitement IN ('EN_ATTENTE', 'VALIDE', 'REJETE', 'ANNULE'))
);
SELECT e.id_exemplaire, e.disponible
FROM Exemplaire e
WHERE e.id_livre = 5;



-- Table Prolongement
CREATE TABLE Prolongement (
    id_prolong SERIAL PRIMARY KEY,
    id_pret INTEGER NOT NULL REFERENCES Pret(id_pret) ON DELETE CASCADE,
    date_debut DATE NOT NULL,
    date_retour_prevue DATE NOT NULL,
    date_retour_effective DATE,
    etat_traitement VARCHAR(20) CHECK (etat_traitement IN ('EN_ATTENTE', 'VALIDE', 'REJETE', 'ANNULE')) DEFAULT 'en_attente'
);

-- Table JourFerie
CREATE TABLE JourFerie (
    id_ferie SERIAL PRIMARY KEY,
    date DATE NOT NULL UNIQUE,
    description VARCHAR(100) NOT NULL
);

-- Index pour améliorer les performances
CREATE INDEX idx_exemplaire_livre ON Exemplaire(id_livre);
CREATE INDEX idx_adherent_profil ON Adherent(id_profil);
CREATE INDEX idx_pret_adherent ON Pret(id_adherent);
CREATE INDEX idx_pret_exemplaire ON Pret(id_exemplaire);
CREATE INDEX idx_reservation_adherent ON Reservation(id_adherent);
CREATE INDEX idx_reservation_exemplaire ON Reservation(id_exemplaire);

ALTER TABLE Exemplaire ADD COLUMN nom_exemplaire VARCHAR(20);
    