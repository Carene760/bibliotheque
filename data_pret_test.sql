
---------------------------
INSERT INTO Utilisateur (username, password) 
VALUES ('bibliothecaire', '2');

INSERT INTO Profil (profil, quota, nbr_jour_pret_penalite, quota_reservation, quota_prolongement) VALUES 
('Etudiant', 2, 7, 1, 3),
('Enseignant', 3, 9, 2, 5),
('Professionnel', 4, 12, 3, 7);


INSERT INTO Livre (nom_livre, auteur, restreint) VALUES
('Les miserables', 'Victor Hugo', false),
('L Etranger', 'Albert Camus', false),
('Harry Potter a l''ecole des sorciers', 'J.K. Rowling', false);



INSERT INTO Adherent (nom, prenom, email, mdp, telephone, date_naissance, adresse, id_profil, actif) VALUES
('Amine', 'Bensaïd', 'Amine', 'ad1', '0612345678', '1990-05-15', '12 Rue de Paris, 75001', 1, true),
('Sarah ', 'El Khattabi', 'Sarah', 'ad2', '0698765432', '2005-11-22', '34 Avenue des Champs, 69002', 1, true),
('Youssef', 'Moujahid', 'Youssef', 'ad3', '0634567890', '1985-03-10', '56 Boulevard Central, 13003', 1, true),
('Nadia', 'Benali', 'Nadia', 'ad3', '0634567890', '1985-03-10', '56 Boulevard Central, 13003', 2, true),
('Karim', 'Haddadi', 'Karim', 'ad3', '0634567890', '1985-03-10', '56 Boulevard Central, 13003', 2, true),
('Salima', 'Touhami', 'Salima', 'ad3', '0634567890', '1985-03-10', '56 Boulevard Central, 13003', 2, true),
('Rachid', 'El Mansouri', 'Rachid', 'ad3', '0634567890', '1985-03-10', '56 Boulevard Central, 13003', 3, true),
('Amina', 'Zerouali', 'Amina', 'ad3', '0634567890', '1985-03-10', '56 Boulevard Central, 13003', 3, true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(9, '2025-02-01', '2025-07-24', true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(10, '2025-02-01', '2025-07-01', true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(11, '2025-04-01', '2025-12-01', true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(12, '2025-07-01', '2026-07-01', true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(13, '2025-08-01', '2026-05-01', true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(14, '2025-07-01', '2026-06-01', true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(15, '2025-06-01', '2025-12-01', true);

INSERT INTO Abonnement (id_adherent, date_debut, date_fin, actif) VALUES
(16, '2025-10-01', '2025-06-01', true);

-- Jours fériés 2025 Madagascar
INSERT INTO JourFerie (date, description) VALUES
  ('2025-07-13', 'Dimanche'),
  ('2025-07-20', 'Dimanche'),
  ('2025-07-27', 'Dimanche'),
  ('2025-08-03', 'Dimanche'),
  ('2025-08-10', 'Dimanche'),
  ('2025-08-17', 'Dimanche'),
  ('2025-07-26', 'Ferie'),
  ('2025-07-19', 'Ferie');

-- Pour ETU001 (id_adherent = 1, 10 jours de pénalité)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (9, '2025-07-01', '2025-07-11', 'EN_COURS');

-- Pour ETU002 (id_adherent = 2)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (10, '2025-07-02', '2025-07-12', 'EN_COURS');

-- Pour ETU003 (id_adherent = 3)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (11, '2025-07-03', '2025-07-13', 'EN_COURS');

-- Pour ENS001 (id_adherent = 4, 9 jours)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (12, '2025-07-01', '2025-07-10', 'EN_COURS');

-- Pour ENS002 (id_adherent = 5)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (13, '2025-07-02', '2025-07-11', 'EN_COURS');

-- Pour ENS003 (id_adherent = 6)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (14, '2025-07-03', '2025-07-12', 'EN_COURS');

-- Pour PROF001 (id_adherent = 7, 8 jours)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (15, '2025-07-01', '2025-07-09', 'EN_COURS');

-- Pour PROF002 (id_adherent = 8)
INSERT INTO Penalisation (id_adherent, date_debut, date_fin, etat)
VALUES (16, '2025-07-02', '2025-07-10', 'EN_COURS');

INSERT INTO Exemplaire (id_livre, disponible, nom_exemplaire) VALUES
(1, true, 'MIS001'),
(1, true, 'MIS002'), 
(1, true, 'MIS003'),
(2, true, 'ETR001'),
(2, true, 'ETR002'),
(3, true, 'HAR001');

CREATE INDEX idx_exemplaire_livre ON Exemplaire(id_livre);
CREATE INDEX idx_adherent_profil ON Adherent(id_profil);
CREATE INDEX idx_pret_adherent ON Pret(id_adherent);
CREATE INDEX idx_pret_exemplaire ON Pret(id_exemplaire);
CREATE INDEX idx_reservation_adherent ON Reservation(id_adherent);
CREATE INDEX idx_reservation_exemplaire ON Reservation(id_exemplaire);