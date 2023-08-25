package com.swasou.steps;

import org.springframework.batch.item.ItemProcessor;

public class processor implements ItemProcessor<String, String>{

	@Override
	public String process(String data) throws Exception {
		// TODO Auto-generated method stub
		return data.toUpperCase();
	}

}
