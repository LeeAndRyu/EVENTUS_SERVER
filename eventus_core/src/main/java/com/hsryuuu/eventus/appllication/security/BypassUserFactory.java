package com.hsryuuu.eventus.appllication.security;

import com.hsryuuu.eventus.appllication.dev.constants.DevConstants;
import com.hsryuuu.eventus.appllication.security.principal.AppUserPrincipal;
import com.hsryuuu.eventus.appllication.security.principal.AuthPrincipal;
import com.hsryuuu.eventus.user.appuser.type.UserRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BypassUserFactory {

    public static Authentication getAllAuthorizedAuthentication() {
        List<GrantedAuthority> allUserAuthorities = getAllUserAuthorities();

        AuthPrincipal principal = new AppUserPrincipal(
                UUID.fromString(DevConstants.DEFAULT_UUID_ID),
                DevConstants.SUPER_USER_NAME,
                allUserAuthorities);

        return new UsernamePasswordAuthenticationToken(
                principal, null, principal.getAuthorities()
        );
    }

    public static List<GrantedAuthority> getAllUserAuthorities() {
        List<GrantedAuthority> allAuthorities = new ArrayList<>();
        for (UserRole value : UserRole.values()) {
            allAuthorities.add(new SimpleGrantedAuthority("ROLE_" + value.name()));
        }
        return allAuthorities;
    }
}
