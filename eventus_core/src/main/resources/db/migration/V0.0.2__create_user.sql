create table app_user
(
    id               uuid not null
        primary key,
    created_at       timestamp,
    email            varchar(255),
    last_modified_at timestamp,
    nickname         varchar(255),
    password         varchar(255),
    phone            varchar(255),
    role             varchar(255),
    username         varchar(255)
);

alter table app_user
    owner to root;