package com.spring.map.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "technology")
	private String technology;
	
	@Column(name = "budjet")
	private double budjet;
	
	@Column(name = "duration")
	private String duration;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="department_id")
	@JsonBackReference
    private Department department;
}
