package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.service.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {
    private final TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }
    public Task getTask(Long taskId) throws TaskNotFoundException {
        return repository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    }
    public Task saveTask(final Task task){
        return repository.save(task);
    }
    public void deleteTask(Long taskId) throws TaskNotFoundException{
        try {
            repository.deleteById(taskId);
        } catch (EmptyResultDataAccessException e){
            throw new TaskNotFoundException();
        }
    }
}
