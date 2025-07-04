package com.hsryuuu.eventus.appllication.security.principal;

import com.hsryuuu.eventus.member.appuser.UserRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AuthPrincipal extends UserDetails {
    UUID getId();

    UserRole getUserRole();
}
