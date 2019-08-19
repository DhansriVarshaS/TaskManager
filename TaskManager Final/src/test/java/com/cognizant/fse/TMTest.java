package com.cognizant.fse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.fse.TMApplication;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TMTest {

	@Test
	public void contextLoads() {
	}

	
	@Test
	   public void main() {
		TMApplication.main(new String[] {});
	   }
	
	@Test
	public void configueTest() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder();
			
			 builder.sources(TMApplication.class);	
	}
	
}