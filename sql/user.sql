create table users
(
    id                    bigint       not null
        constraint users_pkey
            primary key,
    created_by            varchar(255),
    address               varchar(255),
    birth_date            varchar(255),
    change_password_token varchar(255),
    email                 varchar(255),
    is_deleted            boolean,
    login                 varchar(255) not null,
    name                  varchar(255),
    password              varchar(255) not null,
    phone                 varchar(255),
    surname               varchar(255),
    role_id               bigint
        constraint fk_user_roles
            references roles
);

alter table users
    owner to postgres;

INSERT INTO public.users (id, created_by, address, birth_date, change_password_token, email, is_deleted, login, name, password, phone, surname, role_id) VALUES (1, 'ADMIN', 'Пречистенский пер., 5, Москва, 128540', '14.03.1995', null, 'andrey@yandex.ru', false, 'admin', 'Андрей', '$2a$10$SaCLAsioVghFe0x4JYDC4u4HM.5H17Q8nsMOP0r44VMrRo301cSy.', '89159647777', 'Михайлов', 1);
INSERT INTO public.users (id, created_by, address, birth_date, change_password_token, email, is_deleted, login, name, password, phone, surname, role_id) VALUES (2, 'REGISTRATION', 'Овчинниковская наб., 67 стр1, Москва, 136765', '11.07.1991', null, 'ivan@yandex.ru', false, 'manager', 'Иван', '$2a$10$Ow67S6s8Iymrs5Hl19ZAD.OdXLTUl6.CrIgX7ARb7Yc/Yyghe.Ph6', '89159647756', 'Иванов', 3);
INSERT INTO public.users (id, created_by, address, birth_date, change_password_token, email, is_deleted, login, name, password, phone, surname, role_id) VALUES (3, 'REGISTRATION', 'Монетчиковский пер., 90, Москва, 181770', '22.05.1999', null, 'aleksei@yandex.ru', false, 'user', 'Алексей', '$2a$10$ecmJEafkqj3R1vD.rN9OVuvYTdFGGmez2VnFDq6ra9/6mNAmHNzaq', '89126288852', 'Самотин', 2);
INSERT INTO public.users (id, created_by, address, birth_date, change_password_token, email, is_deleted, login, name, password, phone, surname, role_id) VALUES (5, 'REGISTRATION', 'Новый Арбат ул., 4, Москва, 135054', '21.05.1981', null, 'roman@yandex.ru', false, 'user2', 'Роман', '$2a$10$pCd0lcIJIMWAwZ.3Nh1/mOpZmJfHbPwqol1qEeyMEFyDnxyKZgjtu', '89064662621', 'Ерохин', 2);
INSERT INTO public.users (id, created_by, address, birth_date, change_password_token, email, is_deleted, login, name, password, phone, surname, role_id) VALUES (6, 'REGISTRATION', 'Гагаринский пер., 40, Москва, 116735', '11.11.1992', null, 'elena@yandex.ru', false, 'user3', 'Елена', '$2a$10$6sq.8igK4zHmi8eTsgPj8Oku6xZCeNUys2.nbyEBwPtFJKbwAA0ZO', '89201262626', 'Макарова', 2);
INSERT INTO public.users (id, created_by, address, birth_date, change_password_token, email, is_deleted, login, name, password, phone, surname, role_id) VALUES (7, 'REGISTRATION', 'Хрущевский пер., 36, Москва, 185217', '04.11.1996', null, 'mariya@yandex.ru', false, 'user4', 'Мария', '$2a$10$p7knl3IZNO4sDYesxZF05upLzNCWO9ZZgSDYz.ANGMAMbsjZxDmWO', '89102626624', 'Дубова', 2);