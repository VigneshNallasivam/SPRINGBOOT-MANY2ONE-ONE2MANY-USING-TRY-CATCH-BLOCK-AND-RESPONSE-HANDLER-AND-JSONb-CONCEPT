package com.spring.map.jsonb;



import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Child implements Serializable
{
	private String childName;
	private String childLocation;
	
	public Child(String childName, String childLocation) 
	{
		this.childName = childName;
		this.childLocation = childLocation;
	}
	
}

