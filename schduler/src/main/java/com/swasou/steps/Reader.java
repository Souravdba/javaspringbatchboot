package com.swasou.steps;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String>{

	private String[] msg={"hi","hello","bye"};
	private int count=0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		if(count<msg.length)
		{
			return msg[count++];
		}
		else
		{
			count=0;
		}
		return null;
	}

}
