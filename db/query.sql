-- create database dbcajacmlp;
use dbcajacmlp;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbcajacmlp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbcajacmlp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbcajacmlp` DEFAULT CHARACTER SET latin1 ;
USE `dbcajacmlp` ;

-- -----------------------------------------------------
-- Table `dbcajacmlp`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcajacmlp`.`admin` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbcajacmlp`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcajacmlp`.`alumno` (
  `alumno_dni` CHAR(8) NOT NULL,
  `apellidos` VARCHAR(100) NULL DEFAULT NULL,
  `nombres` VARCHAR(100) NULL DEFAULT NULL,
  `sexo` CHAR(1) NULL DEFAULT 'M',
  `edad` CHAR(2) NULL DEFAULT NULL,
  `grado` VARCHAR(45) NULL DEFAULT NULL,
  `seccion` VARCHAR(45) NULL DEFAULT NULL,
  `estado` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`alumno_dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `dbcajacmlp`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcajacmlp`.`matricula` (
  `id_matricula` INT(11) NOT NULL AUTO_INCREMENT,
  `alumno_dni` CHAR(8) NOT NULL,
  `periodo` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_inicio` VARCHAR(10) NULL DEFAULT NULL,
  `fecha_final` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id_matricula`),
  INDEX `FK_matricula_alumno_idx` (`alumno_dni` ASC),
  CONSTRAINT `FK_matricula_alumno`
    FOREIGN KEY (`alumno_dni`)
    REFERENCES `dbcajacmlp`.`alumno` (`alumno_dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `dbcajacmlp`.`pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcajacmlp`.`pagos` (
  `id_pagos` INT(11) NOT NULL AUTO_INCREMENT,
  `id_matricula` INT(11) NOT NULL,
  `importe` DOUBLE(8,2) NULL DEFAULT '0.00',
  `fecha_pago` VARCHAR(10) NULL DEFAULT 'PENDIENTE',
  `pago_motivo` VARCHAR(10) NULL DEFAULT NULL,
  `tipo_pago` CHAR(6) NULL DEFAULT NULL,
  `pago_mora` DOUBLE(8,2) NULL DEFAULT '0.00',
  PRIMARY KEY (`id_pagos`),
  INDEX `FK_pagos_matricula_idx` (`id_matricula` ASC),
  CONSTRAINT `FK_pagos_matricula`
    FOREIGN KEY (`id_matricula`)
    REFERENCES `dbcajacmlp`.`matricula` (`id_matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `dbcajacmlp`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcajacmlp`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(80) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------------------------
-- CONSULTAS
-- -----------------------------------------------------------------------

ALTER TABLE `dbcajacmlp`.`alumno` 
CHANGE COLUMN `sexo` `sexo` CHAR(1) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT 'M' ;

ALTER TABLE `dbcajacmlp`.`pagos` 
CHANGE COLUMN `pago_mora` `pago_mora` DOUBLE(8,2) NULL DEFAULT 0 ;

ALTER TABLE `dbcajacmlp`.`pagos` 
CHANGE COLUMN `importe` `importe` DOUBLE(8,2) NULL DEFAULT 0 ;

ALTER TABLE `dbcajacmlp`.`pagos` 
CHANGE COLUMN `fecha_pago` `fecha_pago` VARCHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT 'PENDIENTE' ;


-- PARA EL KARDEX
select concat(a.alumno_dni,"  ",a.apellidos,"  ",a.nombres)as Alumno,a.grado,a.seccion,
p.tipo_pago,m.fecha_inicio,m.fecha_final,p.fecha_pago,p.pago_motivo,p.importe,p.pago_mora,
CASE 
    WHEN p.importe = '0.00'
	 THEN 480
     ELSE 0
     END AS PENDIENTE 
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where a.alumno_dni='99999999'
group by p.tipo_pago,m.fecha_inicio,m.fecha_final,p.fecha_pago,p.pago_motivo,
p.importe,p.pago_mora,a.grado,a.seccion;


select p.id_matricula,p.importe,p.fecha_pago, p.pago_motivo,
CASE 
    WHEN p.importe = '0.00'
	 THEN 480
     ELSE 0
     END AS DETALLE
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where a.alumno_dni='99999999';



select a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
-- where a.alumno_dni='75870480'
group by a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion;


select a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where concat(a.alumno_dni,a.nombres,a.apellidos) LIKE '%75870480%'
group by a.alumno_dni,a.nombres,a.apellidos,a.grado,a.seccion;


select a.alumno_dni, p.tipo_pago,m.fecha_inicio,m.fecha_final,p.fecha_pago,p.pago_motivo,p.importe,p.pago_mora 
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where a.alumno_dni='75870480'
order by m.fecha_inicio;


-- TODOS LOS QUE PAGARON CLASIFICADO POR PERIODO (fecha)
select m.periodo,a.alumno_dni,concat(a.apellidos,", ",a.nombres)as alumno, p.importe,m.fecha_inicio,m.fecha_final,p.fecha_pago,p.pago_mora
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where p.importe!='0.00'
group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;

select m.periodo,a.alumno_dni,concat(a.apellidos,", ",a.nombres)as alumno, p.importe,m.fecha_inicio,m.fecha_final,p.fecha_pago,p.pago_mora
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where p.importe!='0.00' and  m.periodo='01/03/2019'
group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;

-- TODOS LOS QUE NO PAGARON POR PERIODO(fecha)
select a.alumno_dni,concat(a.apellidos,", ",a.nombres)as alumno, p.importe, p.pago_mora, p.fecha_pago,m.fecha_inicio,m.fecha_final
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where m.periodo='01/03/2019' and p.importe='0.00'
group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;

-- TODOS LOS QUE NO PAGARON POR PERIODO(fecha) y por GRADO

select m.periodo,a.grado, a.alumno_dni,concat(a.apellidos,", ",a.nombres)as alumno, m.fecha_inicio,m.fecha_final,p.importe,p.fecha_pago,p.pago_mora
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where p.importe='0.00'
group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;

select m.periodo,a.grado, a.alumno_dni,concat(a.apellidos,", ",a.nombres)as alumno, m.fecha_inicio,m.fecha_final,p.importe,p.fecha_pago,p.pago_mora
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where m.periodo='01/03/2019' and p.importe='0.00' and a.grado='5'
group by a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;


-- TODOS LOS QUE PAGARON POR PERIODO(fecha) y por GRADO
select a.grado, a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago
from alumno as a
join matricula as m on m.alumno_dni=a.alumno_dni
join pagos as p on p.id_matricula=m.id_matricula
where m.periodo='01/03/2019' and p.importe!='0.00' and a.grado='5'
group by  a.grado, a.alumno_dni, a.nombres, a.apellidos, p.importe, p.pago_mora, p.fecha_pago;

-- Mejorando los detalles
ALTER TABLE `dbcajacmlp`.`alumno` 
CHANGE COLUMN `apellidos` `apellidos` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL AFTER `alumno_dni`;

-- OPCION MAS SELECCIONAR ADELANTE
select * from alumno where estado='1' order by apellidos;
-- Opcion de Eliminar
UPDATE `dbcajacmlp`.`alumno` SET `estado`='0' WHERE `alumno_dni`='99999998';

UPDATE `dbcajacmlp`.`alumno` SET `alumno_dni`='65789051', `apellidos`='TARAZONAq', `nombres`='CARLAq', `sexo`='M', `edad`='22', `grado`='5', `seccion`='2' WHERE `alumno_dni`='65789056';

-- ------------------------------------------
-- PAGOS
-- ------------------------------------------

SELECT * FROM dbcajacmlp.pagos;

SELECT m.periodo,m.alumno_dni,a.apellidos,a.nombres,m.id_matricula FROM pagos as p
join matricula as m on m.id_matricula=p.id_matricula
join alumno as a on a.alumno_dni=m.alumno_dni
where a.estado!='0'
group by m.periodo,m.alumno_dni,a.apellidos,a.nombres,m.id_matricula;

-- ----------------------------------------------------------
SELECT m.alumno_dni,a.apellidos,a.nombres,m.id_matricula,m.periodo FROM pagos as p
join matricula as m on m.id_matricula=p.id_matricula
join alumno as a on a.alumno_dni=m.alumno_dni
where concat(m.alumno_dni,a.apellidos,a.nombres) LIKE '%75870480%'
group by m.alumno_dni,a.apellidos,a.nombres,m.id_matricula,m.periodo;

-- LOGIN
-- CREATE TABLE usuarios (
 -- `id` INT(11) NOT NULL AUTO_INCREMENT,
 -- `usuario` VARCHAR(45) NOT NULL,
 -- `password` VARCHAR(45) NOT NULL,
 -- `nombre` VARCHAR(80) NOT NULL,
 -- `cargo` VARCHAR(45) NOT NULL,
 -- PRIMARY KEY (`id`))
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;



