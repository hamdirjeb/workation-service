CREATE TABLE workation
(
    workation_id varchar(255) PRIMARY KEY,
    employee     varchar(255) NULL,
    origin       varchar(255) NULL,
    destination  varchar(255) NOT NULL,
    start_date   varchar(255) NULL,
    end_date     varchar(255) NULL,
    working_days int NULL,
    risk         varchar(255) NULL
);

create sequence hibernate_sequence;