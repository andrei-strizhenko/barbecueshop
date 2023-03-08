create table products
(
    id          bigint not null
        constraint products_pkey
            primary key,
    created_by  varchar(255),
    available   bigint,
    cost        double precision,
    description varchar(255),
    discount    double precision,
    image       varchar(255),
    ordered     bigint,
    title       varchar(255)
);

alter table products
    owner to postgres;

INSERT INTO public.products (id, created_by,  cost, description, title) VALUES (1, 'MANAGER',  350, 'Шашлык из свинины 100гр ', 'Шашлык из свинины');
INSERT INTO public.products (id, created_by,  cost, description,  title) VALUES (6, 'MANAGER',  50, 'Пирог с рублен свин шашлыком', 'Пирог с рублен свин шашлыком');
INSERT INTO public.products (id, created_by,  cost, description,  title) VALUES (2, 'MANAGER',  220, 'Свинина в лаваше 130гр',  'Свинина в лаваше ');
INSERT INTO public.products (id, created_by,  cost, description,  title) VALUES (7, 'MANAGER',  870, 'Лосось на гриле 250гр',  'Лосось на гриле ');
INSERT INTO public.products (id, created_by,  cost, description,  title) VALUES (8, 'MANAGER',  920, 'Форель на гриле 280гр пикантный',  'Форель на гриле пикантный');
INSERT INTO public.products (id, created_by,  cost, description,  title) VALUES (3, 'MANAGER',  400, 'Шашлык из телятины 100гр',  'Шашлык из телятины ');
INSERT INTO public.products (id, created_by,  cost, description, title) VALUES (5, 'MANAGER',  380, 'Шашлык из баранины 100гр',   'Шашлык из баранины ');
INSERT INTO public.products (id, created_by,  cost, description, title) VALUES (4, 'MANAGER',  200, 'Шашлык куринный 100гр',  'Шашлык куринный ');