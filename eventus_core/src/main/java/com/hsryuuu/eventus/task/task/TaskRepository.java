package com.hsryuuu.eventus.task.task;

import com.hsryuuu.eventus.task.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    boolean existsByParentId(UUID parentId);

    List<Task> findByCreatorId(UUID creatorId);
}
