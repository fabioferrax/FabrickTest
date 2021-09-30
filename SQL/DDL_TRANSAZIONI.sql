DROP TABLE gbs_schema.transazioni;

CREATE TABLE gbs_schema.transazioni
(
    transaction_id character varying(30) NOT NULL,
    operation_id character varying(30) NOT NULL,
    accounting_date character varying(15),
    value_date character varying(15),
    amount numeric(25,2) NOT NULL,
    currency character varying(5) NOT NULL,
    description character varying(255),
    type_value character varying(50),
    type_enum character varying(50)
);

ALTER TABLE gbs_schema.transazioni ADD CONSTRAINT transazioni_pkey PRIMARY KEY (transaction_id);