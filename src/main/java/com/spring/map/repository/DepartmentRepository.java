package com.spring.map.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.map.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> 
{
	
    @Query("SELECT d FROM Department d")
	Page<Department> findAllByPagination(Pageable pageable); 

}
