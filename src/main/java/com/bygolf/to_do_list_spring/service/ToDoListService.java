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
        logger.debug("Receiving all tasks");
        return taskRepository.findAll();
    }

    public Task getTask(int id) {
        logger.debug("Receiving task by id: {}", id);
        Task tempTask = null;
        List<Task> localTasks = taskRepository.findAll();
        for (Task task : localTasks) {
            if (task.getId() == id) {
                tempTask = task;
                break;
            }
        }
        if (tempTask != null) {
            logger.info("Task found with id: {}", id);
        }
        else {
            logger.info("Task not found with id: {}", id);
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
        logger.debug("Removing task with id: {}", id);
        List<Task> localTasks = taskRepository.findAll();
        for (Task task : localTasks) {
            if (task.getId() == id) {
                try {
                    taskRepository.delete(task);
                    logger.info("Task successfully removed. ID: {}", id);
                } catch (Exception e) {
                    logger.error("Error removing task with this id: {}", id);
                    throw e;
                }

                break;
            }
        }
    }

    public Task markAsComplete(int id) {
        logger.debug("Marking task as complete with this id: {}", id);
        Task tempTask = null;
        List<Task> localTasks = taskRepository.findAll();
        for (Task task : localTasks) {
            if (task.getId() == id) {
                try {
                    task.markAsComplete();
                    taskRepository.save(task);
                    tempTask = task;
                    logger.info("Task successfully marked as complete. ID: {}", id);
                } catch (Exception e) {
                    logger.error("Error marking task as complete. ID: {}", id);
                    throw e;
                }
                break;
            }
        }
        return tempTask;
    }

}