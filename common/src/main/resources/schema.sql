create table if not exists picture_publishing."user"
(
    id       varchar(36) not null
        constraint user_primary_key
            primary key,
    name     text        not null,
    email    text        not null,
    password text        not null
);

alter table picture_publishing."user"
    owner to abdelaziz;

create unique index if not exists email_index
    on picture_publishing."user" (email);

DROP TYPE IF EXISTS category_enum;
CREATE TYPE category_enum AS ENUM ('living thing', 'machine', 'nature');

create table if not exists picture_publishing.picture
(
    id          varchar(36)   not null
        primary key,
    description text,
    category    category_enum not null,
    attachment  bytea         not null,
    state       boolean       not null
);

alter table picture_publishing.picture
    owner to abdelaziz;


