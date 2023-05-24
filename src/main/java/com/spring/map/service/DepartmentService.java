package com.spring.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.map.model.Department;
import com.spring.map.repository.DepartmentRepository;

@Service
public class DepartmentService 
{
	@Autowired
	DepartmentRepository departmentRepository;

	public Department create(Department department) 
	{
		return departmentRepository.save(department);	
	}

	public Department update(Long id,Department department) throws Exception 
	{
		Department department2 = departmentRepository.findById(id).get();
		if(departmentRepository.findById(id).isPresent())
		{
			department2.setDeptName(department.getDeptName());
			department2.setDeptStrength(department.getDeptStrength());
			department2.setDeptLocation(department.getDeptLocation());
			departmentRepository.save(department2);
			return department2;
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}
		
	}

	public Page<Department> read(Pageable pageable) throws Exception 
	{
		return departmentRepository.findAllByPagination(pageable);
	}

	public void delete(Long id) throws Exception
	{
		if(departmentRepository.findById(id).isPresent())
		{
			departmentRepository.deleteById(id);
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}

	}

}
