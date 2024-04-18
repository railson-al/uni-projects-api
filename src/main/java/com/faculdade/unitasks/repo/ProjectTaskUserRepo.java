package com.faculdade.unitasks.repo;

import com.faculdade.unitasks.models.ProjectTaskUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTaskUserRepo extends JpaRepository<ProjectTaskUser, Long> {
}
