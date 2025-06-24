package com.hsryuuu.eventus.appllication.security;

import com.hsryuuu.eventus.appllication.security.principal.AuthPrincipal;
import com.hsryuuu.eventus.user.appuser.UserRole;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static AuthPrincipal getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof AuthPrincipal principal) {
            return principal;
        }
        return null;
    }

    public static boolean isOwnerUser(@Nullable AuthPrincipal authPrincipal) {
        if (authPrincipal == null) {
            return false;
        }
        return authPrincipal.getUserRole().equals(UserRole.OWNER) || authPrincipal.getUserRole().equals(UserRole.ADMIN);
    }
}
