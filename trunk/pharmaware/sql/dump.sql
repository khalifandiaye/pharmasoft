--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.6
-- Dumped by pg_dump version 9.2.6
-- Started on 2015-03-11 22:44:34

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 189 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 189
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 180 (class 1259 OID 24578)
-- Name: categorie_medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categorie_medicament (
    nocategoriemedicament integer NOT NULL,
    libelle character varying(255)
);


ALTER TABLE public.categorie_medicament OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 24576)
-- Name: categorie_medicament_nocategoriemedicament_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE categorie_medicament_nocategoriemedicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorie_medicament_nocategoriemedicament_seq OWNER TO postgres;

--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 179
-- Name: categorie_medicament_nocategoriemedicament_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE categorie_medicament_nocategoriemedicament_seq OWNED BY categorie_medicament.nocategoriemedicament;


--
-- TOC entry 169 (class 1259 OID 16387)
-- Name: commande; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE commande (
    no_commande integer NOT NULL,
    datecommande timestamp without time zone,
    montanttotal double precision,
    valide boolean,
    vendeur_noemploye integer
);


ALTER TABLE public.commande OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16393)
-- Name: commande_medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE commande_medicament (
    no_commande integer NOT NULL,
    no_medicament integer NOT NULL
);


ALTER TABLE public.commande_medicament OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 16385)
-- Name: commande_no_commande_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE commande_no_commande_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commande_no_commande_seq OWNER TO postgres;

--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 168
-- Name: commande_no_commande_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE commande_no_commande_seq OWNED BY commande.no_commande;


--
-- TOC entry 172 (class 1259 OID 16400)
-- Name: employe; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employe (
    noemploye integer NOT NULL,
    nom character varying(255),
    prenom character varying(255),
    password character varying(255),
    profil character varying(255),
    username character varying(255)
);


ALTER TABLE public.employe OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16398)
-- Name: employe_noemploye_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE employe_noemploye_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employe_noemploye_seq OWNER TO postgres;

--
-- TOC entry 2049 (class 0 OID 0)
-- Dependencies: 171
-- Name: employe_noemploye_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE employe_noemploye_seq OWNED BY employe.noemploye;


--
-- TOC entry 182 (class 1259 OID 24586)
-- Name: forme_medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE forme_medicament (
    noformemedicament integer NOT NULL,
    libelle character varying(255)
);


ALTER TABLE public.forme_medicament OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 24584)
-- Name: forme_medicament_noformemedicament_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE forme_medicament_noformemedicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.forme_medicament_noformemedicament_seq OWNER TO postgres;

--
-- TOC entry 2050 (class 0 OID 0)
-- Dependencies: 181
-- Name: forme_medicament_noformemedicament_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE forme_medicament_noformemedicament_seq OWNED BY forme_medicament.noformemedicament;


--
-- TOC entry 184 (class 1259 OID 24594)
-- Name: liste_medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE liste_medicament (
    nolistemedicament integer NOT NULL,
    libelle character varying(255)
);


ALTER TABLE public.liste_medicament OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 24592)
-- Name: liste_medicament_nolistemedicament_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE liste_medicament_nolistemedicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.liste_medicament_nolistemedicament_seq OWNER TO postgres;

--
-- TOC entry 2051 (class 0 OID 0)
-- Dependencies: 183
-- Name: liste_medicament_nolistemedicament_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE liste_medicament_nolistemedicament_seq OWNED BY liste_medicament.nolistemedicament;


--
-- TOC entry 174 (class 1259 OID 16411)
-- Name: medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE medicament (
    no_medicament integer NOT NULL,
    code character varying(255),
    description character varying(255),
    libelle character varying(255),
    prix double precision,
    type_notypemedicament integer,
    liste character varying(255),
    categorie character varying(255),
    code_acl character varying(255),
    code_cip character varying(255),
    dosage character varying(255),
    expiant character varying(255),
    formemedicament character varying(255),
    modeadministration character varying(255),
    modeconservation character varying(255),
    posologie character varying(255),
    principe character varying(255),
    categorie_nocategoriemedicament integer,
    formemedicament_noformemedicament integer,
    liste_nolistemedicament integer,
    modeadministration_nomodeadminmedicament integer,
    modeconservation_nomodeconsmedicament integer
);


