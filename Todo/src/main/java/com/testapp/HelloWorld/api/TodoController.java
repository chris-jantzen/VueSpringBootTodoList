package com.testapp.HelloWorld.api;

import com.testapp.HelloWorld.model.Todo;
import com.testapp.HelloWorld.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/todo")
@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping(path = "{id}")
    public Todo getTodoById(@PathVariable("id") UUID id) {
        return todoService.getTodoById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTodoByID(@PathVariable("id") UUID id) {
        todoService.deleteTodo(id);
    }

    @PutMapping(path = "{id}")
    public Todo updateTodoById(@PathVariable("id") UUID id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo).orElse(null);
    }
}
