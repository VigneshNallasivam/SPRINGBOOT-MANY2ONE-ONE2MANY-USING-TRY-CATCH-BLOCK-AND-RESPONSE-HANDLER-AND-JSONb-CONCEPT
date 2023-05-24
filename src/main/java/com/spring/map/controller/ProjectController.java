package com.spring.map.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.map.model.Project;
import com.spring.map.response.Message;
import com.spring.map.response.Response;
import com.spring.map.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController
{
	Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectService;

	@GetMapping("/project")
	public Project getJSON_POJO()
	{
		Project project = new Project(); 
		return project;
	}

	@PostMapping("/projectPost")
	public ResponseEntity<Object> create(@RequestBody Project project)
	{
		try
		{
			Project project2 = projectService.create(project);
			Message msg = new Message("DATA CREATED..!!",project2);
			return Response.generateResponse("Data Creation = Success",true,HttpStatus.CREATED, msg);
		}
		catch(Exception ex)
		{
			logger.error("Error while Create all category data: {}", ex.getMessage());
			return Response.generateResponse("Check Server Error..!!",false,HttpStatus.BAD_REQUEST,null);
		}
	}

	@PutMapping("/projectPut")
	public ResponseEntity<Object> update(Long id,@RequestBody Project project)
	{
		try
		{
			Project project2 = projectService.update(id,project);
			Message msg = new Message("DATA UPDATED..!!",project2);
			return Response.generateResponse("Data Updation = Success",true,HttpStatus.CONTINUE, msg);
		}
		catch(Exception ex)
		{
			logger.error("Error while Update all category data: {}", ex.getMessage());
			return Response.generateResponse("Check Server Error..!!",false,HttpStatus.BAD_REQUEST,null);
		}
	}

	@GetMapping("/projectGet")
	public ResponseEntity<Object> read(@PageableDefault(size = 10, page = 0, sort = "id", direction = Direction.ASC) Pageable pageable)
	{
		try
		{
			Page<Project> projectList = projectService.read(pageable);
			Message message = new Message("Data Readed..!!",projectList);
			return Response.generateResponse("Data Reading = Success",true,HttpStatus.FOUND, message);
		}
		catch (Exception ex)
		{
			logger.error("Error while get all category data: {}", ex.getMessage());
			return Response.generateResponse("Check Server Error..!!",false,HttpStatus.BAD_GATEWAY,null);
		}
	}

	@DeleteMapping("/projectDelete")
	public ResponseEntity<Object> delete(Long id)
	{
		try
		{
			projectService.delete(id);
			Message message = new Message("Data Deleted..!!");
			return Response.generateResponse("Data Deletion = Success",true,HttpStatus.GONE, message);
		}
		catch(Exception ex)
		{
			logger.error("Error while Delete category data: {}", ex.getMessage());
			return Response.generateResponse("Check Client/Server Error..!!",false,HttpStatus.BAD_GATEWAY,null);
		}
	}

}
