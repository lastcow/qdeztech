package me.chen.eztech.services;


import me.chen.eztech.models.Project;
import me.chen.eztech.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    /**
     * Create new project
     * @param project
     * @return
     */
    public Project save(Project project){
        return projectRepository.save(project);
    }

    /**
     * Get project by project id (flowable project id)
     * @param projectId
     * @return
     */
    public Project getProjectById(String projectId) { return projectRepository.getProjectByProjectId(projectId);}

    public void assignStudentToProject(String studentId, String projectId){
        Project project = getProjectById(projectId);
        project.setStudentId(studentId);
        projectRepository.save(project);
    }
}
