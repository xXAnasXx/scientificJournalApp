package com.example.scientificjournalapp.entities;

public class Comment {
    private int id;
    private String text;
    private User reviewer;
    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public User getReviewer() {
        return reviewer;
    }
}
