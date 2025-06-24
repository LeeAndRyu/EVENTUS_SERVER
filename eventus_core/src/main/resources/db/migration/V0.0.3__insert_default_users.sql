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
        'super-user',
        now(),
        now());

insert into owner (id,
                   username,
                   password,
                   business_name,
                   email,
                   phone,
                   created_at,
                   last_modified_at)
values ('00000000-0000-0000-0000-000000000001',
        'SuperOwnerUser',
        'password123', -- 실제 사용 시에는 암호화 필요
        'SuperUser 사업자',
        'owner@example.com',
        '010-0000-0000',
        now(),
        now());