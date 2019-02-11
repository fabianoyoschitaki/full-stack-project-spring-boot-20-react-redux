package br.com.fabianoyoschitaki.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabianoyoschitaki.ppmtool.domain.Project;
import br.com.fabianoyoschitaki.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		
		//Logic 
		
		return projectRepository.save(project);
	}
}
