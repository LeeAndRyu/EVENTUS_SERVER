package com.hsryuuu.eventus.user.appuser;

import com.hsryuuu.eventus.user.appuser.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID> {
    boolean existsByUsername(String username);
}
