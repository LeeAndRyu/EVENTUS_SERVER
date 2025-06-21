package com.hsryuuu.eventus.appllication.dev.mockdata;

import com.hsryuuu.eventus.user.appuser.UserRepository;
import com.hsryuuu.eventus.user.appuser.UserRole;
import com.hsryuuu.eventus.user.appuser.entity.AppUser;
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

    private void createUser() {
        final String USERNAME_HSRYU = "hsryu";
        final String USERNAME_OLUZR = "oluzr";
        if (!userRepository.existsByUsername(USERNAME_HSRYU)) {
            AppUser admin1 = AppUser.builder()
                    .username(USERNAME_HSRYU)
                    .password(USERNAME_HSRYU)
                    .email("happyhsryu@gmail.com")
                    .role(UserRole.ADMIN)
                    .nickname("ADMIN-hsryuuuu")
                    .phone("010-0000-0000")
                    .build();
            userRepository.save(admin1);
        }
        if (!userRepository.existsByUsername(USERNAME_OLUZR)) {
            AppUser admin2 = AppUser.builder()
                    .username("oluzr")
                    .password("oluzr")
                    .email("oluzr@gmail.com")
                    .role(UserRole.ADMIN)
                    .nickname("ADMIN-oluzr")
                    .phone("010-0000-0000")
                    .build();
            userRepository.save(admin2);
        }
    }
}
