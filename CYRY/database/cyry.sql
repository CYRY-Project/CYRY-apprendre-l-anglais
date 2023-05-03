-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : lun. 13 mars 2023 à 15:59
-- Version du serveur : 8.0.30
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cyry`
--

-- --------------------------------------------------------

--
-- Structure de la table `answer`
--

CREATE TABLE `answer` (
  `idAnswer` int UNSIGNED NOT NULL,
  `answer` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `idExercise` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `answer`
--

INSERT INTO `answer` (`idAnswer`, `answer`, `idExercise`) VALUES
(1, 'Red', 1),
(2, 'Blue', 1),
(3, 'Green', 1),
(4, 'Yellow', 1),
(5, 'Pink', 2),
(6, 'Orange', 2),
(7, 'Brown', 2),
(8, 'Red', 2),
(9, 'Dog', 3),
(10, 'Horse', 3),
(11, 'Bird', 3),
(12, 'Cow', 3),
(13, 'Rabbit', 4),
(14, 'Hedgehog', 4),
(15, 'Fox', 4),
(16, 'Cat', 4),
(17, 'Circle', 5),
(18, 'Heart', 5),
(19, 'Triangle', 5),
(20, 'Square', 5),
(21, 'Star', 6),
(22, 'Rectangle', 6),
(23, 'Oval', 6),
(24, 'Trapezoid', 6),
(25, 'thirteen.png', 7),
(26, 'ten.png', 7),
(27, 'fifteen.png', 7),
(28, 'twenty.png', 7),
(29, 'green.png', 8),
(30, 'orange.png', 8),
(31, 'purple.png', 8),
(32, 'brown.png', 8),
(33, 'animal1.png', 9),
(34, 'animal2.png', 9),
(35, 'animal3.png', 9),
(36, 'animal4.png', 9),
(37, 'car1.png', 10),
(38, 'car2.png', 10),
(39, 'car3.png', 10),
(40, 'car4.png', 10),
(41, 'Bleu', 11),
(42, 'Vert', 11),
(43, 'Rouge', 11),
(44, 'Violet', 11),
(45, 'Jaune', 11),
(46, 'John and his friends are playing outside with a ball', 12),
(47, 'is', 13),
(48, 'were', 13),
(49, 'was', 13),
(50, 'car', 13),
(51, 'plane', 13),
(52, 'spaceship', 13),
(53, 'to buy', 13),
(54, 'to get', 13),
(55, 'to sell', 13),
(56, 'Chien', 14),
(57, 'Chat', 14),
(58, 'Oiseaux', 14),
(59, 'Lapin', 14),
(60, 'Vache', 14),
(61, 'bus.png', 15),
(62, 'moto.png', 15),
(63, 'plane.png', 15),
(64, 'car.png', 15),
(65, 'police.png', 16),
(66, 'fire.png', 16),
(67, 'school.png', 16),
(68, 'hospital.png', 16),
(69, 'Dormir', 17),
(70, 'Manger', 17),
(71, 'Entendre', 17),
(72, 'Souffler', 17),
(73, 'Construire', 17),
(74, 'Il', 18),
(75, 'Elle', 18),
(76, 'Nous', 18),
(77, 'Tu / Vous', 18),
(78, 'Ils / Elles', 18),
(79, 'une veste', 19),
(80, 'une robe', 19),
(81, 'un chapeau', 19),
(82, 'une écharpe', 19),
(83, 'un manteau', 19),
(84, '98', 20),
(85, '54', 20),
(86, '45', 20),
(87, '83', 20),
(88, '77', 20),
(89, 'The English red buses are called Double-decker buses', 21),
(90, 'I like pizza more than any other food', 22),
(91, 'She is studying for her exam tomorrow', 23),
(92, 'He always forgets his keys in the car', 24),
(93, 'Jackson works as a doctor at the hospital', 25);

-- --------------------------------------------------------

--
-- Structure de la table `avatar`
--

CREATE TABLE `avatar` (
  `idAvatar` int UNSIGNED NOT NULL,
  `avatarLink` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `avatar`
--

INSERT INTO `avatar` (`idAvatar`, `avatarLink`) VALUES
(1, '1.png'),
(2, '2.png'),
(3, '3.png'),
(4, '4.png'),
(5, '5.png'),
(6, '6.png'),
(7, '7.png'),
(8, '8.png'),
(9, '9.png'),
(10, '10.png');

-- --------------------------------------------------------

--
-- Structure de la table `difficulty`
--

CREATE TABLE `difficulty` (
  `idDifficulty` int UNSIGNED NOT NULL,
  `difficulty` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `difficulty`
--

INSERT INTO `difficulty` (`idDifficulty`, `difficulty`) VALUES
(1, 'Débutant'),
(2, 'Intermédiaire'),
(3, 'Avancé');

-- --------------------------------------------------------

--
-- Structure de la table `exercise`
--

CREATE TABLE `exercise` (
  `idExercise` int UNSIGNED NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `idType` int UNSIGNED NOT NULL,
  `idDifficulty` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `exercise`
--

INSERT INTO `exercise` (`idExercise`, `title`, `idType`, `idDifficulty`) VALUES
(1, 'Quelle est la couleur ?', 1, 1),
(2, 'Quelle est la couleur ?', 1, 1),
(3, 'Quel est cet animal ?', 1, 2),
(4, 'Quel est cet animal ?', 1, 2),
(5, 'Quelle est cette forme ?', 1, 3),
(6, 'Quelle est cette forme ?', 1, 3),
(7, 'Quel numéro ?', 2, 1),
(8, 'Quelle couleur ?', 2, 1),
(9, 'Quel animal ?', 2, 2),
(10, 'Quelle voiture ?', 2, 2),
(11, 'Les couleurs', 4, 1),
(12, 'John plays football outside with his friends.', 5, 1),
(13, 'Remplis les trous / Fill the Gap', 3, 1),
(14, 'Les animaux', 4, 1),
(15, 'Quel véhicule ?', 2, 3),
(16, 'Dans quel bâtiment ?', 2, 3),
(17, 'Les verbes', 4, 3),
(18, 'Les pronoms', 4, 2),
(19, 'Les vêtements', 4, 2),
(20, 'Les nombres', 4, 3),
(21, 'the English red buses', 5, 3),
(22, 'I like pizza', 5, 1),
(23, 'She is studying', 5, 3),
(24, 'The keys of the car', 5, 2),
(25, 'Jackson\'s job', 5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `exercisedone`
--

CREATE TABLE `exercisedone` (
  `idUser` int UNSIGNED NOT NULL,
  `idExercise` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `exercisedone`
--

INSERT INTO `exercisedone` (`idUser`, `idExercise`) VALUES
(3, 1),
(5, 1),
(3, 2),
(5, 2),
(5, 3),
(5, 4),
(5, 5),
(5, 6),
(3, 7),
(5, 7),
(3, 8),
(5, 8),
(5, 9),
(5, 10),
(3, 11),
(5, 11),
(3, 12),
(5, 12),
(5, 13),
(3, 14),
(5, 14);

-- --------------------------------------------------------

--
-- Structure de la table `exerciselist`
--

CREATE TABLE `exerciselist` (
  `idList` int UNSIGNED NOT NULL,
  `idExercise` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `idImage` int UNSIGNED NOT NULL,
  `imageLink` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `idExercise` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`idImage`, `imageLink`, `idExercise`) VALUES
(1, 'qcm1.png', 1),
(2, 'qcm2.png', 2),
(3, 'qcm3.png', 3),
(4, 'qcm4.png', 4),
(5, 'qcm5.png', 5),
(6, 'qcm6.png', 6);

-- --------------------------------------------------------

--
-- Structure de la table `list`
--

CREATE TABLE `list` (
  `idList` int UNSIGNED NOT NULL,
  `listName` varchar(20) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `idQuestion` int UNSIGNED NOT NULL,
  `question` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `goodAnswer` int UNSIGNED NOT NULL,
  `idExercise` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`idQuestion`, `question`, `goodAnswer`, `idExercise`) VALUES
(1, 'Qu\'obtient on en mélangeant du Bleu et du Jaune ?', 3, 1),
(2, 'Qu\'obtient on en mélangeant du Rouge et du Blanc ?', 5, 2),
(3, 'Quel animal est l\'adulte du veau ?', 12, 3),
(4, 'Quel animal mange des carottes ?', 13, 4),
(5, 'Quelle forme n\'a qu\'un côté ?', 17, 5),
(6, 'Quel forme n\'a pas tout les côtés de la même longueur ?', 24, 6),
(7, 'Which number is between twelve and fourteen ?', 25, 7),
(8, 'What colour do you get by mixing blue and red? 	', 31, 8),
(9, 'Which animal is a jellyfish ?', 35, 9),
(10, 'Which car is green ?', 37, 10),
(11, 'What are John and his friends playing with?', 46, 12),
(12, 'Green', 42, 11),
(13, 'Red', 43, 11),
(14, 'Purple', 44, 11),
(15, 'Yellow', 45, 11),
(16, 'Blue', 41, 11),
(17, 'Bryan // planning to go to the mall.', 47, 13),
(18, 'Bryan wants to take his //.', 50, 13),
(19, 'In the mall, Bryan needs // some vegetables for his recipe.', 53, 13),
(20, 'Dog', 56, 14),
(21, 'Cat', 57, 14),
(22, 'Bird', 58, 14),
(23, 'Rabbit', 59, 14),
(24, 'Cow', 60, 14),
(25, 'Which vehicle has only 2 wheels?', 64, 15),
(26, 'In which building can you get treatment?', 68, 16),
(27, 'to Sleep', 69, 17),
(28, 'to Build', 73, 17),
(29, 'to Blow', 72, 17),
(30, 'to Hear', 71, 17),
(31, 'to Eat', 70, 17),
(32, 'He', 74, 18),
(33, 'She', 75, 18),
(34, 'You', 77, 18),
(35, 'We', 76, 18),
(36, 'They', 78, 18),
(37, 'a scarf', 82, 19),
(38, 'a coat', 83, 19),
(39, 'a hat', 81, 19),
(40, 'a dress', 80, 19),
(41, 'a jacket', 79, 19),
(42, 'ninety-height', 84, 20),
(43, 'fifty-four', 85, 20),
(44, 'forty-five', 86, 20),
(45, 'eighty-three', 87, 20),
(46, 'seventy-seven', 88, 20),
(47, 'What are the English red buses called?', 89, 21),
(48, 'What is my favourite food?', 90, 22),
(49, 'What is Amelie doing tonight ?', 91, 23),
(50, 'Where is the keys ?', 92, 24),
(51, 'What is Jackson\'s job ?', 93, 25);

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `idType` int UNSIGNED NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`idType`, `type`) VALUES
(1, 'Question à choix multiples'),
(2, 'Situation'),
(3, 'Texte à trous'),
(4, 'Traduction'),
(5, 'Construction de phrase');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int UNSIGNED NOT NULL,
  `userName` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `userPassword` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `userBirthDate` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `userLevel` int UNSIGNED NOT NULL,
  `userPoints` int UNSIGNED NOT NULL,
  `idAvatar` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `userName`, `userPassword`, `userBirthDate`, `userLevel`, `userPoints`, `idAvatar`) VALUES
(1, 'romain', 'romain', '22-01-1990', 1, 0, 8),
(2, 'yael', 'yael', '26-11-2001', 1, 0, 4),
(3, 'yoann', 'yoann', '10-01-1991', 4, 3500, 7),
(4, 'corentin', 'corentin', '01-01-2001', 1, 0, 10),
(5, 'test', 'test', '01-01-2001', 16, 15000, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`idAnswer`),
  ADD KEY `idExercise` (`idExercise`);

--
-- Index pour la table `avatar`
--
ALTER TABLE `avatar`
  ADD PRIMARY KEY (`idAvatar`);

--
-- Index pour la table `difficulty`
--
ALTER TABLE `difficulty`
  ADD PRIMARY KEY (`idDifficulty`);

--
-- Index pour la table `exercise`
--
ALTER TABLE `exercise`
  ADD PRIMARY KEY (`idExercise`),
  ADD KEY `idDifficulty` (`idDifficulty`),
  ADD KEY `idType` (`idType`);

--
-- Index pour la table `exercisedone`
--
ALTER TABLE `exercisedone`
  ADD PRIMARY KEY (`idUser`,`idExercise`),
  ADD KEY `idExercise` (`idExercise`);

--
-- Index pour la table `exerciselist`
--
ALTER TABLE `exerciselist`
  ADD PRIMARY KEY (`idList`,`idExercise`),
  ADD KEY `idExercise` (`idExercise`);

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`idImage`),
  ADD KEY `idExercise` (`idExercise`);

--
-- Index pour la table `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`idList`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`idQuestion`),
  ADD KEY `idExercise` (`idExercise`),
  ADD KEY `goodAnswer` (`goodAnswer`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`idType`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`),
  ADD KEY `idAvatar` (`idAvatar`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `answer`
--
ALTER TABLE `answer`
  MODIFY `idAnswer` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT pour la table `avatar`
--
ALTER TABLE `avatar`
  MODIFY `idAvatar` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `difficulty`
--
ALTER TABLE `difficulty`
  MODIFY `idDifficulty` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `exercise`
--
ALTER TABLE `exercise`
  MODIFY `idExercise` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `idImage` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `list`
--
ALTER TABLE `list`
  MODIFY `idList` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `idQuestion` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT pour la table `type`
--
ALTER TABLE `type`
  MODIFY `idType` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`idExercise`) REFERENCES `exercise` (`idExercise`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `exercise`
--
ALTER TABLE `exercise`
  ADD CONSTRAINT `exercise_ibfk_1` FOREIGN KEY (`idDifficulty`) REFERENCES `difficulty` (`idDifficulty`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `exercise_ibfk_2` FOREIGN KEY (`idType`) REFERENCES `type` (`idType`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `exercisedone`
--
ALTER TABLE `exercisedone`
  ADD CONSTRAINT `exercisedone_ibfk_1` FOREIGN KEY (`idExercise`) REFERENCES `exercise` (`idExercise`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `exercisedone_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `exerciselist`
--
ALTER TABLE `exerciselist`
  ADD CONSTRAINT `exerciselist_ibfk_1` FOREIGN KEY (`idExercise`) REFERENCES `exercise` (`idExercise`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `exerciselist_ibfk_2` FOREIGN KEY (`idList`) REFERENCES `list` (`idList`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `image_ibfk_1` FOREIGN KEY (`idExercise`) REFERENCES `exercise` (`idExercise`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`idExercise`) REFERENCES `exercise` (`idExercise`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`goodAnswer`) REFERENCES `answer` (`idAnswer`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`idAvatar`) REFERENCES `avatar` (`idAvatar`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
