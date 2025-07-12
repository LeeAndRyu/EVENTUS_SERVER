package com.hsryuuu.eventus.user.appuser.dto;

import com.hsryuuu.eventus.user.appuser.entity.AppUser;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    public static UserDto from(AppUser appUser) {
        return UserDto.builder()
                .id(appUser.getId())
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .email(appUser.getEmail())
                .nickname(appUser.getNickname())
                .phone(appUser.getPhone())
                .createdAt(appUser.getCreatedAt())
                .lastModifiedAt(appUser.getLastModifiedAt())
                .build();
    }
}
