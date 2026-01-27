package br.com.lucasarcanjo.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private ITaskRepository repository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel) {
        var task = repository.save(taskModel);
        return task;
    }
}
