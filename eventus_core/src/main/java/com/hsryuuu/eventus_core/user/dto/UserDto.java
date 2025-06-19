package com.hsryuuu.eventus_core.user.dto;

import com.hsryuuu.eventus_core.user.UserRole;
import com.hsryuuu.eventus_core.user.entity.AppUser;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

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
