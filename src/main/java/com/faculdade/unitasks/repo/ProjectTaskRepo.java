package com.faculdade.unitasks.repo;

import com.faculdade.unitasks.models.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTaskRepo extends JpaRepository<ProjectTask, Long> {
}