ALTER TABLE public.medicament OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16409)
-- Name: medicament_no_medicament_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE medicament_no_medicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicament_no_medicament_seq OWNER TO postgres;

--
-- TOC entry 2052 (class 0 OID 0)
-- Dependencies: 173
-- Name: medicament_no_medicament_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE medicament_no_medicament_seq OWNED BY medicament.no_medicament;


--
-- TOC entry 186 (class 1259 OID 24602)
-- Name: mode_admin_medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mode_admin_medicament (
    nomodeadminmedicament integer NOT NULL,
    libelle character varying(255)
);


ALTER TABLE public.mode_admin_medicament OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 24600)
-- Name: mode_admin_medicament_nomodeadminmedicament_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE mode_admin_medicament_nomodeadminmedicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mode_admin_medicament_nomodeadminmedicament_seq OWNER TO postgres;

--
-- TOC entry 2053 (class 0 OID 0)
-- Dependencies: 185
-- Name: mode_admin_medicament_nomodeadminmedicament_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE mode_admin_medicament_nomodeadminmedicament_seq OWNED BY mode_admin_medicament.nomodeadminmedicament;


--
-- TOC entry 188 (class 1259 OID 24610)
-- Name: mode_cons_medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mode_cons_medicament (
    nomodeconsmedicament integer NOT NULL,
    libelle character varying(255)
);


ALTER TABLE public.mode_cons_medicament OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 24608)
-- Name: mode_cons_medicament_nomodeconsmedicament_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE mode_cons_medicament_nomodeconsmedicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mode_cons_medicament_nomodeconsmedicament_seq OWNER TO postgres;

--
-- TOC entry 2054 (class 0 OID 0)
-- Dependencies: 187
-- Name: mode_cons_medicament_nomodeconsmedicament_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE mode_cons_medicament_nomodeconsmedicament_seq OWNED BY mode_cons_medicament.nomodeconsmedicament;


--
-- TOC entry 176 (class 1259 OID 16422)
-- Name: stock; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE stock (
    nostock integer NOT NULL,
    dateperemption timestamp without time zone,
    quantite integer,
    medicament_no_medicament integer
);


ALTER TABLE public.stock OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16420)
-- Name: stock_nostock_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE stock_nostock_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stock_nostock_seq OWNER TO postgres;

--
-- TOC entry 2055 (class 0 OID 0)
-- Dependencies: 175
-- Name: stock_nostock_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE stock_nostock_seq OWNED BY stock.nostock;


--
-- TOC entry 178 (class 1259 OID 16430)
-- Name: type_medicament; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE type_medicament (
    notypemedicament integer NOT NULL,
    libelle character varying(255)
);


ALTER TABLE public.type_medicament OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16428)
-- Name: type_medicament_notypemedicament_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE type_medicament_notypemedicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_medicament_notypemedicament_seq OWNER TO postgres;

--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 177
-- Name: type_medicament_notypemedicament_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE type_medicament_notypemedicament_seq OWNED BY type_medicament.notypemedicament;


--
-- TOC entry 1875 (class 2604 OID 24581)
-- Name: nocategoriemedicament; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categorie_medicament ALTER COLUMN nocategoriemedicament SET DEFAULT nextval('categorie_medicament_nocategoriemedicament_seq'::regclass);


--
-- TOC entry 1870 (class 2604 OID 16390)
-- Name: no_commande; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commande ALTER COLUMN no_commande SET DEFAULT nextval('commande_no_commande_seq'::regclass);


--
-- TOC entry 1871 (class 2604 OID 16403)
-- Name: noemploye; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employe ALTER COLUMN noemploye SET DEFAULT nextval('employe_noemploye_seq'::regclass);


