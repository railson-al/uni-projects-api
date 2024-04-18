package com.faculdade.unitasks.controllers;

import com.faculdade.unitasks.models.Project;
import com.faculdade.unitasks.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<List<Project>> list() {
        List<Project> projects = projectService.list();
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/")
    public ResponseEntity<Project> create(@Validated @RequestBody Project project) {
        Project newProject = projectService.create(project);
        return ResponseEntity.ok(newProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@Validated @RequestBody Project project, @PathVariable Long id) {
        Project updatedProject = projectService.update(id, project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
