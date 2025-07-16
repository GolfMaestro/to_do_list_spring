package com.bygolf.to_do_list_spring.service;


import com.bygolf.to_do_list_spring.model.Task;
import com.bygolf.to_do_list_spring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ToDoListService {

    private static final Logger logger = LoggerFactory.getLogger(ToDoListService.class);

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(int id) {
        Task tempTask = null;
        List<Task> localTasks = taskRepository.findAll();
        for (Task task : localTasks) {
            if (task.getId() == id) {
                tempTask = task;
                break;
            }
        }
        return tempTask;
    }

    public Task addTask(Task task) {
        logger.debug("Creating new task: {}", task.getTitle());
        try {
            Task savedTask = taskRepository.save(task);
            logger.info("Task created successfully with ID: {}", savedTask.getId());
        } catch (Exception e) {
            logger.error("Error creating task with this title: {}", task.getTitle());
            throw e;
        }

        return task;
    }

    public void removeTask(int id) {
        List<Task> localTasks = taskRepository.findAll();
        for (Task task : localTasks) {
            if (task.getId() == id) {
                taskRepository.delete(task);
                break;
            }
        }
    }

    public Task markAsComplete(int id) {
        Task tempTask = null;
        List<Task> localTasks = taskRepository.findAll();
        for (Task task : localTasks) {
            if (task.getId() == id) {
                task.markAsComplete();
                taskRepository.save(task);
                tempTask = task;
                break;
            }
        }
        return tempTask;
    }

}
