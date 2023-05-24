package com.spring.map.response;

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
public class Message 
{
	private String message;
	private Object object;
	public Message(String message)
	{
		this.message = message;
	}
}
