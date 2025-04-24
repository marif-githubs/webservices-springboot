package com.TODO.S.webservices;

public class TODOitem {
    private String id;
    private String todo;
    private String deadline;

    public TODOitem(String id, String todo, String deadline){
        this.id = id;
        this.todo = todo;
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }

    public String getdeadline() {
        return deadline;
    }

    public TODOitem setId(String id) {
        this.id = id;
        return this;
    }

    public TODOitem setdeadline(String deadline) {
        this.deadline = deadline;
        return this;
    }

    public TODOitem settodo(String todo) {
        this.todo = todo;
        return this;
    }

    public String gettodo() {
        return todo;
    }

}
