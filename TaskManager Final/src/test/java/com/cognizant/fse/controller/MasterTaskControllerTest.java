package com.cognizant.fse.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.fse.controller.MasterTaskController;
import com.cognizant.fse.eo.ParentTaskEO;
import com.cognizant.fse.service.MasterTaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=MasterTaskController.class,secure = false)
public class MasterTaskControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MasterTaskService parentService;
	
	@Test
	public void testGetAllUsers() throws Exception{
		
		ParentTaskEO mockParent=new ParentTaskEO();
		mockParent.setParentTask("First");
		List<ParentTaskEO> userList = new ArrayList<ParentTaskEO>();
		userList.add(mockParent);
		
		
		Mockito.when(parentService.getAllUsers()).thenReturn(userList);
		
		String URI = "/parenttask/all";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(userList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	
	@Test
	public void testAddNewParentTask() throws Exception {		
	 
	         
	  ParentTaskEO ptask = new ParentTaskEO();  		
		String task="taskName";
		ptask.setParentTask(task);		
		String inputInJson = this.mapToJson(task);
		
		String URI = "/parenttask/add";
		
		Mockito.when(parentService.addNew(task)).thenReturn(ptask);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		//assertThat(outputInJson).isEqualTo(inputInJson);
		//assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	}
}
