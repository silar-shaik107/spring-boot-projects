package com.taskproject.serviceImple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskproject.entity.Task;
import com.taskproject.entity.Users;
import com.taskproject.exception.APIException;
import com.taskproject.exception.TaskNotFound;
import com.taskproject.exception.UserNotFound;
import com.taskproject.payload.TaskDto;
import com.taskproject.repository.TaskRepository;
import com.taskproject.repository.UserRepository;
import com.taskproject.service.TaskService;

@Service
public class TaskServiceImple implements TaskService {

	// ModelMapper which is used to convert Entity <==> Dto
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TaskRepository taskRepository;

	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {

		// checking if User is present or not before assinging Task to User

		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFound(String.format("User Id %d not found", userId)));
		Task task = modelMapper.map(taskDto, Task.class);
		task.setUsers(user);

		// Afetr setting the user we are storing data in DB

		Task savedTask = taskRepository.save(task);

		return modelMapper.map(savedTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTasks(long userid) {
		userRepository.findById(userid)
				.orElseThrow(() -> new UserNotFound(String.format("User id %d not found", userid)));
		List<Task> tasks = taskRepository.findAllByUsersId(userid);
		return tasks.stream().map(task -> modelMapper.map(task, TaskDto.class)).collect(Collectors.toList());
	}

	@Override
	public TaskDto getTask(long userid, long taskid) {
		Users users = userRepository.findById(userid)
				.orElseThrow(() -> new UserNotFound(String.format("User Id %d not found", userid)));

		Task task = taskRepository.findById(taskid)
				.orElseThrow(() -> new TaskNotFound(String.format("User Id %d not found", taskid)));

		if (users.getId() != task.getUsers().getId()) {
			throw new APIException(String.format("Task Id %d is not belongs to UserID", taskid));
		}
		return modelMapper.map(task, TaskDto.class);
	}

	@Override
	public void deleteTask(long userid, long taskid) {
		Users users = userRepository.findById(userid)
				.orElseThrow(() -> new UserNotFound(String.format("User Id %d not found", userid)));

		Task task = taskRepository.findById(taskid)
				.orElseThrow(() -> new TaskNotFound(String.format("User Id %d not found", taskid)));

		if (users.getId() != task.getUsers().getId()) {
			throw new APIException(String.format("Task Id %d is not belongs to UserID", taskid));
		}
		taskRepository.deleteById(taskid);

	}

}
