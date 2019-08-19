package com.cognizant.fse.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.fse.controller.UserTabController;
import com.cognizant.fse.eo.UserEO;
import com.cognizant.fse.service.UserTabService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@WebMvcTest(value=UserTabController.class,secure = false)
public class UserTabControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserTabService userService;
	
	@Test
	public void testAddNewUser() throws Exception {
		
		UserEO mockUser =new UserEO();
		mockUser.setFirstName("shoban");
		mockUser.setLastName("vk");
		mockUser.setEmployeeId("1");
		
		String inputInJson = this.mapToJson(mockUser);
		
		String URI = "/user/add";
		
		Mockito.when(userService.addNewUser(Mockito.any(UserEO.class))).thenReturn(mockUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	}
	
	@Test
	public void testGetAllUsers() throws Exception{
		
		UserEO mockUser =new UserEO();
		mockUser.setFirstName("shobana");
		mockUser.setLastName("vk");
		mockUser.setEmployeeId("1");
		
	
		
		List<UserEO> userList = new ArrayList<UserEO>();
		userList.add(mockUser);
		
		
		Mockito.when(userService.findAll()).thenReturn(userList);
		
		String URI = "/user/all";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(userList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	@Test
	public void updateUserTest() throws Exception{
		
		UserEO mockUser =new UserEO();
		UserEO user =new UserEO();
		mockUser.setFirstName("shobana");
		mockUser.setLastName("vk");
		mockUser.setEmployeeId("1");
		
		
			
		Mockito.when(userService.updateUser(user)).thenReturn(mockUser);
		
		
		
		
		String URI = "/user/update";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(mockUser);
		String outputInJson = result.getResponse().getContentAsString();
		//assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}
