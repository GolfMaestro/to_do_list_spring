package com.bygolf.to_do_list_spring.repository;

import com.bygolf.to_do_list_spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
