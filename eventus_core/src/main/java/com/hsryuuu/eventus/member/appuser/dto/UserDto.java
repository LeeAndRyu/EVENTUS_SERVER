package com.hsryuuu.eventus.member.appuser.dto;

import com.hsryuuu.eventus.member.appuser.UserRole;
import com.hsryuuu.eventus.member.appuser.entity.AppUser;
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
    private UserRole role;
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
                .role(appUser.getRole())
                .nickname(appUser.getNickname())
                .phone(appUser.getPhone())
                .createdAt(appUser.getCreatedAt())
                .lastModifiedAt(appUser.getLastModifiedAt())
                .build();
    }
}
