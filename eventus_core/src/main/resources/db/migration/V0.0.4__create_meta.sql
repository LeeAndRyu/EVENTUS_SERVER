-- auto-generated definition
create table category
(
    id          uuid not null
        primary key,
    parent_id   uuid
        constraint category_category_parent_id_fk
            references category,
    description text,
    name        varchar(255),
    created_at  timestamp,
    updated_at  timestamp
);

alter table category
    owner to root;