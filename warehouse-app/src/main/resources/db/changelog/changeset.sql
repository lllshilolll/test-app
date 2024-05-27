--liquibase formatted sql

--changeset Baranova:create_table_owners
CREATE TABLE owners
(
    owner_id varchar(50)  not null,
    name varchar(50)  not null,
    phone_number  varchar(20)  not null,

    PRIMARY KEY (owner_id)
);

--changeset Baranova:create_table_warehouses
CREATE TABLE warehouses
(
    warehouse_id varchar(50)  not null,
    country      varchar(100) not null,
    city         varchar(50)  not null,
    size         int          not null,
    phone_number  varchar(20)  not null,
    owner_id varchar(50)  not null,

    PRIMARY KEY (warehouse_id),
    foreign key (owner_id) REFERENCES owners (owner_id)

);

--changeset Baranova:create_table_users
CREATE TABLE users
(
    user_id       varchar(50) not null,
    role         varchar(50) not null,
    phone_number varchar(20) not null,

    PRIMARY KEY (user_id)
);

--changeset Baranova:create_table_products
CREATE TABLE products
(
    id                  varchar(50)  not null,
    uniq_number_product varchar(50)  not null,
    name                varchar(100) not null,
    producer_id         varchar(50)  not null,
    warehouse_id        varchar(50),

    PRIMARY KEY (id),
    foreign key (producer_id) REFERENCES users (user_id),
    foreign key (warehouse_id) REFERENCES warehouses (warehouse_id)

);

--changeset Baranova:create_column
ALTER TABLE users
    add column name varchar(50);

--changeset Baranova:create_column_users
ALTER TABLE users
    add column password varchar(200);

--changeset Baranova:create_constrain_users_name
ALTER TABLE users
    ADD UNIQUE (name);


