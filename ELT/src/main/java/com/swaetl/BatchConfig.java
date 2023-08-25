package com.swaetl;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.swaetl.batch.Reader;
import com.swaetl.batch.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	public JobBuilderFactory jbf;
	
	@Autowired
	public StepBuilderFactory sbf;
	
	@Bean
	public Reader read()
	{
		return new Reader();
	}

	@Bean
	public Writer write()
	{
		return new Writer();
	}
	
	@Bean
	public Step step1()
	{
		return sbf.get("Step1")
				.<Object,Object> chunk(10)
				.reader(read())
				.writer(write())
				.build();
				
	}
	
	@Bean
	public Job job()
	{
		return jbf.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}
	
}

