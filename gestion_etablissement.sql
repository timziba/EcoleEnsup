-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 31 jan. 2020 à 16:09
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP :  7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_etablissement`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `idCours` int(11) NOT NULL,
  `theme` varchar(25) NOT NULL,
  `nombreHeure` tinyint(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`idCours`, `theme`, `nombreHeure`) VALUES
(1, 'anglais', 2),
(2, 'gtm', 3),
(3, 'droit', 3);

-- --------------------------------------------------------

--
-- Structure de la table `detailscours`
--

CREATE TABLE `detailscours` (
  `idcours` int(11) NOT NULL,
  `idetudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `detailscours`
--

INSERT INTO `detailscours` (`idcours`, `idetudiant`) VALUES
(1, 1),
(2, 1),
(3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

CREATE TABLE `ecole` (
  `idEcole` int(11) NOT NULL,
  `nomEcole` varchar(25) NOT NULL,
  `adresseEcole` varchar(30) NOT NULL,
  `emailEcole` varchar(15) NOT NULL,
  `directeurEcole` varchar(30) NOT NULL,
  `numeroEcole` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ecole`
--

INSERT INTO `ecole` (`idEcole`, `nomEcole`, `adresseEcole`, `emailEcole`, `directeurEcole`, `numeroEcole`) VALUES
(1, 'Ensup', 'Guyancourt', 'ensup@ensup.fr', 'buvalet', '04178877');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `idEnseignant` int(11) NOT NULL,
  `nomEnseignant` varchar(25) NOT NULL,
  `prenomEnseignant` varchar(30) NOT NULL,
  `adresseEnseignant` varchar(30) NOT NULL,
  `emailEnseignant` varchar(15) NOT NULL,
  `matiere` varchar(15) NOT NULL,
  `numeroEnseignant` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `idEtudiant` int(11) NOT NULL,
  `nomEtudiant` varchar(25) NOT NULL,
  `prenomEtudiant` varchar(30) NOT NULL,
  `adresseEtudiant` varchar(30) NOT NULL,
  `emailEtudiant` varchar(15) NOT NULL,
  `numeroEtudiant` varchar(15) NOT NULL,
  `datenaissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`idEtudiant`, `nomEtudiant`, `prenomEtudiant`, `adresseEtudiant`, `emailEtudiant`, `numeroEtudiant`, `datenaissance`) VALUES
(1, 'ba', 'awa', ' guyancourt', 'resredx', 'gcfgfx', '2018-06-06'),
(3, 'ba', 'fatima', 'sdfghjk', 'edrtyu', 'esxdrcfv', '1995-06-11'),
(4, 'diatta', 'ema', 'sdfghjk', 'edrtyu', 'esxdrcfv', '1998-06-11');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`idCours`);

--
-- Index pour la table `detailscours`
--
ALTER TABLE `detailscours`
  ADD KEY `idetudiant` (`idetudiant`),
  ADD KEY `idcours` (`idcours`),
  ADD KEY `idcours_2` (`idcours`,`idetudiant`) USING BTREE;

--
-- Index pour la table `ecole`
--
ALTER TABLE `ecole`
  ADD PRIMARY KEY (`idEcole`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`idEnseignant`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`idEtudiant`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `idCours` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `ecole`
--
ALTER TABLE `ecole`
  MODIFY `idEcole` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `idEnseignant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `idEtudiant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `detailscours`
--
ALTER TABLE `detailscours`
  ADD CONSTRAINT `detailscours_ibfk_1` FOREIGN KEY (`idetudiant`) REFERENCES `etudiant` (`idEtudiant`),
  ADD CONSTRAINT `detailscours_ibfk_2` FOREIGN KEY (`idcours`) REFERENCES `cours` (`idCours`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
