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

create table owner
(
    id               uuid         not null primary key,
    username         varchar(100) not null unique,
    password         varchar(255) not null,
    business_name    varchar(255),
    email            varchar(255),
    phone            varchar(50),
    created_at       timestamp,
    last_modified_at timestamp
);

alter table owner
    owner to root;