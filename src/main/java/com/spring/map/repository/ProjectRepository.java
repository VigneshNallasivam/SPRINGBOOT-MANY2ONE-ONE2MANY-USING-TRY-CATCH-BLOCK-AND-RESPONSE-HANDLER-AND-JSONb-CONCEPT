package com.spring.map.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.map.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

	@Query("SELECT d FROM Project d")
	Page<Project> findAllByPagination(Pageable pageable);

}
