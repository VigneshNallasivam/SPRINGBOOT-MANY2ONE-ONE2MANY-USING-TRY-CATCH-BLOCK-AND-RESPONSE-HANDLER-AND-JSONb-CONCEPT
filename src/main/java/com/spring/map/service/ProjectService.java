package com.spring.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.map.model.Department;
import com.spring.map.model.Project;
import com.spring.map.repository.ProjectRepository;

@Service
public class ProjectService 
{
	@Autowired
	ProjectRepository projectRepository;

	public Project create(Project Project) 
	{
		return projectRepository.save(Project);	
	}

	public Project update(Long id,Project Project) throws Exception 
	{
		Project Project2 = projectRepository.findById(id).get();
		if(projectRepository.findById(id).isPresent())
		{
			Project2.setCustomerName(Project.getCustomerName());
			Project2.setTechnology(Project.getTechnology());
			Project2.setBudjet(Project.getBudjet());
			Project2.setDuration(Project.getDuration());
			projectRepository.save(Project2);
			return Project2;
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}
		
	}

	public Page<Project> read(Pageable pageable) 
	{
		
		return projectRepository.findAllByPagination(pageable);
		
	}

	public void delete(Long id) throws Exception
	{
		if(projectRepository.findById(id).isPresent())
		{
			projectRepository.deleteById(id);
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}

	}

}
