insert into app_user (id,
                      email,
                      nickname,
                      phone,
                      password,
                      role,
                      username,
                      created_at,
                      last_modified_at)
values ('00000000-0000-0000-0000-000000000001',
        'super-user@example.com',
        'SuperUser',
        '010-0000-0000',
        'password123', -- 실제 사용 시 암호화 필요
        'ADMIN',
        'SuperUser',
        now(),
        now());