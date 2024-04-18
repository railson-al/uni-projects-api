package com.faculdade.unitasks.services;

import com.faculdade.unitasks.exceptions.project.ProjectNotFoundException;
import com.faculdade.unitasks.models.Project;
import com.faculdade.unitasks.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> list() {
        return projectRepo.findAll();
    }

    public Project create(Project project) {
        return projectRepo.save(project);
    }

    public Project update(Long id, Project updatedProject) {

        Optional<Project> optionalProject = projectRepo.findById(id);
        if (optionalProject.isEmpty()) {
            throw new ProjectNotFoundException("Project ID: "+id+" not found!");
        }

        Project project = optionalProject.get();
        project.setTitle(updatedProject.getTitle());
        project.setDescription(updatedProject.getDescription());
        project.setStartDate(updatedProject.getStartDate());
        project.setEndDate(updatedProject.getEndDate());
        project.setDeadline(updatedProject.getDeadline());
        project.setStatus(updatedProject.getStatus());
        project.setIsActive(updatedProject.getIsActive());

        return projectRepo.save(project);
    }

    public void delete(Long id){


        if (!projectRepo.existsById(id)) {
            throw new ProjectNotFoundException("Project ID: "+id+" not found!");
        }

        projectRepo.deleteById(id);
    }

}
