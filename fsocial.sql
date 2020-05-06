-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 06/05/2020 às 23:44
-- Versão do servidor: 10.4.6-MariaDB
-- Versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `fsocial`
--
CREATE DATABASE IF NOT EXISTS `fsocial` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `fsocial`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `login` varchar(20) NOT NULL COMMENT 'IDENTIFICADOR DE ACESSO AO SISTEMA',
  `nome` varchar(100) NOT NULL COMMENT 'NOME COMPLETO DO USUÁRIO',
  `email` varchar(100) NOT NULL COMMENT 'EMAIL VÁLIDO PERTENCENTE AO USUÁRIO',
  `senha` varchar(20) NOT NULL COMMENT 'SENHA DE ACESSO AO SISTEMA',
  `atribuicao` varchar(20) NOT NULL COMMENT 'ATRIBUTO DEFINIDOR DE PERMISSÃO NA APLICAÇÃO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `tb_usuario`
--

INSERT INTO `tb_usuario` (`login`, `nome`, `email`, `senha`, `atribuicao`) VALUES
('admin', 'ADMINISTRADOR DO SISTEMA', 'email', 'admin', 'ADMIN'),
('usuario', 'Usuário Comum do Sistema', 'juan.sistinf@gmail.com', 'usuario', 'USER');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
