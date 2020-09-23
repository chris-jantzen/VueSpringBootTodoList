package com.testapp.HelloWorld.dao;

import com.testapp.HelloWorld.model.Todo;
import org.springframework.stereotype.Repository;

import javax.websocket.MessageHandler;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository("todoDao")
public class TodoDataAccessService implements TodoDao {

    private final static List<Todo> DB = new ArrayList<>();

    @Override
    public Todo addTodo(UUID id, Todo todo) {
        Todo newTodo = new Todo(id, todo.getTitle());
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
        int indexToReplace = -1;
        for (int i=0; i < DB.size(); ++i) {
            if (DB.get(i).getId().equals(id)) {
                indexToReplace = i;
            }
        }
        if (indexToReplace != -1 ) {
            if (todo.getId() == null) {
                Todo oldTodo = DB.get(indexToReplace);
                Todo newTodo = new Todo(oldTodo.getId(), todo.getTitle());
                DB.set(indexToReplace, newTodo);
                return Optional.of(newTodo);
            } else {
                DB.set(indexToReplace, todo);
                return Optional.of(todo);
            }
        } else {
            return Optional.empty();
        }
    }
}
