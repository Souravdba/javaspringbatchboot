package com.swasou.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> arg0) throws Exception {
		// TODO Auto-generated method stub
		for (String string : arg0) {
			System.out.println("Writing the data"+string);
		}
	}

}
