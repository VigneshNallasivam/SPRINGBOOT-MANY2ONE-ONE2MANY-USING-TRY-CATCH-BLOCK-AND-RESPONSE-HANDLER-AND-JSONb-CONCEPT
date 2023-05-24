package com.spring.map.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.map.jsonb.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long>
{

	

}
