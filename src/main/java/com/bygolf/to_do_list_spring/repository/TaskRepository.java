package com.bygolf.to_do_list_spring.repository;

import com.bygolf.to_do_list_spring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
