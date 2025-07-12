package com.hsryuuu.eventus.appllication.security;

import com.hsryuuu.eventus.appllication.security.principal.AuthPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public class SecurityUtils {

    public static AuthPrincipal getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof AuthPrincipal principal) {
            return principal;
        }
        return null;
    }

    public static Optional<UUID> getCurrentUserId() {
        AuthPrincipal currentUser = getCurrentUser();

        if (currentUser != null) {
            return Optional.of(currentUser.getId());
        }
        return Optional.empty();
    }


}
