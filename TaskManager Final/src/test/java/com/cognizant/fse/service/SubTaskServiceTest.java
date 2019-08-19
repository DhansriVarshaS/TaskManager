package com.cognizant.fse.service;

import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.fse.dto.TaskDTO;
import com.cognizant.fse.eo.ParentTaskEO;
import com.cognizant.fse.eo.ProjectEO;
import com.cognizant.fse.eo.TaskEO;
import com.cognizant.fse.eo.UserEO;
import com.cognizant.fse.repository.SubTaskRepository;
import com.cognizant.fse.service.SubTaskService;

public class SubTaskServiceTest {

	@InjectMocks
	private SubTaskService taskService;

	@Mock
	private SubTaskRepository taskRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void validate() {
		validateMockitoUsage();
	}

	@Test
	public void updateTaskTest() throws ParseException {

		TaskEO t = new TaskEO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		Date dateTwo = sdf.parse(startDate);
		TaskEO temp = new TaskEO(1, dateOne, dateTwo, 1, "STARTED");

		when(taskRepo.findOne(123)).thenReturn(temp);
		t.setTask(temp.getTask());
		t.setStartDate(temp.getStartDate());
		t.setEndDate(temp.getEndDate());
		t.setPriority(temp.getPriority());
		t.setStatus(temp.getStatus());
		taskRepo.save(t);
	}

	@Test
	public void getTasksByProjectTest() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);

		List<TaskEO> taskList = new ArrayList<>();
		when(taskRepo.findAll()).thenReturn(taskList);

	}

	@Test
	public void addNewTaskTest() throws ParseException

	{

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		Date dateTwo = sdf.parse(startDate);

		TaskDTO task = new TaskDTO();

		TaskEO t = new TaskEO(12, dateOne, dateTwo, 1, "STARTED");
		taskService.addNewTask(task);

	}

	@Test
	public void addNewTaskTest2() {

		ParentTaskEO pTask = new ParentTaskEO();
		pTask.setParentTask("task");
		TaskDTO task = new TaskDTO();
		taskService.addNewTask(task);

	}

	@Test

	public void getAllTasksTest() throws ParseException {
		List<TaskDTO> taskObjList = new ArrayList<>();
		List<TaskEO> taskList = new ArrayList<>(Arrays.asList(new TaskEO()));
		taskList.get(0).setUser(new UserEO());
		taskList.get(0).setProject(new ProjectEO());
		when(taskRepo.findAll()).thenReturn(taskList);
		when(taskService.getAllTasks()).thenReturn(taskObjList);
	}
}
