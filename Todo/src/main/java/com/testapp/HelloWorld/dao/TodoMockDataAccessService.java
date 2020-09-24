package com.testapp.HelloWorld.dao;

import com.testapp.HelloWorld.model.Todo;
import org.springframework.stereotype.Repository;

import javax.websocket.MessageHandler;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository("todoDao")
public class TodoMockDataAccessService implements TodoDao {

    private final static List<Todo> DB = new ArrayList<>();

    @Override
    public Todo addTodo(UUID id, Todo todo) {
        Todo newTodo = new Todo(id, todo.getTitle(), false);
        DB.add(newTodo);
        return newTodo;
    }

    @Override
    public List<Todo> selectAllTodos() {
        return DB;
    }

    @Override
    public Optional<Todo> selectTodoById(UUID id) {
        return DB.stream().filter(todo -> todo.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteTodoById(UUID id) {
        Optional<Todo> todo = selectTodoById(id);
        if (!todo.isPresent()) {
            return;
        }
        DB.remove(todo.get());
    }

    @Override
    public Optional<Todo> updateTodoById(UUID id, Todo todo) {
        return selectTodoById(id)
                .map(t -> {
                    int indexOfTodoToUpdate = DB.indexOf(t);
                    if (indexOfTodoToUpdate != -1) {
                        String title;
                        if (todo.getTitle() == null) {
                            title = t.getTitle();
                        } else {
                            title = todo.getTitle();
                        }
                        Todo newTodo = new Todo(id, title, todo.getCompleted());
                        DB.set(indexOfTodoToUpdate, newTodo);
                        return newTodo;
                    }
                    return null;
                });
    }

    @Override
    public Optional<Todo> updateTodoTitleById(UUID id, String Title) {
        return Optional.empty(); // Could implement but am not using the mock DB anymore
    }

    @Override
    public Optional<Todo> updateTodoCompletedById(UUID id, Boolean completed) {
        return Optional.empty(); // Could implement but am not using the mock DB anymore
    }
}
