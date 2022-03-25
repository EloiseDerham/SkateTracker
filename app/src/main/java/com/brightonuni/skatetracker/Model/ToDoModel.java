package com.brightonuni.skatetracker.Model;

// model for database data and recyclerview interaction

public class ToDoModel {
    private int id, status, deleted;
    private String task;

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getTask() {
        return task;
    }
}
