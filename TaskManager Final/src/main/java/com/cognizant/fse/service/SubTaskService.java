package com.cognizant.fse.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fse.dto.TaskDTO;
import com.cognizant.fse.eo.ParentTaskEO;
import com.cognizant.fse.eo.ProjectEO;
import com.cognizant.fse.eo.TaskEO;
import com.cognizant.fse.eo.UserEO;
import com.cognizant.fse.repository.MasterTaskRepository;
import com.cognizant.fse.repository.SubTaskRepository;

@Service
public class SubTaskService {

	@Autowired
	private SubTaskRepository taskRepo;

	@Autowired
	private MasterTaskRepository repo;


	public String addNewTask(TaskDTO task) {
		if (task.isParentTask()) {
			ParentTaskEO pTask = new ParentTaskEO();
			pTask.setParentTask(task.getTaskName());
			repo.save(pTask);
		} else {
			TaskEO t = new TaskEO();
			if (null != task.getParentTaskId()) {
				ParentTaskEO parentTask = new ParentTaskEO();
				parentTask.setParentId(task.getParentTaskId());
				t.setParentTask(parentTask);
			}

			ProjectEO project = new ProjectEO();
			project.setProjectId(task.getProjectId());

			t.setProject(project);
			t.setTask(task.getTaskName());
			t.setStartDate(task.getStartDate());
			t.setEndDate(task.getEndDate());
			t.setPriority(task.getPriority());

			UserEO user = new UserEO();
			user.setUserId(task.getUserId());
			t.setUser(user);
			t.setStatus("STARTED");
			taskRepo.save(t);
		}

		return "Saved";
	}

	public List<TaskDTO> getAllTasks() {
		List<TaskDTO> taskObjList = new ArrayList<>();
		List<TaskEO> taskList = (List<TaskEO>) taskRepo.findAll();
		for (TaskEO t : taskList) {
			TaskDTO obj = new TaskDTO();
			obj.setTaskId(t.getTaskId());
			obj.setTaskName(t.getTask());
			obj.setStartDate(t.getStartDate());
			obj.setEndDate(t.getEndDate());
			obj.setPriority(t.getPriority());
			obj.setStatus(t.getStatus());
			if (null != t.getParentTask()) {
				obj.setParentTaskId(t.getParentTask().getParentId());
				obj.setParentTaskName(t.getParentTask().getParentTask());
			}
			if (null != t.getProject()) {
				obj.setProjectName(t.getProject().getProject());
				obj.setProjectId(t.getProject().getProjectId());
			}
			if (null != t.getUser()) {
				obj.setUserName(t.getUser().getFirstName());
				obj.setUserId(t.getUser().getUserId());
			}

			taskObjList.add(obj);

		}

		return taskObjList;
	}

	public TaskEO updateTask(TaskDTO task) {
		TaskEO t = taskRepo.findOne(task.getTaskId());

		ParentTaskEO parentTask = new ParentTaskEO();
		parentTask.setParentId(task.getParentTaskId());
		t.setParentTask(parentTask);

		ProjectEO project = new ProjectEO();
		project.setProjectId(task.getProjectId());
		t.setProject(project);

		t.setTask(task.getTaskName());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setPriority(task.getPriority());
		t.setStatus(task.getStatus());
		return taskRepo.save(t);
	}

	public Iterable<TaskDTO> getTasksByProject(Long id) {
		List<TaskDTO> taskObjList = new ArrayList<>();
		List<TaskEO> taskList = taskRepo.findAll(Arrays.asList(id.intValue()));
		for (TaskEO t : taskList) {
			TaskDTO obj = new TaskDTO();
			obj.setTaskId(t.getTaskId());

			obj.setTaskName(t.getTask());
			obj.setStartDate(t.getStartDate());
			obj.setEndDate(t.getEndDate());
			obj.setPriority(t.getPriority());
			obj.setStatus(t.getStatus());

			if (null != t.getParentTask()) {
				obj.setParentTaskId(t.getParentTask().getParentId());
				obj.setParentTaskName(t.getParentTask().getParentTask());
			}
			if (null != t.getProject()) {
				obj.setProjectName(t.getProject().getProject());
				obj.setProjectId(t.getProject().getProjectId());
			}
			if (null != t.getUser()) {
				obj.setUserName(t.getUser().getFirstName());
				obj.setUserId(t.getUser().getUserId());
			}

			taskObjList.add(obj);

		}
		return taskObjList;
	}

	public TaskEO endTask(TaskDTO task) {
		TaskEO t = taskRepo.findOne(task.getTaskId());

		t.setStatus("COMPLETED");
		return taskRepo.save(t);
	}

}
