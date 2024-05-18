-- liquibase formatted sql

-- changeset create_table_products
CREATE TABLE products
(
    id                  varchar(50)  not null,
    uniq_number_product varchar(50)  not null,
    name                varchar(100) not null,
    producer_id         varchar(50)  not null,
--     consumer_id         varchar(50),
    warehouse_id        varchar(50),

    PRIMARY KEY (id),
    foreign key (producer_id) REFERENCES users (userId),
--     foreign key (consumer_id) REFERENCES users (userId),
    foreign key (warehouse_id) REFERENCES warehouses (warehouse_id)

);

-- changeset create_table_users

CREATE TABLE users
(
    userId       varchar(50) not null,
    role         varchar(50) not null,
    phone_number varchar(20) not null,

    PRIMARY KEY (userId)
);

-- changeset create_table_warehouses
CREATE TABLE warehouses
(
    warehouse_id varchar(50)  not null,
    country      varchar(100) not null,
    city         varchar(50)  not null,
    size         int          not null,
    phoneNumber  varchar(20)  not null,

    PRIMARY KEY (warehouse_id)
);
