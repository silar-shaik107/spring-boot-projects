package com.taskproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskproject.entity.Task;
import com.taskproject.payload.TaskDto;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


	List<Task> findAllByUsersId(long userid);

}
