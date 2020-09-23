package com.testapp.HelloWorld.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Todo {
    private final UUID id;
    private final String title;
    private Boolean completed;

    public Todo(@JsonProperty("id") UUID id, @JsonProperty("title") String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public UUID getId() {
        return this.id;
    }


    public String getTitle() {
        return this.title;
    }

    public void CheckOff() {
        this.completed = !this.completed;
    }
}
