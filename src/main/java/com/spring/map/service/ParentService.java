package com.spring.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.map.jsonb.Biography;
import com.spring.map.jsonb.Child;
import com.spring.map.jsonb.Parent;
import com.spring.map.repository.ParentRepository;

@Service
public class ParentService 
{
	@Autowired
	ParentRepository parentRepository;
	
	public Parent createNew(Parent parent) 
	{
		return parentRepository.save(parent);
		
	}

//	public Parent read()
//	{
//		return parentRepository.save(new Parent("Parent-A","Coimbatore",asList(new Child("Child-A","Erode"), new Child("Child-B","Tirupur")), 
//				new Biography("Coimbatore","Parent A Has 2 Childrens")
//				)
//				);
//	}
//
//	private List<Child> asList(Child child, Child child2) 
//	{
//		return null;
//	}
}
