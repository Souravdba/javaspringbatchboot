package com.swasou.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.swasou.listener.JobCompleteListner;
import com.swasou.steps.Reader;
import com.swasou.steps.Writer;
import com.swasou.steps.processor;

@Configuration
@EnableBatchProcessing
public class Batchconfig {

	@Autowired
	public JobBuilderFactory jobbuilder;
	
	@Autowired
	public StepBuilderFactory stepBuilder;

	
	
	@Bean
	public Job processJob() {
		return  jobbuilder.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listner())
				.flow(orderstep()).end().build();
	}
	
    @Bean 
	public Step orderstep()
	{
		return  stepBuilder.get("step1").<String,String> chunk(1)
				.reader(new Reader())
				.processor(new processor())
				.writer(new Writer()).build();
				
		
	}
	@Bean
	public JobExecutionListener listner()
	{
		return new JobCompleteListner();
		
	}
}
