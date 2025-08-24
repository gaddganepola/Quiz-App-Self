-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2025 at 01:24 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `questionms`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `answer`, `category`, `option1`, `option2`, `option3`, `option4`, `question`) VALUES
(2, 'H2O', 'Science', 'H2O', 'O2', 'CO2', 'NaCl', 'What is the chemical symbol for water?'),
(3, 'Mars', 'Science', 'Earth', 'Mars', 'Jupiter', 'Venus', 'Which planet is known as the Red Planet?'),
(4, 'Oxygen', 'Science', 'Oxygen', 'Carbon dioxide', 'Nitrogen', 'Hydrogen', 'What gas do plants release during photosynthesis?'),
(5, 'Nucleus', 'Science', 'Nucleus', 'Mitochondria', 'Cytoplasm', 'Cell membrane', 'What part of the cell contains genetic material?'),
(6, 'Skin', 'Science', 'Brain', 'Skin', 'Liver', 'Heart', 'Which is the largest organ in the human body?'),
(7, 'Vitamin D', 'Science', 'Vitamin A', 'Vitamin B12', 'Vitamin C', 'Vitamin D', 'Which vitamin is produced when the skin is exposed to sunlight?'),
(8, '100°C', 'Science', '50°C', '100°C', '150°C', '200°C', 'What is the boiling point of water at sea level?'),
(9, '300,000 km/s', 'Science', '300,000 km/s', '150,000 km/s', '3,000 km/s', '30,000 km/s', 'What is the speed of light?'),
(10, 'Carbon dioxide', 'Science', 'Oxygen', 'Carbon dioxide', 'Nitrogen', 'Hydrogen', 'What gas do humans exhale?'),
(11, 'Mitochondria', 'Science', 'Ribosome', 'Mitochondria', 'Nucleus', 'Chloroplast', 'What is the powerhouse of the cell?'),
(12, '12', 'Maths', '10', '11', '12', '13', 'What is 5 + 7?'),
(13, '9', 'Maths', '7', '8', '9', '10', 'What is the square root of 81?'),
(14, '90', 'Maths', '60', '75', '80', '90', 'What is 15 × 6?'),
(15, '4', 'Maths', '2', '3', '4', '5', 'What is 100 ÷ 25?'),
(16, '3.14', 'Maths', '3.12', '3.14', '3.16', '3.18', 'What is the value of π (approx)?'),
(17, '144', 'Maths', '124', '144', '164', '184', 'What is 12²?'),
(18, '20', 'Maths', '10', '15', '20', '25', 'What is the perimeter of a square with side 5?'),
(19, '100', 'Maths', '50', '75', '100', '150', 'What is 50% of 200?'),
(20, '56', 'Maths', '54', '56', '58', '64', 'What is 7 × 8?'),
(21, '544', 'Maths', '534', '544', '554', '564', 'What is 1000 – 456?');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
