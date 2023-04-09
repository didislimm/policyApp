create table belarus_policy_seq
(
    next_val bigint
) engine=InnoDB;
insert into belarus_policy_seq
values (1);

CREATE TABLE russian_policy_seq
(
    next_val BIGINT
) ENGINE=InnoDB;
INSERT INTO russian_policy_seq
VALUES (1);

CREATE TABLE belarus_policy
(
    id                        BIGINT NOT NULL,
    term_of_insurance         INT,
    start_insurance           DATETIME,
    end_insurance             DATE,
    type                      VARCHAR(255),
    brand                     VARCHAR(255),
    registration_number       VARCHAR(255),
    engine_capacity           INT,
    load_capacity             DOUBLE,
    number_of_places          INT,
    power                     INT,
    win_number                VARCHAR(255),
    insurance_fee_in_euro     DOUBLE,
    insurance_fee_in_byn      DOUBLE,
    rate                      VARCHAR(255),
    k1                        DOUBLE,
    k2                        DOUBLE,
    k3                        DOUBLE,
    discount                  DOUBLE,
    total                     DOUBLE,
    payment_method            VARCHAR(255),
    agreement_date            DATE,
    second_part_insurance_fee DOUBLE,
    date_of_second_fee        DATE,
    owner_full_name           VARCHAR(255),
    policy_holder_full_name   VARCHAR(255),
    is_active                 BOOLEAN,
    total_with_discount       DOUBLE,
    is_paid                   BOOLEAN
) ENGINE=InnoDB;

CREATE TABLE russian_policy
(
    id                     BIGINT NOT NULL,
    term_of_insurance      INT,
    start_insurance        DATETIME,
    end_insurance          DATE,
    policy_holder          VARCHAR(255),
    is_trailer             BOOLEAN,
    brand                  VARCHAR(255),
    win_number             VARCHAR(255),
    registration_number    VARCHAR(255),
    type_of_document       VARCHAR(255),
    series                 VARCHAR(255),
    number_of_document     VARCHAR(255),
    owner_full_name        VARCHAR(255),
    driving_license_series VARCHAR(255),
    driving_license_number VARCHAR(255),
    insurance_premium      DOUBLE,
    special_marks          TEXT,
    agreement_date         DATE
) ENGINE=InnoDB;
