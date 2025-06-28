package com.hsryuuu.eventus.user.owner;

import com.hsryuuu.eventus.user.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {
}
