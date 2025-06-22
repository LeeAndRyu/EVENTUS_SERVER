package com.hsryuuu.eventus.appllication.security;

import com.hsryuuu.eventus.appllication.dev.constants.DevConstants;
import com.hsryuuu.eventus.appllication.security.principal.AppUserPrincipal;
import com.hsryuuu.eventus.appllication.security.principal.AuthenticatedPrincipal;
import com.hsryuuu.eventus.user.appuser.UserRole;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BypassAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 이미 인증된 사용자가 없을 경우만 주입
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            this.setAllAuthorizedUser();
        }

        filterChain.doFilter(request, response);
    }

    private void setAllAuthorizedUser() {
        List<GrantedAuthority> allUserAuthorities = this.getAllUserAuthorities();

        AuthenticatedPrincipal principal = new AppUserPrincipal(
                UUID.randomUUID(),
                DevConstants.ADMIN_USER_NAME,
                UserRole.ADMIN,
                allUserAuthorities);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal, null, principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private List<GrantedAuthority> getAllUserAuthorities() {
        List<GrantedAuthority> allAuthorities = new ArrayList<>();
        for (UserRole value : UserRole.values()) {
            allAuthorities.add(new SimpleGrantedAuthority("ROLE_" + value.name()));
        }
        return allAuthorities;
    }
}
