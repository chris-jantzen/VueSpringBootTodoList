package com.testapp.HelloWorld.dao;

import com.testapp.HelloWorld.model.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoDao {

    Todo addTodo(UUID id, Todo todo);

    default Todo addTodo(Todo todo) {
        UUID id = UUID.randomUUID();
        if (todo.getCompleted() == null) {
            todo.setCompleted(false);
        }
        return addTodo(id, todo);
    }

    List<Todo> selectAllTodos();

    Optional<Todo> selectTodoById(UUID id);

    void deleteTodoById(UUID id);

    Optional<Todo> updateTodoById(UUID id, Todo todo);
}
