package com.testapp.HelloWorld.dao;

import com.testapp.HelloWorld.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class TodoDataAccessService implements TodoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TodoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Todo addTodo(UUID id, Todo todo) {
        final String sql = "INSERT INTO todo (id, title, completed) VALUES (?, ?, ?)";
        int res = jdbcTemplate.update(sql, id, todo.getTitle(), todo.getCompleted());
        if (res == 1) {
            return new Todo(id, todo.getTitle(), todo.getCompleted());
        }
        return null;
    }

    @Override
    public List<Todo> selectAllTodos() {
        final String sql = "SELECT id, title, completed FROM todo";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            Boolean completed = resultSet.getBoolean("completed");
            return new Todo(id, title, completed);
        });
    }

    @Override
    public Optional<Todo> selectTodoById(UUID id) {
        final String sql = "SELECT id, title, completed FROM todo WHERE id=?";
        Todo todo = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID todoId = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            Boolean completed = resultSet.getBoolean("completed");
            return new Todo(id, title, completed);
        });
        return Optional.ofNullable(todo);
    }

    @Override
    public void deleteTodoById(UUID id) {
        final String sql = "DELETE FROM todo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Todo> updateTodoById(UUID id, Todo todo) {
        String title = todo.getTitle();
        Boolean completed = todo.getCompleted();
        final String sql = "UPDATE todo SET title = ?, completed = ? WHERE id = ?";
        int res = jdbcTemplate.update(sql, title, completed, id);
        if (res == 1) {
            return Optional.of(new Todo(id, title, completed));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Todo> updateTodoTitleById(UUID id, String title) {
        final String sql = "UPDATE todo SET title = ? WHERE id = ?";
        int res = jdbcTemplate.update(sql, title, id);
        if (res == 1) {
            return selectTodoById(id);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Todo> updateTodoCompletedById(UUID id, Boolean completed) {
        final String sql = "UPDATE todo SET completed = ? WHERE id = ?";
        int res = jdbcTemplate.update(sql, completed, id);
        if (res == 1) {
            return selectTodoById(id);
        }
        return Optional.empty();
    }
}
