create table providers
(
    id           bigint not null
        constraint providers_pkey
            primary key,
    created_by   varchar(255),
    amount       bigint,
    cost         double precision,
    description  varchar(255),
    phone        varchar(255),
    product_name varchar(255),
    name         varchar(255)
);

alter table providers
    owner to postgres;

INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (1, 'ADMIN', 20, 350, 'Шашлык из свинины 100гр ', '89159625552', 'Шашлык из свинины', 'ООО "Веранда"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (2, 'ADMIN', 28, 220, 'Свинина в лаваше 130гр', '89159625552', 'Свинина в лаваше', 'ООО "Веранда"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (3, 'ADMIN', 12, 400, 'Шашлык из телятины 100гр', '89159625552', 'Шашлык из телятины', 'ООО "Веранда"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (4, 'ADMIN', 23, 200, 'Шашлык куринный 100гр', '89159625552', 'Шашлык куринный', 'ООО "Веранда"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (5, 'ADMIN', 10, 380, 'Шашлык из баранины 100гр', '89159625552', 'Шашлык из баранины ', 'ООО "Веранда"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (6, 'ADMIN', 20, 320, 'Шашлык из свинины 100гр ', '89625626555', 'Шашлык из свинины', 'ООО "Беседка"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (7, 'ADMIN', 40, 50, 'Пирог с рублен свин шашлыком', '89625626555', 'Пирог с рублен свин шашлыком', 'ООО "Беседка"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (8, 'ADMIN', 8, 870, 'Лосось на гриле 250гр', '89035644281', 'Лосось на гриле ', 'ООО "МореПР"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (9, 'ADMIN', 9, 920, 'Форель на гриле 280гр пикантный', '89035644281', 'Форель на гриле ', 'ООО "МореПР"');
INSERT INTO public.providers (id, created_by, amount, cost, description, phone, product_name, name) VALUES (10, 'ADMIN', 11, 550, 'Судак сыро-копченый 320гр ', '89035644281', 'Судак сыро-копченый  ', 'ООО "МореПР"');