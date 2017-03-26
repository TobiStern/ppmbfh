-- -----------------------------------------------------
-- Schema ppm
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS ppm ;

-- -----------------------------------------------------
-- Table Customers
-- -----------------------------------------------------
DROP TABLE IF EXISTS Customers ;

CREATE TABLE IF NOT EXISTS Customers (
  pk_idCustomer INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(60) NULL,
  Firstname VARCHAR(60) NULL,
  Adress VARCHAR(80) NULL,
  Phone VARCHAR(45) NULL,
  Email VARCHAR(45) NULL,
  Company VARCHAR(45) NULL,
  State VARCHAR(45) NULL,
  ZIPCode VARCHAR(45) NULL,
  PRIMARY KEY (pk_idCustomer))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Configuration
-- -----------------------------------------------------
DROP TABLE IF EXISTS Configuration ;

CREATE TABLE IF NOT EXISTS Configuration (
  pk_idConfiguration INT NOT NULL,
  Companyname VARCHAR(45) NULL,
  Adress VARCHAR(45) NULL,
  ZIPCode VARCHAR(45) NULL,
  State VARCHAR(45) NULL,
  Licencekey VARCHAR(45) NULL,
  ExpiryDate VARCHAR(45) NULL,
  PRIMARY KEY (pk_idConfiguration))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Portfolio
-- -----------------------------------------------------
DROP TABLE IF EXISTS Portfolio ;

