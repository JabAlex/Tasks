package com.crud.tasks.service;

import com.crud.tasks.config.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DbServiceTest {

    @Autowired
    private DbService dbService;

    @Test
    void shouldSaveDeleteAndGetTasks() throws TaskNotFoundException {
        //Given
        Task task1 = new Task(1L, "test1", "test");
        Task task2 = new Task(2L, "test2", "test");
        Task task3 = new Task(3L, "test3", "test");
        //When
        dbService.saveTask(task1);
        dbService.saveTask(task2);
        dbService.saveTask(task3);
        dbService.deleteTask(3L);
        //Then
        assertEquals(2, dbService.getAllTasks().size());
        assertEquals(task2.getTitle(), dbService.getTask(2L).getTitle());
        assertThrows(TaskNotFoundException.class,() -> dbService.getTask(3L));
    }
}
