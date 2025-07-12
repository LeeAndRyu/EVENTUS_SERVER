create table app_user
(
    id               uuid not null primary key,
    email            varchar(255),
    nickname         varchar(255),
    password         varchar(255),
    phone            varchar(255),
    role             varchar(255),
    username         varchar(255),
    created_at       timestamp,
    last_modified_at timestamp
);

alter table app_user
    owner to root;