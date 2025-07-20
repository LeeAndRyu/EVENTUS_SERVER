CREATE TABLE category
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    creator_id UUID         NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at TIMESTAMP    NOT NULL DEFAULT now(),
    CONSTRAINT fk_task_user
        FOREIGN KEY (creator_id) REFERENCES app_user (id)
);

insert into category(id,
                     name,
                     creator_id)
values ('00000000-0000-0000-0000-000000000001', '분류1', '00000000-0000-0000-0000-000000000001');

-- task
CREATE TABLE task
(
    id           UUID PRIMARY KEY,
    parent_id    UUID,
    seq          INTEGER,
    title        VARCHAR(255) NOT NULL,
    is_completed BOOLEAN               default false,
    category_id  UUID,
    start_at     TIMESTAMP,
    due_at       TIMESTAMP,
    priority     VARCHAR(20),
    created_at   TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at   TIMESTAMP    NOT NULL DEFAULT now(),
    creator_id   UUID         NOT NULL,
    CONSTRAINT fk_task_user
        FOREIGN KEY (creator_id) REFERENCES app_user (id),
    CONSTRAINT fk_task_parent
        FOREIGN KEY (parent_id) REFERENCES task (id)
);

-- task detail
CREATE TABLE task_detail
(
    task_id    UUID PRIMARY KEY,
    content    TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    CONSTRAINT fk_task_detail_task FOREIGN KEY (task_id) REFERENCES task (id)
);