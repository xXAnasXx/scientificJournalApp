package com.example.scientificjournalapp.entities;

import model.enums.Status;

import java.io.File;
import java.util.List;

public class ArticleVersion {
    private int versionID;
    private int submissionID;
    private File articleFile;
    private List<Comment> comments;
    private Status status;

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public int getSubmissionID() {
        return submissionID;
    }

    public void setSubmissionID(int submissionID) {
        this.submissionID = submissionID;
    }

    public File getArticleFile() {
        return articleFile;
    }

    public void setArticleFile(File articleFile) {
        this.articleFile = articleFile;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
