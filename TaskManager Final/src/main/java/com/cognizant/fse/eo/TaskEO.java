package com.cognizant.fse.eo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class TaskEO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Integer taskId;
	@Column(name = "task")
	private String task;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "priority")
	private Integer priority;
	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEO user;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private ParentTaskEO parentTask;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEO project;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ParentTaskEO getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTaskEO parentTask) {
		this.parentTask = parentTask;
	}

	public ProjectEO getProject() {
		return project;
	}

	public void setProject(ProjectEO project) {
		this.project = project;
	}

	public UserEO getUser() {
		return user;
	}

	public void setUser(UserEO user) {
		this.user = user;
	}

	public TaskEO(Integer taskId, Date startDate, Date endDate, Integer priority, String status) {
		super();
		this.taskId = taskId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
	}

	public TaskEO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