--
-- TOC entry 1876 (class 2604 OID 24589)
-- Name: noformemedicament; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY forme_medicament ALTER COLUMN noformemedicament SET DEFAULT nextval('forme_medicament_noformemedicament_seq'::regclass);


--
-- TOC entry 1877 (class 2604 OID 24597)
-- Name: nolistemedicament; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liste_medicament ALTER COLUMN nolistemedicament SET DEFAULT nextval('liste_medicament_nolistemedicament_seq'::regclass);


--
-- TOC entry 1872 (class 2604 OID 16414)
-- Name: no_medicament; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicament ALTER COLUMN no_medicament SET DEFAULT nextval('medicament_no_medicament_seq'::regclass);


--
-- TOC entry 1878 (class 2604 OID 24605)
-- Name: nomodeadminmedicament; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mode_admin_medicament ALTER COLUMN nomodeadminmedicament SET DEFAULT nextval('mode_admin_medicament_nomodeadminmedicament_seq'::regclass);


--
-- TOC entry 1879 (class 2604 OID 24613)
-- Name: nomodeconsmedicament; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mode_cons_medicament ALTER COLUMN nomodeconsmedicament SET DEFAULT nextval('mode_cons_medicament_nomodeconsmedicament_seq'::regclass);


--
-- TOC entry 1873 (class 2604 OID 16425)
-- Name: nostock; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stock ALTER COLUMN nostock SET DEFAULT nextval('stock_nostock_seq'::regclass);


--
-- TOC entry 1874 (class 2604 OID 16433)
-- Name: notypemedicament; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY type_medicament ALTER COLUMN notypemedicament SET DEFAULT nextval('type_medicament_notypemedicament_seq'::regclass);


--
-- TOC entry 2030 (class 0 OID 24578)
-- Dependencies: 180
-- Data for Name: categorie_medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY categorie_medicament (nocategoriemedicament, libelle) FROM stdin;
1	HUMAIN
2	VETERINAIRE
3	HOMEOPATHIQUE
\.


--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 179
-- Name: categorie_medicament_nocategoriemedicament_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('categorie_medicament_nocategoriemedicament_seq', 3, true);


--
-- TOC entry 2019 (class 0 OID 16387)
-- Dependencies: 169
-- Data for Name: commande; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY commande (no_commande, datecommande, montanttotal, valide, vendeur_noemploye) FROM stdin;
5	2014-02-22 17:23:44.019	\N	f	\N
\.


--
-- TOC entry 2020 (class 0 OID 16393)
-- Dependencies: 170
-- Data for Name: commande_medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY commande_medicament (no_commande, no_medicament) FROM stdin;
\.


--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 168
-- Name: commande_no_commande_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('commande_no_commande_seq', 7, true);


--
-- TOC entry 2022 (class 0 OID 16400)
-- Dependencies: 172
-- Data for Name: employe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY employe (noemploye, nom, prenom, password, profil, username) FROM stdin;
13	retr	reytrydfdf	\N	\N	\N
18	aaaa	aqsf	\N	\N	\N
16	mbengue	moustapha	tapha	pharmacien	tapha
\.


--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 171
-- Name: employe_noemploye_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('employe_noemploye_seq', 19, true);


--
-- TOC entry 2032 (class 0 OID 24586)
-- Dependencies: 182
-- Data for Name: forme_medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY forme_medicament (noformemedicament, libelle) FROM stdin;
1	COMPRIME
2	GELLULE
3	COLLYRE
4	SUPPOSITOIRE
5	POUDRE
6	OVULE
7	SIROP
8	rfjjf
\.


--
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 181
-- Name: forme_medicament_noformemedicament_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('forme_medicament_noformemedicament_seq', 8, true);


--
-- TOC entry 2034 (class 0 OID 24594)
-- Dependencies: 184
-- Data for Name: liste_medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY liste_medicament (nolistemedicament, libelle) FROM stdin;
1	liste1
2	liste2
3	liste3
\.


--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 183
-- Name: liste_medicament_nolistemedicament_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('liste_medicament_nolistemedicament_seq', 6, true);


