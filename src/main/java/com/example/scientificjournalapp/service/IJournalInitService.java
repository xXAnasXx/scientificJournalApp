package com.example.scientificjournalapp.service;

import java.net.URISyntaxException;

public interface IJournalInitService {
    public void initArticleVersions() throws URISyntaxException;
    public void initAuthors();
    public void initCategories();
    public void initComments();
    public void initCommittees();
    public void initReviewers();
    public void initSubmissions();
}
