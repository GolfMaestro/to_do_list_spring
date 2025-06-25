package com.bygolf.to_do_list_spring.service;


import com.bygolf.to_do_list_spring.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ToDoListService {

    private ArrayList<Task> tasks = new ArrayList<>();

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int id) {
        Task tempTask = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                tempTask = task;
                break;
            }
        }
        return tempTask;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public void removeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                break;
            }
        }
    }

    public Task markAsComplete(int id) {
        Task tempTask = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsComplete();
                tempTask = task;
                break;
            }
        }
        return tempTask;
    }

}
