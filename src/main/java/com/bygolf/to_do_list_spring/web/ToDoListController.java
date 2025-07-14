package com.bygolf.to_do_list_spring.web;

import com.bygolf.to_do_list_spring.service.ToDoListService;
import com.bygolf.to_do_list_spring.model.Task;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoListController {

    ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping("/")
    public String helloPage() {
        return "Hello! This is to do app";
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return toDoListService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return toDoListService.getTask(id);

    }

    @PostMapping("/tasks")
    public Task addTask(@Valid Task task) {
        return toDoListService.addTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        toDoListService.removeTask(id);
    }

    @PutMapping("/tasks/{id}")
    public Task markTaskAsComplete(@PathVariable int id) {

        return toDoListService.markAsComplete(id);
    }

}
