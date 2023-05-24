package com.spring.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.map.jsonb.Parent;
import com.spring.map.service.ParentService;

@RestController
@RequestMapping("/parent")
public class ParentController
{
	@Autowired
	ParentService parentService;
	
	@GetMapping("/parent")
	public Parent getJSON_POJO()
	{
		Parent parent = new Parent();
		return parent;
	}
	
	@PostMapping("/parentNewPost")
	public Parent createNew(@RequestBody Parent parent)
	{
         Parent parent1 = parentService.createNew(parent);	
         return parent1;
	}
	
//	@GetMapping("/parentGet")
//	public Parent read()
//	{
//		return parentService.read();
//		
//	}
}