--
-- TOC entry 2024 (class 0 OID 16411)
-- Dependencies: 174
-- Data for Name: medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY medicament (no_medicament, code, description, libelle, prix, type_notypemedicament, liste, categorie, code_acl, code_cip, dosage, expiant, formemedicament, modeadministration, modeconservation, posologie, principe, categorie_nocategoriemedicament, formemedicament_noformemedicament, liste_nolistemedicament, modeadministration_nomodeadminmedicament, modeconservation_nomodeconsmedicament) FROM stdin;
7	ghj	ghv	cggh	0	\N	\N	\N	b				\N	\N	\N	yghj	hg	2	3	2	4	\N
12	hnb		ghgg	0	1	\N	\N					\N	\N	\N			2	4	1	4	1
8		fgcv	dfg	12	1	\N	\N	xcv				\N	\N	\N	455		1	2	1	\N	2
11		nhvb 	rdfcgh	0	1	\N	\N					\N	\N	\N	yghj		2	2	2	3	2
10	dfghc	hgh	aaa	123	1	\N	\N					\N	\N	\N			2	4	3	3	1
\.


--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 173
-- Name: medicament_no_medicament_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('medicament_no_medicament_seq', 12, true);


--
-- TOC entry 2036 (class 0 OID 24602)
-- Dependencies: 186
-- Data for Name: mode_admin_medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY mode_admin_medicament (nomodeadminmedicament, libelle) FROM stdin;
1	ORAL
2	BUCAL
3	LINGUAL
4	INJECTABLE
5	COLLYRE
6	VAGINAL
7	yhjk
8	ujhjkn
9	jkx fgkjf
10	xjnfg dfkgkf
\.


--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 185
-- Name: mode_admin_medicament_nomodeadminmedicament_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mode_admin_medicament_nomodeadminmedicament_seq', 10, true);


--
-- TOC entry 2038 (class 0 OID 24610)
-- Dependencies: 188
-- Data for Name: mode_cons_medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY mode_cons_medicament (nomodeconsmedicament, libelle) FROM stdin;
1	MISE AU FRIGO
2	TEMPERATURE AMBIANTE
3	fhjgghj
\.


--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 187
-- Name: mode_cons_medicament_nomodeconsmedicament_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mode_cons_medicament_nomodeconsmedicament_seq', 3, true);


--
-- TOC entry 2026 (class 0 OID 16422)
-- Dependencies: 176
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY stock (nostock, dateperemption, quantite, medicament_no_medicament) FROM stdin;
\.


--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 175
-- Name: stock_nostock_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('stock_nostock_seq', 4, true);


--
-- TOC entry 2028 (class 0 OID 16430)
-- Dependencies: 178
-- Data for Name: type_medicament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY type_medicament (notypemedicament, libelle) FROM stdin;
1	hgh
\.


--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 177
-- Name: type_medicament_notypemedicament_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('type_medicament_notypemedicament_seq', 6, true);


--
-- TOC entry 1893 (class 2606 OID 24583)
-- Name: categorie_medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categorie_medicament
    ADD CONSTRAINT categorie_medicament_pkey PRIMARY KEY (nocategoriemedicament);


--
-- TOC entry 1883 (class 2606 OID 16397)
-- Name: commande_medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY commande_medicament
    ADD CONSTRAINT commande_medicament_pkey PRIMARY KEY (no_commande, no_medicament);


--
-- TOC entry 1881 (class 2606 OID 16392)
-- Name: commande_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY commande
    ADD CONSTRAINT commande_pkey PRIMARY KEY (no_commande);


--
-- TOC entry 1885 (class 2606 OID 16408)
-- Name: employe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employe
    ADD CONSTRAINT employe_pkey PRIMARY KEY (noemploye);


--
-- TOC entry 1895 (class 2606 OID 24591)
-- Name: forme_medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY forme_medicament
    ADD CONSTRAINT forme_medicament_pkey PRIMARY KEY (noformemedicament);


