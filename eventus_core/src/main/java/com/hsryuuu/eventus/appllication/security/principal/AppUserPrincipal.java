package com.hsryuuu.eventus.appllication.security.principal;

import com.hsryuuu.eventus.member.appuser.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class AppUserPrincipal implements AuthPrincipal, UserDetails {

    private final UUID id;
    private final String username;
    private final UserRole userRole;
    private final List<GrantedAuthority> authorities;


    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public UserRole getUserRole() {
        return this.userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
