package com.hsryuuu.eventus_core.user;

import com.hsryuuu.eventus_core.user.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID> {
}
