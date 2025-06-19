package com.hsryuuu.eventus_core.appllication.dev.mockdata;

import com.hsryuuu.eventus_core.user.UserRepository;
import com.hsryuuu.eventus_core.user.UserRole;
import com.hsryuuu.eventus_core.user.UserService;
import com.hsryuuu.eventus_core.user.entity.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 개발용 mock data init
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class MockDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        this.createUser();
    }

    private void createUser(){
        AppUser admin1 = AppUser.builder()
                .username("hsryu")
                .password("hsryu")
                .email("happyhsryu@gmail.com")
                .role(UserRole.ADMIN)
                .nickname("ADMIN-hsryuuuu")
                .phone("010-0000-0000")
                .build();
        AppUser admin2 = AppUser.builder()
                .username("oluzr")
                .password("oluzr")
                .email("oluzr@gmail.com")
                .role(UserRole.ADMIN)
                .nickname("ADMIN-oluzr")
                .phone("010-0000-0000")
                .build();

        userRepository.save(admin1);
        userRepository.save(admin2);
    }
}
