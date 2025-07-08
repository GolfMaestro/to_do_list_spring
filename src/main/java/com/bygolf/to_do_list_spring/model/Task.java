package com.bygolf.to_do_list_spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
    @Entity
    @Table(name = "tasks")
    public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        private String title;
        private String description;
        private boolean completed;
        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;

        public Task() {

        }

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false;
//            this.createdAt = LocalDateTime.now();
        }

    public long getId() {
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

    public boolean getCompleted() {
        return completed;
    }

    public void markAsComplete() {
        this.completed = true;
    }

    public void markAsNotComplete() {
        this.completed = false;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


}
