package com.example.scientificjournalapp.entities;

import java.util.List;

public class Reviewer extends User {

    private List<Integer> submissionIds;
    private List<Comment> comments;
    public Reviewer() {
        super();
    }

    public Reviewer(String id, String name, String password) {
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
    public List<Integer> getSubmissionIds() {
        return submissionIds;
    }

    public void setSubmissionIds(List<Integer> submissionIds) {
        this.submissionIds = submissionIds;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
