package com.example.scientificjournalapp.entities;

import model.enums.SubmissionPhase;

import java.util.Date;
import java.util.List;

public class Submission {
    private int submissionId;
    private Category category;
    private List<ArticleVersion> articleVersions;
    private Author author;
    private SubmissionPhase submissionPhase;
    private Committy committy;
    private Date date;
}
