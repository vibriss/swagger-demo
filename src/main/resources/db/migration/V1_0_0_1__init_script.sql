CREATE TABLE IF NOT EXISTS students (
    id                       bigserial           PRIMARY KEY,
    name                     varchar(32)         NOT NULL,
    student_card_number      int2                NOT NULL UNIQUE,
    active                   boolean             NOT NULL);