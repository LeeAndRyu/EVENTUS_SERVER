package com.hsryuuu.eventus.appllication.security;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.GlobalException;
import com.hsryuuu.eventus.appllication.security.principal.AuthPrincipal;
import com.hsryuuu.eventus.member.appuser.UserRole;
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

    public static boolean isUserHasRole(@Nullable AuthPrincipal user, UserRole requiredRole) {
        if (user == null) return false;
        UserRole actualRole = user.getUserRole();

        return actualRole == UserRole.ADMIN || actualRole == requiredRole;
    }


    public static void assertCurrentUserRole(UserRole requiredRole) {
        AuthPrincipal currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new GlobalException(ErrorCode.UNAUTHORIZED);
        }
        if (!isUserHasRole(currentUser, requiredRole)) {
            throw new GlobalException(ErrorCode.FORBIDDEN);
        }
    }
}
