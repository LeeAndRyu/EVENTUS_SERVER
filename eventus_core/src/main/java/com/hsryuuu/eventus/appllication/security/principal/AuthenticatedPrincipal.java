package com.hsryuuu.eventus.appllication.security.principal;

import com.hsryuuu.eventus.user.appuser.UserRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AuthenticatedPrincipal extends UserDetails {
    UUID getId();

    UserRole getUserRole();
}