CREATE TABLE IF NOT EXISTS Portfolio (
  pk_idPortfolio INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(80) NULL,
  Description VARCHAR(45) NULL,
  Status VARCHAR(45) NULL,
  fk_idConfig INT NULL,
  PRIMARY KEY (pk_idPortfolio),
  CONSTRAINT fk_idConfig
    FOREIGN KEY (fk_idConfig)
    REFERENCES Configuration (pk_idConfiguration)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_idConfig_idx ON Portfolio (fk_idConfig ASC);


-- -----------------------------------------------------
-- Table Project
-- -----------------------------------------------------
DROP TABLE IF EXISTS Project ;

CREATE TABLE IF NOT EXISTS Project (
  pk_idProjekt INT NOT NULL AUTO_INCREMENT,
  Active INT NULL,
  Name VARCHAR(45) NULL,
  Owner VARCHAR(45) NULL,
  Status VARCHAR(45) NOT NULL,
  Projectphase VARCHAR(45) NOT NULL,
  Budget INT NULL,
  PlannedValue INT NULL,
  ActualCost INT NULL,
  EarnedValue INT NULL,
  Milestones VARCHAR(45) NULL,
  Startdate TIMESTAMP NULL,
  Enddate TIMESTAMP NULL,
  Stakeholder VARCHAR(60) NULL,
  Description VARCHAR(255) NULL,
  fk_Customer INT NULL,
  fk_Portfolio INT NULL,
  PRIMARY KEY (pk_idProjekt),
  CONSTRAINT fk_customer
    FOREIGN KEY (fk_Customer)
    REFERENCES Customers (pk_idCustomer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Portfolio
    FOREIGN KEY (fk_Portfolio)
    REFERENCES Portfolio (pk_idPortfolio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_customer_idx ON Project (fk_Customer ASC);

CREATE INDEX fk_Portfolio_idx ON Project (fk_Portfolio ASC);


-- -----------------------------------------------------
-- Table Teammembers
-- -----------------------------------------------------
DROP TABLE IF EXISTS Teammembers ;

CREATE TABLE IF NOT EXISTS Teammembers (
  pk_idTeammembers INT NOT NULL AUTO_INCREMENT,
  Firstname VARCHAR(45) NULL,
  Lastname VARCHAR(45) NULL,
  Section VARCHAR(45) NULL,
  Function VARCHAR(45) NULL,
  Rate DECIMAL(5,2) NULL,
  PRIMARY KEY (pk_idTeammembers))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Risks
-- -----------------------------------------------------
DROP TABLE IF EXISTS Risks ;

CREATE TABLE IF NOT EXISTS Risks (
  pk_idRisks INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(45) NULL,
  Description VARCHAR(45) NULL,
  Type VARCHAR(45) NULL,
  Level INT NULL,
  Activities VARCHAR(45) NULL,
  Probability VARCHAR(45) NULL,
  PRIMARY KEY (pk_idRisks))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Projectteam
-- -----------------------------------------------------
DROP TABLE IF EXISTS Projectteam ;

CREATE TABLE IF NOT EXISTS Projectteam (
  pk_idProjectteam INT NOT NULL AUTO_INCREMENT,
  fk_Teammember INT NULL,
  fk_Project INT NULL,
  PRIMARY KEY (pk_idProjectteam),
  CONSTRAINT fk_Teammember
    FOREIGN KEY (fk_Teammember)
    REFERENCES Teammembers (pk_idTeammembers)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Project
    FOREIGN KEY (fk_Project)
    REFERENCES Project (pk_idProjekt)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_Teammember_idx ON Projectteam (fk_Teammember ASC);

CREATE INDEX fk_Project_idx ON Projectteam (fk_Project ASC);


-- -----------------------------------------------------
-- Table Projectrisks
-- -----------------------------------------------------
DROP TABLE IF EXISTS Projectrisks ;

CREATE TABLE IF NOT EXISTS Projectrisks (
  pk_idProjectrisks INT NOT NULL AUTO_INCREMENT,
  fk_idProject INT NULL,
  fk_Risk INT NULL,
  PRIMARY KEY (pk_idProjectrisks),
  CONSTRAINT fk_idProject
    FOREIGN KEY (fk_idProject)
    REFERENCES Project (pk_idProjekt)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Risk
    FOREIGN KEY (fk_Risk)
    REFERENCES Risks (pk_idRisks)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_idProject_idx ON Projectrisks (fk_idProject ASC);

CREATE INDEX fk_Risk_idx ON Projectrisks (fk_Risk ASC);

-- Testdaten --
-- Configuration-Tabelle befüllen mit Testdaten --
INSERT INTO Configuration VALUES (1, 'RUAG', 'Together-Strasse', '3000', 'Bern', '1234-5678-0936', '13.03.2018');
INSERT INTO Configuration VALUES (2, 'Die Mobiliar', 'Bundesstrasse', '3000', 'Bern', '7463-9352-927', '18.09.2018');
INSERT INTO Configuration VALUES (3, 'Der Bund', 'Musterstrasse', '3000', 'Bern', '74634-9474-8364', '21.04.2019');
INSERT INTO Configuration VALUES (4, 'Garaio AG', 'Portugal-Strasse', '3000', 'Bern', '1954-0319-4194', '01.01.2021');
INSERT INTO Configuration VALUES (5, 'SBB', 'GA-Strasse', '3014', 'Bern', 'AB54-GHEJ-84F8', '12.06.2017');

-- Portfolio-Tabelle befüllen mit Testdaten --
INSERT INTO Portfolio VALUES (1, 'Marketing', 'Werbung, Kampagnen und Messen', 'Aktiv', 1);
INSERT INTO Portfolio VALUES (2, 'Sales', 'Einkäufe, Verkäufe und Kennzahlen', 'Aktiv', 4);
INSERT INTO Portfolio VALUES (3, 'ICT', 'interne Angelegenheiten', 'Inaktiv', 3);

-- Customers-Tabelle befüllen mit Testdaten --
INSERT INTO Customers VALUES (1, 'Darth', 'Vader', 'Todesstern 3', '123 456 83 94', 'dark_side@gmail.com', 'Star Wars', 'Weltall', '65748');
INSERT INTO Customers VALUES (2, 'Luke', 'Skywalker', 'Valhalla 73', '985 846 09 76', 'bright_side@gmail.com', 'Star Wars2', 'Universum', '7574');

-- Project-Tabelle befüllen mit Testdaten --
INSERT INTO Project VALUES (1, 1, 'Boss-Pet', 'Kyle', 'Grün', 'Initialisation', 80000, 2000, 500, 500, 'MS1.1', TO_TIMESTAMP('2017-03-01 07:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), TO_TIMESTAMP('2017-09-01 07:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'Elmoooooo', 'Ertes erfasstes Projekt', 2, 1);
INSERT INTO Project VALUES (2, 1, 'TooExpensiveProject', 'Butters', 'Grün', 'Realisation', 50000, 30000, 10000, 10000, 'MS4.3', TO_TIMESTAMP('2018-04-01 18:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), TO_TIMESTAMP('2020-03-30 15:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'Logan', 'Projekt um Sales-Kennzahlen einzuführen', 1, 2);
INSERT INTO Project VALUES (3, 1, 'Kiwi', 'Cartman', 'Gelb', 'Konzeption', 5000, 1000, 600, 200, 'MS3.7', TO_TIMESTAMP('2017-06-01 07:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), TO_TIMESTAMP('2017-11-01 18:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'John Wick', 'Neues Verfahren Berechnung Profit', 1, 2);
INSERT INTO Project VALUES (4, 1, 'Banane', 'Kenny', 'Rot', 'Einführung', 25000, 13000, 15000, 7000, 'MS5.4', TO_TIMESTAMP('2017-05-01 07:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), TO_TIMESTAMP('2017-012-30 07:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'Peter', 'Integration des Frameworks SAFe', 2, 1);
INSERT INTO Project VALUES (5, 1, 'Orange', 'Stan', 'Gelb', 'Planung', 45000, 12000, 8000, 6500, 'MS2.4', TO_TIMESTAMP('2017-09-01 07:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), TO_TIMESTAMP('2018-03-01 07:00:00.000000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'Rob', 'Migration Platform AIX auf Linux', 2, 1);

-- Teammembers-Tabelle befüllen mit Testdaten --
INSERT INTO Teammembers VALUES(1, 'Tobias', 'Stern', 'Business', 'PM', 160.00);
INSERT INTO Teammembers VALUES(2, 'Tobias', 'Lüthi', 'IT', 'Applikationsentwickler', 150.00);
INSERT INTO Teammembers VALUES(3, 'Tenud', 'Chris', 'IT', 'Applikationsentwickler', 150.00);
INSERT INTO Teammembers VALUES(4, 'Omeni', 'Kim', 'HR', 'Personalmanagement', 145.00);
INSERT INTO Teammembers VALUES(5, 'Zimmermann', 'Nadja', 'Business', 'Marketing', 155.00);

-- Projectteam-Tabelle befüllen mit Testdaten --
INSERT INTO Projectteam VALUES(1, 5, 2);
INSERT INTO Projectteam VALUES(2, 1, 2);
INSERT INTO Projectteam VALUES(3, 2, 2);
INSERT INTO Projectteam VALUES(4, 1, 5);
INSERT INTO Projectteam VALUES(5, 2, 5);
INSERT INTO Projectteam VALUES(6, 3, 5);
INSERT INTO Projectteam VALUES(7, 4, 3);
INSERT INTO Projectteam VALUES(8, 5, 3);
INSERT INTO Projectteam VALUES(9, 1, 3);

-- Risks-Tabelle befüllen mit Testdaten --
INSERT INTO Risks VALUES(1, 'Risiko 1', 'Explosion der Kosten', 'Typ1', 4, 'Budgetieren + Kontrollieren', 'Mittel');
INSERT INTO Risks VALUES(2, 'Risiko 2', 'Akzeptanz Mgmt', 'Typ2', 3, 'frühe Kommunikation', 'Klein');

-- Prjectrisks-Tabelle befüllen mit Testdaten --
INSERT INTO Projectrisks VALUES(1, 1, 1);
INSERT INTO Projectrisks VALUES(2, 3, 2);