--
-- TOC entry 1897 (class 2606 OID 24599)
-- Name: liste_medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY liste_medicament
    ADD CONSTRAINT liste_medicament_pkey PRIMARY KEY (nolistemedicament);


--
-- TOC entry 1887 (class 2606 OID 16419)
-- Name: medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY medicament
    ADD CONSTRAINT medicament_pkey PRIMARY KEY (no_medicament);


--
-- TOC entry 1899 (class 2606 OID 24607)
-- Name: mode_admin_medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mode_admin_medicament
    ADD CONSTRAINT mode_admin_medicament_pkey PRIMARY KEY (nomodeadminmedicament);


--
-- TOC entry 1901 (class 2606 OID 24615)
-- Name: mode_cons_medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mode_cons_medicament
    ADD CONSTRAINT mode_cons_medicament_pkey PRIMARY KEY (nomodeconsmedicament);


--
-- TOC entry 1889 (class 2606 OID 16427)
-- Name: stock_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (nostock);


--
-- TOC entry 1891 (class 2606 OID 16435)
-- Name: type_medicament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY type_medicament
    ADD CONSTRAINT type_medicament_pkey PRIMARY KEY (notypemedicament);


--
-- TOC entry 1903 (class 2606 OID 16441)
-- Name: fk2d4967fef3e0e9f7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commande_medicament
    ADD CONSTRAINT fk2d4967fef3e0e9f7 FOREIGN KEY (no_medicament) REFERENCES medicament(no_medicament);


--
-- TOC entry 1904 (class 2606 OID 16446)
-- Name: fk2d4967fefb9311f9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commande_medicament
    ADD CONSTRAINT fk2d4967fefb9311f9 FOREIGN KEY (no_commande) REFERENCES commande(no_commande);


--
-- TOC entry 1911 (class 2606 OID 16456)
-- Name: fk68af716b8c3e951; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT fk68af716b8c3e951 FOREIGN KEY (medicament_no_medicament) REFERENCES medicament(no_medicament);


--
-- TOC entry 1908 (class 2606 OID 24626)
-- Name: fk77228d191722c21d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicament
    ADD CONSTRAINT fk77228d191722c21d FOREIGN KEY (categorie_nocategoriemedicament) REFERENCES categorie_medicament(nocategoriemedicament);


--
-- TOC entry 1909 (class 2606 OID 24631)
-- Name: fk77228d19232586f4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicament
    ADD CONSTRAINT fk77228d19232586f4 FOREIGN KEY (modeconservation_nomodeconsmedicament) REFERENCES mode_cons_medicament(nomodeconsmedicament);


--
-- TOC entry 1906 (class 2606 OID 24616)
-- Name: fk77228d1981930d74; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicament
    ADD CONSTRAINT fk77228d1981930d74 FOREIGN KEY (formemedicament_noformemedicament) REFERENCES forme_medicament(noformemedicament);


--
-- TOC entry 1910 (class 2606 OID 24636)
-- Name: fk77228d1999033631; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicament
    ADD CONSTRAINT fk77228d1999033631 FOREIGN KEY (modeadministration_nomodeadminmedicament) REFERENCES mode_admin_medicament(nomodeadminmedicament);


--
-- TOC entry 1905 (class 2606 OID 16451)
-- Name: fk77228d19b0e34933; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicament
    ADD CONSTRAINT fk77228d19b0e34933 FOREIGN KEY (type_notypemedicament) REFERENCES type_medicament(notypemedicament);


--
-- TOC entry 1907 (class 2606 OID 24621)
-- Name: fk77228d19ef8d038d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicament
    ADD CONSTRAINT fk77228d19ef8d038d FOREIGN KEY (liste_nolistemedicament) REFERENCES liste_medicament(nolistemedicament);


--
-- TOC entry 1902 (class 2606 OID 16436)
-- Name: fkdc160a7ae255ec64; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commande
    ADD CONSTRAINT fkdc160a7ae255ec64 FOREIGN KEY (vendeur_noemploye) REFERENCES employe(noemploye);


--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-03-11 22:44:35

--
-- PostgreSQL database dump complete
--

