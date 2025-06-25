package com.bygolf.to_do_list_spring.controller;

import com.bygolf.to_do_list_spring.service.ToDoListService;
import com.bygolf.to_do_list_spring.model.Task;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ToDoListController {

    ToDoListService toDoListService = new ToDoListService();

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
        return toDoListService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return toDoListService.getTask(id);

    }

    @PostMapping("/tasks/")
    public Task addTask(@Valid Task task) {
        return toDoListService.addTask(task);
    }

    @DeleteMapping("tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        toDoListService.removeTask(id);
    }

    @PutMapping("tasks/{id}")
    public Task markTaskAsComplete(@PathVariable int id) {

        return toDoListService.markAsComplete(id);
    }

}
