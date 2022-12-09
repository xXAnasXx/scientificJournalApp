package com.example.scientificjournalapp.entities;

import java.util.List;

public class Committy {
    private List<Reviewer> reviewers;
    private Integer submissionId;

    public List<Reviewer> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }
}
