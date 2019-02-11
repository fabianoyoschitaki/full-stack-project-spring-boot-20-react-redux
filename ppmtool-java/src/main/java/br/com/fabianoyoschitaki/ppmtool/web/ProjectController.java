package br.com.fabianoyoschitaki.ppmtool.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabianoyoschitaki.ppmtool.domain.Project;
import br.com.fabianoyoschitaki.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(
		@Valid @RequestBody Project project, BindingResult result){
		
		if (result.hasErrors()) {
//			return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
//			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
			
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<Project>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
	}
}
