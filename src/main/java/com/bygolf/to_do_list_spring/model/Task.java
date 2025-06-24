package com.bygolf.to_do_list_spring.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.UUID;

public class Task {

    private static int idCounter = 1;
    private final int id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private boolean completed;
    private final Date createdAt;

    public Task(String title, String description) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsComplete() {
        this.completed = true;
    }

    public void markAsNotComplete() {
        this.completed = false;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}
