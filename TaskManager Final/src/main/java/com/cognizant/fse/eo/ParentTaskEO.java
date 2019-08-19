package com.cognizant.fse.eo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parent_task")
public class ParentTaskEO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parent_id")
	private Integer parentId;
	@Column(name = "parent_task")
	private String parentTask;

	@OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL)
	private List<TaskEO> tasks;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public List<TaskEO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskEO> tasks) {
		this.tasks = tasks;
	}

	public ParentTaskEO(Integer parentId, String parentTask) {
		super();
		this.parentId = parentId;
		this.parentTask = parentTask;
	}

	public ParentTaskEO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
