package com.cognizant.fse.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.cognizant.fse.controller.ProjectTabController;
import com.cognizant.fse.dto.ProjectDTO;
import com.cognizant.fse.service.ProjectTabService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value=ProjectTabController.class,secure = false)
public class ProjectTabControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProjectTabService projectService;
	
	final Date date = Mockito.mock(Date.class);
	
	@Test
	public void testAddProject() throws Exception {
		
		ProjectDTO mockProject = new ProjectDTO();
		
		mockProject.setProjectName("UI");
		mockProject.setStartDate(date);
		mockProject.setEndDate(date);
		mockProject.setPriority(10);
		mockProject.setUserId(01);
		
		
		String inputInJson = this.mapToJson(mockProject);
		
		String URI = "/project/add";
		
		Mockito.when(projectService.addProject(Mockito.any(ProjectDTO.class))).thenReturn(mockProject);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		
	
	}
	
	@Test
	public void testGetAllProject() throws Exception{
		
		ProjectDTO mockProject = new ProjectDTO();
		
		mockProject.setProjectName("UI");
		mockProject.setStartDate(date);
		mockProject.setEndDate(date);
		mockProject.setPriority(10);
		mockProject.setUserId(01);
		
	
		
		List<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
		projectList.add(mockProject);
		
		
		Mockito.when(projectService.getAllProject()).thenReturn(projectList);
		
		String URI = "/project/all";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(projectList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	
	@Test
	public void updateProjectTest() throws Exception{
		
		ProjectDTO mockProject = new ProjectDTO();
		
		mockProject.setProjectName("UI");
		mockProject.setStartDate(date);
		mockProject.setEndDate(date);
		mockProject.setPriority(10);
		mockProject.setUserId(01);
		
	
		
		List<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
		projectList.add(mockProject);
		
		
		Mockito.when(projectService.getAllProject()).thenReturn(projectList);
		
		String URI = "/project/update";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	}
	
	/*@Test
	public void updateEmployeeAPI() throws Exception 
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		  String startDate = "15-10-2015";
		  Date dateOne = sdf.parse(startDate);
		  
		  SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		  String endDate = "15-10-2015";
		  Date dateTwo = sdf.parse(startDate);
		 
	  mockMvc.perform( MockMvcRequestBuilders
	      .put("/project/update")
	      .content(mapToJson(new ProjectObj(2, "name", dateOne,dateTwo,12,123,78,"manager",1)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.projectId").value(2))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.projectName").value("name"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value(dateOne))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value(endDate))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.priority").value(12))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.taskNumber").value(123))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.completedTaskNumber").value(78))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.manager").value("manager"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(1));
	}*/
	/*public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}*/
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	

	@Test
	public void gettersSetterTest() throws ParseException
	{
	//Integer projectId, String projectName, Date startDate, Date endDate, Integer priority,
				//Integer taskNumber, Integer completedTaskNumber, String manager, Integer userId)
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		  String startDate = "15-10-2015";
		  Date dateOne = sdf.parse(startDate);
		  
		  SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		  String endDate = "15-10-2015";
		  Date dateTwo = sdf.parse(startDate);
		
		ProjectDTO proj = new ProjectDTO(2L, "name", dateOne,dateTwo,12,123,78L,"manager",1);

		
		ProjectDTO project = new ProjectDTO();
		project.setProjectId(5L);
		project.getProjectId();
		project.getProjectName();
		project.setProjectName("proj");
		project.setStartDate(dateTwo);
		project.getStartDate();
		project.setEndDate(dateTwo);
		project.getEndDate();
		project.setPriority(20);
		project.getPriority();
		project.setTaskNumber(11);
		project.getTaskNumber();
		project.setUserId(12);
		project.getUserId();
		
		}

	
}
