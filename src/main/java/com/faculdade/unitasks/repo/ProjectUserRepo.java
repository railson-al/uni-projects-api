package com.faculdade.unitasks.repo;

import com.faculdade.unitasks.models.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectUserRepo extends JpaRepository<ProjectUser, Long> {
}
