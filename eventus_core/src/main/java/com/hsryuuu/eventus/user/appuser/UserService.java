package com.hsryuuu.eventus.user.appuser;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.GlobalException;
import com.hsryuuu.eventus.user.appuser.dto.UserDto;
import com.hsryuuu.eventus.user.appuser.entity.AppUser;
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
