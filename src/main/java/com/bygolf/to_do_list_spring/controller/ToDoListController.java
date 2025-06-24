package com.bygolf.to_do_list_spring.controller;

import com.bygolf.to_do_list_spring.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ToDoListController {

    private ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String helloPage() {
        return "Hello! This is to do app";
    }

    @GetMapping("/debug")
    public String debug() {
        return "How did you get here?";
    }

    @GetMapping("/tasks")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        Task tempTask = null;

        for (Task task : tasks) {
            if (task.getId() == id) {
                tempTask = task;
                break;
            }
        }

        return tempTask;

    }

    @PostMapping("/tasks/")
    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    @DeleteMapping("tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
            }
        }
    }

    @PutMapping("tasks/{id}")
    public Task markTaskAsComplete(@PathVariable int id) {

        Task tempTask = null;

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsComplete();
                tempTask = task;
            }
        }
        return tempTask;
    }


}
