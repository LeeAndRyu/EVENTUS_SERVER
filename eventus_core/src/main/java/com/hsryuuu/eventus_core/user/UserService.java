package com.hsryuuu.eventus_core.user;

import com.hsryuuu.eventus_core.appllication.exception.ErrorCode;
import com.hsryuuu.eventus_core.appllication.exception.GlobalException;
import com.hsryuuu.eventus_core.user.dto.UserDto;
import com.hsryuuu.eventus_core.user.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;


    public UserDto getUser(UUID id) {
        AppUser user = userRepository.findById(id).orElseThrow(() -> new GlobalException(ErrorCode.NOT_FOUND));
        return UserDto.from(user);

    }
}
