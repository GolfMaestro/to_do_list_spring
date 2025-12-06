package com.bygolf.to_do_list_spring;

import com.bygolf.to_do_list_spring.model.Task;
import com.bygolf.to_do_list_spring.repository.TaskRepository;
import com.bygolf.to_do_list_spring.service.ToDoListService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class ToDoListSpringApplicationTests {

	@Mock
	private TaskRepository taskRepository;

	@InjectMocks
	private ToDoListService toDoListService;

	@Test
	void testCreateTask() {
		Task task = new Task(1L, "task1", "task1 extended");

		when(taskRepository.save(any(Task.class))).thenReturn(task);

		Task createdTask = toDoListService.addTask(task);

		assertNotNull(createdTask);
		assertEquals("task1", createdTask.getTitle());
		assertEquals("task1 extended", createdTask.getDescription());
		verify(taskRepository, times(1)).save(task);

	}

}
