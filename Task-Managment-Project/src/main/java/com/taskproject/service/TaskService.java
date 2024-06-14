package com.taskproject.service;

import java.util.List;

import com.taskproject.payload.TaskDto;

public interface TaskService {
	
	public TaskDto saveTask(long userId,TaskDto taskDto);
	
	public List<TaskDto> getAllTasks(long userid);
	
	public TaskDto getTask(long userid,long taskid);
	
	public void deleteTask(long userid,long taskid);

}
