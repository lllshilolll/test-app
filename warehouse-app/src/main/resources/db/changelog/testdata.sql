--liquibase formatted sql

--changeset Baranova:inset_user
INSERT INTO users (userId, name, password, phone_number, role)
VALUES ('4fe289fc-6703-42f8-ae8f-994f33701b21', 'admin', '123', '8-999-000-000', 'admin');
INSERT INTO users (userId, name, password, phone_number, role)
VALUES ('31873e28-4347-4c9c-ae1c-aecb2708a026', 'user', '123', '8-999-000-000', 'user');

--changeset Baranova:inset_owner
insert into owners (owner_id, name, phonenumber)
values ('6491758e-c56b-487b-8477-8e33b9957ce9', 'Boss', '8-999-222-000');

--changeset Baranova:inset_warehouses
insert into warehouses (warehouse_id, city, country, phonenumber, "size", owner_id)
values ('08b1239b-4e7d-423a-a046-0c6ef5dfbedf', 'Moscow', 'Russia', '8-999-000-111', '12',
        '6491758e-c56b-487b-8477-8e33b9957ce9');

--changeset Baranova:inset_product
insert into products (id, name, uniq_number_product, producer_id, warehouse_id)
values ('99b544ce-2a35-4f41-a807-8f7397789da1', 'product1', '2db29435-a5c8-4ab1-9aae-372abd6c0d31',
        '4fe289fc-6703-42f8-ae8f-994f33701b21', '08b1239b-4e7d-423a-a046-0c6ef5dfbedf');