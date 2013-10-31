



--  Drop Tables, Stored Procedures and Views 

DROP TABLE IF EXISTS comm_medica CASCADE;
DROP TABLE IF EXISTS commande CASCADE;
DROP TABLE IF EXISTS employe CASCADE;
DROP TABLE IF EXISTS medicament CASCADE;
DROP TABLE IF EXISTS stock CASCADE;
DROP TABLE IF EXISTS type_medicament CASCADE;

CREATE SEQUENCE seq_commande;
CREATE SEQUENCE seq_employe;
CREATE SEQUENCE seq_medicament;
CREATE SEQUENCE seq_comm_medic;
CREATE SEQUENCE seq_stock;
CREATE SEQUENCE seq_type_medicament;

--  Create Tables 
CREATE TABLE comm_medica ( 
	no_comm_medica integer DEFAULT nextval(('seq_comm_medica'::text)::regclass) NOT NULL,
	no_commande integer NOT NULL,
	no_medicament integer NOT NULL
);


CREATE TABLE commande ( 
	no_commande integer DEFAULT nextval(('seq_commande'::text)::regclass) NOT NULL,
	montantTotal float NULL,
	valide boolean NULL,
	dateCommande timestamp NULL,
	employe_id integer NULL
);

CREATE TABLE employe ( 
	no_employe integer DEFAULT nextval(('seq_employe'::text)::regclass) NOT NULL,
	nom varchar(50) NULL,
	prenom varchar(50) NULL
);

CREATE TABLE medicament ( 
	no_medicament integer DEFAULT nextval(('seq_medicament'::text)::regclass) NOT NULL,
	libelle varchar(50) NULL,
	code varchar(50) NULL,
	description varchar(50) NULL,
	prix float NULL,
	type_medicament integer NULL
);

CREATE TABLE stock ( 
	no_stock integer DEFAULT nextval(('seq_stock'::text)::regclass) NOT NULL,
	quantite float NULL,
	date_peremption timestamp NOT NULL,
	medicament_id integer NULL
);

CREATE TABLE type_medicament ( 
	no_type_medicament integer DEFAULT nextval(('seq_type_medicament'::text)::regclass) NOT NULL,
	libelle varchar(50) NULL
);


--  Create Primary Key Constraints 
ALTER TABLE comm_medica ADD CONSTRAINT PK_comm_medica 
	PRIMARY KEY (no_comm_medica);


ALTER TABLE commande ADD CONSTRAINT PK_commande 
	PRIMARY KEY (no_commande);


ALTER TABLE employe ADD CONSTRAINT PK_employe 
	PRIMARY KEY (no_employe);


ALTER TABLE medicament ADD CONSTRAINT PK_medicament 
	PRIMARY KEY (no_medicament);


ALTER TABLE stock ADD CONSTRAINT PK_stock 
	PRIMARY KEY (no_stock);


ALTER TABLE type_medicament ADD CONSTRAINT PK_type_medicament 
	PRIMARY KEY (no_type_medicament);




--  Create Foreign Key Constraints 
ALTER TABLE comm_medica ADD CONSTRAINT FK_comm_medica_commande 
	FOREIGN KEY (no_commande) REFERENCES commande (no_commande);

ALTER TABLE comm_medica ADD CONSTRAINT FK_comm_medica_medicament 
	FOREIGN KEY (no_medicament) REFERENCES medicament (no_medicament);

ALTER TABLE commande ADD CONSTRAINT FK_commande_employe 
	FOREIGN KEY (employe_id) REFERENCES employe (no_employe);

ALTER TABLE medicament ADD CONSTRAINT FK_medicament_type_medicament 
	FOREIGN KEY (type_medicament) REFERENCES type_medicament (no_type_medicament);

ALTER TABLE stock ADD CONSTRAINT FK_stock_medicament 
	FOREIGN KEY (medicament_id) REFERENCES medicament (no_medicament);
