create table roles
(
    id          bigint not null
        constraint roles_pkey
            primary key,
    description varchar(255),
    title       varchar(255)
);

alter table roles
    owner to postgres;

INSERT INTO public.roles (id, description, title) VALUES (1, 'admin', 'admin');
INSERT INTO public.roles (id, description, title) VALUES (2, 'user', 'user');
INSERT INTO public.roles (id, description, title) VALUES (3, 'manager', 'manager');