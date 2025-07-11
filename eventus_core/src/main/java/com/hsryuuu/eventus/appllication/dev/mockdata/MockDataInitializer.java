package com.hsryuuu.eventus.appllication.dev.mockdata;

import com.hsryuuu.eventus.appllication.dev.constants.DevConstants;
import com.hsryuuu.eventus.user.appuser.UserRepository;
import com.hsryuuu.eventus.user.appuser.entity.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 개발용 mock data init
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class MockDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        this.createUser();
    }

    private void createUser() {
        if (!userRepository.existsByUsername(DevConstants.USERNAME_HSRYU)) {
            AppUser admin1 = AppUser.builder()
                    .username(DevConstants.USERNAME_HSRYU)
                    .password(DevConstants.USERNAME_HSRYU)
                    .email("happyhsryu@gmail.com")
                    .nickname("ADMIN-hsryuuuu")
                    .phone("010-0000-0000")
                    .build();
            userRepository.save(admin1);
        }
        if (!userRepository.existsByUsername(DevConstants.USERNAME_OLUZR)) {
            AppUser admin2 = AppUser.builder()
                    .username(DevConstants.USERNAME_OLUZR)
                    .password(DevConstants.USERNAME_OLUZR)
                    .email("oluzr@gmail.com")
                    .nickname("ADMIN-oluzr")
                    .phone("010-0000-0000")
                    .build();
            userRepository.save(admin2);
        }
    }
}
