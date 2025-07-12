CREATE TABLE task
(
    id         UUID PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    type       VARCHAR(20)  NOT NULL,
    status     VARCHAR(20)  NOT NULL,
    start_at   TIMESTAMP,
    due_at     TIMESTAMP,
    priority   VARCHAR(20),
    created_at TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at TIMESTAMP    NOT NULL DEFAULT now(),
    creator_id UUID         NOT NULL,
    properties JSONB
);

-- 외래 키 (AppUser 테이블이 존재한다고 가정)
ALTER TABLE task
    ADD CONSTRAINT fk_task_user
        FOREIGN KEY (creator_id) REFERENCES app_user (id);