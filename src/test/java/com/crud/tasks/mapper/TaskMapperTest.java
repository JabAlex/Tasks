package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void testMapToTask(){
        //Given
        TaskDto testTaskDto = new TaskDto(1L, "test", "test");
        Task expectedResult = new Task(1L, "test", "test");
        //When
        Task result = taskMapper.mapToTask(testTaskDto);
        //Then
        assertEquals(expectedResult.getId(), result.getId());
        assertEquals(expectedResult.getTitle(), result.getTitle());
        assertEquals(expectedResult.getContent(), result.getContent());
    }
    @Test
    void testMapToTaskDto(){
        //Given
        Task testTask = new Task(1L, "test", "test");
        TaskDto expectedResult = new TaskDto(1L, "test", "test");
        //When
        TaskDto result = taskMapper.mapToTaskDto(testTask);
        //Then
        assertEquals(expectedResult.getId(), result.getId());
        assertEquals(expectedResult.getTitle(), result.getTitle());
        assertEquals(expectedResult.getContent(), result.getContent());
    }
    @Test
    void testMapToTaskDtoList(){
        //Given
        List<Task> testTasks = new ArrayList<>();
        Task testTask1 = new Task(1L, "test1", "test1");
        Task testTask2 = new Task(2L, "test2", "test2");
        Task testTask3 = new Task(3L, "test3", "test3");
        testTasks.add(testTask1);
        testTasks.add(testTask2);
        testTasks.add(testTask3);
        List<TaskDto> expectedResult = new ArrayList<>();
        TaskDto expectedTaskDto1 = new TaskDto(1L, "test1", "test1");
        TaskDto expectedTaskDto2 = new TaskDto(2L, "test2", "test2");
        TaskDto expectedTaskDto3 = new TaskDto(3L, "test3", "test3");
        expectedResult.add(expectedTaskDto1);
        expectedResult.add(expectedTaskDto2);
        expectedResult.add(expectedTaskDto3);
        //When
        List<TaskDto> result = taskMapper.mapToTaskDtoList(testTasks);
        //Then
        for(int i = 0; i < expectedResult.size(); i++){
            assertEquals(expectedResult.get(i).getId(), result.get(i).getId());
            assertEquals(expectedResult.get(i).getTitle(), result.get(i).getTitle());
            assertEquals(expectedResult.get(i).getContent(), result.get(i).getContent());
        }
    }
}
