-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2018 at 10:00 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pad_bd`
--

-- --------------------------------------------------------

--
-- Table structure for table `farmacie`
--

CREATE TABLE `farmacie` (
  `id_farmacie` int(100) NOT NULL,
  `nume` varchar(30) NOT NULL,
  `adresa` varchar(100) NOT NULL,
  `telefon` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farmacie`
--

INSERT INTO `farmacie` (`id_farmacie`, `nume`, `adresa`, `telefon`) VALUES
(1, 'FarmaALWT Timisoara', 'Timisoara, Str. Calea Martirilor, Nr. 62', '0732.671.043'),
(2, 'FarmaALWT Arad', 'Arad, Str.Andreny Karoly, Nr. 2-4', '0357.800.056'),
(3, 'FarmaALWT Bucuresti', 'Bucuresti,Bd Ion Mihalache,Nr 5,Sector 1', '031.437.87.28'),
(4, 'FarmaALWT Iasi', 'Iasi, Strada CAROL I, Nr. 3', '0799.914.677'),
(5, 'FarmaALWT Sibiu', 'Sibiu, Str.Nicolae Balcescu, nr.33', '0269.215.259');

-- --------------------------------------------------------

--
-- Table structure for table `farmacist`
--

CREATE TABLE `farmacist` (
  `id_farmacist` int(10) NOT NULL,
  `nume` varchar(30) NOT NULL,
  `parola` varchar(200) NOT NULL,
  `id_farmacie` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicament`
--

CREATE TABLE `medicament` (
  `id_medicament` int(11) NOT NULL,
  `nume` varchar(30) NOT NULL,
  `descriere` varchar(1000) NOT NULL,
  `poza` varchar(20) NOT NULL,
  `pret` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicament`
--

INSERT INTO `medicament` (`id_medicament`, `nume`, `descriere`, `poza`, `pret`) VALUES
(1, 'Paracetamol', 'Paracetamol Terapia este analgezic (actioneaza impotriva durerii) si antipiretic (ajuta la scaderea temperaturii corpului in caz de febra). \r\nParacetamol Terapia este indicat in tratamentul simptomatic al durerilor de intensitate usoara pana la moderata, cu diferite localizari: dureri de cap, migrene, dureri ale articulatiilor, dureri de spate, dureri de dinti (inclusiv cele aparute dupa proceduri stomatologice-extractii dentare), dureri in gat, durere postvaccinala si dureri menstruale. \r\nDe asemenea, ajuta la scaderea temperaturii corpului in caz de febra.\r\nDaca dupa 3 zile nu va simtiti mai bine sau va simtiti mai rau, trebuie sa va adresati unui medic.', 'paracetamol.jpg', 4),
(2, 'Aspirina', 'Aspirina, considerata de multi specialisti \"medicamentul-minune\" a fost primul medicament descoperit din clasa antiinflamatoarelor nesteroidiene, in prezent fiind unul dintre cele mai utilizate medicamente pe plan mondial, cu un consum anual estimat de aproximativ 40.000 de tone. Desi cunoscut sub forma actuala (tablete) de aproximativ 100 de ani, ingredientul activ al apirinei este utilizat pentru tratarea durerii de mai bine de 3000 de ani. Aspirina ajuta la prevenirea producerii de prostaglandine, substante chimice produse de organism care regleaza durerea si inflamatia.', 'aspirina.jpg', 4.5),
(3, 'Nurofen', 'Cititi cu atentie si in intregime acest prospect, deoarece el contine informatii importante pentru dumneavoastra.\r\nAcest medicament este disponibil fara prescriptie medicala. Cu toate acestea, este necesar sa utilizati Nurofen Forte cu atentie, pentru a obtine cele mai bune rezultate.\r\nIntrebati farmacistul daca aveti nevoie de mai multe informatii sau sfaturi.\r\n Trebuie sa va prezentati la medic daca simptomele dumneavoastra se inrautatesc sau nu se imbunatatesc dupa 3-5 zile.\r\n Daca vreuna dintre reactiile adverse devine grava sau daca observati orice reactie adversa nementionata in acest prospect, va rugam sa-i spuneti medicului dumneavoastra sau farmacistului.', 'nurofen.jpg', 15),
(4, 'Vitamina C', 'Antioxidant ce stimuleaza imunitatea; accelereaza regenerarea tesuturilor; participa la sinteza fibrelor de colagen, a cartilajelor si oaselor. Vitamina C prezinta o importanta capitala pentru organism. Compozitie: 1 comprimat contine 180mg\r\nPrincipalele ei proprietati sunt urmatoarele:\r\ncel mai puternic antioxidant; este antiinfectioasa, tonifianta, antitoxica; participa la asimilarea de catre organism a fierului; mareste rezistenta vaselor sanguine ; contribuie la formarea globulelor rosii, a dintilor si oaselor; are rol de reglare a nivelului glicemiei si al colesterolului, de distrugere a toxinelor o acumulate in organism; \r\nAdministrare: 1-2 comprimate masticabile pe zi.', 'vitaminaC.jpg', 10),
(5, 'Colebil', 'Tratament simptomatic in tulburari dispeptice: balonari epigastrice, eructatii, flatulenta, greata; constipatie (ca medicatie adjuvanta).\r\nDrajeuri continand bila de bou uscata 100 mg, salicilat de sodiu 90 mg, metenamina 50 mg, ulei de menta 5 mg Cutie cu 2 blistere cu 10 drajeuri\r\nMod de administrare\r\nAdulti: 1-3 drajeuri de 2-3 ori pe zi. Copii peste 7 ani: 1 drajeu de 2-3 ori pe zi. Se administreaza oral dupa mesele principale. Durata uzuala a unei cure de tratament este de 2-3 saptamani.', 'colebil.jpg', 11.5);

-- --------------------------------------------------------

--
-- Table structure for table `med_farmacie`
--

CREATE TABLE `med_farmacie` (
  `id_medfarm` int(10) NOT NULL,
  `id_farmacie` int(10) NOT NULL,
  `id_medicament` int(10) NOT NULL,
  `cantitate` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `med_farmacie`
--

INSERT INTO `med_farmacie` (`id_medfarm`, `id_farmacie`, `id_medicament`, `cantitate`) VALUES
(1, 1, 1, 13),
(2, 2, 1, 14),
(4, 1, 4, 20),
(5, 2, 4, 10),
(6, 3, 4, 30),
(7, 4, 4, 10),
(8, 5, 4, 20),
(9, 1, 3, 15),
(10, 2, 3, 15),
(11, 3, 3, 15),
(12, 5, 5, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `farmacie`
--
ALTER TABLE `farmacie`
  ADD PRIMARY KEY (`id_farmacie`);

--
-- Indexes for table `farmacist`
--
ALTER TABLE `farmacist`
  ADD PRIMARY KEY (`id_farmacist`);

--
-- Indexes for table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`id_medicament`);

--
-- Indexes for table `med_farmacie`
--
ALTER TABLE `med_farmacie`
  ADD PRIMARY KEY (`id_medfarm`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `farmacie`
--
ALTER TABLE `farmacie`
  MODIFY `id_farmacie` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `farmacist`
--
ALTER TABLE `farmacist`
  MODIFY `id_farmacist` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medicament`
--
ALTER TABLE `medicament`
  MODIFY `id_medicament` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `med_farmacie`
--
ALTER TABLE `med_farmacie`
  MODIFY `id_medfarm` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
