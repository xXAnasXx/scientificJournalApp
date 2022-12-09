package com.example.scientificjournalapp.entities;

import java.util.List;

public class Author extends User {

    private List<Integer> submissionIds;
    public Author() {
        super();
    }

    public Author(String id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public void login() {
        super.login();
    }

    @Override
    public void subscribe() {
        super.subscribe();
    }


    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}
