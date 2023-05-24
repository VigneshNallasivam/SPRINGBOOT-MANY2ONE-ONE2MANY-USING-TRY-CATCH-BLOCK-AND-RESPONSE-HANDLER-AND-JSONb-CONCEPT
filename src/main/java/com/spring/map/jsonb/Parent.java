package com.spring.map.jsonb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

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
@Table(name="parent_table")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Parent implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long parentId;
	private String parentName;
	private String parentLocation;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Child> children;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Biography biography;
    
    public Parent(String parentName,String parentLocation, List<Child> children, Biography biography)
    {
        this.parentName = parentName;
        this.parentLocation = parentLocation;
        this.children = children;
        this.biography = biography;
    }
}
