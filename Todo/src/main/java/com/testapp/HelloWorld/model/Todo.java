package com.testapp.HelloWorld.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Todo {
    private final UUID id;
    private String title;
    private Boolean completed;

    public Todo(@JsonProperty("id") UUID id, @JsonProperty("title") String title, @JsonProperty("completed") Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public UUID getId() {
        return this.id;
    }


    public String getTitle() {
        return this.title;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void CheckOff() {
        this.completed = !this.completed;
    }
}
