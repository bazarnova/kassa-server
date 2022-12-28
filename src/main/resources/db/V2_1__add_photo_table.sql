CREATE TABLE IF NOT EXISTS kassa.photos (
    "ID" bigint NOT NULL,
    "FILE_ID" character varying(1000),
    "MESSAGE_DATE" date,
    "ADDED_DATE" date,
    "PROCESSED" boolean,
    "PATH" character varying(1000)
);

CREATE SEQUENCE kassa."photos_IDD_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE kassa."photos_IDD_seq" OWNED BY kassa.photos."ID";

ALTER TABLE ONLY kassa.photos ALTER COLUMN "ID" SET DEFAULT nextval('kassa."photos_IDD_seq"'::regclass);

ALTER TABLE ONLY kassa.photos
    ADD CONSTRAINT photos_pkey PRIMARY KEY ("ID");
