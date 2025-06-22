create table event
(
    id          uuid not null primary key,
    creatorType varchar(255),
    title       varchar(255),
    description varchar(255),
    event_type  varchar(255),
    owner_id    uuid,
    start_time  timestamp,
    end_time    timestamp,
    created_at  timestamp,
    updated_at  timestamp
);

alter table event
    owner to root;

create table event_condition
(
    id             uuid not null
        primary key,
    condition_type varchar(255),
    value          varchar(255),
    event_id       uuid
        constraint event_condition_event_id_fk
            references event
);

alter table event_condition
    owner to root;
