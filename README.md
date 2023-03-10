Concert API -
Permet de faire des requêtes pour récupérer des concerts, salles et soirées.

Structure de données

Concert :
    - long id
    - LocalDate date_debut
    - LocalDate date_fin
    - Soiree soiree
    - Groupe groupe
    
Soiree :
    - Long Id
    - String nom
    - double prix
    - Salle salle
    - List<Concert> concerts

Salle :
    - Long Id
    - String nom
    - String adresse
    - int capacite
    - String association
    - String nom_gestionnaire
    - String prenom_gestionnaire
    - List<Soiree> soirees

Lien dans la base de données avec API concert (clé étrangère) :
Artiste :
    - Long id
    - String nom
    - String prenom
    - Date date_naissance
    - String ville_origine
    - Groupe groupe

Groupe :
    - Long id
    - String nom
    - Boolean seul
    - List<Artiste> artistes

Base de données : user = "root" mdp = " " - nom = concert_db

Jeu de données :

INSERT INTO `t_artiste_art` (`art_id`, `art_nom`, `art_prenom`, `art_date_naissance`, `art_ville_origine`, `grp_id`) VALUES
(1, 'Nom artiste', 'Prenom artiste', '2023-03-23', 'Ville origne', 1),
(2, 'Albarn', 'Damon ', '1968-03-23', 'Londres', 6),
(3, 'Waters', 'Roger', '1943-09-06', 'Great Bookham', 5),
(4, 'Wright', 'Richard', '1943-07-28', 'Hatch End', 5),
(5, 'Mason', 'Nick ', '1944-01-27', 'Edgbaston, Birmingham', 5),
(6, 'Barrett', 'Syd', '1946-01-06', 'Cambridge', 5),
(7, 'Reynolds', 'Dan', '1987-07-14', ' Las Vegas, Nevada', 4),
(8, 'McKee', 'Ben', '1985-04-07', 'Forestville, Californie', 4),
(9, 'Lennon', 'John', '1940-10-09', ' Liverpool', 3),
(10, 'McCartney', 'Paul', '1942-06-18', 'Liverpool', 3),
(11, 'Cobain', 'Kurt', '1967-02-20', 'Aberdeen', 2),
(12, 'Grohl', 'Dave', '1969-01-14', ' Warren, Ohio', 2);

INSERT INTO `t_concert_con` (`con_id`, `con_date_debut`, `con_date_fin`, `soi_id`, `grp_id`, `soiree`) VALUES
(1, '1590-04-02 00:00:00', '1590-04-03 00:00:00', 1, 1, NULL),
(2, '2026-02-26 00:00:00', '2026-02-26 00:00:00', 1, 6, NULL),
(3, '2026-03-26 00:00:00', '2026-03-26 00:00:00', 1, 4, NULL),
(4, '2026-03-26 00:00:00', '2026-03-26 00:00:00', 2, 3, NULL),
(6, '2026-03-26 00:00:00', '2026-03-26 00:00:00', 2, 5, NULL),
(7, '2026-03-26 00:00:00', '2026-03-26 00:00:00', 2, 2, NULL),
(8, '2023-03-03 00:00:00', '2023-03-03 00:00:00', 2, 6, NULL),
(9, '1990-04-03 00:00:00', '1990-04-03 00:00:00', 1, 3, NULL),
(12, '2026-03-26 00:00:00', '2026-03-26 00:00:00', 2, 4, NULL);

INSERT INTO `t_salle_sal` (`sal_id`, `sal_nom`, `sal_adresse`, `sal_capacite`, `sal_association`, `sal_nom_gest`, `sal_prenom_gest`) VALUES
(1, 'Jules Noel', 'Rue Jules Noel', 12, 'Association \r\n', 'Tho', 'Max'),
(2, 'La salle jules noel', 'rfff', 10, 'Association2', 'Tho', 'Max'),
(3, 'La salle jules noel', '5 rue jules noel', 10, 'Association\r\n', 'Tho', 'Max');

INSERT INTO `t_soiree_soi` (`soi_id`, `soi_nom`, `sal_id`, `soi_prix`) VALUES
(1, 'La première soirée', 1, 10),
(2, 'La deuxième soirée', 1, 30);


INSERT INTO `t_groupe_grp` (`grp_id`, `grp_nom`, `grp_seul`) VALUES
(1, 'Indochine', 0),
(2, 'Nirvana', 0),
(3, 'The beatles', 0),
(4, 'Imagine Dragons', 0),
(5, 'Pink Floyd', 0),
(6, 'Gorillaz', 0);