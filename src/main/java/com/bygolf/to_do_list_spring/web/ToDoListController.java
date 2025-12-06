package com.bygolf.to_do_list_spring.web;

import com.bygolf.to_do_list_spring.model.Person;
import com.bygolf.to_do_list_spring.service.PersonService;
import com.bygolf.to_do_list_spring.service.ToDoListService;
import com.bygolf.to_do_list_spring.model.Task;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoListController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoListController.class);

    @Autowired
    ToDoListService toDoListService;
    @Autowired
    PersonService personService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
        logger.info("ToDoListController initialized");
    }

    @GetMapping("/")
    public String helloPage() {
        return "Hello! This is to do app";
    }

//    @GetMapping("/tasks")
//    public List<Task> getTasks() {
//        logger.info("Received request to get all tasks");
//        return toDoListService.getTasks();
//    }

    @GetMapping("/tasks")
    public List<Task> getPersonTasks(@RequestParam("personId") Long personId) {
        return toDoListService.getPersonTasks(personId);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        logger.info("Received request to get task by id: {}", id);
        return toDoListService.getTask(id);

    }

    @PostMapping("/tasks")
    public Task addTask(@Valid Task task) {
        logger.info("Received request to add task with title: {}", task.getTitle());
        logger.info("Received request to add task with desc: {}", task.getDescription());
        logger.info("Received request to add task with person_id: {}", task.getPersonId());
        return toDoListService.addTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        logger.info("Received request to delete task by id: {}", id);
        toDoListService.removeTask(id);
    }

    @PutMapping("/tasks/{id}")
    public Task markTaskAsComplete(@PathVariable int id) {
        logger.info("Received request to mark as complete task by id: {}", id);
        return toDoListService.markAsComplete(id);
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        logger.info("Received request to get all persons");
        return personService.getPersons();
    }

}
