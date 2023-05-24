package com.spring.map.jsonb;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Biography implements Serializable
{
	private String origin;
	private String achievements;
	public Biography(String origin, String achievements) 
	{
		super();
		this.origin = origin;
		this.achievements = achievements;
	}
	

}
