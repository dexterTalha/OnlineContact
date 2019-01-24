-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 24, 2019 at 01:14 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id3275324_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mobile` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`id`, `username`, `name`, `mobile`, `email`, `address`) VALUES
(3, 'q', 'hello', '23423424', 'mail.com', 'gorakhpur'),
(4, 'q', 'alpha', '6646494494', 'znsjananan', 'nsnsnss');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mobileno` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `mobileno`) VALUES
(1, 'talha', 'dexter', '9099887680'),
(2, 'alpha', 'password', '2343434334'),
(3, 'raginee', 'anamik', '8766746757'),
(4, 'tanya', '12345', '6776878789'),
(5, 'tanu', '12345', '9198712176'),
(6, 'sakshi', 'saku', '887898998'),
(7, 'anubhav', 'mishra', '1598753246'),
(8, 'subhi', 'saku', '375847484'),
(9, 'ft', 'dexter', '9899887680'),
(10, 'teli', 'teli', '0000000000'),
(11, 'master', 'teli', '7878787878'),
(12, 'vinay', 'mau..', '098898700'),
(13, 'john', 'mau..', '6969696969'),
(14, 'saif', 'fine..', '1414141414'),
(15, 'janbo', 'therobot', '3541257891'),
(16, 'beta', 'password', '2343434334'),
(18, 'qwe', 'qwe', '2121212121'),
(19, 'mango', 'banana', '8520147895'),
(20, 'qwerty', 'qwerty', '1213151415'),
(21, 'vaishali', 'vaishu', '63738384'),
(22, 'username=Xyz', 'Pqr', '9519332391'),
(23, 'Komal', 'Gupta', '2356891245'),
(24, 'Supriya', 'Gupta', '2457888'),
(25, 'username=anu', '0000', '1234'),
(26, 'username=anuu', '0000', '1234'),
(27, 'pk', 'kp', '134'),
(28, 'sonia', 'niku', '1234'),
(29, 'ruhi', '0707', '6757483930'),
(30, 'an', 'na', '12'),
(31, 'username=', '', ''),
(32, 'q', 'w', '8888885');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
