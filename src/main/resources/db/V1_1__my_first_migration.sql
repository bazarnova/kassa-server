CREATE SCHEMA IF NOT EXISTS kassa;

CREATE TABLE kassa.product (
    "PRODUCT_ID" bigint NOT NULL,
    "PRODUCT_NAME" character varying(1000),
    "AMOUNT" integer NOT NULL,
    "ACCOUNT" integer,
    "WEIGHT" numeric(12,2),
    "CHECK_ID" integer,
    "DESCRIPTION" character varying(1000)
);
CREATE SEQUENCE kassa."product_IDD_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE kassa."product_IDD_seq" OWNED BY kassa.product."PRODUCT_ID";

ALTER TABLE ONLY kassa.product ALTER COLUMN "PRODUCT_ID" SET DEFAULT nextval('kassa."product_IDD_seq"'::regclass);

ALTER TABLE ONLY kassa.product
    ADD CONSTRAINT product_pkey PRIMARY KEY ("PRODUCT_ID");

CREATE TABLE kassa.checks (
    "ID" bigint NOT NULL,
    "SUM_AMOUNT" integer NOT NULL,
    --    TODO notnull
    "DATE" date,
    "SHOP_NAME" character varying(1000),
    "COMMENT" character varying(1000)
);

CREATE SEQUENCE kassa."checks_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE kassa."checks_ID_seq" OWNED BY kassa.checks."ID";

ALTER TABLE ONLY kassa.checks ALTER COLUMN "ID" SET DEFAULT nextval('kassa."checks_ID_seq"'::regclass);

ALTER TABLE ONLY kassa.checks
    ADD CONSTRAINT checks_pkey PRIMARY KEY ("ID");

