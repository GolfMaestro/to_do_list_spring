package com.bygolf.to_do_list_spring.repository;

import com.bygolf.to_do_list_spring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByPersonId(Long personId);

}
