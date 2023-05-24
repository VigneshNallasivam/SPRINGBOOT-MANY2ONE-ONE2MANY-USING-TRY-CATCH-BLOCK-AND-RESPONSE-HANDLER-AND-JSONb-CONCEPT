package com.spring.map.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="department_table")
public class Department 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "dept_strength")
	private String deptStrength;
	
	@Column(name = "dept_location")
	private String deptLocation;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Project> projectList;
}